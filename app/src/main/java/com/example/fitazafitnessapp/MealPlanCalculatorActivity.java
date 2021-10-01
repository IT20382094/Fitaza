package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MealPlanCalculatorActivity extends AppCompatActivity {

    private Button btnCalculate,btnBack;
    private TextView age;
    private TextView weight;
    private TextView height;
    private TextView gender;
    private RadioButton male;
    private RadioButton female;
    DatabaseReference dbRef;
    static double BMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_calculator);

        age = findViewById(R.id.et_age);
        gender = findViewById(R.id.et_gender);
        weight = findViewById(R.id.et_weight);
        height = findViewById(R.id.et_height);


        dbRef = FirebaseDB.getFirebaseDB().child("Profile");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChildren()) {
                    age.setText(snapshot.child("age").getValue().toString());
                    gender.setText(snapshot.child("gender").getValue().toString());
                    weight.setText(snapshot.child("weight").getValue().toString());
                    height.setText(snapshot.child("height").getValue().toString());
                } else
                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        btnBack = findViewById(R.id.btn_calculate_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanCalculatorActivity.this, MealDailyPlanActivity.class);
                startActivity(intent);
            }
        });

        btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bMRCalculation(Double.parseDouble(weight.getText().toString()),
                        Double.parseDouble(height.getText().toString()),
                        gender.getText().toString(),
                        Integer.parseInt(age.getText().toString()));

                Intent intent = new Intent(MealPlanCalculatorActivity.this, MealPlanResultActivity.class);
                startActivity(intent);
            }
        });

    }


    public static double bMRCalculation(double weight, double height, String gender, int age) {
        if (gender.equals("Female")) {
            BMR = 10 * weight + 6.25 * height - 5 * age - 161;
            return BMR;
        } else if (gender.equals("Male")) {
            BMR = 10 * weight + 6.25 * height - 5 * age + 5;
            return BMR;
        }
        return 0.0;
    }


}