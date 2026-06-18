package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FeedbackList implements Serializable {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("customer review List")
    @Expose
    private List<FeedbackModel> categorylist = null;


    public FeedbackList(){

    }

    public FeedbackList(String message, List<FeedbackModel> categorylist) {
        this.message = message;
        this.categorylist = categorylist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FeedbackModel> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<FeedbackModel> categorylist) {
        this.categorylist = categorylist;
    }
}
