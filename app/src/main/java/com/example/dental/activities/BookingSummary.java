package com.example.dental.activities;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dental.R;
import com.example.dental.activities.thaotest.LoadingDialogClass;
import com.google.android.material.button.MaterialButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookingSummary extends AppCompatActivity {
    MaterialButton btnDatCho;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summary);
        btnDatCho = (MaterialButton) findViewById(R.id.btn_datcho);
        btnDatCho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LoadingDialogClass loading = new LoadingDialogClass(BookingSummary.this);
                loading.startDialog();
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(6000);
                            Intent intent = new Intent(getBaseContext(), BookingSuccessActivity.class);
                            startActivity(intent);
                            finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        loading.dismiss();

                    }
                });
                thread.start();
            }
        });
    }

    public void stopThread(){
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
