package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class WorkoutUpdate extends AppCompatActivity {

    TimePicker start_time, target_time;
    DatabaseReference dbRef;
    Button btn_update;
    private String pStart, pTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_update);

        start_time = findViewById(R.id.workout_start_time);
        target_time = findViewById(R.id.workout_end_time);

        btn_update = findViewById(R.id.btn_next);

        Intent intent = getIntent();

        pStart = intent.getStringExtra("workoutStartTime");
        pTarget = intent.getStringExtra("workoutTargetTime");

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });
    }

    public void updateData(){
        dbRef = FirebaseDB.getFirebaseDatabaseRef();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("Workout")){
                    Workout workoutobj = new Workout();
                    workoutobj.setWorkoutStartTimeH(start_time.getHour());
                    workoutobj.setWorkoutStartTimeM(start_time.getMinute());
                    workoutobj.setWorkoutTargetTimeH(target_time.getHour());
                    workoutobj.setWorkoutTargetTimeM(target_time.getMinute());

                    if (start_time.getHour() == target_time.getHour()) {
                        if (start_time.getMinute() >= target_time.getMinute()) {
                            Toast.makeText(getApplicationContext(), "Start Time Minutes Be Less Than End Time Minutes", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
                            dbRef.setValue(workoutobj);
                            Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(WorkoutUpdate.this, WorkoutCaloriesActivity.class);
                            startActivity(intent);
                        }
                    }
                    else if(start_time.getMinute() == target_time.getMinute()){
                        if (start_time.getHour() >= target_time.getHour()) {
                            Toast.makeText(getApplicationContext(), "Start Time Hours Should Be Less Than End Time Hours", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
                            dbRef.setValue(workoutobj);
                            Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(WorkoutUpdate.this, WorkoutCaloriesActivity.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
                        dbRef.setValue(workoutobj);
                        Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(WorkoutUpdate.this, WorkoutCaloriesActivity.class);
                        startActivity(intent);
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}