package com.example.smartmart001.Store;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("storeId")
    private int storeId;
    @SerializedName("storeName")
    private String storeName;
    @SerializedName("storeRating")
    private String storeRating;
    @SerializedName("storeStatus")
    private String storeStatus;
    @SerializedName("storeAddress")
    private String storeAddress;

    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Store(int storeId, String storeName, String storeRating, String storeStatus, String storeAddress) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeRating = storeRating;
        this.storeStatus = storeStatus;
        this.storeAddress = storeAddress;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreRating() {
        return storeRating;
    }

    public void setStoreRating(String storeRating) {
        this.storeRating = storeRating;
    }

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeRating='" + storeRating + '\'' +
                ", storeStatus='" + storeStatus + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                '}';
    }
}
