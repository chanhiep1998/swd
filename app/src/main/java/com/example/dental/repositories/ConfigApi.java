package com.example.dental.repositories;

public class ConfigApi {

    public static final String BASE_URL = "http://10.0.2.2:4000/";



    public interface Api {
        // Clinics Api
        String GET_CLINIC = "Clinics";
        String GET_CLINIC_NEARBY = "NearbyClinics";
        String GET_CLINIC_MOST_LIKED = "MostLiked";
        String GET_CLINIC_MOST_DISCOUNT = "MostDiscount";
        String GET_CLINIC_BY_ID = "clinic";

        String GET_COMMENT_FOR_CLINIC = "comments";
        String GET_DCLINIC = "vehicles/{vehicle_id}";

    }

}