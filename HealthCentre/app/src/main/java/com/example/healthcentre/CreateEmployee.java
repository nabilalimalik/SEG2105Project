package com.example.healthcentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_employee);
    }

    public void AlreadyCreated(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult (intent,0);
    }
}
