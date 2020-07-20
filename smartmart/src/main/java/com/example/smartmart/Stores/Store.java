package com.example.smartmart.Stores;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String storeRating;
    private String storeStatus;

    public Store() {
    }

    public Store(int storeId, String storeName, String storeAddress, String storeRating, String storeStatus) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeRating = storeRating;
        this.storeStatus = storeStatus;
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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
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

    @Override
    public String toString() {
        return "Store{" +"storeId=" + storeId + ", storeName='" + storeName + '\'' + ", storeAddress='" + storeAddress + '\'' + ", storeRating='" + storeRating + '\'' + ", storeStatus='" + storeStatus + '\'' + '}';
    }
}
