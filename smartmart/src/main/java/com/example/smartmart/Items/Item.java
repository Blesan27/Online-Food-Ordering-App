package com.example.smartmart.Items;

import com.example.smartmart.Stores.Store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    private int itemId;
    private int itemRate;
    private String itemName;
    private String itemDescription;

    private int storeId;

    public Item() {
    }

    public Item(int itemId,int itemRate,String itemName,String itemDescription, int storeId){
        this.itemDescription = itemDescription;
        this.itemId = itemId;
        this.itemRate = itemRate;
        this.itemName = itemName;
        this.storeId = storeId;

    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemRate() {
        return itemRate;
    }

    public void setItemRate(int itemRate) {
        this.itemRate = itemRate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemRate=" + itemRate +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", storeId=" + storeId +
                '}';
    }
}
