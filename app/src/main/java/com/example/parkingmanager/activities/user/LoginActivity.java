package com.example.parkingmanager.activities.user;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.ParkingActivity;
import com.example.parkingmanager.activities.admin.SummaryReportActivity;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.functions.NFCEx;
import com.example.parkingmanager.functions.PermissionEx;

public class LoginActivity extends AppCompatActivity {
    private TextView edtUsername, edtPassword;
//    private NFCEx nfcEx;
    private Toast toast;
    private Runnable runnableCallback;
    private String cardId;
    private AppDatabase db;
    private PakingManagerApplication application;
    String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        new PermissionEx().request(this);
//        nfcEx = new NFCEx(this);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT);
        db = AppDatabase.getInstance(getApplication());
        application = (PakingManagerApplication) getApplication();

        runnableCallback = new Runnable() {
            public void run() {
//                cardId = nfcEx.getCardId();
                db.userDAO().getLiveUserByCardId(cardId).observe(LoginActivity.this, user -> {
                    if (user != null) {
                        toast.setText("Welcome " + user.getUsername());
                        toast.show();
                        login();
                    } else {
                        toast.setText("User not found");
                        toast.show();
                    }
                });
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
        Intent intent = new Intent(LoginActivity.this, ParkingActivity.class);
        startActivity(intent);
        this.finish();
    }

    private boolean validate() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
//        nfcEx.onTap(runnableCallback);
    }
}