package com.cax.jeffchen.mylistview;

/**
 * Created by jeffchen on 16/7/26.
 */
public class Spot {
    private int imageId;
    private String name;
    private String address;
    private String phone;

    public Spot(int imageId, String name, String address, String phone) {
        this.imageId = imageId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
