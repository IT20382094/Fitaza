package com.example.fitazafitnessapp;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProfileTest {


    @Test
    public void testBmiCalculation(){
        double result = YourBMIActivity.calculateBmi(54.00, 156.00);
        assertEquals(22.19, result, 0.1);
    }

    @Test
    public void testBmiCalculation2(){
        double result = YourBMIActivity.calculateBmi(54.00, 156.00);
        assertEquals(25.19, result, 0.1);
    }
}
