package com.example.parkingmanager.activities.user;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Record;
import com.example.parkingmanager.functions.CameraEx;
import com.example.parkingmanager.functions.FileEx;
import com.example.parkingmanager.functions.NFCEx;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class ParkingActivity extends AppCompatActivity implements NfcAdapter.ReaderCallback {
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private CameraEx cameraEx;
    private PreviewView previewView;
    private Runnable runnable;
    private FileEx fileEx;
    private Bitmap bitmap;
    private String cardId;
    private NfcAdapter mNfcAdapter;
    private PakingManagerApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        previewView = findViewById(R.id.previewView);
        application = (PakingManagerApplication) getApplication();
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        fileEx = new FileEx((PakingManagerApplication) getApplication());
        cameraEx = new CameraEx(this, previewView);
        cameraEx.showPreview();

    }

    private void parkingRecord() {
        Bitmap bitmap = cameraEx.takePicture();
        FileEx fileEx = new FileEx((PakingManagerApplication) getApplication());

        fileEx.saveToInternalStorage(bitmap, "parking_record", "parking_record");
    }

    @Override
    protected void onResume() {
        super.onResume();
        stopCamera();
        if (mNfcAdapter != null) {
            Bundle options = new Bundle();
            // Work around for some broken Nfc firmware implementations that poll the card too fast
            options.putInt(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY, 250);

            // Enable ReaderMode for all types of card and disable platform sounds
            mNfcAdapter.enableReaderMode(this,
                    this,
                    NfcAdapter.FLAG_READER_NFC_A |
                            NfcAdapter.FLAG_READER_NFC_B |
                            NfcAdapter.FLAG_READER_NFC_F |
                            NfcAdapter.FLAG_READER_NFC_V |
                            NfcAdapter.FLAG_READER_NFC_BARCODE |
                            NfcAdapter.FLAG_READER_NO_PLATFORM_SOUNDS,
                    options);
        }
    }

    @Override
    protected void onPause() {
        Log.d("NFC", "XXXXXXXXXXXXXXXXXXXXXXonPause");
        super.onPause();
        if (mNfcAdapter != null) {
            mNfcAdapter.disableReaderMode(this);
        }
    }

    public void onTagDiscovered(Tag tag) {
        cardId = ByteArrayToHexString(tag.getId());
        Log.d("NFC", "XXXXXXXXXXXXXXXXXXXXXXonTagDiscovered " + cardId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCamera();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public String ByteArrayToHexString(byte[] inarray) {
        int i, j, in;
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String out = "";

        for (j = 0; j < inarray.length; ++j) {
            in = (int) inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
    }

    private void stopCamera() {
        try {
            android.hardware.Camera mCamera = android.hardware.Camera.open();
            mCamera.release();
            mCamera = null;
        } catch (RuntimeException e) {
            Log.e("Camera", "Camera failed to open: " + e.getLocalizedMessage());
            return;
        }
    }

    private void dataIn(String idCard,int idUser,Bitmap image) {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-ddThh:mm:ss");
        String strDate = dateFormat.format(date);
        DateFormat fileNameFormat=new SimpleDateFormat("yyyymmddhhmmss");
        String imageName=fileNameFormat.format(date);
        Record record = new Record(1l, strDate,"1",imageName,"","1",idUser,idCard);
        AppDatabase.getInstance(this).recordDAO().insertParkingRecord(record);

        fileEx.saveToInternalStorage(image, "parking_record", imageName);
    }

    private void dataOut(Record record,Bitmap image){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-ddThh:mm:ss");
        String strDate = dateFormat.format(date);
        DateFormat fileNameFormat=new SimpleDateFormat("yyyymmddhhmmss");
        String imageName=fileNameFormat.format(date);
        record.setImgOut(imageName);
        record.setTimeOut(strDate);
        AppDatabase.getInstance(this).recordDAO().updateParkingRecord(record);

        fileEx.saveToInternalStorage(image, "parking_record", imageName);

    }
    private void save(){
        if (cardId != null) {
            Record record = AppDatabase.getInstance(this).recordDAO().getParkingRecordByImgOutNull(cardId);
            if (record != null) {
                dataOut(record,bitmap);
            } else {
                dataIn(cardId,application.getUser().getId(),bitmap);
            }
        }
    }


}
