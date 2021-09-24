package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ProfileViewActivity extends AppCompatActivity {

    private TextView age, weight, height, gender;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_add;
    private Button btn_bmi;

    DatabaseReference dbProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        age =findViewById(R.id.age);
        gender=findViewById(R.id.gender);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        btn_update = findViewById(R.id.btn_update);

        dbProfile = FirebaseDB.getFirebaseDatabaseRef().child("Profile");
        dbProfile.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    age.setText(snapshot.child("age").getValue().toString());
                    gender.setText(snapshot.child("gender").getValue().toString());
                    weight.setText(snapshot.child("weight").getValue().toString());
                    height.setText(snapshot.child("height").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileViewActivity.this, ProfileUpdateActivity.class);
                startActivity(intent);
            }
        });

        btn_add = findViewById(R.id.btn_back);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileViewActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        btn_bmi = findViewById(R.id.btn_bmi);
        btn_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileViewActivity.this, YourBMIActivity.class);
                startActivity(intent);
            }
        });

        btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteProfile();
                clearControls();
//                Intent intent = new Intent(ProfileViewActivity.this, MyProfileActivity.class);
//                startActivity(intent);
            }
        });

    }

    public void clearControls(){
        age.setText("");
        gender.setText("");
        weight.setText("");
        height.setText("");
    }

    public void deleteProfile(){
        dbProfile = FirebaseDB.getFirebaseDatabaseRef();
        dbProfile.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("Profile")){
                    dbProfile = FirebaseDB.getFirebaseDatabaseRef().child("Profile");
                    dbProfile.removeValue();
                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}