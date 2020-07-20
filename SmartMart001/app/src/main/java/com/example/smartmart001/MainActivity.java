package com.example.smartmart001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartmart001.Controller.StoreController;

public class MainActivity extends AppCompatActivity {


    TextView login_id,password,password_error,login_id_error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);
            }
        });

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login_id = findViewById(R.id.loginid);
                password = findViewById(R.id.password);
                login_id_error = findViewById(R.id.loginid_error);
                password_error = findViewById(R.id.password_error);

                int login = 0;
                int pass = 0;

                if (login_id.getText().toString().matches("")) {
                    login_id_error.setVisibility(View.VISIBLE);
                } else if (login_id.getText().toString().equals("admin")) {
                    login = 1;
                    login_id_error.setVisibility(View.GONE);
                } else {
                    login_id_error.setVisibility(View.GONE);
                }

                if (password.getText().toString().matches("")) {
                    password_error.setVisibility(View.VISIBLE);
                } else if (password.getText().toString().equals("admin")) {
                    pass = 1;
                }


                //StoreController.getInstance().BaseUrl = password.getText().toString();
                if (login == 1 && pass == 1) {
                    Toast.makeText(getApplicationContext(),"http://"+StoreController.getInstance().BaseUrl+":"+StoreController.getInstance().Port, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(i);

                }


            }
        });

    }

    public void forgotPassword(View v) {
        Toast.makeText(getApplicationContext(), "Password - admin", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}
