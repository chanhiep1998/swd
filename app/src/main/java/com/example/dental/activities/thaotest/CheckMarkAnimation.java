package com.example.dental.activities.thaotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dental.R;

public class CheckMarkAnimation extends AppCompatActivity {
    ImageView animation;
    Button btn;
    AnimatedVectorDrawable avd2;
    AnimatedVectorDrawableCompat avd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thaotest_activity_check_mark_animation);
        animation = findViewById(R.id.img_animation);
        btn = findViewById(R.id.btnShow);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = animation.getDrawable();
                if(drawable instanceof  AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable;
                    avd.start();
                } else if(drawable instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable;
                    avd2.start();
                }
            }
        });
    }
}
