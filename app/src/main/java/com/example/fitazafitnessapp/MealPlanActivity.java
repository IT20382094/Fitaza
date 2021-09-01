package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealPlanActivity extends AppCompatActivity {

    private Button btnDailyPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        btnDailyPlan = findViewById(R.id.btn_daily_plan);
        btnDailyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanActivity.this, MealDailyPlanActivity.class);
                startActivity(intent);
            }
        });
    }
}