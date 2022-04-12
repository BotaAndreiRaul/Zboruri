package com.example.zboruri.Users;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CUSTOMER_USERNAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_PASSWORD = "CUSTOMER_AGE";

    public UserDbHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "Create Table " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + COLUMN_CUSTOMER_USERNAME + " TEXT NOT NULL, " + COLUMN_CUSTOMER_PASSWORD + " TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(User user){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CUSTOMER_USERNAME, user.getUsername());
        contentValues.put(COLUMN_CUSTOMER_PASSWORD, user.getPassword());

        long insert = db.insert(CUSTOMER_TABLE, null, contentValues);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean deleteOne(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + CUSTOMER_TABLE + " WHERE " + COLUMN_ID + " = " + user.getId();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<User> searchUser(String s1, String s2){
        ArrayList<User> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + CUSTOMER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int userID = cursor.getInt(0);
                String customerEmail = cursor.getString(1);
                String customerPass = cursor.getString(2);

                if(customerEmail.equals(s1) && customerPass.equals(s2)){
                    User user = new User(userID, customerEmail, customerPass);
                    returnList.add(user);
                }


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

    public ArrayList<User> getEveryone(){
        ArrayList<User> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + CUSTOMER_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int userID = cursor.getInt(0);
                String customerEmail = cursor.getString(1);
                String customerPass = cursor.getString(2);

                User user = new User(userID, customerEmail, customerPass);
                returnList.add(user);

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
