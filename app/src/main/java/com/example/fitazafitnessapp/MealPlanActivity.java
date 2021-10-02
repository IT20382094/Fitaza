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
    CheckBox mealPlan1200Breakfast, mealPlan1300Breakfast, mealPlan1500Breakfast, mealPlan1200Lunch, mealPlan1300Lunch, mealPlan1500Lunch, mealPlan1200Dinner, mealPlan1300Dinner, mealPlan1500Dinner;


    private Button btnMealPlan;
    private Button btnMealPlanBack;
    private Button gotoMealPlanBack;

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
                addListenerOnButtonClick();
               // onCheckboxClicked();
                Intent intent = new Intent(MealPlanActivity.this, MealDailyPlanActivity.class);
                startActivity(intent);
            }
        });

        btnMealPlanBack = findViewById(R.id.btn_meal_plan_back);
        btnMealPlanBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


        gotoMealPlanBack = findViewById(R.id.btn_meal_plan_view);
        gotoMealPlanBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MealPlanActivity.this, MealDailyPlanActivity.class);
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


    public void  addListenerOnButtonClick(){
//        mealPlan1200Breakfast = (CheckBox)findViewById(R.id.breakfast_check1);
//        mealPlan1200Lunch = (CheckBox)findViewById(R.id.lunch_check1);
//        btnMealPlan = (Button)findViewById(R.id.btn_add_daily_plan);
        dbRef = FirebaseDB.getFirebaseDatabaseRef().child("mealPlan");


        String id = dbRef.push().getKey();

        MealPlan breakfastMenu1 = new MealPlan(id, "BreakfastMenu1");
        MealPlan lunchMenu1 = new MealPlan(id,"LunchMenu1");
        MealPlan dinnerMenu1 =new MealPlan(id,"DinnerMenu1");

        MealPlan breakfastMenu2 = new MealPlan(id, "BreakfastMenu2");
        MealPlan lunchMenu2 = new MealPlan(id,"LunchMenu2");
        MealPlan dinnerMenu2 = new MealPlan(id,"DinnerMenu2");

        MealPlan breakfastMenu3 = new MealPlan(id, "BreakfastMenu3");
        MealPlan lunchMenu3 = new MealPlan(id,"LunchMenu3");
        MealPlan dinnerMenu3 = new MealPlan(id,"DinnerMenu3");

        List<String> breakfast1200Menu1 = new ArrayList<>();
        List<String> lunch1200Menu1 = new ArrayList<>();
        List<String> dinner1200Menu1 = new ArrayList<>();

        List<String> breakfast1500Menu2 = new ArrayList<>();
        List<String> lunch1500Menu2 = new ArrayList<>();
        List<String> dinner1500Menu2 = new ArrayList<>();

        List<String> breakfast2000Menu3 = new ArrayList<>();
        List<String> lunch2000Menu3 = new ArrayList<>();
        List<String> dinner2000Menu3 = new ArrayList<>();

        if(breakfastChk1.isChecked()) {

            breakfast1200Menu1.add("All-bran cereal (125)");
            breakfast1200Menu1.add("Milk (50)");
            breakfast1200Menu1.add("Banana (90)");
            breakfastMenu1.setMealsList(breakfast1200Menu1);

            dbRef.push().setValue(breakfastMenu1);
        }
        if (lunchChk1.isChecked()){
            lunch1200Menu1.add("Grilled cheese with tomato (300)");
            lunch1200Menu1.add("Salad (50)");
            lunch1200Menu1.add("Walnuts (100)");
            lunchMenu1.setMealsList(lunch1200Menu1);

            dbRef.push().setValue(lunchMenu1);
        }

        if (dinnerChk1.isChecked()){
            dinner1200Menu1.add("Grilled Chicken (200)");
            dinner1200Menu1.add("Brussel sprouts (100)");
            dinner1200Menu1.add("Quinoa (105)");
            dinnerMenu1.setMealsList(dinner1200Menu1);

            dbRef.push().setValue(dinnerMenu1);
        }
//-----------------------------------------------------------------------------------------
        if(breakfastChk2.isChecked()) {
            breakfast1500Menu2.add("Granola (120)");
            breakfast1500Menu2.add("Greek yogurt (120)");
            breakfast1500Menu2.add("Blueberries (40)");
            breakfastMenu2.setMealsList(breakfast1500Menu2);

            dbRef.push().setValue(breakfastMenu2);
        }
        if (lunchChk2.isChecked()){
            lunch1500Menu2.add("Chicken and vegetable soup (300)");
            lunch1500Menu2.add("Bread (100)");
            lunchMenu2.setMealsList(lunch1500Menu2);

            dbRef.push().setValue(lunchMenu2);
        }
        if (dinnerChk2.isChecked()){
            dinner1500Menu2.add("Steak (375)");
            dinner1500Menu2.add("Mashed potatoes (150)");
            dinner1500Menu2.add("Asparagus (75)");
            dinnerMenu2.setMealsList(dinner1500Menu2);

            dbRef.push().setValue(dinnerMenu2);
        }
        //-----------------------------------------------------------------------------------------
        if(breakfastChk3.isChecked()) {
            breakfast2000Menu3.add("Buttered toast (150)");
            breakfast2000Menu3.add("Egg (80)");
            breakfast2000Menu3.add("Banana (90)");
            breakfast2000Menu3.add("Almonds (170)");
            breakfastMenu3.setMealsList(breakfast2000Menu3);

            dbRef.push().setValue(breakfastMenu3);
        }

        if (lunchChk3.isChecked()){
            lunch2000Menu3.add("Grilled chicken (225)");
            lunch2000Menu3.add("Grilled vegetables (125)");
            lunch2000Menu3.add("Pasta (185)");
            lunchMenu3.setMealsList(lunch2000Menu3);

            dbRef.push().setValue(lunchMenu3);
        }
        if (dinnerChk3.isChecked()){
            dinner2000Menu3.add("Grilled salmon (225)");
            dinner2000Menu3.add("Brown rice (175)");
            dinner2000Menu3.add("Green beans (100)");
            dinner2000Menu3.add("Walnuts (165)");
            dinnerMenu3.setMealsList(dinner2000Menu3);

            dbRef.push().setValue(dinnerMenu3);
        }

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
