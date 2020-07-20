package com.example.smartmart001.StoreItems;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class StoreItemsList {

    @SerializedName("storeId")
    private int store_id;
    @SerializedName("itemId")
    private int item_id;
    @SerializedName("itemRate")
    private int item_rate;
    @SerializedName("itemName")
    private String item_name;
    @SerializedName("itemDescription")
    private String item_description;

    private Bitmap Image;

    public Bitmap getImage() {
        return Image;
    }

    public void setImage(Bitmap image) {
        Image = image;
    }

    StoreItemsList(int id, int itemId, int rate, String name, String description){
        store_id = id;
        item_id = itemId;
        item_rate = rate;
        item_name = name;
        item_description = description;
    }

    public String getItem_name() {
        return item_name;
    }
    public int getStore_id() {
        return store_id;
    }

    public int getItem_rate() {
        return item_rate;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_description() {
        return item_description;
    }

    @Override
    public String toString() {
        return "StoreItemsList{" +
                "store_id=" + store_id +
                ", item_id=" + item_id +
                ", item_rate=" + item_rate +
                ", item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                '}';
    }
}
