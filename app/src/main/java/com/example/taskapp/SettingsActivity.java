package com.example.taskapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSettings();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelSettings();
            }
        });
    }

    private void saveSettings() {
        // Save the settings and perform any necessary operations

        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void cancelSettings() {
        // Discard the changes and perform any necessary operations

        Toast.makeText(this, "Changes discarded", Toast.LENGTH_SHORT).show();
        finish();
    }
}
