package com.example.dental.repositories;

public class ConfigApi {

//    public static final String BASE_URL = "http://10.0.2.2:4000/";
    public static final String BASE_URL = "http://10.0.2.2:8080/api/";


    public interface Api {
        // Clinics Api
        String GET_CLINIC = "clinics";
        String GET_SERVICE = "patient/clinicservices";
        String GET_USER_INFORMATION = "patients/{userId}";
        String GET_SERVICES_OF_CLINIC = "patient/clinics/{clinicId}/clinicservices";



        String GET_CLINIC_NEARBY = "NearbyClinics";
        String GET_CLINIC_MOST_LIKED = "MostLiked";
        String GET_CLINIC_MOST_DISCOUNT = "MostDiscount";
        String GET_CLINIC_BY_ID = "clinic";
        String GET_CLINIC_BY_ID_TEST = "Clinics/{id}";
        String GET_CLINIC_BY_ID_NEW = "Clinics";

        String LOGIN = "auth/signin";
        String GET_USER_INFO = "test/user";

        String GET_COMMENT_FOR_CLINIC = "comments";
        String GET_DCLINIC = "vehicles/{vehicle_id}";

    }

}