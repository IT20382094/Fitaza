package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.MyProfile;
import com.google.firebase.database.DatabaseReference;

public class MyProfileActivity extends AppCompatActivity {

//    private EditText age, weight, height;
//    private RadioButton male;
//    private RadioButton female;
//    private Button btnAddProfile;
//    private Button btnComputeBmiBack;
//    DatabaseReference dbProfile;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_profile);
//
//        btnAddProfile = findViewById(R.id.btn_update_profile);
//        btnComputeBmiBack = findViewById(R.id.btn_back);
//        age = findViewById(R.id.age);
//        male = findViewById(R.id.radioMale);
//        female = findViewById(R.id.radioFemale);
//        weight = findViewById(R.id.weights);
//        height = findViewById(R.id.height);
//
//
//        dbProfile = FirebaseDB.getFirebaseDatabaseRef();
//        btnAddProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //insertProfile();
//                Intent intent = new Intent(MyProfileActivity.this, ProfileViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        btnComputeBmiBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MyProfileActivity.this, ProfileViewActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    public void clearControls() {
//        age.setText("");
//        male.setText("");
//        female.setText("");
//        weight.setText("");
//        height.setText("");
//    }


    private EditText age, weight, height;
    private RadioButton male;
    private RadioButton female;
    private Button btnAddProfile;
    private Button btnComputeBmiBack;
    DatabaseReference dbProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btnAddProfile = findViewById(R.id.btn_update_profile);
        btnComputeBmiBack = findViewById(R.id.btn_back);
        age = findViewById(R.id.age);
        male = findViewById(R.id.radioMale);
        female = findViewById(R.id.radioFemale);
        weight = findViewById(R.id.weights);
        height = findViewById(R.id.height);


        dbProfile = FirebaseDB.getFirebaseDatabaseRef();
        btnAddProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbProfile = FirebaseDB.getFirebaseDatabaseRef();
                if (TextUtils.isEmpty(age.getText().toString())) {
                    age.requestFocus();
                    age.setError("Please enter an age");
                } else if (TextUtils.isEmpty(weight.getText().toString())) {
                    weight.requestFocus();
                    weight.setError("Please enter your weight");
                } else if (TextUtils.isEmpty(height.getText().toString())){
                    height.requestFocus();
                    height.setError("Please enter your height");
                }
                else if (!age.getText().toString().matches("[0-9 ]+")) {
//                    Toast.makeText(getApplicationContext(), "Please enter only numbers", Toast.LENGTH_SHORT).show();
                    age.requestFocus();
                    age.setError("Please enter only numbers");
                }
                else if (!weight.getText().toString().matches("[0-9. ]+")) {
                    weight.requestFocus();
                    weight.setError("Please enter only numbers");
                }
                else if (!height.getText().toString().matches("[0-9. ]+")) {
                    height.requestFocus();
                    height.setError("Please enter only numbers");
                }
                else {
                    MyProfile myProfile = new MyProfile();
                    myProfile.setAge(Integer.parseInt(age.getText().toString().trim()));
                    if (male.isChecked()) {
                        myProfile.setGender(male.getText().toString().trim());
                    } else {
                        myProfile.setGender(female.getText().toString().trim());
                    }
//            else {
//                Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
//            }
                    myProfile.setWeight(Double.parseDouble(weight.getText().toString().trim()));
                    myProfile.setHeight(Double.parseDouble(height.getText().toString().trim()));

                    dbProfile.child("Profile").setValue(myProfile);

                    Toast.makeText(getApplicationContext(), "Profile saved successfully", Toast.LENGTH_SHORT).show();
                    clearControls();

                    Intent intent = new Intent(MyProfileActivity.this, ProfileViewActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnComputeBmiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });

    }

    public void clearControls() {
        age.setText("");
        male.setText("");
        female.setText("");
        weight.setText("");
        height.setText("");
    }
    

}

















