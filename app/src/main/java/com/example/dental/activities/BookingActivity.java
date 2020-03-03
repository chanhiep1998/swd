package com.example.dental.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        String des = "Đặt chỗ thành công với khuyến mãi <b>Giấc trưa vui khám răng: miễn phí chụp và tư vấn.</b> " +
                "Giờ đặt: <b>14:15, 20/02/2020</b> tại <b>Nha Khoa Lan An</b>";
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
