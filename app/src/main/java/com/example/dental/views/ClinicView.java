package com.example.dental.views;

import com.example.dental.models.ClinicModel;
import com.example.dental.models.ClinicModel;
import com.example.dental.models.ServiceModel;

import java.util.List;

public interface ClinicView {
    void getAllClinics(List<ClinicModel> listResult);

    void getAllServices(List<ServiceModel> listResult);

    void getServicesByClinicId(List<ServiceModel> listResult);

    void getMostDiscountClinics(List<ClinicModel> listResult);

    void getNearbyClinics(List<ClinicModel> listResult);

    void getClinicById(ClinicModel result);

    void getClinicByIdNew(ClinicModel result);



}
