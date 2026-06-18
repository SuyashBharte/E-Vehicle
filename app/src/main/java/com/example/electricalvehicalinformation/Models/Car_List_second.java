package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Car_List_second {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Car detail")
    @Expose
    private List<CarDetailsList_Second> categorylist = null;

    public Car_List_second() {

    }

    public Car_List_second(String message, List<CarDetailsList_Second> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CarDetailsList_Second> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<CarDetailsList_Second> categorylist) {
        this.categorylist = categorylist;
    }
}










