package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class WorkoutCaloriesActivity extends AppCompatActivity {

    TextView date, start_time, target_time;
    EditText ending_time;
    Button btn_cal, btn_update, btn_delete;
    DatabaseReference dbRef;
    double calory = 20.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_calories);

        date = (TextView) findViewById(R.id.date);
        start_time = (TextView) findViewById(R.id.start_time_view);
        target_time = (TextView) findViewById(R.id.target_time_view);
        ending_time = findViewById(R.id.ending_time);

        btn_cal = findViewById(R.id.btn_burnt_calories);
        btn_update = findViewById(R.id.btn_update_workout);
        btn_delete = findViewById(R.id.btn_delete_workout);

        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Workout");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    String d = snapshot.child("workoutDay").getValue().toString();
                    String s = snapshot.child("workoutStartTime").getValue().toString();
                    String t = snapshot.child("workoutTargetTime").getValue().toString();

                    date.setText(d);
                    start_time.setText(s);
                    target_time.setText(t);

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
                intent.putExtra("workoutDay", date.getText().toString());
                intent.putExtra("workoutStartTime", start_time.getText().toString());
                intent.putExtra("workoutTargetTime", target_time.getText().toString());
                startActivity(intent);

            }
        });

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDate();
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutBurntActivity.class);
                startActivity(intent);

            }
        });


    }
    public void clearControls(){
        ending_time.setText("");
    }

    public void createDate(){
        dbRef = FirebaseDB.getFirebaseDatabaseRef();

        if (TextUtils.isEmpty(date.getText().toString()))
            Toast.makeText(getApplicationContext(),"Please enter a time", Toast.LENGTH_SHORT).show();
        else{
            Workout workoutobj = new Workout();
            workoutobj.setWorkoutEndingTime(ending_time.getText().toString().trim());

            dbRef.child("Workout").setValue(workoutobj);

            Toast.makeText(getApplicationContext(), "Ending time inserted successfully", Toast.LENGTH_SHORT).show();
            clearControls();
        }
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
//
//    public double cararyCalculate(){
//        double val = 0;
//        val = calory*(ending_time-start_time);
//        return val;
//    }
}

