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

    private EditText age, weight, height;
    private RadioButton male;
    private RadioButton female;
    private Button btnHome;
    private TextView bmi_value;


    double pWeight, pHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bmiactivity);

        TextView t = (TextView) findViewById(R.id.txt_your_bmi);
        t.setText(Html.fromHtml("YOUR BMI (kg/" + "m<sup>2</sup>" + ")"));

        age =findViewById(R.id.age);
        female =findViewById(R.id.radioFemale);
        male=findViewById(R.id.radioMale);
        weight =findViewById(R.id.weights);
        height =findViewById(R.id.height);
        bmi_value=findViewById(R.id.bmi_value);
        btnHome=findViewById(R.id.btn_go_to_home);

        Intent intent = getIntent();

        pWeight= Double.parseDouble(intent.getStringExtra("weight"));
        pHeight =Double.parseDouble(intent.getStringExtra("height"));

        bmi_value.setText((int) calculateBmi(pWeight,pHeight));


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourBMIActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    public double calculateBmi(Double weight, Double height){
        Double ans = (weight*10000)/(height*height);
        return ans;
    }

//    public void calculateBmi(View view){
//        bmi_value.setText((int) (pWeight*10000/pHeight));
//    }
}