package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.MealPlan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MealDailyPlanActivity extends AppCompatActivity {

    private Button btnDailyPlan;
    private Button btnCalorieCal;
    private Button btnDelete;
    private Button btnUpdate;
    private LinearLayout lyBreakfastMenu1, lyLunchMenu1, lyDinnerMenu1;
    private TextView breakfastMenu1TV1, lunchMenu1TV1, dinnerMenu1TV1;
    private TextView breakfastMenu, lunchMenu, dinnerMenu;
    DatabaseReference dbRef;
    CheckBox mealPlan1200Breakfast, mealPlan1300Breakfast, mealPlan1500Breakfast, mealPlan1200Lunch, mealPlan1300Lunch, mealPlan1500Lunch, mealPlan1200Dinner, mealPlan1300Dinner, mealPlan1500Dinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_daily_plan);

        lyBreakfastMenu1 = findViewById(R.id.lyBreakfastMenu1);
        lyLunchMenu1 = findViewById(R.id.lyLunchMenu1);
        lyDinnerMenu1 = findViewById(R.id.lyDinnerMenu1);

        breakfastMenu1TV1 = findViewById(R.id.bMenu1TV1);
        lunchMenu1TV1 = findViewById(R.id.lMenu1TV1);
        dinnerMenu1TV1 = findViewById(R.id.dMenu1TV1);

        breakfastMenu = findViewById(R.id.breakfastMenu);
        lunchMenu = findViewById(R.id.lunchMenu);
        dinnerMenu = findViewById(R.id.dinnerMenu);

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
                    List<String> breakfast1200Menu1 = new ArrayList<>();
                    //  list = dataSnapshot.getValue("mealsList");
                    MealPlan value = dataSnapshot.getValue(MealPlan.class);

                    if (value.getMealPlanName().equals("BreakfastMenu1")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        breakfastMenu.setText("Menu1");
                        breakfastMenu1TV1.setText(meals);
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }

                    if (value.getMealPlanName().equals("BreakfastMenu2")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        breakfastMenu.setText("Menu2");
                        breakfastMenu1TV1.setText(meals);
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("BreakfastMenu3")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        breakfastMenu.setText("Menu3");
                        breakfastMenu1TV1.setText(meals);
                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
                    }


                    if (value.getMealPlanName().equals("LunchMenu1")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        lunchMenu.setText("Menu1");
                        lunchMenu1TV1.setText(meals);
                        lyLunchMenu1.setVisibility(View.VISIBLE);

                    }

                    if (value.getMealPlanName().equals("LunchMenu2")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        lunchMenu.setText("Menu2");
                        lunchMenu1TV1.setText(meals);
                        lyLunchMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("LunchMenu3")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        lunchMenu.setText("Menu3");
                        lunchMenu1TV1.setText(meals);
                        lyLunchMenu1.setVisibility(View.VISIBLE);
                    }


                    if (value.getMealPlanName().equals("DinnerMenu1")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        dinnerMenu.setText("Menu1");
                        dinnerMenu1TV1.setText(meals);
                        lyDinnerMenu1.setVisibility(View.VISIBLE);

                    }

                    if (value.getMealPlanName().equals("DinnerMenu2")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        dinnerMenu.setText("Menu2");
                        dinnerMenu1TV1.setText(meals);
                        lyDinnerMenu1.setVisibility(View.VISIBLE);
                    }
                    if (value.getMealPlanName().equals("DinnerMenu3")) {

                        String meals = "";
                        for (String meal : value.getMealsList()) {
                            meals = meals + meal + "\n";
                        }

                        dinnerMenu.setText("Menu3");
                        dinnerMenu1TV1.setText(meals);
                        lyDinnerMenu1.setVisibility(View.VISIBLE);
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void deletePlan() {
        dbRef = FirebaseDB.getFirebaseDatabaseRef();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("mealPlan")) {
                    dbRef = FirebaseDB.getFirebaseDatabaseRef().child("mealPlan");
                    dbRef.removeValue();
                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}


//                    if (value.getMealsList().equals("mealsList")) {
//                        breakfastMenu1TV1.setText(value.getMealsList().toString());
//                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("BreakfastMenu1")) {
//                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("BreakfastMenu2")){
//                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("BreakfastMenu3")){
//                        lyBreakfastMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("LunchMenu1")) {
//                        lyLunchMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("LunchMenu2")){
//                        lyLunchMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("LunchMenu3")){
//                        lyLunchMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("DinnerMenu1")) {
//                        lyDinnerMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("DinnerMenu2")){
//                        lyDinnerMenu1.setVisibility(View.VISIBLE);
//                    }
//                    if (value.getMealPlanName().equals("DinnerMenu3")){
//                        lyDinnerMenu1.setVisibility(View.VISIBLE);
//                    }


//        new DatePickerDialog(MealDailyPlanActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                //DO SOMETHING
//            }
//        }, 2015, 02, 26).show();