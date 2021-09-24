package com.example.fitazafitnessapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Workout {
    private String workoutDay;
    private String workoutStartTime;
    private String workoutTargetTime;
    private String workoutEndingTime;

    public Workout() {
    }

    public String getWorkoutDay() {
        return workoutDay;
    }

    public void setWorkoutDay(String workoutDay) {
        this.workoutDay = workoutDay;
    }

    public String getWorkoutStartTime() {
        return workoutStartTime;
    }

    public void setWorkoutStartTime(String workoutStartTime) {
        this.workoutStartTime = workoutStartTime;
    }

    public String getWorkoutTargetTime() {
        return workoutTargetTime;
    }

    public void setWorkoutTargetTime(String workoutTargetTime) {
        this.workoutTargetTime = workoutTargetTime;
    }

    public String getWorkoutEndingTime() {
        return workoutEndingTime;
    }

    public void setWorkoutEndingTime(String workoutEndingTime) {
        this.workoutEndingTime = workoutEndingTime;
    }
}
