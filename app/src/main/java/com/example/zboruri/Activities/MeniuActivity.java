package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zboruri.R;
import com.example.zboruri.Users.User;
import com.example.zboruri.Users.UserDbHelper;

public class MeniuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Meniu");

        Button viewUserBtn = findViewById(R.id.buttonViewUser);
        Button addFlightBtn = findViewById(R.id.buttonAddFlight);
        Button viewFlightBtn = findViewById(R.id.buttonViewFlights);

        viewUserBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MeniuActivity.this, UserViewActivity.class);
            startActivity(intent);
        });

        addFlightBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MeniuActivity.this, AddFlightActivity.class);
            startActivity(intent);
        });

        viewFlightBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MeniuActivity.this, FlightViewActivity.class);
            startActivity(intent);
        });
    }
}