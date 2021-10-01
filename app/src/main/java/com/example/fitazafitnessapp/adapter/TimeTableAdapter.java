package com.example.fitazafitnessapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitazafitnessapp.R;
import com.example.fitazafitnessapp.ViewTimeTableActivity;
import com.example.fitazafitnessapp.db.FirebaseDB;
import com.example.fitazafitnessapp.model.Timetable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder> {

    private List<Timetable> timetableList;
    private LayoutInflater inflater;
    private Context context;

    @NonNull
    @Override
    public TimeTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_view_time_table, parent, false);
        return new TimeTableAdapter.TimeTableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeTableViewHolder holder, int position) {
        Timetable timetable = timetableList.get(position);
        holder.txtDay.setText(timetable.getDay());
        holder.txtExercise1.setText(timetable.getExercise1());
        holder.txtExercise2.setText(timetable.getExercise2());
        String time1 = LocalTime.of(timetable.getTime1H(), timetable.getTime1M()).format(DateTimeFormatter.ofPattern("hh:mm a"));
        String time2 = LocalTime.of(timetable.getTime1H(), timetable.getTime1M()).format(DateTimeFormatter.ofPattern("hh:mm a"));
        holder.txtTime1.setText(time1);
        holder.txtTime2.setText(time2);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTimeTable(timetable);
            }
        });
    }

    private void deleteTimeTable(Timetable timetable) {
        DatabaseReference dbRef = FirebaseDB.getFirebaseDatabaseRef().child("Timetable");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(timetable.getId())) {
                    dbRef.child(timetable.getId()).removeValue();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return timetableList.size();
    }

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public class TimeTableViewHolder extends RecyclerView.ViewHolder {

        TextView txtDay, txtExercise1, txtTime1, txtExercise2, txtTime2;
        Button btnDelete;

        public TimeTableViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDay = itemView.findViewById(R.id.txtDay);
            txtExercise1 = itemView.findViewById(R.id.txtExercise1);
            txtTime1 = itemView.findViewById(R.id.txtTime1);
            txtExercise2 = itemView.findViewById(R.id.txtExercise2);
            txtTime2 = itemView.findViewById(R.id.txtTime2);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

    }
}
