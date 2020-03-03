package com.example.dental.repositories;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GenericApi {

    @GET(ConfigApi.Api.GET_CLINIC)
    Call<ResponseBody> getClinic();

    @GET(ConfigApi.Api.GET_CLINIC_NEARBY)
    Call<ResponseBody> getNearbyClinics();

    @GET(ConfigApi.Api.GET_CLINIC_MOST_LIKED)
    Call<ResponseBody> getMostLikedClinics();

    @GET(ConfigApi.Api.GET_CLINIC_MOST_DISCOUNT)
    Call<ResponseBody> getMostDiscountClinics();

//    @GET(ConfigApi.Api.GET_VEHICLE)
//    Call<ResponseBody> getVehicleById(@Path("vehicle_id") int vehicleId);


}
