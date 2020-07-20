package com.example.smartmart001.Controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.example.smartmart001.Store.Store;
import com.example.smartmart001.Store.StoreAdapter;
import com.example.smartmart001.StoreItems.StoreItemsAdapter;
import com.example.smartmart001.StoreItems.StoreItemsList;

import java.io.InputStream;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private Store store;
    private StoreAdapter storeAdapter;

    private StoreItemsList storeItemsList;
    private StoreItemsAdapter storeItemsAdapter;

    public DownloadImageTask(Store store, StoreAdapter storeAdapter){
        this.store = store;
        this.storeAdapter = storeAdapter;
    }

    public DownloadImageTask(StoreItemsList storeItemsList, StoreItemsAdapter storeItemsAdapter) {
        this.storeItemsList = storeItemsList;
        this.storeItemsAdapter = storeItemsAdapter;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap bmp = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            bmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return bmp;
    }
    protected void onPostExecute(Bitmap result) {
        if (store !=null){
            store.setImage(result);
            storeAdapter.notifyDataSetChanged();

        }
        else {
            storeItemsList.setImage(result);
            storeItemsAdapter.notifyDataSetChanged();
        }
    }
}

 //new DownloadImageTask(image).execute(url);
