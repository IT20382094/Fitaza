package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class WorkoutCaloriesActivity extends AppCompatActivity {

    TextView start_timeH, target_timeH, start_timeM, target_timeM;
    Button btn_cal, btn_update, btn_delete;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_calories);

        start_timeH = findViewById(R.id.start_time_viewH);
        start_timeM = findViewById(R.id.start_time_viewM);
        target_timeH = findViewById(R.id.target_time_viewH);
        target_timeM = findViewById(R.id.target_time_viewM);

        btn_cal = findViewById(R.id.btn_burnt_calories);
        btn_update = findViewById(R.id.btn_update_workout);
        btn_delete = findViewById(R.id.btn_delete_workout);

        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    start_timeH.setText(snapshot.child("workoutStartTimeH").getValue().toString());
                    start_timeM.setText(snapshot.child("workoutStartTimeM").getValue().toString());
                    target_timeH.setText(snapshot.child("workoutTargetTimeH").getValue().toString());
                    target_timeM.setText(snapshot.child("workoutTargetTimeM").getValue().toString());

                } else
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteWorkout();

                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutStepsActivity.class);
                startActivity(intent);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutUpdate.class);
                intent.putExtra("workoutStartTimeH", start_timeH.getText().toString());
                intent.putExtra("workoutStartTimeM",start_timeM.getText().toString());
                intent.putExtra("workoutTargetTimeH", target_timeH.getText().toString());
                intent.putExtra("workoutTargetTimeM",target_timeM.getText().toString());
                startActivity(intent);

            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutBurntActivity.class);

//                caloryCalculate(calory, );
                startActivity(intent);

            }
        });


    }
    public void deleteWorkout(){
        dbRef = FirebaseDB.getFirebaseDatabaseRef();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("Workout")){
                    dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
                    dbRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public double caloryCalculate(double calory, int a, int b){
        int start_time, target_time;
        double val = 0;
        a = Integer.parseInt(start_timeH.getText().toString());
        b = Integer.parseInt(target_timeH.getText().toString());
        start_time = (a * 60) + Integer.parseInt(start_timeM.getText().toString());
        target_time=(b * 60) + Integer.parseInt(target_timeM.getText().toString());
        val = calory*(double)(target_time-start_time);
        return val;
    }
}

