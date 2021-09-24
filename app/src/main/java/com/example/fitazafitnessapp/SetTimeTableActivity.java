package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Timetable;
import com.example.fitazafitnessapp.model.Workout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetTimeTableActivity extends AppCompatActivity {

    private TimePicker time1, time2;
    private Button btnSet;
    private Spinner spinnerDay, spinnerExercise1, spinnerExercise2;
    private static final String[] pathsDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] pathsExercise = {"Abs Exercise", "Butt Exercise", "Chest Exercise", "Leg Exercise"};
    private Timetable timetableObj = new Timetable();

    DatabaseReference dbRef;

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

        spinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                timetableObj.setDay(pathsDay[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinnerExercise1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                timetableObj.setExercise1(pathsExercise[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinnerExercise2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                timetableObj.setExercise2(pathsExercise[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        btnSet = findViewById(R.id.btn_set);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetTimeTableActivity.this, ViewTimeTableActivity.class);
                startActivity(intent);
            }
        });


        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);


        btnSet = findViewById(R.id.btn_set);

        dbRef = FirebaseDB.getFirebaseDatabaseRef();

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createData();
                Intent intent = new Intent(SetTimeTableActivity.this, ViewTimeTableActivity.class);
                startActivity(intent);
            }
        });
    }

//    public void clearControls() {
//
////        time1.setText("");
////        time2.setText("");
//    }

    public void createData() {
        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Timetable");
        String id = dbRef.push().getKey();
        timetableObj.setTime1H(time1.getHour());
        timetableObj.setTime1M(time1.getMinute());
        timetableObj.setTime2H(time2.getHour());
        timetableObj.setTime2M(time2.getMinute());

//        if (TextUtils.isEmpty(time1.getText().toString()))
//            Toast.makeText(getApplicationContext(), "Please enter a time", Toast.LENGTH_SHORT).show();
//        else if (TextUtils.isEmpty(time2.getText().toString()))
//            Toast.makeText(getApplicationContext(), "Please enter a time", Toast.LENGTH_SHORT).show();
//        else {
//
//            Timetable timetableobj = new Timetable();
//            timetableobj.setTime1(time1.getText().toString().trim());
//            timetableobj.setTime2(time2.getText().toString().trim());
//
        dbRef.child(id).setValue(timetableObj);
//
//            //feedback to user via a toast message
//            Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
//            clearControls();
//        }
    }

//        btnSet = findViewById(R.id.btn_set_back);
//        btnSet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(SetTimeTableActivity.this, ViewTimeTableActivity.class);
//                startActivity(intent);
//            }
//        });

}
