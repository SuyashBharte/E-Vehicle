package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StationList implements Serializable {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Station list")
    @Expose
    private List<StationModel> categorylist = null;

    public StationList(){

    }

    public StationList(String message, List<StationModel> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<StationModel> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<StationModel> categorylist) {
        this.categorylist = categorylist;
    }
}
