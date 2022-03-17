package com.example.cityparcel;

public class ReviewClass {
    String username;
    String reviewheading;
    String reviewdesc_line1;
    String reviewdesc_line2;
    String reviewdesc_line3;
    int userimage;

    public ReviewClass(String username, String reviewheading, String reviewdesc_line1, String reviewdesc_line2, String reviewdesc_line3,int userimage) {
        this.username = username;
        this.reviewheading = reviewheading;
        this.reviewdesc_line1 = reviewdesc_line1;
        this.reviewdesc_line2 = reviewdesc_line2;
        this.reviewdesc_line3 = reviewdesc_line3;
        this.userimage = userimage;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReviewheading() {
        return reviewheading;
    }

    public void setReviewheading(String reviewheading) {
        this.reviewheading = reviewheading;
    }

    public String getReviewdesc_line1() {
        return reviewdesc_line1;
    }

    public void setReviewdesc_line1(String reviewdesc_line1) {
        this.reviewdesc_line1 = reviewdesc_line1;
    }

    public String getReviewdesc_line2() {
        return reviewdesc_line2;
    }

    public void setReviewdesc_line2(String reviewdesc_line2) {
        this.reviewdesc_line2 = reviewdesc_line2;
    }

    public String getReviewdesc_line3() {
        return reviewdesc_line3;
    }

    public void setReviewdesc_line3(String reviewdesc_line3) {
        this.reviewdesc_line3 = reviewdesc_line3;
    }

    public int getUserimage() {
        return userimage;
    }

    public void setUserimage(int userimage) {
        this.userimage = userimage;
    }

}
