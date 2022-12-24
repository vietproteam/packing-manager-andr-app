package com.example.parkingmanager.activities.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.admin.SummaryReportActivity;

public class LoginActivity extends AppCompatActivity {
    TextView edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            login();
        });
    }

    private void login() {
        // Check if the username or password is empty
        if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username or password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (validate()) {
            Intent intent = new Intent(LoginActivity.this, SummaryReportActivity.class);
            startActivity(intent);
            this.finish();
        }
        else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        return true;
    }
}