package com.example.dental.activities.thaotest;

import androidx.appcompat.app.AppCompatActivity;

import com.comix.overwatch.HiveProgressView;
import com.example.dental.R;
import com.roger.catloadinglibrary.CatLoadingView;
import com.white.progressview.CircleProgressView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class TestProgressDialog extends AppCompatActivity {
    Button b1,b2;
    HiveProgressView progressDialog;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_progress_dialog);
        b1 = (Button) findViewById(R.id.thaotest_btnprogress);
        b2 = (Button) findViewById(R.id.thaotest_btnprogress2);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final LoadingDialogClass loading = new LoadingDialogClass(TestProgressDialog.this);
//                loading.startDialog();
//                thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(6000);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        loading.dismiss();
//                    }
//                });
//                thread.start();
//            }
//        });
    }

    public void stopThread(){
        try {
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
