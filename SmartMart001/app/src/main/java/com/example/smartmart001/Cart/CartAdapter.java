package com.example.smartmart001.Cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartmart001.R;

import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<Cart> {

    public CartAdapter(@NonNull Context context, ArrayList<Cart> cartItems)  {
        super(context, 0, cartItems);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View my_view = convertView;

        if(my_view == null){
            my_view = LayoutInflater.from(getContext()).inflate(R.layout.cart_view, parent, false);
        }

        Cart current_cart = getItem(position);

        TextView tv = my_view.findViewById(R.id.cart_item_name);
        
        tv.setText(current_cart != null ? current_cart.getItem_name() : null);

        tv = my_view.findViewById(R.id.cart_item_rate);
        tv.setText(""+current_cart.getItem_rate());

        Button clear = my_view.findViewById(R.id.clear_cart_view);

        ImageView im = my_view.findViewById(R.id.cart_image);
        im.setImageBitmap(current_cart.getImage());

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartFragment.cart_items.remove(position);
                CartFragment.adapter.notifyDataSetChanged();
            }
        });

        return my_view;
    }
}
