package com.example.fitazafitnessapp.db;

import com.example.fitazafitnessapp.LoginActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDB {

    public static DatabaseReference getFirebaseDatabaseRef() {
        return FirebaseDatabase.getInstance().getReference("Fitaza").child(LoginActivity.getUsername());
    }

    public static DatabaseReference getFirebaseDatabase() {
        return FirebaseDatabase.getInstance().getReference("Fitaza");
    }

    public static DatabaseReference getFirebaseDB() {
        return FirebaseDatabase.getInstance().getReference("Fitaza").child("sewmi@gmailcom");
    }

}
