package com.example.dental.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.activities.MainActivity;
import com.example.dental.adapters.HomeMoreAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class HomeMoreFragment extends Fragment implements ClinicView {
    private RecyclerView clinicList;
    HomeMoreAdapter adapter;
    HomeMoreFragment fragment = this;
    ClinicPresenter presenter;
    String token;
    MainActivity activity;


    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinic_more_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        clinicList = view.findViewById(R.id.clinicList);

        clinicList.setLayoutManager(layoutManager);

        activity = (MainActivity) getActivity();
        Intent intent = activity.getIntent();


        token = SaveSharedPreference.getUserName(activity.getApplicationContext());


        presenter = new ClinicPresenter(this, getContext());
        presenter.getAllClinic(token);
        return view;
    }

    @Override
    public void getAllClinics(List<ClinicModel> listResult) {
        ArrayList<ClinicModel> tempList = new ArrayList<>();
        for (ClinicModel item : listResult) {
            ClinicModel clinic = new ClinicModel();
            clinic.setId(item.getId());
//            clinic.setServiceRating(item.getServiceRating());
            clinic.setName(item.getName());
            clinic.setAddress(item.getAddress());
            clinic.setDescription(item.getDescription());
            clinic.setOldPrice(item.getOldPrice());
            clinic.setPrice(item.getPrice());
            if (item.getImage() != null) {
                clinic.setImage(item.getImage());
            }
            tempList.add(clinic);
        }
        adapter = new HomeMoreAdapter(getContext(), (ArrayList<ClinicModel>) listResult);
        clinicList.setAdapter(adapter);
    }

    @Override
    public void getAllServices(List<ServiceModel> listResult) {
    }

    @Override
    public void getServicesByClinicId(List<ServiceModel> listResult) {


    }

    @Override
    public void getMostDiscountClinics(List<ClinicModel> listResult) {
    }

    public void getNearbyClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getClinicById(ClinicModel result) {

    }

    @Override
    public void getClinicByIdNew(ClinicModel result) {

    }
}
