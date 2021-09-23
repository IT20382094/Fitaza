package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WorkoutCaloriesActivity extends AppCompatActivity {

    private Button btnBurnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_calories);

        btnBurnt = findViewById(R.id.btn_burnt_calories);
        btnBurnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutBurntActivity.class);
                startActivity(intent);
            }
        });

        btnBurnt = findViewById(R.id.btn_delete_workout);
        btnBurnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkoutCaloriesActivity.this, WorkoutStepsActivity.class);
                startActivity(intent);
            }
        });

    }
}

//    EditText id, name, address, contactNumber;
//    Button btn_save, btn_show, btn_update, btn_delete;
//    Student stuObj;
//    DatabaseReference dbRef;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        id =findViewById(R.id.id);
//        name=findViewById(R.id.name);
//        address=findViewById(R.id.address);
//        contactNumber=findViewById(R.id.contactNumber);
//
//        btn_save=findViewById(R.id.btn_save);
//        btn_show=findViewById(R.id.btn_show);
//        btn_update=findViewById(R.id.btn_update);
//        btn_delete=findViewById(R.id.btn_delete);
//
//        stuObj =new Student();
//
//        btn_save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                createData();
//            }
//        });
//
//        btn_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                deleteData();
//            }
//        });
//
//        btn_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                showData();
//            }
//        });
//        btn_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                updateData();
//            }
//        });
//    }
//
//    public void clearControls(){
//        id.setText("");
//        name.setText("");
//        address.setText("");
//        contactNumber.setText("");
//    }
//
//    public void createData(){
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
//        try{
//            if (TextUtils.isEmpty(id.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter an ID", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(name.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter a name", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(address.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter an address", Toast.LENGTH_SHORT).show();
//            else if (TextUtils.isEmpty(contactNumber.getText().toString()))
//                Toast.makeText(getApplicationContext(),"Please enter a contact number", Toast.LENGTH_SHORT).show();
//
//            else{
//                //Take inputs from user and assign them to this instance (stuBoj) of the student
//                stuObj.setId(id.getText().toString().trim());
//                stuObj.setName(name.getText().toString().trim());
//                stuObj.setAddress(address.getText().toString().trim());
//                stuObj.setContactNumber(Integer.parseInt(contactNumber.getText().toString().trim()));
//
//                //insert it to database
//                dbRef.push().setValue(stuObj);
//
//                dbRef.child("Std3").setValue(stuObj);
//                //feedback to user via a toast message
//                Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
//                clearControls();
//            }
//        }
//        catch (NumberFormatException e){
//            Toast.makeText(getApplicationContext(), "Invalid contact Number", Toast.LENGTH_SHORT).show();
//        }
//    }
//    public void showData(){
//        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std3");
//        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.hasChildren()){
//                    id.setText(snapshot.child("id").getValue().toString());
//                    name.setText(snapshot.child("name").getValue().toString());
//                    address.setText(snapshot.child("address").getValue().toString());
//                    contactNumber.setText(snapshot.child("contactNumber").getValue().toString());
//                }
//                else
//                    Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

//    public void deleteData(){
//        dbRef = FirebaseDatabase.getInstance().getReference().child("Student");
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChild("Std3")){
//                    dbRef = FirebaseDatabase.getInstance().getReference().child("Student").child("Std3");
//                    dbRef.removeValue();
//                    clearControls();
//                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }
