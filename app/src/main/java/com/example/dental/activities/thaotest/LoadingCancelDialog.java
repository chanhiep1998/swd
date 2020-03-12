package com.example.dental.activities.thaotest;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.dental.R;
import com.example.dental.activities.BookingDetailActivity;
import com.google.android.material.button.MaterialButton;

public class LoadingCancelDialog {
    BookingDetailActivity activity;
    AlertDialog alertDialog;
    MaterialButton btnOk, btnHuy;

    public LoadingCancelDialog(BookingDetailActivity activity) {
        this.activity = activity;
    }

    public void startDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.thao_canceldialog,null));
        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
        btnOk = alertDialog.findViewById(R.id.canceldialog_btnxacnhan);
        btnHuy = alertDialog.findViewById(R.id.canceldialog_btnhuy);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getCancelButton().setText("Đã Hủy");
                alertDialog.dismiss();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
