package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewTimeTableActivity extends AppCompatActivity {

    private Button btnSetTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);

        btnSetTarget = findViewById(R.id.btn_set_target);
        btnSetTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewTimeTableActivity.this, SetWaterTargetActivity.class);
                startActivity(intent);
            }
        });
    }
}