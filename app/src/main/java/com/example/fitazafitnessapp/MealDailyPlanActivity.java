package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MealDailyPlanActivity extends AppCompatActivity {

    private Button btnCalorieCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_daily_plan);

//        new DatePickerDialog(MealDailyPlanActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                //DO SOMETHING
//            }
//        }, 2015, 02, 26).show();

        btnCalorieCal = findViewById(R.id.btn_calorie_cal);
        btnCalorieCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealDailyPlanActivity.this, MealPlanCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}