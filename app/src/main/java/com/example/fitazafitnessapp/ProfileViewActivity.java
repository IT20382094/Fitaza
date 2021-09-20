package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileViewActivity extends AppCompatActivity {

    private Button btnProfileUpdate;
    private Button btnProfileDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        btnProfileUpdate = findViewById(R.id.btn_compute_bmi_update);
        btnProfileUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileViewActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });

        btnProfileDelete = findViewById(R.id.btn_compute_bmi_delete);
        btnProfileDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileViewActivity.this, MyProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}