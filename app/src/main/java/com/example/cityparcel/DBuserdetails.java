package com.example.cityparcel;

public class DBuserdetails {
    String id;
    String username;
    String phoneno;
    String birthdate;
    String anniversarydate;

    public DBuserdetails() {

    }

    public DBuserdetails(String username, String phoneno, String birthdate, String anniversarydate) {
        this.username = username;
        this.phoneno = phoneno;
        this.birthdate = birthdate;
        this.anniversarydate = anniversarydate;
    }

    public DBuserdetails(String id, String username, String phoneno, String birthdate, String anniversarydate) {
        this.id = id;
        this.username = username;
        this.phoneno = phoneno;
        this.birthdate = birthdate;
        this.anniversarydate = anniversarydate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAnniversarydate() {
        return anniversarydate;
    }

    public void setAnniversarydate(String anniversarydate) {
        this.anniversarydate = anniversarydate;
    }
}
