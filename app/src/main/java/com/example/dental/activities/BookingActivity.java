package com.example.dental.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.BookingAdapter;

public class BookingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[];
    String s2[] = new String[20];
    int images[] = {R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh
            , R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_layout);
        String des = "Dịch vụ: <b> Trám răng </b> <br/>  " +
                "Địa điểm: <b>Nha Khoa Lan An</b>" +
                "Thời gian: <b>14:15, 20/02/2020</b> <br/>" +
                "Lời nhắc: Bạn có thể vệ sinh răng miệng ở nhà để cải thiện tốc độ dịch vụ";


        int i = 0;
        while (i < 20) {
            s2[i] = des;
            i++;
        }
        s1 = getResources().getStringArray(R.array.programming_languages);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_history);
        BookingAdapter bookingAdapter = new BookingAdapter(this, s1, s2, images);
        recyclerView.setAdapter(bookingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
