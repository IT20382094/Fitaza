package com.example.fitazafitnessapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Workout {
    private LocalDate workoutDay;
    private LocalTime workoutStartTime;
    private LocalTime workoutTargetTime;

    public Workout() {
    }

    public LocalDate getWorkoutDay() {
        return workoutDay;
    }

    public void setWorkoutDay(LocalDate workoutDay) {
        this.workoutDay = workoutDay;
    }

    public LocalTime getWorkoutStartTime() {
        return workoutStartTime;
    }

    public void setWorkoutStartTime(LocalTime workoutStartTime) {
        this.workoutStartTime = workoutStartTime;
    }

    public LocalTime getWorkoutTargetTime() {
        return workoutTargetTime;
    }

    public void setWorkoutTargetTime(LocalTime workoutTargetTime) {
        this.workoutTargetTime = workoutTargetTime;
    }
}
