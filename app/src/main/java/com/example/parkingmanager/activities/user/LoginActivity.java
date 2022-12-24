package com.example.parkingmanager.activities.user;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.admin.SummaryReportActivity;
import com.example.parkingmanager.functions.NFCActivity;
import com.example.parkingmanager.functions.NFCEx;

public class LoginActivity extends AppCompatActivity {
    private TextView edtUsername, edtPassword;
    private NFCEx nfcEx;
    private Toast toast;
    NfcAdapter.ReaderCallback readerCallback;
    String cardId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nfcEx = new NFCEx(this);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);

        readerCallback = new NfcAdapter.ReaderCallback() {
            @Override
            public void onTagDiscovered(Tag tag) {
                cardId = nfcEx.ByteArrayToHexString(tag.getId());
                Log.d("NFC", "onTagDiscovered: " + cardId);
                toast.setText("onTagDiscovered: " + cardId);
                toast.show();
            }
        };

        btnLogin.setOnClickListener(v -> {
            loginCheck();
        });
    }

    private void loginCheck() {
        // Check if the username or password is empty
        if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
            toast.setText("Username or password is empty");
            return;
        }
        if (validate()) {
            login();
        } else {
            toast.setText("Invalid username or password");
        }
    }

    private void login() {
        Intent intent = new Intent(LoginActivity.this, SummaryReportActivity.class);
        startActivity(intent);
        this.finish();
    }

    private boolean validate() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcEx.getCardId(readerCallback);
    }
}