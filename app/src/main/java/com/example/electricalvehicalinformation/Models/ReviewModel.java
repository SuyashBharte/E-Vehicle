package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReviewModel implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("r_name")
    @Expose
    private String r_name;
    @SerializedName("r_email")
    @Expose
    private String r_email;
    @SerializedName("r_review")
    @Expose
    private String r_review;

    public ReviewModel(){

    }

    public ReviewModel(String id, String r_name, String r_email, String r_review) {
        this.id = id;
        this.r_name = r_name;
        this.r_email = r_email;
        this.r_review = r_review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_review() {
        return r_review;
    }

    public void setR_review(String r_review) {
        this.r_review = r_review;
    }
}
