package com.example.dental.models;

import java.io.Serializable;
import java.util.List;

public class ClinicModel implements Serializable {
    private int id;
    private String name;
    private int oldPrice;
    private int price;
    private String description;
    private String phone;
    private String address;
    private String image;
    private List<ServiceModel> services;
    private float latitude;
    private float longtitude;


    public ClinicModel() {
    }

    public ClinicModel(int id, String name, int oldPrice, int price, String description, String phone, String address, String image, List<ServiceModel> services, float latitude, float longtitude) {
        this.id = id;
        this.name = name;
        this.oldPrice = oldPrice;
        this.price = price;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.services = services;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ServiceModel> getServices() {
        return services;
    }

    public void setServices(List<ServiceModel> services) {
        this.services = services;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public int getDiscountPercent() {
        return (int) ((double) (price - oldPrice) / (double) oldPrice * 100);
    }
}
