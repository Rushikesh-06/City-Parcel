package com.example.cityparcel;

public class adresslist {
 String email;
 String name;
 String address;
 String nearestlandmark;
 String state;
 String city;
 Boolean typeofaddress;


    public adresslist(String email, String name, String address, String nearestlandmark, String state, String city, Boolean typeofaddress) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.nearestlandmark = nearestlandmark;
        this.state = state;
        this.city = city;
        this.typeofaddress = typeofaddress;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNearestlandmark() {
        return nearestlandmark;
    }

    public void setNearestlandmark(String nearestlandmark) {
        this.nearestlandmark = nearestlandmark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getTypeofaddress() {
        return typeofaddress;
    }

    public void setTypeofaddress(Boolean typeofaddress) {
        this.typeofaddress = typeofaddress;
    }
}
