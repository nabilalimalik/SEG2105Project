package com.example.healthcentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameCheck ,passwordCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        passwordCheck = (EditText)findViewById(R.id.password);
        usernameCheck = (EditText)findViewById(R.id.username);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NewPatientAccount(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), CreateAccount.class);
        startActivityForResult (intent,0);
    }

    public void NewEmployeeAccount(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), CreateEmployee.class);
        startActivityForResult (intent,0);
    }

    public void login(View view) {
        Intent intent = new Intent(getApplicationContext(), Welcome.class);
        startActivityForResult (intent,0);
    }
}