package com.example.smartmart001.Cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.History.History;
import com.example.smartmart001.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment {

    static public ArrayList<Cart> cart_items = new ArrayList<>();

    public static CartAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment, container, false);

        final Button btn = view.findViewById(R.id.order_button);

        adapter = new CartAdapter(getContext(), cart_items);

        final ListView cart_list_view = view.findViewById(R.id.cart_list_view);

        cart_list_view.setAdapter(adapter);

        cart_list_view.setEmptyView(view.findViewById(R.id.cart_items_empty_view));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Ordered",Toast.LENGTH_SHORT).show();

                for (final Cart cart: cart_items){
                    Call<Void> call = StoreController.getInstance().changer().saveHistory(new History(cart.getStore_id(), cart.getItem_id()),1);

                    call.enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            //Toast.makeText(getContext(),""+cart.getItem_id(),Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });

                }

                cart_items.clear();
                adapter.notifyDataSetChanged();

                btn.setVisibility(View.GONE);
            }
        });


        if (cart_items.isEmpty()){
            btn.setVisibility(View.GONE);
        }
        else {
            btn.setVisibility(View.VISIBLE);
        }

        return view;
    }

}
