package com.example.parkingmanager.functions;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx {
    PakingManagerApplication application;

    public FileEx(PakingManagerApplication application) {
        this.application = application;
    }

    public void saveToInternalStorage(Bitmap bitmapImage, String subFolder, String fileName) {
        // Create imageDir
        File filePath = new File(application.appConfig.savePath + subFolder, fileName + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filePath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Bitmap loadImageFromStorage(String subFolder,String fileName) {

        try {
            File f = new File( application.appConfig.savePath + subFolder, fileName);
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
        } catch (FileNotFoundException e) {
            Toast toast = Toast.makeText(application.getApplicationContext(), "File not found", Toast.LENGTH_SHORT);
            e.printStackTrace();
        }
        return null;
    }
}
