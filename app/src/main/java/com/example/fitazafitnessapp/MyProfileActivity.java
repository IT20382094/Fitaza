package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity {

    private Button btnComputeBmi;
    private Button btnComputeBmiBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btnComputeBmi = findViewById(R.id.btn_compute_bmi);
        btnComputeBmiBack =findViewById(R.id.btn_compute_bmi_back);

        btnComputeBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, YourBMIActivity.class);
                startActivity(intent);
            }
        });

        btnComputeBmiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfileActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });



    }
}