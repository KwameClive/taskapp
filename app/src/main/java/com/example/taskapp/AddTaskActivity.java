package com.example.taskapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText descriptionEditText;
    private Button saveTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveTaskButton = findViewById(R.id.saveTaskButton);

        saveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });
    }

    private void addTask() {
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();

        // Perform any necessary operations with the title and description here
        MainActivity.taskList.add(title);
        // Finish the activity
        System.out.println(MainActivity.taskList);
        finish();

    }
}
