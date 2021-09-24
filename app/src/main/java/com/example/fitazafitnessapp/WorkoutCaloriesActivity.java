package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class WorkoutCaloriesActivity extends AppCompatActivity {

    private Button btnBurnt;

    TextView date, start_time, target_time;
    EditText ending_time;
    Button btn_cal, btn_update, btn_delete;
    DatabaseReference dbRef;

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

        dbRef = FirebaseDB.getFirebaseDatabaseRef();

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String d = snapshot.child("workoutDay").getValue().toString();
                        String s = snapshot.child("workoutStartTime").getValue().toString();
                        String t = snapshot.child("workoutTargetTime").getValue().toString();

                        date.setText(d);
                        start_time.setText(s);
                        target_time.setText(t);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutBurntActivity.class);
                startActivity(intent);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutStepsActivity.class);
                startActivity(intent);
            }
        });

//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                deleteData();
//            }
//        });

    }

//    public void clearControls() {
//        date.setText("");
//        start_time.setText("");
//        target_time.setText("");
//        ending_time.setText("");
//    }
//
//    public void showData() {
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChildren()) {
//                    date.setText(snapshot.child("date").getValue().toString());
//                    start_time.setText(snapshot.child("start_time").getValue().toString());
//                    target_time.setText(snapshot.child("target_time").getValue().toString());
//                } else
//                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
}

//    public void deleteData(){
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChild("Std3")){
//                    dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std3");
//                    dbRef.removeValue();
//                    clearControls();
//                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }
