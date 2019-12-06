package com.example.healthcentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText username ,password;
    Button loginButton;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText)findViewById(R.id.password);
        username = (EditText)findViewById(R.id.username);
        loginButton =  (Button)findViewById(R.id.login);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //if(user != null){
        //    finish();
        //    startActivity(new Intent(MainActivity.this, Patient.class));
        //}

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                login(username.getText().toString(), password.getText().toString());
            }
        });
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

    public void login(final String usernameCheck, final String passwordCheck) {


        progressDialog.setMessage("Logging in. Please wait.");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(usernameCheck, passwordCheck).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this, Patient.class));
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else if ((usernameCheck.equals("admin"))  && (passwordCheck.equals("5T5ptQ"))) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), Admin.class);
                    startActivityForResult(intent, 0);
                }
                else{
                    Toast.makeText(MainActivity.this, "Username / Password combination does not exist.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}