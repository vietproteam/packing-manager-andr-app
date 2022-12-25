package com.example.parkingmanager.functions;

import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;

import java.security.Permission;
import java.util.List;

public class PermissionEx {

    public void request(AppCompatActivity activity) {
            String[] listPermistions = new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.INTERNET,
                    Manifest.permission.NFC
            };
            for (String permission : listPermistions) {
                if (activity.checkSelfPermission(permission) != activity.getPackageManager().PERMISSION_GRANTED) {
                    activity.requestPermissions(listPermistions, 1);
                }
            }

    }
}
