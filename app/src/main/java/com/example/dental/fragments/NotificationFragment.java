package com.example.dental.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.BookingAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    RecyclerView recyclerView;
    String s1[];
    String s2[] = new String[20];
    int images[] = {R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh
            , R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh, R.drawable.lananh,
            R.drawable.lananh, R.drawable.lananh, R.drawable.lananh};

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.booking_layout, container, false);
        String des = "Đặt chỗ thành công với khuyến mãi <b>Giấc trưa vui khám răng: miễn phí chụp và tư vấn.</b> " +
                "Giờ đặt: <b>14:15, 20/02/2020</b> tại <b>Nha Khoa Lan An</b>";

        int i = 0;
        while (i < 20) {
            s2[i] = des;
            i++;
        }
        s1 = getResources().getStringArray(R.array.programming_languages);
        recyclerView = (RecyclerView) view.findViewById(R.id.rcv_history);
        BookingAdapter bookingAdapter = new BookingAdapter(getContext(), s1, s2, images);
        recyclerView.setAdapter(bookingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

}
