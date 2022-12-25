package com.example.parkingmanager.functions;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.parkingmanager.activities.user.LoginActivity;

public class NFCEx {

    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private Tag card;
    private String cardId = "";
    private Activity activity;
    private Toast toast;

    public NFCEx(Activity activity) {
        this.activity = activity;
        this.card = null;
        toast = Toast.makeText(this.activity.getApplicationContext(), "onResume", Toast.LENGTH_SHORT);
        // creating pending intent:
        PendingIntent pendingIntent = PendingIntent.getActivity(this.activity, 0, new Intent(this.activity, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), PendingIntent.FLAG_IMMUTABLE);
        // creating intent receiver for NFC events:
        IntentFilter filter = new IntentFilter();
        filter.addAction(NfcAdapter.ACTION_TAG_DISCOVERED);
        filter.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filter.addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
    }

    public String getCardId() {
        return cardId;
    }

    public void onTap(Runnable runnableCallback) {
        // enabling foreground dispatch for getting intent from NFC event:
        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this.activity);
        nfcAdapter.enableReaderMode(
                this.activity,
                new NfcAdapter.ReaderCallback() {
                    @Override
                    public void onTagDiscovered(Tag tag) {
                        card = tag;
                        cardId = ByteArrayToHexString(tag.getId());
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(runnableCallback);
                    }
                },
                NfcAdapter.FLAG_READER_NFC_A |
                        NfcAdapter.FLAG_READER_NFC_B |
                        NfcAdapter.FLAG_READER_NFC_F |
                        NfcAdapter.FLAG_READER_NFC_V |
                        NfcAdapter.FLAG_READER_NFC_BARCODE |
                        NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK,
                null
        );
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
}
