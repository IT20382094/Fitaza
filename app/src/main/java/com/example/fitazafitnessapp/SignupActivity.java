package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class SignupActivity extends AppCompatActivity {

    private Button signupButton;
    private EditText signupName, signupEmail, signupPassword, signupRePassword;
    private FirebaseAuth mAuth;
    private DatabaseReference dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signupName);
        signupEmail = findViewById(R.id.signupEmail);
        signupPassword = findViewById(R.id.signupPassword);
        signupRePassword = findViewById(R.id.signupRePassword);

        mAuth = FirebaseAuth.getInstance();

        signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accSignup();
            }
        });
    }

    private void accSignup() {
        if (!signupName.getText().toString().equals("") && !signupEmail.getText().toString().equals("") && !signupPassword.getText().toString().equals("")) {
            if (signupPassword.getText().toString().equals(signupRePassword.getText().toString())) {
                String id = signupEmail.getText().toString().replace(".", "");
                dbUser = FirebaseDB.getFirebaseDatabase().child(id).child("user");
                User user = new User();
                user.setName(signupName.getText().toString());
                user.setEmail(signupEmail.getText().toString());
                mAuth.createUserWithEmailAndPassword(signupEmail.getText().toString(), signupPassword.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dbUser.setValue(user);
                                    signupName.setText("");
                                    signupEmail.setText("");
                                    signupPassword.setText("");
                                    signupRePassword.setText("");
                                    Toast.makeText(getApplicationContext(), "Sign Up Success", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Sign Up Failed", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            } else {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
        }
    }
}