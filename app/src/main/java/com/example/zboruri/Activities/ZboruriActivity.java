package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zboruri.Flights.Flight;
import com.example.zboruri.Flights.FlightDbHelper;
import com.example.zboruri.R;

import java.util.List;

public class ZboruriActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zboruri);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Flights");
        listView = findViewById(R.id.ZboruriListView);
        FlightDbHelper flightDbHelper = new FlightDbHelper(ZboruriActivity.this);
        List<Flight> everyone = flightDbHelper.getEveryone();
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<Flight>(ZboruriActivity.this, android.R.layout.simple_list_item_1, everyone);
        listView.setAdapter(customerArrayAdapter);
    }
}