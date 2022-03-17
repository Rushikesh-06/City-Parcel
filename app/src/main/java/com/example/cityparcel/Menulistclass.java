package com.example.cityparcel;

public class Menulistclass {

    String dishname;
    String price;
    String description;
    int image;

    public Menulistclass(String dishname, String price, String description,int image) {
        this.dishname = dishname;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
