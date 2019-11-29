package com.example.healthcentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username = (EditText)findViewById(R.id.username);
    EditText password = (EditText)findViewById(R.id.password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        if (username.getText().toString().equals("admin") && password.getText().toString().equals("5T5ptQ")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult (intent,0);
        }
    }
}
