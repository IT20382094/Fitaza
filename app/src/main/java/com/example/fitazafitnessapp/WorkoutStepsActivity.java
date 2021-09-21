package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutStepsActivity extends AppCompatActivity {

    private Button btnSeeSteps,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_steps);

        btnSeeSteps = findViewById(R.id.btn_see_steps);
        btnSeeSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutStepsActivity.this, activity_belly_steps.class);
                startActivity(intent);
            }
        });

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutStepsActivity.this, WorkoutCaloriesActivity.class);
                startActivity(intent);
            }
        });
    }
}