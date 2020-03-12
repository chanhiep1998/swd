package com.example.dental.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dental.R;
import com.example.dental.activities.DetailedActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class ClinicBottomSheetFragment extends BottomSheetDialogFragment {

    TextView forward;
    TextView clinicName;
    TextView clinicAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clinic_bottomsheet, container, false);
        String address = getArguments().getString("address");

        clinicName = view.findViewById(R.id.itemNameTextView);
        clinicAddress = view.findViewById(R.id.itemAddressTextView);
        forward = view.findViewById(R.id.forwardButton);


        clinicAddress.setText(address);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailedActivity.class);
                intent.putExtra("isClinic","clinic");
                startActivity(intent);
            }
        });

        return view;
    }
}
