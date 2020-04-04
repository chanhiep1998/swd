package com.example.dental.repositories;

import com.example.dental.models.LoginModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GenericApi {

    @POST(ConfigApi.Api.LOGIN)
    Call<ResponseBody> login(@Body LoginModel loginModel);

    @GET(ConfigApi.Api.GET_USER_INFORMATION)
    Call<ResponseBody> getUserInfo(@Header("Authorization") String authToken, @Path("userId") long id);

    @GET(ConfigApi.Api.GET_CLINIC)
    Call<ResponseBody> getClinic(@Header("Authorization") String authToken);

    @GET(ConfigApi.Api.GET_SERVICE)
    Call<ResponseBody> getService(@Header("Authorization") String authToken);

    @GET(ConfigApi.Api.GET_SERVICES_OF_CLINIC)
    Call<ResponseBody> getServicesByClinicId(@Header("Authorization") String authToken, @Path("clinicId") long id);

    @GET(ConfigApi.Api.GET_CLINIC_NEARBY)
    Call<ResponseBody> getNearbyClinics();

    @GET(ConfigApi.Api.GET_CLINIC_MOST_LIKED)
    Call<ResponseBody> getMostLikedClinics();

    @GET(ConfigApi.Api.GET_CLINIC_MOST_DISCOUNT)
    Call<ResponseBody> getMostDiscountClinics();

    @GET(ConfigApi.Api.GET_CLINIC_BY_ID)
    Call<ResponseBody> getClinicById();

    @GET(ConfigApi.Api.GET_CLINIC_BY_ID_NEW)
    Call<ResponseBody> getClinicByIdNew(@Query("id") int id);

    @GET(ConfigApi.Api.GET_CLINIC_BY_ID_TEST)
    Call<ResponseBody> getClinicByIdTest(@Path("id") int id);

    @GET(ConfigApi.Api.GET_COMMENT_FOR_CLINIC)
    Call<ResponseBody> getCommentForClinic();

//    @GET(ConfigApi.Api.GET_VEHICLE)
//    Call<ResponseBody> getVehicleById(@Path("vehicle_id") int vehicleId);


}
