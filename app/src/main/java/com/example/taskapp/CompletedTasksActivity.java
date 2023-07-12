package com.example.taskapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompletedTasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_tasks);

        // Get the completed task information from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("completedTask") && intent.hasExtra("completedTaskDescription")) {
            String completedTask = intent.getStringExtra("completedTask");
            String completedTaskDescription = intent.getStringExtra("completedTaskDescription");

            // Display the completed task details in TextViews
            TextView completedTaskTextView = findViewById(R.id.completedTaskTextView);
            completedTaskTextView.setText(completedTask);

            TextView completedTaskDescriptionTextView = findViewById(R.id.completedTaskDescriptionTextView);
            completedTaskDescriptionTextView.setText(completedTaskDescription);
        }
    }
}
