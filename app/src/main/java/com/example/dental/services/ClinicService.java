package com.example.dental.services;

import com.example.dental.callbacks.CallBackData;
import com.example.dental.models.ClinicModel;

import java.util.List;

public interface ClinicService {
    void getAllClinic(CallBackData<List<ClinicModel>> callBackData);
    void getMostDiscountClinics(CallBackData<List<ClinicModel>> callBackData);
    void getMostLikedClinics(CallBackData<List<ClinicModel>> callBackData);
    void getNearbyClinics(CallBackData<List<ClinicModel>> callBackData);
}
