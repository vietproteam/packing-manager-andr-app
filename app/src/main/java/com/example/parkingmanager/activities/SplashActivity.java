package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingmanager.PakingManagerApplication;
import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.admin.SuperLoginActivity;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.whoosh);
        mp.setVolume(0.2f, 0.2f);
        mp.start();

        ImageView img = (ImageView)findViewById(R.id.img_logo_splash);
        Animation aniImage = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_screen_ani);
        img.startAnimation(aniImage);

        TextView textView = (TextView) findViewById(R.id.txt_splash);
        Animation aniText = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_text);
        textView.startAnimation(aniText);

        PakingManagerApplication pakingManagerApplication = (PakingManagerApplication) getApplicationContext();

        //splash screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pakingManagerApplication.getEncSharedPrefs().getString("id").equals("")) {
                    Intent intent = new Intent(getApplicationContext(), SuperLoginActivity.class);
                    startActivity(intent);
                } else {
                    pakingManagerApplication.getEncSharedPrefs().getSuperUser();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
            }
        }, 2500);
    }
}