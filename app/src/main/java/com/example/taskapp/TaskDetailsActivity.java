package com.example.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        int position = getIntent().getIntExtra("position", -1);
        Task selectedTask = getTaskDetails(position);
        
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);


        titleTextView.setText(selectedTask.getTitle());
        descriptionTextView.setText(selectedTask.getDescription());

        //     taskTextView.setText(task);

        // // Get the task information from the intent
        // Intent intent = getIntent();
        // if (intent != null && intent.hasExtra("task")) {
        //     String task = intent.getStringExtra("task");

        //     // Display the task details in a TextView
        //     TextView taskTextView = findViewById(R.id.taskTextView);
        //     taskTextView.setText(task);
        // }
    }

}
