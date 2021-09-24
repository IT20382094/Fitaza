package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class YourBMIActivity extends AppCompatActivity {

    private TextView weight, height;

    private Button btnHome, btn_bmi_value, back;
    private TextView bmi_value, view_result;

    private String pWeight, pHeight, result;
    private Double pWt, pHt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bmiactivity);

        //TextView t = (TextView) findViewById(R.id.txt_your_bmi);
        //t.setText(Html.fromHtml("YOUR BMI (kg/" + "m<sup>2</sup>" + ")"));


        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        btn_bmi_value = findViewById(R.id.btn_bmi_value);
        bmi_value = findViewById(R.id.bmi_value);
        btnHome = findViewById(R.id.btn_go_to_home);
        view_result = findViewById(R.id.view_result);
        back = findViewById(R.id.btn_go_to_home_back);

        Intent intent = getIntent();

//        pWeight= Double.parseDouble(intent.getStringExtra("weight"));
//        pHeight =Double.parseDouble(intent.getStringExtra("height"));

        // bmi_value.setText((int) calculateBmi(pWeight,pHeight));


        pWeight = intent.getStringExtra("weight");
        pHeight = intent.getStringExtra("height");
        weight.setText(pWeight);
        height.setText(pHeight);

        pWt = Double.parseDouble(pWeight);
        pHt = Double.parseDouble(pHeight);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourBMIActivity.this, ProfileViewActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourBMIActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        btn_bmi_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmi_value = calculateBmi(pWt, pHt);
//                double value =bmi_value.setText((int) (pWt*10000/pHt*pHt));

                if (bmi_value < 18.5) {
                    result = "Underweight";
                } else if (bmi_value >= 18.5 && bmi_value <= 25) {
                    result = "Normal weight";
                } else if (bmi_value >= 25 && bmi_value <= 30) {
                    result = "Overweight";
                } else {
                    result = "Obese";
                }
                view_result.setText("You are " + result);

            }
        });
    }

    public double calculateBmi(Double weight, Double height) {
        double ans = (weight * 10000) / (height * height);
        bmi_value.setText(String.format("%.2f", ans));
        return ans;
    }

//    public void calculateBmi(View view){
//        bmi_value.setText((int) (pWt*10000/pHt*pHt));
//    }
}