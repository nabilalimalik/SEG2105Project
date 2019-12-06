package com.example.healthcentre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class CreateAccount extends AppCompatActivity {

    private EditText setfirstname, setlastname, setusername, setpassword;
    private Button setcreateaccount;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        setcreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    //Upload data to the database
                    String add_firstname = setfirstname.getText().toString().trim();
                    String add_lastname = setlastname.getText().toString().trim();
                    String add_username = setusername.getText().toString().trim();
                    String add_password = setpassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(add_username, add_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(CreateAccount.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(CreateAccount.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(CreateAccount.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void setupUIViews(){
        setfirstname = (EditText)findViewById(R.id.firstname);
        setlastname = (EditText)findViewById(R.id.lastname);
        setusername = (EditText)findViewById(R.id.username);
        setpassword = (EditText)findViewById(R.id.password);
        setcreateaccount = (Button)findViewById(R.id.createaccount);
    }

    private Boolean validate(){
        Boolean result = false;

        String firstnameCheck = setfirstname.getText().toString();
        String lastnameCheck = setlastname.getText().toString();
        String usernameCheck = setusername.getText().toString();
        String passwordCheck = setpassword.getText().toString();

        if(usernameCheck.isEmpty() || passwordCheck.isEmpty()){
            Toast.makeText(this, "Please enter all information", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }

        return result;
    }

    public void AlreadyCreated(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult (intent,0);
    }
}