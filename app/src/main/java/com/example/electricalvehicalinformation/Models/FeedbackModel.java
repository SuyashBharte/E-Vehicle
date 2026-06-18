package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FeedbackModel implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cname")
    @Expose
    private String cname;
    @SerializedName("cemail")
    @Expose
    private String cemail;
    @SerializedName("review")
    @Expose
    private String review;


    public FeedbackModel(){

    }

    public FeedbackModel(String id, String cname, String cemail, String review) {
        this.id = id;
        this.cname = cname;
        this.cemail = cemail;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
