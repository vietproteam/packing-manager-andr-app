package com.example.parkingmanager.activities.admin;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.parkingmanager.R;
import com.github.dhaval2404.imagepicker.ImagePicker;


import de.hdodenhof.circleimageview.CircleImageView;


public class UpdateMyInfoActivity extends AppCompatActivity {
    private ImageButton btnCamera;
    private CircleImageView circleImageView;
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private ImageView avatar;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_my_info);

        btnCamera = findViewById(R.id.btnCamera);
        circleImageView = findViewById(R.id.avatar);

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
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            circleImageView.setImageBitmap(imageBitmap);
        }
    }

}








