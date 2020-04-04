package com.example.dental.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;

public class SplashActivity extends AppCompatActivity {
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splash = findViewById(R.id.splashImageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        animation.setDuration(900);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}
