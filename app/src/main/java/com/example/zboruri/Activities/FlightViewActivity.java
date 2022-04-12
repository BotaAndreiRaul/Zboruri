package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zboruri.Flights.Flight;
import com.example.zboruri.Flights.FlightDbHelper;
import com.example.zboruri.R;
import com.example.zboruri.Users.User;
import com.example.zboruri.Users.UserDbHelper;

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
        showFlightOnListView(flightDbHelper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(FlightViewActivity.this);
                alert.setMessage("Are you sure you want to delete this flight?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Flight clickedFlight = (Flight) parent.getItemAtPosition(position);
                        flightDbHelper.deleteOne(clickedFlight);
                        showFlightOnListView(flightDbHelper);
                        Toast.makeText(FlightViewActivity.this, "Flight deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.create().show();
            }
        });
    }

    private void showFlightOnListView(FlightDbHelper flightDbHelper) {
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<Flight>(FlightViewActivity.this, android.R.layout.simple_list_item_1, flightDbHelper.getEveryone());
        listView.setAdapter(customerArrayAdapter);
    }
}