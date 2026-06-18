package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CarImageResponse implements Serializable {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("md_id")
    @Expose
    private String mdId;

    @SerializedName("s_id")
    @Expose
    private String sid;

    @SerializedName("car_name")
    @Expose
    private String carname;

    @SerializedName("c_photo")
    @Expose
    private String photo;


    public CarImageResponse(String message, String mdId, String sid, String carname, String photo) {
        this.message = message;
        this.mdId = mdId;
        this.sid = sid;
        this.carname = carname;
        this.photo = photo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMdId() {
        return mdId;
    }

    public void setMdId(String mdId) {
        this.mdId = mdId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
