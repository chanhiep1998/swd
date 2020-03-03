package com.example.dental.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.dental.R;

public class PopActivity extends AppCompatActivity {

    Spinner spinnerWithTextView;

    String[] Subject = new String[]{
            "29/02/2020",
            "01/03/2020",
            "02/03/2020",
            "03/03/2020"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_service_detail);

//        spinnerWithTextView = (Spinner)findViewById(R.id.spinner);
//
//        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
//                this,R.layout.textview_layout,Subject );
//
//        spinnerArrayAdapter.setDropDownViewResource(R.layout.textview_layout);
//
//        spinnerWithTextView.setAdapter(spinnerArrayAdapter);

//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int) (width * 1), (int) (height * .8));
    }
}
