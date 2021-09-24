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

public class MealPlanResultActivity extends AppCompatActivity {

    private Button btnGoToHome;
    private TextView age;
    private TextView weight;
    private TextView height;
    private TextView gender;
    DatabaseReference dbRef;
    MealPlanCalculatorActivity result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_result);

        age =findViewById(R.id.et_age);
        gender=findViewById(R.id.et_gender);
        weight=findViewById(R.id.et_weight);
        height=findViewById(R.id.et_height);

        dbRef = FirebaseDB.getFirebaseDB().child("Profile");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
//                    result.BMRCalculation(weight.par, height, gender, age);
                }
                else
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnGoToHome = findViewById(R.id.btn_go_to_home);



        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanResultActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        btnGoToHome = findViewById(R.id.btn_go_to_home_back);
        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanResultActivity.this, MealPlanCalculatorActivity.class);
                startActivity(intent);
            }
        });



    }




}