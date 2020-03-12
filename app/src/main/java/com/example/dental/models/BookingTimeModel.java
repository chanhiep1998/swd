package com.example.dental.models;

public class BookingTimeModel {
    private String time;
    private String price;
    private int people;

    public BookingTimeModel(String time, String price, int people) {
        this.time = time;
        this.price = price;
        this.people = people;
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

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
}
