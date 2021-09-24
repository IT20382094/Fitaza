package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.MyProfile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileUpdateActivity extends AppCompatActivity {
    private EditText age, weight, height, gender;
    private Button btnUpdateProfile;
    private Button btnBack;
    DatabaseReference dbProfile;
    private String pAge, pGender, pWeight, pHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        btnUpdateProfile = findViewById(R.id.btn_update_profile);
        btnBack = findViewById(R.id.btn_back);

        Intent intent = getIntent();

        pAge = intent.getStringExtra("age");
        pGender = intent.getStringExtra("gender");
        pWeight = intent.getStringExtra("weight");
        pHeight = intent.getStringExtra("height");

        age.setText(pAge);
        gender.setText(pGender);
        weight.setText(pWeight);
        height.setText(pHeight);

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Intent intent = new Intent(ProfileUpdateActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileUpdateActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

    }

    public void updateData() {
        dbProfile = FirebaseDB.getFirebaseDatabaseRef();
        dbProfile.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("Profile")) {
                    MyProfile myProfile = new MyProfile();
                    myProfile.setAge(Integer.parseInt(age.getText().toString().trim()));
                    myProfile.setGender(gender.getText().toString().trim());
                    myProfile.setWeight(Double.parseDouble(weight.getText().toString().trim()));
                    myProfile.setHeight(Double.parseDouble(height.getText().toString().trim()));

                    dbProfile = FirebaseDB.getFirebaseDatabaseRef().child("Profile");
                    dbProfile.setValue(myProfile);
                    Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}




