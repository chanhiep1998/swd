package com.example.dental.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dental.SaveSharedPreference;
import com.example.dental.activities.MainActivity;
import com.example.dental.R;
import com.example.dental.activities.NearMeActivity;
import com.example.dental.adapters.SliderAdapter;
import com.example.dental.models.ClinicModel;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    String token;
    Context context;

    public HomeFragment() {
        // Required empty public constructor
    }

    MainActivity mainActivity;
    SliderView sliderView;
    ImageView nearMeImageView;
    public void slider_auto() {


        final SliderAdapter adapter = new SliderAdapter(getContext());
        adapter.setCount(3);
        adapter.slide = 0;
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });


    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        token = SaveSharedPreference.getUserName(context);
        System.out.println("HomeFragment: " + token);

        HomeMoreFragment fragment = (HomeMoreFragment) getChildFragmentManager().findFragmentById(R.id.clinicMore);
        fragment.setToken(token);
        fragment.token = token;


        sliderView = view.findViewById(R.id.imageSlider);
        slider_auto();
        mainActivity = (MainActivity) getActivity();
        nearMeImageView = view.findViewById(R.id.nearMeImageView);
        nearMeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NearMeActivity.class));
            }
        });

        return view;
    }

    public String getToken() {
        return token;
    }




}
