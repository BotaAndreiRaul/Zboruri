package com.example.zboruri.Flights;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FlightDbHelper extends SQLiteOpenHelper {


    public static final String FLIGHTS_TABLE = "FLIGHTS_TABLE";
    public static final String ID = "id";
    public static final String START = "START";
    public static final String DESTINATION = "DESTINATION";
    public static final String PRICE = "PRICE";

    public FlightDbHelper(@Nullable Context context) {
        super(context, "Flights.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "Create Table " + FLIGHTS_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + START + " TEXT NOT NULL, " + DESTINATION + " TEXT NOT NULL, " + PRICE + " INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Flight flight){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(START, flight.getStart());
        contentValues.put(DESTINATION, flight.getDestination());
        contentValues.put(PRICE, flight.getPrice());

        long insert = db.insert(FLIGHTS_TABLE, null, contentValues);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<Flight> getEveryone(){
        ArrayList<Flight> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + FLIGHTS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int flightID = cursor.getInt(0);
                String flightStart = cursor.getString(1);
                String flightDestination = cursor.getString(2);
                int flightPrice = cursor.getInt(3);

                Flight flight = new Flight(flightID, flightStart, flightDestination, flightPrice);
                returnList.add(flight);

            }while (cursor.moveToNext());
        }
        else{
            //failure do not do anything
        }

        // close both cursor and database
        cursor.close();
        db.close();
        return  returnList;
    }
}
