package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarDetailsList {
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

    @SerializedName("model_no")
    @Expose
    private String modelno;

    @SerializedName("launch_date")
    @Expose
    private String launchdate;

    @SerializedName("specification")
    @Expose
    private String specification;

    @SerializedName("model_type")
    @Expose
    private String modeltype;

    @SerializedName("wheel_size")
    @Expose
    private String wsize;

    @SerializedName("features")
    @Expose
    private String features;

    @SerializedName("Cost")
    @Expose
    private String cost;

    @SerializedName("Variant")
    @Expose
    private String variant;

    @SerializedName("D_range")
    @Expose
    private String range;

    @SerializedName("motar")
    @Expose
    private String motor;

    @SerializedName("battray")
    @Expose
    private String battery;

    @SerializedName("warranty")
    @Expose
    private String warranty;

    public CarDetailsList(String message, String mdId, String sid, String carname, String photo, String modelno, String launchdate, String specification, String modeltype, String wsize, String features, String cost, String variant, String range, String motor, String battery, String warranty) {
        this.message = message;
        this.mdId = mdId;
        this.sid = sid;
        this.carname = carname;
        this.photo = photo;
        this.modelno = modelno;
        this.launchdate = launchdate;
        this.specification = specification;
        this.modeltype = modeltype;
        this.wsize = wsize;
        this.features = features;
        this.cost = cost;
        this.variant = variant;
        this.range = range;
        this.motor = motor;
        this.battery = battery;
        this.warranty = warranty;
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

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getLaunchdate() {
        return launchdate;
    }

    public void setLaunchdate(String launchdate) {
        this.launchdate = launchdate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getModeltype() {
        return modeltype;
    }

    public void setModeltype(String modeltype) {
        this.modeltype = modeltype;
    }

    public String getWsize() {
        return wsize;
    }

    public void setWsize(String wsize) {
        this.wsize = wsize;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }
}