package com.example.electricalvehicalinformation.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowroomDetaillist {

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("c_id")
    @Expose
    private String cid;

    @SerializedName("first")
    @Expose
    private String first;

    @SerializedName("middle")
    @Expose
    private String middle;

    @SerializedName("last")
    @Expose
    private String last;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("Showroom_name")
    @Expose
    private String shname;


    public ShowroomDetaillist(){

    }

    public ShowroomDetaillist(String message, String cid, String first, String middle, String last, String mobile, String gender, String email, String city, String address, String state, String shname) {
        this.message = message;
        this.cid = cid;
        this.first = first;
        this.middle = middle;
        this.last = last;
        this.mobile = mobile;
        this.gender = gender;
        this.email = email;
        this.city = city;
        this.address = address;
        this.state = state;
        this.shname = shname;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }
}




