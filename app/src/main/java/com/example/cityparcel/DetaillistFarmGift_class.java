package com.example.cityparcel;

public class DetaillistFarmGift_class {

    String title;
    String price;
    int image;



    public DetaillistFarmGift_class(String title, String price,int image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
