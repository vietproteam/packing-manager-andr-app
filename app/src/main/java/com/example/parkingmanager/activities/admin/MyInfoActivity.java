package com.example.parkingmanager.activities.admin;

import static com.example.parkingmanager.R.id.ibedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.parkingmanager.R;


public class MyInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        ImageButton imageButton = (ImageButton) findViewById(ibedit);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onpenUpdateMyInfoActivity();
            }
        });
    }
    public void onpenUpdateMyInfoActivity(){
        setContentView(R.layout.activity_update_my_info);
    }
}