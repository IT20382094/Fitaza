package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SetTimeTableActivity extends AppCompatActivity {

    private Button btnSet;
    private Spinner spinnerDay, spinnerExercise1, spinnerExercise2;
    private static final String[] pathsDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] pathsExercise = {"Arm Exercise", "Thigh Exercise"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time_table);

        spinnerDay = (Spinner) findViewById(R.id.spinner_day);
        ArrayAdapter<String> adapterDay = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, pathsDay);
        adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(adapterDay);

        spinnerExercise1 = (Spinner) findViewById(R.id.spinner_exercise1);
        ArrayAdapter<String> adapterExercise1 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, pathsExercise);
        adapterExercise1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExercise1.setAdapter(adapterExercise1);

        spinnerExercise2 = (Spinner) findViewById(R.id.spinner_exercise2);
        ArrayAdapter<String> adapterExercise2 = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, pathsExercise);
        adapterExercise2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExercise2.setAdapter(adapterExercise2);

        btnSet = findViewById(R.id.btn_set);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetTimeTableActivity.this, ViewTimeTableActivity.class);
                startActivity(intent);
            }
        });

        btnSet = findViewById(R.id.btn_set_back);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetTimeTableActivity.this, MenuActivity.class);
                startActivity(intent);
            }

        });

    }
}