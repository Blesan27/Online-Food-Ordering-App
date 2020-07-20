package com.example.smartmart001.StoreItems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.smartmart001.Controller.StoreController;
import com.example.smartmart001.Main2Activity;
import com.example.smartmart001.R;
import com.example.smartmart001.Settings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreItems extends AppCompatActivity {

    public StoreItemsAdapter storeItemsAdapter;

    Toolbar toolbar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_items);
        Intent i = getIntent();
        int store_id = i.getIntExtra("store_id", 0);

        toolbar = findViewById(R.id.store_items_toolbar);
        toolbar.setTitle(i.getStringExtra("store_name"));
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        storeItemsAdapter = new StoreItemsAdapter(getApplicationContext(), new ArrayList<StoreItemsList>());


        Call<ArrayList<StoreItemsList>> call = StoreController.getInstance().changer().getItems(store_id);

        call.enqueue(new Callback<ArrayList<StoreItemsList>>() {
            @Override
            public void onResponse(Call<ArrayList<StoreItemsList>> call, Response<ArrayList<StoreItemsList>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Not successful", Toast.LENGTH_SHORT).show();
                }

                storeItemsAdapter.addAll(response.body());
                //Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayList<StoreItemsList>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });


        ListView store_item_list_view = findViewById(R.id.store_items_list_view);

        store_item_list_view.setAdapter(storeItemsAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.settings){
            Intent i = new Intent(getApplicationContext(), Settings.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.cart_icon){
            Intent i = new Intent(this, Main2Activity.class);
            i.putExtra("gotoCart",true);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }


}
/*
        storeItems.add(new StoreItemsList(store_id,1,241,"Biryani", "Non-Veg Mutton Biryani"));
        storeItems.add(new StoreItemsList(store_id,2,241,"Biryani", "Non-Veg Mutton Biryani"));
        storeItems.add(new StoreItemsList(store_id,3,241,"Biryani", "Non-Veg Mutton Biryani"));
        storeItems.add(new StoreItemsList(store_id,4,241,"Biryani", "Non-Veg Mutton Biryani"));
        storeItems.add(new StoreItemsList(store_id,5,241,"Biryani", "Non-Veg Mutton Biryani"));
        storeItems.add(new StoreItemsList(store_id,6,241,"Biryani", "Non-Veg Mutton Biryani"));
*/