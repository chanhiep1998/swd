package com.example.dental.models;

import java.io.Serializable;

public class ServiceModel implements Serializable {
    String id, name, description;
    int price;
    ClinicModel clinic;


    public ServiceModel() {
    }

    public ServiceModel(String id, String name, String description, int price, ClinicModel clinic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.clinic = clinic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ClinicModel getClinic() {
        return clinic;
    }

    public void setClinic(ClinicModel clinic) {
        this.clinic = clinic;
    }
}
