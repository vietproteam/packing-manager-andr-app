package com.example.parkingmanager.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.HomeActivity;

public class SuperLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_login);

        TextView tvRegister = findViewById(R.id.tvRegister);
        TextView etEmail = findViewById(R.id.etEmail);
        TextView etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(SuperLoginActivity.this, SuperRegisterActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(SuperLoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }

}
