package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zboruri.Flights.Flight;
import com.example.zboruri.Flights.FlightDbHelper;
import com.example.zboruri.R;
import com.example.zboruri.Users.User;

import java.util.List;

public class FlightViewActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("View Flight");
        listView = findViewById(R.id.FligtListView);
        FlightDbHelper flightDbHelper = new FlightDbHelper(FlightViewActivity.this);
        List<Flight> everyone = flightDbHelper.getEveryone();
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<Flight>(FlightViewActivity.this, android.R.layout.simple_list_item_1, everyone);
        listView.setAdapter(customerArrayAdapter);

    }
}