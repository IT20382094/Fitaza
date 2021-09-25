package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
//
//        start_time.setText(pStart);
//        target_time.setText(pTarget);



        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                Intent intent = new Intent(WorkoutUpdate.this, WorkoutCaloriesActivity.class);
                startActivity(intent);

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
//                    workoutobj.setWorkoutDay(date.getText().toString().trim());
//                    workoutobj.setWorkoutStartTime(start_time.getText().toString().trim());
//                    workoutobj.setWorkoutTargetTime(target_time.getText().toString().trim());

                    dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
                    dbRef.setValue(workoutobj);
                    Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No source to update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

//    public void clearControls(){
//        start_time.setText("");
//        target_time.setText("");
//    }
}