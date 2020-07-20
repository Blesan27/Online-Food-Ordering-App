package com.example.smartmart001.StoreItems;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartmart001.Cart.Cart;
import com.example.smartmart001.Cart.CartFragment;
import com.example.smartmart001.Controller.DownloadImageTask;
import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.R;

import java.util.ArrayList;

public class StoreItemsAdapter extends ArrayAdapter<StoreItemsList> {

    public StoreItemsAdapter(Context context, ArrayList<StoreItemsList> storeItems){
        super(context, 0, storeItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        View my_view = convertView;

        if(my_view == null){
            my_view = LayoutInflater.from(getContext()).inflate(R.layout.store_item_view, parent, false);
        }

        final StoreItemsList current_store_item = getItem(position);

        TextView tv = my_view.findViewById(R.id.item_name);
        tv.setText(current_store_item.getItem_name());
        tv = my_view.findViewById(R.id.item_description);
        tv.setText(current_store_item.getItem_description());
        tv = my_view.findViewById(R.id.item_rate);
        tv.setText(""+current_store_item.getItem_rate());

        ImageView im = my_view.findViewById(R.id.item_image);
        Bitmap image = current_store_item.getImage();
        if (image == null) {
            new DownloadImageTask(current_store_item, this).execute("http://" + StoreController.getInstance().BaseUrl + ":8080/downloadImage/" + current_store_item.getItem_name() + ".jpg");
        }
        else{
            im.setImageBitmap(image);
        }

        Button add_to_cart = my_view.findViewById(R.id.button_add_to_cart);
        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartFragment.cart_items.add(new Cart(current_store_item.getItem_rate(),
                                            current_store_item.getStore_id(),
                                            current_store_item.getItem_id(),
                                            current_store_item.getItem_name(),
                                            current_store_item.getImage()));

                Toast.makeText(getContext(), "Added to Cart "+current_store_item.getItem_name(),Toast.LENGTH_SHORT).show();

            }
        });
        Button share = my_view.findViewById(R.id.share_item_list_view);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_SENDTO);
                in.putExtra(Intent.EXTRA_TEXT, "Try "+current_store_item.getItem_name()+" by ordering in SmartMart app.");
                in.setData(Uri.parse("mailto:"));
                in.putExtra(Intent.EXTRA_SUBJECT, "SMARTMART the best food ordering app");
                in.putExtra(Intent.EXTRA_EMAIL, "name@smartmart.com");
                if (in.resolveActivity(getContext().getPackageManager())!=null)
                    getContext().startActivity(in);

                Toast.makeText(getContext(), "shared "+current_store_item.getItem_name(),Toast.LENGTH_SHORT).show();
            }
        });
        return my_view;
    }
}

