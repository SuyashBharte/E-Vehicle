package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileList {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("car List")
    @Expose
    private List<CarImageResponse> categorylist = null;


    public ProfileList() {

    }

    public ProfileList(String message, List<CarImageResponse> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CarImageResponse> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<CarImageResponse> categorylist) {
        this.categorylist = categorylist;
    }
}