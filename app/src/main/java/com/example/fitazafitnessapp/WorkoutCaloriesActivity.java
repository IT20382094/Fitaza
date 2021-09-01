package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutCaloriesActivity extends AppCompatActivity {

    private Button btnBurnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_calories);

        btnBurnt = findViewById(R.id.btn_burnt_calories);
        btnBurnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutBurntActivity.class);
                startActivity(intent);
            }
        });

    }
}