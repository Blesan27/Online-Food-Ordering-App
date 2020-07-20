package com.example.smartmart001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.smartmart001.Cart.CartFragment;
import com.example.smartmart001.History.HistoryFragment;
import com.example.smartmart001.Store.StoreFragment;
import com.google.android.material.navigation.NavigationView;

public class Main2Activity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        boolean b = i.getBooleanExtra("gotoCart",false);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        navigationView = findViewById(R.id.navigation);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new StoreFragment()).commit();
            navigationView.setCheckedItem(R.id.stores);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch(id){

                    case R.id.cart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new CartFragment()).commit();
                        break;

                    case R.id.stores:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new StoreFragment()).commit();
                        break;

                    case R.id.history:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HistoryFragment()).commit();
                        break;

                    case R.id.share:
                        Intent in = new Intent(Intent.ACTION_SENDTO);
                        in.putExtra(Intent.EXTRA_TEXT, "Hi, Iam having fun ordering and having food using this app.\nSure you to TRY IT!!!");
                        in.setData(Uri.parse("mailto:"));
                        in.putExtra(Intent.EXTRA_SUBJECT, "SMARTMART the best food ordering app");
                        in.putExtra(Intent.EXTRA_EMAIL, "name@smartmart.com");
                        if (in.resolveActivity(getPackageManager())!=null)
                            startActivity(in);
                        break;

                    case R.id.logout:
                        Toast toast = Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        if (b){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new CartFragment()).commit();
            navigationView.setCheckedItem(R.id.cart);
        }

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
            navigationView.setCheckedItem(R.id.cart);
            getSupportFragmentManager().beginTransaction() .replace(R.id.fragmentcontainer, new CartFragment()).commit();

        }

        return super.onOptionsItemSelected(item);
    }

    public void CloseDrawer(View view){
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else if (navigationView.getCheckedItem().getItemId() == R.id.stores){
            Toast.makeText(getApplicationContext(), "Logout to go Back", Toast.LENGTH_SHORT).show();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new StoreFragment()).commit();
            navigationView.setCheckedItem(R.id.stores);
        }
    }

}