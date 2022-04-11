package com.example.zboruri;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ZboruriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zboruri);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Zboruri");
    }
}