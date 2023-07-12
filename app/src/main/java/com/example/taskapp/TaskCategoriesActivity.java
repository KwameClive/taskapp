package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
public class EditTaskActivity extends AppCompatActivity {
    private EditText editTextTaskName;
    private Spinner spinnerTaskCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        editTextTaskName = findViewById(R.id.editTextTaskName);
        spinnerTaskCategory = findViewById(R.id.spinnerTaskCategory);
        // Get the task id from the intent
        Intent intent = getIntent();
        int taskId = intent.getIntExtra("taskId", -1);
        // If the task id is not -1, then we know that we are editing an existing task
        if (taskId != -1) {
            // Get the task from the database
            Task task = Task.getTaskById(this, taskId);
            // Set the task name and category in the UI
            editTextTaskName.setText(task.getName());
            spinnerTaskCategory.setSelection(task.getCategory());
        }
    }
    public void onSaveTask(View view) {
        // Get the task name and category from the UI
        String taskName = editTextTaskName.getText().toString();
        int taskCategory = spinnerTaskCategory.getSelectedItemPosition();
        // Create a new task or update an existing task
        Task