package com.example.smartmart001.History;

import com.google.gson.annotations.SerializedName;

public class History {
    private Integer id;
    @SerializedName("storeId")
    private int store_id;
    private Integer customerId;
    private int itemId;
    private String date;
    private String itemName;
    private String storeName;

    public History() {
    }


    public History(Integer id, int store_id, Integer customerId, int itemId, String date, String itemName, String storeName) {
        this.id = id;
        this.store_id = store_id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.date = date;
        this.itemName = itemName;
        this.storeName = storeName;
    }

    public History(int store_id, int itemId) {
        this.store_id = store_id;
        this.itemId = itemId;
        id = null;
        customerId = null;
        date = null;
        itemName = null;
        storeName = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "History{" +
                "store_id=" + store_id +
                ", customerId=" + customerId +
                ", itemId=" + itemId +
                ", date=" + date +
                '}';
    }
}
