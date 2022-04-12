package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zboruri.R;
import com.example.zboruri.Users.User;
import com.example.zboruri.Users.UserDbHelper;

import java.util.List;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("LogIn User");

        EditText emailText = findViewById(R.id.editEmail);
        EditText passwordText = findViewById(R.id.editPass);
        Button logBtn = findViewById(R.id.button2);

        logBtn.setOnClickListener(view -> {
            String email = emailText.getText().toString();
            String password = passwordText.getText().toString();
            UserDbHelper userDbHelper = new UserDbHelper(this);
            List<User> userList = userDbHelper.searchUser(email, password);
            if(!email.contains("@") || !email.contains(".") || userList.isEmpty()){
                Toast toast = Toast.makeText(this, "Email-ul sau parola sunt gresite", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Intent intent = new Intent(this, ZboruriActivity.class);
                startActivity(intent);
            }
        });
    }
}