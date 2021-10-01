package com.example.fitazafitnessapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimeTableTest {

    @Test
    public void testWaterBottlesCalc() {
        int waterCalc = SetWaterTargetActivity.waterCalc(8, 5);
        assertEquals(3, waterCalc);
    }



}
