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
import android.widget.Spinner;

import com.example.zboruri.Flights.Flight;
import com.example.zboruri.Flights.FlightDbHelper;
import com.example.zboruri.R;

import java.util.Arrays;
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Flight clickedFlight = (Flight) adapterView.getItemAtPosition(i);
                AlertDialog.Builder alert = new AlertDialog.Builder(ZboruriActivity.this);
                    alert.setMessage("Price is " + flightDbHelper.getPrice(clickedFlight) + " Euro");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AlertDialog.Builder alert2 = new AlertDialog.Builder(ZboruriActivity.this);
                            alert2.setMessage("Thank you for your purchase");
                            alert2.create().show();
                        }
                    });
                alert.create().show();
            }
        });
    }
}