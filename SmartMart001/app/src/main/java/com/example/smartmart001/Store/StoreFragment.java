package com.example.smartmart001.Store;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.R;
import com.example.smartmart001.StoreItems.StoreItems;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreFragment extends Fragment {

    public StoreAdapter storeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.stores_fragment, container, false);


        storeAdapter = new StoreAdapter(getContext(), new ArrayList<Store>());

        try {
            Call<ArrayList<Store>> call = StoreController.getInstance().changer().getStores();

            call.enqueue(new Callback<ArrayList<Store>>() {
                @Override
                public void onResponse(Call<ArrayList<Store>> call, Response<ArrayList<Store>> response) {
                    if(!response.isSuccessful()){
                        Toaster("not Successful");
                        return;
                    }
                    storeAdapter.addAll(response.body());

                }

                @Override
                public void onFailure(Call<ArrayList<Store>> call, Throwable t) {
                    Toaster("failed");
                }
            });

        }catch (Exception e){
            Toaster("Loading Error.....");
        }




        ListView store_list_view = view.findViewById(R.id.store_list_view);

        store_list_view.setAdapter(storeAdapter);

        store_list_view.setEmptyView(view.findViewById(R.id.store_empty_view));

        store_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Store current_store = storeAdapter.getItem(position);
                if (!current_store.getStoreStatus().equals("close")) {

                    Intent i = new Intent(getContext(), StoreItems.class);
                    i.putExtra("store_id", current_store.getStoreId());
                    i.putExtra("store_name", "" + current_store.getStoreName());
                    startActivity(i);
                }
                else{
                    Toast.makeText(getContext(),"Store Closed",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

    private void Toaster(String msg){
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }
}




        /*
        stores.add(new Store(1,"Store1", "Hyderabad, Telangana","4.3", "open"));
        stores.add(new Store(2,"Store2", "Hyderabad, Telangana","3.2", "close"));
        stores.add(new Store(3,"Store3", "Hyderabad, Telangana","4.9", "open"));
        stores.add(new Store(4,"Store4", "Hyderabad, Telangana","1.4", "open"));
        stores.add(new Store(5,"Store5", "Hyderabad, Telangana","4.0", "open"));
        stores.add(new Store(6,"Store6", "Hyderabad, Telangana","5.0", "close"));
        */
