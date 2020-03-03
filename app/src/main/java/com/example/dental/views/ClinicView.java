package com.example.dental.views;

import com.example.dental.models.ClinicModel;

import java.util.List;

public interface ClinicView {
    void getAllClinic(List<ClinicModel> listResult);
    void getMostLikedClinics(List<ClinicModel> listResult);
    void getMostDiscountClinics(List<ClinicModel> listResult);
    void getNearbyClinics(List<ClinicModel> listResult);
}
