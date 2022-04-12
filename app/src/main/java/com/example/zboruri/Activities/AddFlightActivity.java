package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zboruri.Flights.Flight;
import com.example.zboruri.Flights.FlightDbHelper;
import com.example.zboruri.R;

public class AddFlightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add Flight");

        EditText start = findViewById(R.id.startEt);
        EditText destination = findViewById(R.id.destinationEt);
        EditText price = findViewById(R.id.priceEt);
        Button saveBtn = findViewById(R.id.savebtn);

        saveBtn.setOnClickListener(view -> {
            FlightDbHelper flightDbHelper = new FlightDbHelper(AddFlightActivity.this);
            Flight flight;
            try {
                flight = new Flight(-1, start.getText().toString(), destination.getText().toString(), Integer.parseInt(price.getText().toString()));
                boolean succes = flightDbHelper.addOne(flight);
                Toast.makeText(AddFlightActivity.this, "Flight added succesfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(AddFlightActivity.this, "Error creating flight", Toast.LENGTH_SHORT).show();
            }
        });
    }
}