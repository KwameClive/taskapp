package com.example.taskapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CompletedTasksActivity extends AppCompatActivity {

    private ListView completedTasksListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> completedTasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_tasks);

        ListView completedTasksListView = findViewById(R.id.listView_completed_tasks);

        completedTasksList = new ArrayList<>();
        completedTasksList.add("Completed Task 1");
        completedTasksList.add("Completed Task 2");
        completedTasksList.add("Completed Task 3");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, completedTasksList);
        completedTasksListView.setAdapter(adapter);
    }
}
