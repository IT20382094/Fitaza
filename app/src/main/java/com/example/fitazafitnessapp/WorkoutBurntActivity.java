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
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class WorkoutBurntActivity extends AppCompatActivity {

    private Button btnHome;
    private String caloriesBurnt;
    TextView burntCalories;
    private Workout workoutobj = new Workout();
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_burnt);

        btnHome = findViewById(R.id.btn_go_to_home);
        burntCalories = findViewById(R.id.burntCalories);

        dbref = FirebaseDB.getFirebaseDatabaseRef().child("Workout");
        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    burntCalories.setText(snapshot.child("calories").getValue().toString());
                }
                else{
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutBurntActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}