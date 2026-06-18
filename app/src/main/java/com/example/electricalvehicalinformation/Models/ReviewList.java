package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ReviewList implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("Category List")
    @Expose
    private List<ReviewModel> categorylist = null;


    public ReviewList(){

    }

    public ReviewList(String message, List<ReviewModel> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ReviewModel> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<ReviewModel> categorylist) {
        this.categorylist = categorylist;
    }
}
