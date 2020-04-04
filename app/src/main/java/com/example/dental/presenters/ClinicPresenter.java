package com.example.dental.presenters;

import android.content.Context;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.helpers.ClinicHelper;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.views.ClinicView;
import com.example.dental.views.UserView;

import java.util.List;

public class ClinicPresenter {
    ClinicHelper helper;
    ClinicView view;
    UserView userView;
    Context context;

    public ClinicPresenter(ClinicView view, Context context) {
        helper = new ClinicHelper();
        this.view = view;
        this.context = context;
    }



    public void getAllClinic(String token) {
        helper.getClinic(token, new CallBackData<List<ClinicModel>>() {
            @Override
            public void onSuccess(List<ClinicModel> clinicModels) {
                view.getAllClinics(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getClinicById(int clinicId) {
        helper.getClinicById(clinicId, new CallBackData<ClinicModel>() {
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

    public void getClinicByIdNew(int clinicId) {
        helper.getClinicByIdNew(clinicId, new CallBackData<ClinicModel>() {
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

    public void getAllServices(String token) {
        helper.getAllServices(token, new CallBackData<List<ServiceModel>>() {
            @Override
            public void onSuccess(List<ServiceModel> clinicModels) {
                view.getAllServices(clinicModels);
            }

            @Override
            public void onFail(String message) {
                //Có thể tạo một hàm gì đó để trả về View
            }
        });
    }

    public void getServicesByClinicId(String token, long id) {
        helper.getServicesByClinicId(token, id, new CallBackData<List<ServiceModel>>() {
            @Override
            public void onSuccess(List<ServiceModel> serviceModels) {
                view.getServicesByClinicId(serviceModels);
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
