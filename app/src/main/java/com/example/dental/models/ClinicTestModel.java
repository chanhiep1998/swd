package com.example.dental.models;

import java.util.List;

public class ClinicTestModel {
    private int id;
    private String name;
    private int oldPrice;
    private int price;
    private String description;
    private String image;
    private List<String> services;
    float serviceRating;
    private List<CommentModel> comments;


    public ClinicTestModel() {
    }

    public ClinicTestModel(int id, String name, int oldPrice, int price, String description, String image, List<String> services, float serviceRating, List<CommentModel> comments) {
        this.id = id;
        this.name = name;
        this.oldPrice = oldPrice;
        this.price = price;
        this.description = description;
        this.image = image;
        this.services = services;
        this.serviceRating = serviceRating;
        this.comments = comments;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(float serviceRating) {
        this.serviceRating = serviceRating;
    }

    public int getDiscountPercent() {
        return (int) ((double) (price - oldPrice) / (double) oldPrice * 100);
    }
}
