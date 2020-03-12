package com.example.dental.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarkerFragment extends Fragment {


    TextView markerText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clinic_marker, container, false);


        return view;
    }
}
