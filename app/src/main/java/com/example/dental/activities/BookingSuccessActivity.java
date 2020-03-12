package com.example.dental.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.dental.R;
import com.google.android.material.button.MaterialButton;

import android.os.Bundle;
import android.view.View;

public class BookingSuccessActivity extends AppCompatActivity {
    MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);
        button = (MaterialButton) findViewById(R.id.btn_datcho);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
