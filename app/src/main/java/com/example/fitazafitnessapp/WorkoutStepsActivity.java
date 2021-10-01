package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.DatabaseReference;

public class WorkoutStepsActivity extends AppCompatActivity {

    private TimePicker start_time, target_time;
    private Button btnSeeSteps,btnNext;
    DatabaseReference dbRef;
    private Workout workoutObj = new Workout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_steps);

        start_time = findViewById(R.id.workout_start_time);
        target_time = findViewById(R.id.workout_end_time);

        btnNext = findViewById(R.id.btn_next);

        dbRef = FirebaseDB.getFirebaseDatabaseRef();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createData();
                Intent intent = new Intent(WorkoutStepsActivity.this, WorkoutCaloriesActivity.class);
                startActivity(intent);
            }
        });

        btnSeeSteps = findViewById(R.id.btn_see_steps);
        btnSeeSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutStepsActivity.this, activity_belly_steps.class);
                startActivity(intent);
            }
        });
    }

    public void createData(){
        dbRef = FirebaseDB.getFirebaseDatabaseRef();

        workoutObj.setWorkoutStartTimeH(start_time.getHour());
        workoutObj.setWorkoutStartTimeM(start_time.getMinute());
        workoutObj.setWorkoutTargetTimeH(target_time.getHour());
        workoutObj.setWorkoutTargetTimeM(target_time.getMinute());

        dbRef.child("Workout").setValue(workoutObj);

        Toast.makeText(getApplicationContext(), "Workout inserted successfully", Toast.LENGTH_SHORT).show();

    }
}




