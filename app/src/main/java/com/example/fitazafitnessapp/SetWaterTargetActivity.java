package com.example.fitazafitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetWaterTargetActivity extends AppCompatActivity {

    private Button back_btn, done;
    private EditText clac, expected, achieved;
//    private int ach,ex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_water_target);


        back_btn = findViewById(R.id.btn_back1);
        done = findViewById(R.id.done);
        clac = findViewById(R.id.water_clac);
        expected = findViewById(R.id.expected);
        achieved = findViewById(R.id.achieved);

//        ach =Integer.parseInt(achieved.getText().toString());
//        ex =Integer.parseInt(expected.getText().toString());


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetWaterTargetActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clac.setText(waterCalc(Integer.parseInt(expected.getText().toString()), Integer.parseInt(achieved.getText().toString())) + "");
//                int value=waterCalc(ach,ex);
//                    clac.setText(value);
//                waterCalc(Integer.parseInt(expected.getText().toString()), Integer.parseInt(achieved.getText().toString()));
//                Intent intent = new Intent(SetWaterTargetActivity.this, MenuActivity.class);
//                startActivity(intent);
            }
        });

    }

    public static int waterCalc(int num1, int num2) {

        int waterCalc;
        waterCalc = num1 - num2;
        //clac.setText(waterCalc);
        return waterCalc;

    }


}