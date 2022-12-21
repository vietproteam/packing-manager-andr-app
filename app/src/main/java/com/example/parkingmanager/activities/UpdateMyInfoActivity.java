package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.github.dhaval2404.imagepicker.ImagePicker;


import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;


public class UpdateMyInfoActivity extends AppCompatActivity {
    private ImageButton btnCamera;
    private CircleImageView circleImageView;
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    String path;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_my_info);

        btnCamera = findViewById(R.id.btnCamera);
        circleImageView = findViewById(R.id.profile_image);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.with(UpdateMyInfoActivity.this)
//                        .crop()
//                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK && requestCode==101) {
            //Image Uri will not be null for RESULT_OK
            uri = data.getData();
            circleImageView.setImageURI(uri);


//        } else {
//            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
//        }
    }

}








