package com.example.dental.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dental.R;
import com.example.dental.SaveSharedPreference;
import com.example.dental.adapters.ClinicPromotionAdapter;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.presenters.ClinicPresenter;
import com.example.dental.views.ClinicView;

import java.util.ArrayList;
import java.util.List;

public class ClinicPromotionFragment extends Fragment implements ClinicView {
    private RecyclerView clinicList;
    ClinicPromotionAdapter adapter;
    ClinicPresenter presenter;
    ServiceModel model;

    public void setModel(ServiceModel model) {
        this.model = model;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clinic_promotion_list, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        clinicList = view.findViewById(R.id.clinicList);
        clinicList.setLayoutManager(layoutManager);

        Intent intent = getActivity().getIntent();
        model = (ServiceModel) intent.getSerializableExtra("serviceObj");
        presenter = new ClinicPresenter(this, getContext());
        Toast.makeText(getContext(), model.getClinic().getId() + "", Toast.LENGTH_SHORT).show();
        presenter.getServicesByClinicId(SaveSharedPreference.getUserName(getContext()), model.getClinic().getId());
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
        System.out.println("HA: " + listResult);
        Toast.makeText(getContext(), listResult.get(0).getName() + "", Toast.LENGTH_SHORT).show();
        adapter = new ClinicPromotionAdapter(getContext(), (ArrayList<ServiceModel>) listResult);
        clinicList.setAdapter(adapter);
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
