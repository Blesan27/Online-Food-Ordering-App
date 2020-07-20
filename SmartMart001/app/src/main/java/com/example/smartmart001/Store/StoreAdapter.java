package com.example.smartmart001.Store;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartmart001.Controller.DownloadImageTask;
import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.R;

import java.util.ArrayList;

public class StoreAdapter extends ArrayAdapter<Store> {

    public StoreAdapter(Context context, ArrayList<Store> stores){
        super(context, 0, stores);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View my_view = convertView;

        if(my_view == null){
            my_view = LayoutInflater.from(getContext()).inflate(R.layout.store_view, parent, false);
        }

        Store current_store = getItem(position);

        TextView tv = my_view.findViewById(R.id.store_name);
        tv.setText(current_store.getStoreName());
        tv = my_view.findViewById(R.id.store_address);
        tv.setText(current_store.getStoreAddress());
        tv = my_view.findViewById(R.id.store_rating);
        tv.setText(current_store.getStoreRating());
        tv = my_view.findViewById(R.id.store_status);
        String status = current_store.getStoreStatus();
        if (status.equals("open")){
            tv.setTextColor(Color.rgb(0,255,0));
        }else{
            tv.setTextColor(Color.rgb(255,0,0));
        }
        tv.setText(status);

        ImageView im = my_view.findViewById(R.id.store_image);
        Bitmap image = current_store.getImage();
        if (image == null) {
            new DownloadImageTask(current_store, this).execute("http://" + StoreController.getInstance().BaseUrl + ":8080/downloadImage/" + current_store.getStoreName() + ".jpg");
        }
        else{
            im.setImageBitmap(image);
        }
        return my_view;
    }
}

