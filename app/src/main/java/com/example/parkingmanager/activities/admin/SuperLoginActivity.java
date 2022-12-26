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
import android.widget.Toast;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.HomeActivity;
import com.example.parkingmanager.activities.user.LoginActivity;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.functions.EncSharedPrefs;

public class SuperLoginActivity extends AppCompatActivity {
    EncSharedPrefs encSharedPrefs;
    TextView etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        encSharedPrefs = new EncSharedPrefs((PakingManagerApplication) getApplication());

        if (encSharedPrefs.getString("username") != "") login();

        setContentView(R.layout.activity_super_login);

        TextView tvRegister = findViewById(R.id.tvRegister);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(SuperLoginActivity.this, SuperRegisterActivity.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {
            if (loginCheck()) login();
        });
    }

    private boolean loginCheck() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        saveUserCache("admin", "admin");

        if (offlineLoginCheck(email, password)|| onlineLoginCheck(email, password)) {
            return true;
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean onlineLoginCheck(String email, String password) {
        if (email.equals("admin") && password.equals("admin")) {
            saveUserCache(email, password);
            return true;
        }
        return false;
    }

    private void saveUserCache(String email, String password) {
        encSharedPrefs.putString("username", email);
        encSharedPrefs.putString("password", password);
        // init 3 positions (Admin, Manager, User)
        AppDatabase db = AppDatabase.getInstance(this);
//        db.positionDAO().insertPosition(new Position(1, "Admin"));
//        db.positionDAO().insertPosition(new Position(2, "Manager"));
//        db.positionDAO().insertPosition(new Position(3, "User"));

        User user = new User(email,password,email,"1E88A063", db.positionDAO().getPositionById(1));
        db.userDAO().insertUser(user);
    }

    private boolean offlineLoginCheck(String email, String password) {
        if (email.equals(encSharedPrefs.getString("username")) && password.equals(encSharedPrefs.getString("password"))) {
            return true;
        } else {
            return false;
        }
    }

    private void login() {

        Intent intent = new Intent(SuperLoginActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
