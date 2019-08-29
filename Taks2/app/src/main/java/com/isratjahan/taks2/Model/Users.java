package com.isratjahan.taks2.Model;

import java.util.ArrayList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("version")
    @Expose
    private Double version;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("demo")
    @Expose
    private Boolean demo;
    @SerializedName("users")
    @Expose
    private ArrayList<User> users = null;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getDemo() {
        return demo;
    }

    public void setDemo(Boolean demo) {
        this.demo = demo;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}