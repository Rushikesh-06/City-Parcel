package com.example.cityparcel;

public class DeatillistClass {

    String title;
    String description;
    String price;
    String delivery_time;
    int image;





    public DeatillistClass(String title, String description, String price, String delivery_time,int image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.delivery_time = delivery_time;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
