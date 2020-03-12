package com.example.dental.helpers;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.ClinicModel;
import com.example.dental.services.ClinicService;
import com.example.dental.services.serviceimpl.ClinicServiceImpl;

import java.util.List;

public class ClinicHelper {
    private Context context;
    ClinicService service;

    public ClinicHelper(Context context) {
        this.context = context;
    }

    public ClinicHelper() {
    }

    public void getClinic(final CallBackData<List<ClinicModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getAllClinic(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                callBackData.onSuccess(clinicModels);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void getNearbyClinics(final CallBackData<List<ClinicModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getNearbyClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                callBackData.onSuccess(clinicModels);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void getMostLikedClinics(final CallBackData<List<ClinicModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getMostLikedClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                callBackData.onSuccess(clinicModels);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void getMostDiscountClinics(final CallBackData<List<ClinicModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getMostDiscountClinics(new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                callBackData.onSuccess(clinicModels);
            }
            @Override
            public void onFail(String message) {
            }
        });
    }

    public void getClinicById(final CallBackData<ClinicModel> callBackData) {
        service = new ClinicServiceImpl();
        service.getClinicById(new CallBackData<ClinicModel>() {
            @Override
            public void onSuccess(ClinicModel clinicModel) {
                callBackData.onSuccess(clinicModel);
            }
            @Override
            public void onFail(String message) {
            }
        });
    }
}
