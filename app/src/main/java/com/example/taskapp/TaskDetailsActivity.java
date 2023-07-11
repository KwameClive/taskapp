package com.example.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        // Get the task information from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("task")) {
            String task = intent.getStringExtra("task");

            // Display the task details in a TextView
            TextView taskTextView = findViewById(R.id.taskTextView);
            taskTextView.setText(task);
        }
    }
}
