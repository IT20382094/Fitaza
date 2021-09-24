package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.MealPlan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MealDailyPlanActivity extends AppCompatActivity {

    private Button btnDailyPlan;
    private Button btnCalorieCal;
    private Button btnDelete;
    private Button btnUpdate;
    private LinearLayout lyBreakfastMenu1, lyLunchMenu1, lyDinnerMenu1;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_daily_plan);

        lyBreakfastMenu1 = findViewById(R.id.lyBreakfastMenu1);
        lyLunchMenu1 = findViewById(R.id.lyLunchMenu1);
        lyDinnerMenu1 = findViewById(R.id.lyDinnerMenu1);

        setLayoutsFalse();

        loadMenus();


        btnCalorieCal = findViewById(R.id.btn_calorie_cal);
        btnCalorieCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealDailyPlanActivity.this, MealPlanCalculatorActivity.class);
                startActivity(intent);
            }
        });

        btnDailyPlan = findViewById(R.id.btn_daily_plan_back);
        btnDailyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealDailyPlanActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });

        btnUpdate = findViewById(R.id.btn_update_meal);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealDailyPlanActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });

        btnDelete = findViewById(R.id.btn_delete_meal);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePlan();
                Intent intent = new Intent(MealDailyPlanActivity.this, MealPlanActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setLayoutsFalse() {
        lyBreakfastMenu1.setVisibility(View.GONE);
        lyLunchMenu1.setVisibility(View.GONE);
        lyDinnerMenu1.setVisibility(View.GONE);
    }

    private void loadMenus() {
        DatabaseReference mealPlan = FirebaseDB.getFirebaseDatabaseRef().child("mealPlan");
        mealPlan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    MealPlan value = dataSnapshot.getValue(MealPlan.class);
                    if (value.getMealPlanName().equals("BreakfastMenu1")) {
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("BreakfastMenu2")){
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("BreakfastMenu3")){
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("LunchMenu1")) {
                        lyLunchMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("LunchMenu2")){
                        lyLunchMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("LunchMenu3")){
                        lyLunchMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("DinnerMenu1")) {
                        lyDinnerMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("DinnerMenu2")){
                        lyDinnerMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("DinnerMenu3")){
                        lyDinnerMenu1.setVisibility(View.VISIBLE);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void deletePlan(){
        dbRef = FirebaseDB.getFirebaseDatabaseRef();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("mealPlan")){
                    dbRef = FirebaseDB.getFirebaseDatabaseRef().child("mealPlan");
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
}


//        new DatePickerDialog(MealDailyPlanActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                //DO SOMETHING
//            }
//        }, 2015, 02, 26).show();