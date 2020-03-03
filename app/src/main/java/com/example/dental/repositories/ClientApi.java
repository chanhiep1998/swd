package com.example.dental.repositories;


public class ClientApi extends BaseApi {

    public GenericApi  getGenericApi(){
        return this.getService(GenericApi.class, ConfigApi.BASE_URL);
    }


    public GenericApi getAuthGenericApi(){
        return this.getService(GenericApi.class, ConfigApi.BASE_URL);
    }
}
