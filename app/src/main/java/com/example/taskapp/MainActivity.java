package com.example.taskapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView taskListView;
    private ArrayAdapter<String> adapter;
    public static ArrayList<String> taskList = new ArrayList<>();

    private static final int ADD_TASK_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList.add("Task 1");
        taskList.add("Task 2");
        taskList.add("Task 3");

        taskListView = findViewById(R.id.taskListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                openTaskDetailsScreen(position);
                System.out.println("Task list clicked");
            }
        });

        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddTaskScreen();
            }
        });

        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsScreen();
            }
        });

        Button markAsCompletedButton = findViewById(R.id.markAsCompletedButton);
        markAsCompletedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markTaskAsCompleted();
            }
        });
    }
    protected void onResume() {
        super.onResume();

        // Reload or update the variables here
        taskListView = findViewById(R.id.taskListView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);
    }
    private void openAddTaskScreen() {
        Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
        startActivityForResult(intent, ADD_TASK_REQUEST_CODE);
    }

    private void openTaskDetailsScreen(int position) {
        String task = taskList.get(position);
        Intent intent = new Intent(MainActivity.this, TaskDetailsActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    private void openSettingsScreen() {
        try {

            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        } catch (ActivityNotFoundException err) {
            System.out.println(err);
        }
    }

    private void markTaskAsCompleted() {
        // Get the selected task
        int position = taskListView.getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            String completedTask = taskList.get(position);
            // Perform any necessary operations with the completed task

            // Remove the completed task from the list
            taskList.remove(position);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_TASK_REQUEST_CODE && resultCode == RESULT_OK) {
            String newTask = data.getStringExtra("newTask");
            taskList.add(newTask);
            adapter.notifyDataSetChanged();
        }
    }
}
