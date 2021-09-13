package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_belly_steps extends AppCompatActivity {

    private Button btnGoToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belly_steps);

        btnGoToHome = findViewById(R.id.btn_start);
        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_belly_steps.this, WorkoutStepsActivity.class);
                startActivity(intent);
            }
        });

    }
}