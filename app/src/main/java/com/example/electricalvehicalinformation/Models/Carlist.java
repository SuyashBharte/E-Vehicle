package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Carlist {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Car detail")
    @Expose
    private List<CarDetailsList> categorylist = null;

    public Carlist() {

    }

    public Carlist(String message, List<CarDetailsList> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CarDetailsList> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<CarDetailsList> categorylist) {
        this.categorylist = categorylist;
    }
}










