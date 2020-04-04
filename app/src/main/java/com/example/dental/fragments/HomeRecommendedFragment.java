package com.example.dental.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.adapters.HomeRecommendedAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class HomeRecommendedFragment extends Fragment implements ClinicView {
    private RecyclerView clinicList;
    HomeRecommendedAdapter adapter;
    ClinicPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinic_highly_recommend_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        clinicList = view.findViewById(R.id.clinicList);

        clinicList.setLayoutManager(layoutManager);


        presenter = new ClinicPresenter(this, getContext());
        presenter.getNearbyClinics();
        return view;
    }

    @Override
    public void getAllClinics(List<ClinicModel> listResult) {
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
        ArrayList<ClinicModel> tempList = new ArrayList<>();
        for (ClinicModel item : listResult) {
            ClinicModel clinic = new ClinicModel();
            clinic.setId(item.getId());
//            clinic.setServiceRating(item.getServiceRating());
//            clinic.setComments(item.getComments());
            clinic.setName(item.getName());
            clinic.setDescription(item.getDescription());
            clinic.setOldPrice(item.getOldPrice());
            clinic.setPrice(item.getPrice());
            if (item.getImage() != null) {
                clinic.setImage(item.getImage());
            }
            tempList.add(clinic);
        }
        adapter = new HomeRecommendedAdapter(getContext(), tempList);
        clinicList.setAdapter(adapter);
    }

    @Override
    public void getClinicById(ClinicModel result) {

    }

    @Override
    public void getClinicByIdNew(ClinicModel result) {

    }
}
