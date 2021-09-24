package com.example.fitazafitnessapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import java.time.LocalDate;
import java.time.LocalTime;


public class WorkoutStepsActivity extends AppCompatActivity {

//    private Button btnSeeSteps,btnNext;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_workout_steps);
//
//        btnSeeSteps = findViewById(R.id.btn_see_steps);
//        btnSeeSteps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WorkoutStepsActivity.this, activity_belly_steps.class);
//                startActivity(intent);
//            }
//        });
//
//        btnNext = findViewById(R.id.btn_next);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(WorkoutStepsActivity.this, WorkoutCaloriesActivity.class);
//                startActivity(intent);
//            }
//        });
//    }



    EditText date, start_time, target_time;
    private Button btnSeeSteps,btnNext;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_steps);

        date = findViewById(R.id.workout_date);
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
    }

    public void clearControls(){

        date.setText("");
        start_time.setText("");
        target_time.setText("");
    }

    public void createData(){
        dbRef = FirebaseDatabase.getInstance().getReference();

        if (TextUtils.isEmpty(date.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter a date", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(start_time.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter a starting time", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(target_time.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter a target time", Toast.LENGTH_SHORT).show();

        else{

            Workout workoutobj = new Workout();
            workoutobj.setWorkoutDay(date.getText().toString().trim());
            workoutobj.setWorkoutStartTime(start_time.getText().toString().trim());
            workoutobj.setWorkoutTargetTime(target_time.getText().toString().trim());

            dbRef.push().setValue(workoutobj);

            //feedback to user via a toast message
            Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
            clearControls();
        }
    }
}




