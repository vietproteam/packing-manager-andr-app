package com.example.parkingmanager.activities.admin;

import static android.Manifest.*;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.Manifest.permission;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.HomeActivity;
import com.example.parkingmanager.activities.user.LoginActivity;

public class SuperLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_login);
        requestPermission();
        TextView tvRegister = findViewById(R.id.tvRegister);
        TextView etEmail = findViewById(R.id.etEmail);
        TextView etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(SuperLoginActivity.this, SuperRegisterActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(SuperLoginActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    private void requestPermission() {
        String[] listPermistions = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
                Manifest.permission.NFC
        };
        for (String permission : listPermistions) {
            if (checkSelfPermission(permission) != getPackageManager().PERMISSION_GRANTED) {
                requestPermissions(listPermistions, 1);
            }
        }
    }

}
