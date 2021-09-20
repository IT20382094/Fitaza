package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealPlanCalculatorActivity extends AppCompatActivity {

    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_calculator);

        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanCalculatorActivity.this, MealPlanResultActivity.class);
                startActivity(intent);
            }
        });

        btnCalculate = findViewById(R.id.btn_calculate_back);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanCalculatorActivity.this, MealDailyPlanActivity.class);
                startActivity(intent);
            }
        });
    }
}