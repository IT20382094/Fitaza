package com.example.fitazafitnessapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MealPlanTest {

    @Test
    public void testBMRCalculationFemale(){
        double result = MealPlanCalculatorActivity.bMRCalculation(45.4, 151.1, "Female", 24);
        assertEquals(1117.375, result,0.1);
    }

    @Test
    public void testBMRCalculationMale(){
        double result = MealPlanCalculatorActivity.bMRCalculation(65.0, 180.0, "Male", 25);
        assertEquals(1655, result,0);
    }
}
