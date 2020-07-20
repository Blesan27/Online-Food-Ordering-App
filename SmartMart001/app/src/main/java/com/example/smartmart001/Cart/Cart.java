package com.example.smartmart001.Cart;

import android.graphics.Bitmap;

public class Cart {

    private int item_rate;
    private int store_id;
    private int item_id;
    private String item_name;
    private Bitmap image;

    public Cart(int item_rate, int store_id, int item_id, String item_name, Bitmap image) {
        this.item_rate = item_rate;
        this.store_id = store_id;
        this.item_id = item_id;
        this.item_name = item_name;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getItem_rate() {
        return item_rate;
    }

    public int getStore_id() {
        return store_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "item_rate=" + item_rate +
                ", store_id=" + store_id +
                ", item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                '}';
    }
}
