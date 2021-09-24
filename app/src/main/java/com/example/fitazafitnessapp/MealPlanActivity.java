package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.MealPlan;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MealPlanActivity extends AppCompatActivity {

    CheckBox breakfastChk1, breakfastChk2, breakfastChk3, lunchChk1, lunchChk2, lunchChk3, dinnerChk1, dinnerChk2, dinnerChk3;
    DatabaseReference dbRef;
    MealPlan mealPlan;




    private Button btnMealPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        breakfastChk1 = findViewById(R.id.breakfast_check1);
        breakfastChk2 = findViewById(R.id.breakfast_check2);
        breakfastChk3 = findViewById(R.id.breakfast_check3);
        lunchChk1 = findViewById(R.id.lunch_check1);
        lunchChk2 = findViewById(R.id.lunch_check2);
        lunchChk3 = findViewById(R.id.lunch_check3);
        dinnerChk1 = findViewById(R.id.dinner_check1);
        dinnerChk2 = findViewById(R.id.dinner_check2);
        dinnerChk3 = findViewById(R.id.dinner_check3);


        btnMealPlan = findViewById(R.id.btn_add_daily_plan);

        mealPlan = new MealPlan();

        btnMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCheckboxClicked();
                Intent intent = new Intent(MealPlanActivity.this, MealDailyPlanActivity.class);
                startActivity(intent);
            }
        });

        btnMealPlan = findViewById(R.id.btn_meal_plan_back);
        btnMealPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onCheckboxClicked() {
        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("mealPlan");


        String id = dbRef.push().getKey();
        if (breakfastChk1.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"BreakfastMenu1"));
        } else if (breakfastChk2.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"BreakfastMenu2"));
        } else if (breakfastChk3.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"BreakfastMenu3"));
        }

        if (lunchChk1.isChecked()) {
           dbRef.push().setValue(new MealPlan(id,"LunchMenu1"));
        } else if (lunchChk2.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"LunchMenu2"));
        } else if (lunchChk3.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"LunchMenu3"));
        }

        if (dinnerChk1.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"DinnerMenu1"));
        } else if (dinnerChk2.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"DinnerMenu2"));
        } else if (dinnerChk3.isChecked()) {
            dbRef.push().setValue(new MealPlan(id,"DinnerMenu3"));
        }

        Toast.makeText(this, "Data saved Successfully", Toast.LENGTH_SHORT).show();

    }
}




//  List<String> calPlan1200Breakfast = new ArrayList<>();

//
//    ListView menu1;
//    String[] calPlan1200Breakfast = {
//            "All-bran cereal (125)",
//            "Milk (50)",
//            "Cucumber (30)",
//            "Avocado dip (50)"
//    };
//    String[] calPlan1200Lunch = {
//            "Grilled cheese with tomato (300)",
//            "Salad (50)",
//            "Walnuts (100)"
//    };
//    String[] calPlan1200Dinner= {
//            "Grilled Chicken (200)",
//            "Brussel sprouts (100)",
//            " Quinoa (105)"
//
//    };





    //    dbRef = FirebaseDB.getFirebaseDatabase().child("User");
    // Is the view now checked?
    // boolean checked = ((CheckBox) view).isChecked();
    // Check which checkbox was clicked
//    List<String> calPlan1200Breakfast = new ArrayList<>();
//        calPlan1200Breakfast.add("All-bran cereal (125)");
//                calPlan1200Breakfast.add("Milk (50)");
//                calPlan1200Breakfast.add("Cucumber (30)");
//                calPlan1200Breakfast.add("Avocado dip (50)");
//
//                List<String> calPlan1200Lunch = new ArrayList<>();
//        calPlan1200Lunch.add("Grilled cheese with tomato (300)");
//        calPlan1200Lunch.add("Salad (50)");
//        calPlan1200Lunch.add("Walnuts (100)");
//
//        List<String> calPlan1200Dinner = new ArrayList<>();
//        calPlan1200Dinner.add("Grilled Chicken (200)");
//        calPlan1200Dinner.add("Brussel sprouts (100)");
//        calPlan1200Dinner.add(" Quinoa (105)");
//
//        List<String> calPlan1300Breakfast = new ArrayList<>();
//        calPlan1300Breakfast.add("All-bran cereal (125)");
//        calPlan1300Breakfast.add("Milk (50)");
//        calPlan1300Breakfast.add("Cucumber (30)");
//        calPlan1300Breakfast.add("Avocado dip (50)");
//
//        List<String> calPlan1300Lunch = new ArrayList<>();
//        calPlan1300Lunch.add("Grilled cheese with tomato (300)");
//        calPlan1300Lunch.add("Salad (50)");
//        calPlan1300Lunch.add("Walnuts (100)");
//
//        List<String> calPlan1300Dinner = new ArrayList<>();
//        calPlan1300Dinner.add("Grilled Chicken (200)");
//        calPlan1300Dinner.add("Brussel sprouts (100)");
//        calPlan1300Dinner.add(" Quinoa (105)");
//
//        List<String> calPlan1500Breakfast = new ArrayList<>();
//        calPlan1500Breakfast.add("All-bran cereal (125)");
//        calPlan1500Breakfast.add("Milk (50)");
//        calPlan1500Breakfast.add("Cucumber (30)");
//        calPlan1500Breakfast.add("Avocado dip (50)");
//
//        List<String> calPlan1500Lunch = new ArrayList<>();
//        calPlan1500Lunch.add("Grilled cheese with tomato (300)");
//        calPlan1500Lunch.add("Salad (50)");
//        calPlan1500Lunch.add("Walnuts (100)");
//
//        List<String> calPlan1500Dinner = new ArrayList<>();
//        calPlan1500Dinner.add("Grilled Chicken (200)");
//        calPlan1500Dinner.add("Brussel sprouts (100)");
//        calPlan1500Dinner.add(" Quinoa (105)");

//  mealPlan.setCalPlan1200Breakfast(Collections.singletonList(breakfastChk1.getText());
//        calPlan1200Breakfast = (List<String>) mealPlan.setCalPlan1200Breakfast(Collections.singletonList(breakfastChk1.getText().toString().trim()));
//        calPlan1300Breakfast = mealPlan.setCalPlan1300Breakfast(Collections.singletonList(breakfastChk2.getText().toString().trim()));
//        mealPlan.setCalPlan1500Breakfast(Collections.singletonList(breakfastChk3.getText().toString().trim()));





//        switch(view.getId()) {
//            case breakfastChk1:
//
//                if (checked) {
//                    dbRef.push().setValue(calPlan1200Breakfast);
//                }
//            case breakfastChk2:
//                if (checked)
//                     dbRef.push().setValue(calPlan1200Lunch);
//            case  breakfastChk3:
//                if (checked)
//                    dbRef.push().setValue(calPlan1200Dinner);
//
//
//                break;
//            // Perform your logic
//        }
