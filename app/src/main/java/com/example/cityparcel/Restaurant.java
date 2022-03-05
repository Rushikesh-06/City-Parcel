package com.example.cityparcel;

public class Restaurant {
    String title;
    String description;
    String delivery_time;
    double rating;
    int image;

    public Restaurant(String title, String description, String delivery_time, double rating, int image) {
        this.title = title;
        this.description = description;
        this.delivery_time = delivery_time;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
