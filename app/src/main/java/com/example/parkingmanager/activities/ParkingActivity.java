package com.example.parkingmanager.activities;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

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
import com.example.parkingmanager.functions.CameraEx;
import com.example.parkingmanager.functions.FileEx;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class ParkingActivity extends AppCompatActivity {
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private CameraEx cameraEx;
    private PreviewView previewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        previewView = findViewById(R.id.previewView);
        cameraEx = new CameraEx(this, previewView);
        cameraEx.showPreview();
    }

    private void parkingRecord() {
        Bitmap bitmap = cameraEx.takePicture();
        FileEx fileEx = new FileEx((PakingManagerApplication) getApplication());

        fileEx.saveToInternalStorage(bitmap, "parking_record", "parking_record");
    }
}
