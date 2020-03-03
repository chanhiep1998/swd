package com.example.dental.models;

public class BookingTimeModel {
    private String time;
    private String price;

    public BookingTimeModel(String time, String price) {
        this.time = time;
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
