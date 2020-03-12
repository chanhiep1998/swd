package com.example.dental.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dental.R;
import com.example.dental.activities.BookingActivity;
import com.example.dental.activities.BookingDetailActivity;
import com.example.dental.adapters.BookingTimeAdapter;
import com.example.dental.adapters.HomeNearbyAdapter;
import com.example.dental.blocs.BookingTimeBloc;
import com.example.dental.blocs.DiscountBloc;


public class BookingTimeFragment extends Fragment {private RecyclerView bookingTime;
    BookingTimeAdapter adapter;
    private BookingTimeBloc bookingTimeBloc = new BookingTimeBloc();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_booking_time_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        bookingTime = (RecyclerView) view.findViewById(R.id.bookingTimeList);
//        adapter = new BookingTimeAdapter(getContext(), bookingTimeBloc.getHomeProducts());
        bookingTime.setLayoutManager(layoutManager);
        bookingTime.setAdapter(adapter);
        return view;
    }

    public void clickToBook(View view) {
        startActivity(new Intent(getContext(), BookingDetailActivity.class));
    }
}
