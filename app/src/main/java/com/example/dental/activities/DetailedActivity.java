package com.example.dental.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dental.R;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent intent = getIntent();
        String clinicName = intent.getStringExtra("Name");
        Toast.makeText(this, clinicName,Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this, PopActivity.class));
    }




    public void clickToClose(View view) {
        this.finish();
    }

    public void clickToShowMore(View view) {
        TextView textPolicy = (TextView) findViewById(R.id.policy);
        textPolicy.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT));
    }

}
