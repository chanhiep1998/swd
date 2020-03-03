package com.example.dental.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.HomeMoreAdapter;
import com.example.dental.adapters.HomeNearbyAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class HomeMoreFragment extends Fragment implements ClinicView {
    private RecyclerView clinicList;
    HomeMoreAdapter adapter;
    ClinicPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinic_more_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        clinicList = (RecyclerView) view.findViewById(R.id.clinicList);

        clinicList.setLayoutManager(layoutManager);


        presenter = new ClinicPresenter(this, getContext());
        presenter.getAllClinic();
        return view;
    }

    @Override
    public void getAllClinic(List<ClinicModel> listResult) {
        ArrayList<ClinicModel> tempList = new ArrayList<>();
        for (ClinicModel item : listResult) {
            ClinicModel clinic = new ClinicModel();
            clinic.setId(item.getId());
            clinic.setName(item.getName());
            clinic.setDescription(item.getDescription());
            clinic.setOldPrice(item.getOldPrice());
            clinic.setPrice(item.getPrice());
            if (item.getImage() != null) {
                clinic.setImage(item.getImage());
            }
            tempList.add(clinic);
        }
        adapter = new HomeMoreAdapter(getContext(), tempList);
        clinicList.setAdapter(adapter);
    }

    @Override
    public void getMostLikedClinics(List<ClinicModel> listResult) {
    }

    @Override
    public void getMostDiscountClinics(List<ClinicModel> listResult) {
    }

    public void getNearbyClinics(List<ClinicModel> listResult) {

    }
}
