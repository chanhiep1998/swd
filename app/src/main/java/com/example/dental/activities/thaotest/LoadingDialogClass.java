package com.example.dental.activities.thaotest;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dental.R;
import com.example.dental.activities.BookingSummary;
import com.google.android.material.button.MaterialButton;
import com.white.progressview.CircleProgressView;
import com.white.progressview.HorizontalProgressView;

public class LoadingDialogClass {
    BookingSummary activity;
    AlertDialog alertDialog;
    CircleProgressView progressView;

    public LoadingDialogClass(BookingSummary activity) {
        this.activity = activity;
    }

    public void startDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.thaotest_customdialog,null));
        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
        progressView = (CircleProgressView) alertDialog.findViewById(R.id.circle_progress_normal);
        progressView.setRotationY(180);
        progressView.setProgressInTime(100, 5000);
        MaterialButton btnHuy = (MaterialButton) alertDialog.findViewById(R.id.dialog_btnHuy);
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.stopThread();
            }
        });
    }

    public void dismiss() {
        alertDialog.dismiss();
    }

    public void check() {
        progressView.setBackgroundResource(R.drawable.checked);
    }
}
