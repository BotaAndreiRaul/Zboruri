package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zboruri.R;
import com.example.zboruri.Users.User;
import com.example.zboruri.Users.UserDbHelper;

public class UserAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Add User");

        Button addBtn = findViewById(R.id.buttonAdd);
        EditText emailEt = findViewById(R.id.editTextEmail);
        EditText userPassEt = findViewById(R.id.editTextPassword);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!emailEt.getText().toString().contains("@") || !emailEt.getText().toString().contains(".") || userPassEt.getText().toString().length()==0){
                    Toast.makeText(UserAddActivity.this, "Error Creating User", Toast.LENGTH_SHORT).show();
                }
                else{
                    UserDbHelper userDbHelper = new UserDbHelper(UserAddActivity.this);
                    User user;
                    user = new User(-1, emailEt.getText().toString(), userPassEt.getText().toString());
                    boolean succes = userDbHelper.addOne(user);
                    if(succes){
                        Toast.makeText(UserAddActivity.this, "User created succesfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UserAddActivity.this, LogInActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(UserAddActivity.this, "Succes= " + succes, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}