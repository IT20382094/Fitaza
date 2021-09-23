package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WorkoutStepsActivity extends AppCompatActivity {

    private Button btnSeeSteps,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_steps);

        btnSeeSteps = findViewById(R.id.btn_see_steps);
        btnSeeSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutStepsActivity.this, activity_belly_steps.class);
                startActivity(intent);
            }
        });

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutStepsActivity.this, WorkoutCaloriesActivity.class);
                startActivity(intent);
            }
        });
    }
}



//    EditText date, start_time, target_time;
//    Workout workoutobj;
//    private Button btnSeeSteps,btnNext;
////    DatabaseReference dbRef;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_workout_steps);
//
//        date =findViewById(R.id.workout_date);
//        start_time=findViewById(R.id.workout_start_time);
//        target_time=findViewById(R.id.workout_end_time);
//
//        btnNext=findViewById(R.id.btn_next);
////        btn_show=findViewById(R.id.btn_show);
////        btn_update=findViewById(R.id.btn_update);
////        btn_delete=findViewById(R.id.btn_delete);
//
//        workoutobj =new Workout();
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                createData();
//                Intent intent = new Intent(WorkoutStepsActivity.this, WorkoutCaloriesActivity.class);
//                startActivity(intent);
//            }
//        });

//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                deleteData();
//            }
//        });
//
//        btn_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                showData();
//            }
//        });
//        btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                updateData();
//            }
//        });
//    }

//    public void clearControls(){
//
//        date.setText("");
//        start_time.setText("");
//        target_time.setText("");
//    }
//
//    public void createData(){
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Workout");
//        try{
//            if (TextUtils.isEmpty(id.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter an ID", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(name.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter a name", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(address.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter an address", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(contactNumber.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter a contact number", Toast.LENGTH_SHORT).show();
//
//            else{
//                //Take inputs from user and assign them to this instance (stuBoj) of the student
//                stuObj.setId(id.getText().toString().trim());
//                stuObj.setName(name.getText().toString().trim());
//                stuObj.setAddress(address.getText().toString().trim());
//                stuObj.setContactNumber(Integer.parseInt(contactNumber.getText().toString().trim()));
//
//                //insert it to database
//                dbRef.push().setValue(stuObj);
//
//                dbRef.child("Std3").setValue(stuObj);
//                //feedback to user via a toast message
//                Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
//                clearControls();
//            }
//        }
//        catch (NumberFormatException e){
//            Toast.makeText(getApplicationContext(), "Invalid contact Number", Toast.LENGTH_SHORT).show();
//        }
//    }