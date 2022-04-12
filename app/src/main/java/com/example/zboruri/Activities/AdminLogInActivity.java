package com.example.zboruri.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zboruri.R;

public class AdminLogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("LogIn Admin");

        EditText emailText = findViewById(R.id.AdminEmail);
        EditText passwordText = findViewById(R.id.AdminPass);
        Button logBtn = findViewById(R.id.adminbtn);

        logBtn.setOnClickListener(view -> {
            String email = emailText.getText().toString();
            String password = passwordText.getText().toString();
            System.out.println(email + " " + password );
            if(!email.contains("@") || !email.contains(".") || !email.equals("admin@gmail.com") || !password.equals("admin")){
                Toast toast = Toast.makeText(this, "Email-ul sau parola sunt gresite", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Intent intent = new Intent(AdminLogInActivity.this, MeniuActivity.class);
                startActivity(intent);
            }
        });
    }
}