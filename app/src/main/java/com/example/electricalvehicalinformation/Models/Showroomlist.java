package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Showroomlist {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("showroom list")
    @Expose
    private List<ShowroomDetaillist> categorylist = null;

    public Showroomlist() {

    }

    public Showroomlist(String message, List<ShowroomDetaillist> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ShowroomDetaillist> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<ShowroomDetaillist> categorylist) {
        this.categorylist = categorylist;
    }
}


