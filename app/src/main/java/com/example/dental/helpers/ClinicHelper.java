package com.example.dental.helpers;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
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

    public void getClinic(String token, final CallBackData<List<ClinicModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getAllClinic(token, new CallBackData<List<ClinicModel>>() {
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

    public void getAllServices(String token, final CallBackData<List<ServiceModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getAllServices(token, new CallBackData<List<ServiceModel>>() {
            @Override
            public void onSuccess(List<ServiceModel> clinicModels) {
                callBackData.onSuccess(clinicModels);
            }

            @Override
            public void onFail(String message) {

            }
        });
    }

    public void getServicesByClinicId(String token, long id, final CallBackData<List<ServiceModel>> callBackData) {
        service = new ClinicServiceImpl();
        service.getServicesByClinicId(token, id, new CallBackData<List<ServiceModel>>() {
            @Override
            public void onSuccess(List<ServiceModel> serviceModels) {
                callBackData.onSuccess(serviceModels);
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

    public void getClinicById(int clinicId, final CallBackData<ClinicModel> callBackData) {
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

    public void getClinicByIdNew(int clinicId, final CallBackData<ClinicModel> callBackData) {
        service = new ClinicServiceImpl();
        service.getClinicByIdNew(clinicId, new CallBackData<ClinicModel>() {
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
