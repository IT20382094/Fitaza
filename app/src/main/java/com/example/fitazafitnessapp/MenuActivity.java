package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button btnMyProfile, btnWorkOut, btnMealPlan, btnTimeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMyProfile = findViewById(R.id.btn_my_profile);
        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        btnWorkOut = findViewById(R.id.btn_workout);
        btnWorkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, WorkoutFocusActivity.class);
                startActivity(intent);
            }
        });

        btnMealPlan = findViewById(R.id.btn_meal_plan);
        btnMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });

        btnTimeTable = findViewById(R.id.btn_timetable);
        btnTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, SetTimeTableActivity.class);
                startActivity(intent);
            }
        });
    }
}