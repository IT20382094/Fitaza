package com.example.fitazafitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class YourBMIActivity extends AppCompatActivity {

    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_bmiactivity);

        TextView t = (TextView) findViewById(R.id.txt_your_bmi);
        t.setText(Html.fromHtml("YOUR BMI (kg/" + "m<sup>2</sup>" + ")"));

        btnHome=findViewById(R.id.btn_go_to_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourBMIActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}