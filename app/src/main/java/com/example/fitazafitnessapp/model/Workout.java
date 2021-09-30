package com.example.fitazafitnessapp.model;

public class Workout {
    private int workoutStartTimeH;
    private int workoutStartTimeM;
    private int workoutTargetTimeH;
    private int workoutTargetTimeM;
    private double calories;

    public Workout() {
    }

    public int getWorkoutStartTimeH() {
        return workoutStartTimeH;
    }

    public void setWorkoutStartTimeH(int workoutStartTimeH) {
        this.workoutStartTimeH = workoutStartTimeH;
    }

    public int getWorkoutStartTimeM() {
        return workoutStartTimeM;
    }

    public void setWorkoutStartTimeM(int workoutStartTimeM) {
        this.workoutStartTimeM = workoutStartTimeM;
    }

    public int getWorkoutTargetTimeH() {
        return workoutTargetTimeH;
    }

    public void setWorkoutTargetTimeH(int workoutTargetTimeH) {
        this.workoutTargetTimeH = workoutTargetTimeH;
    }

    public int getWorkoutTargetTimeM() {
        return workoutTargetTimeM;
    }

    public void setWorkoutTargetTimeM(int workoutTargetTimeM) {
        this.workoutTargetTimeM = workoutTargetTimeM;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
