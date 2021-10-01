package com.example.fitazafitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fitazafitnessapp.adapter.TimeTableAdapter;
import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Timetable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewTimeTableActivity extends AppCompatActivity {

    private Button btnSetTarget, btnDelete;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_time_table);

        loadTimeTables();
        btnDelete = findViewById(R.id.btn_delete);
        btnSetTarget = findViewById(R.id.btn_add_target);
        btnSetTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewTimeTableActivity.this, SetTimeTableActivity.class);
                startActivity(intent);
            }
        });

        btnSetTarget = findViewById(R.id.btn_set_target);
        btnSetTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewTimeTableActivity.this, SetWaterTargetActivity.class);
                startActivity(intent);
            }
        });

//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                deleteTimeTable();
//                Intent intent = new Intent(ViewTimeTableActivity.this, SetWaterTargetActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void loadTimeTables() {
        List<Timetable> timetableList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycler_view_timetable);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        TimeTableAdapter timeTableAdapter = new TimeTableAdapter();
        Context context = this;

        Query timeTables = FirebaseDB.getFirebaseDatabaseRef().child("Timetable");
        timeTables.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                timetableList.clear();
                for (DataSnapshot timeTable : snapshot.getChildren()) {
                    timetableList.add(timeTable.getValue(Timetable.class));
                }
                timeTableAdapter.setTimetableList(timetableList);
                timeTableAdapter.setContext(context);
                recyclerView.setAdapter(timeTableAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

//    public void deleteTimeTable() {
//        dbRef = FirebaseDB.getFirebaseDatabaseRef();
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChild("Timetable")) {
//                    dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Timetable");
//                    dbRef.removeValue();
//                    Toast.makeText(getApplicationContext(), "Data deleted Successfully", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "No source to delete", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
//    }
