package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutFocusActivity extends AppCompatActivity {

    private static String exerciseType;
    private Button btnBelly, btnButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_focus);

        btnBelly = findViewById(R.id.btn_belly);
        btnBelly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFocusActivity.this, activity_belly_steps.class);
                startActivity(intent);
            }
        });

        btnButt = findViewById(R.id.btn_butt);
        btnButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFocusActivity.this, activity_butt_steps.class);
                startActivity(intent);
            }
        });

        btnButt = findViewById(R.id.btn_chest);
        btnButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFocusActivity.this, activity_chest_steps.class);
                startActivity(intent);
            }
        });

        btnButt = findViewById(R.id.btn_legs);
        btnButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFocusActivity.this, activity_legs_steps.class);
                startActivity(intent);
            }
        });

        btnButt = findViewById(R.id.btn_shoulder);
        btnButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutFocusActivity.this, activity_shoulder_steps.class);
                startActivity(intent);
            }
        });
    }
}