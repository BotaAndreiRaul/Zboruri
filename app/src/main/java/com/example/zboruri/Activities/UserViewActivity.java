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

import com.example.zboruri.R;
import com.example.zboruri.Users.User;
import com.example.zboruri.Users.UserDbHelper;

import java.util.List;

public class UserViewActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Users");
        listView = findViewById(R.id.UserListView);
        UserDbHelper userDbHelper = new UserDbHelper(UserViewActivity.this);
        List<User> everyone = userDbHelper.getEveryone();
        showCustomerOnListView(userDbHelper);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(UserViewActivity.this);
                    alert.setMessage("Are you sure you want to delete this user?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        User clickedUser = (User) parent.getItemAtPosition(position);
                        userDbHelper.deleteOne(clickedUser);
                        showCustomerOnListView(userDbHelper);
                        Toast.makeText(UserViewActivity.this, "Deleted User", Toast.LENGTH_SHORT).show();
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

    private void showCustomerOnListView(UserDbHelper userDbHelper) {
        ArrayAdapter customerArrayAdapter = new ArrayAdapter<User>(UserViewActivity.this, android.R.layout.simple_list_item_1, userDbHelper.getEveryone());
        listView.setAdapter(customerArrayAdapter);
    }
}