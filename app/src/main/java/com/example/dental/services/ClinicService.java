package com.example.dental.services;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.LoginModel;
import com.example.dental.models.ServiceModel;
import com.example.dental.models.UserModel;

import java.util.List;

public interface ClinicService {
    void getAllClinic(String token, CallBackData<List<ClinicModel>> callBackData);

    void getMostDiscountClinics(CallBackData<List<ClinicModel>> callBackData);

    void getAllServices(String token, CallBackData<List<ServiceModel>> callBackData);

    void getNearbyClinics(CallBackData<List<ClinicModel>> callBackData);

    void getClinicById(CallBackData<ClinicModel> callBackData);

    void getClinicByIdNew(int id, CallBackData<ClinicModel> callBackData);

    void getServicesByClinicId(String token, long id, CallBackData<List<ServiceModel>> callBackData);


}
