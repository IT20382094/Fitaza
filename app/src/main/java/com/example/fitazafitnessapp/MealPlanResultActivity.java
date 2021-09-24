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

public class MealPlanResultActivity extends AppCompatActivity {

    private Button btnGoToHome;
    private TextView txtBMR;
    DatabaseReference dbRef;
    MealPlanCalculatorActivity result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_result);

        txtBMR = findViewById(R.id.txtBMR);

        txtBMR.setText(MealPlanCalculatorActivity.BMR + "");

        btnGoToHome = findViewById(R.id.btn_go_to_home);


        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanResultActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        btnGoToHome = findViewById(R.id.btn_go_to_home_back);
        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanResultActivity.this, MealPlanCalculatorActivity.class);
                startActivity(intent);
            }
        });


    }


}