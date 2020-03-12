package com.example.dental.presenters;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.fragments.HomeNearbyFragment;
import com.example.dental.helpers.ClinicHelper;
import com.example.dental.models.ClinicModel;
import com.example.dental.views.ClinicView;

import java.util.List;

public class ClinicPresenter {
    ClinicHelper helper;
    ClinicView view;
    Context context;

    public ClinicPresenter(ClinicView view, Context context) {
        helper = new ClinicHelper();
        this.view = view;
        this.context = context;
    }


    public void getAllClinic() {
        helper.getClinic(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                view.getAllClinic(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getClinicById() {
        helper.getClinicById(new CallBackData<ClinicModel>() {
            @Override
            public void onSuccess(ClinicModel clinicModel) {
                view.getClinicById(clinicModel);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getNearbyClinics() {
        helper.getNearbyClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                view.getNearbyClinics(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getMostLikedClinics() {
        helper.getMostLikedClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                view.getMostLikedClinics(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getMostDiscountClinics() {
        helper.getMostDiscountClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                view.getMostDiscountClinics(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }
}
