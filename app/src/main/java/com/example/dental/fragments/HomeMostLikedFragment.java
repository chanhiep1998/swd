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
import com.example.dental.adapters.HomeMostLikedAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class HomeMostLikedFragment extends Fragment implements ClinicView {
    private RecyclerView clinicList;
    HomeMostLikedAdapter adapter;
    ClinicPresenter presenter;
    MainActivity activity;
    String token;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinic_most_like_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        clinicList = (RecyclerView) view.findViewById(R.id.clinicList);
        clinicList.setLayoutManager(layoutManager);

        activity = (MainActivity) getActivity();


        token = SaveSharedPreference.getUserName(activity.getApplicationContext());
        token =  activity.getToken();

        presenter = new ClinicPresenter(this, getContext());
        presenter.getAllServices(token);
        return view;
    }

    @Override
    public void getAllClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getAllServices(List<ServiceModel> listResult) {
        ArrayList<ServiceModel> tempList = new ArrayList<>();
        for (ServiceModel item : listResult) {
            ServiceModel service = new ServiceModel();
            service.setId(item.getId());
//            service.setServiceRating(item.getServiceRating());
            service.setName(item.getName());
            service.setDescription(item.getDescription());
//            service.setOldPrice(item.getOldPrice());
            service.setPrice(item.getPrice());
            service.setClinic(item.getClinic());
//            if (item.getImage() != null) {
//                service.setImage(item.getImage());
//            }
            tempList.add(service);
        }
        adapter = new HomeMostLikedAdapter(getContext(), tempList);
        clinicList.setAdapter(adapter);
    }

    @Override
    public void getServicesByClinicId(List<ServiceModel> listResult) {

    }

    @Override
    public void getMostDiscountClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getNearbyClinics(List<ClinicModel> listResult) {

    }

    @Override
    public void getClinicById(ClinicModel result) {

    }

    @Override
    public void getClinicByIdNew(ClinicModel result) {

    }
}
