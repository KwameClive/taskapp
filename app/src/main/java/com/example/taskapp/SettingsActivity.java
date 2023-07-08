package com.example.taskapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingsActivity extends AppCompatActivity {

    private Button darkModeButton;
    private Button lightModeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        darkModeButton = findViewById(R.id.darkModeButton);
        lightModeButton = findViewById(R.id.lightModeButton);

        darkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDarkMode();
            }
        });

        lightModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLightMode();
            }
        });
    }

    private void setDarkMode() {
        // Save the selected mode preference
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("selected_mode", "dark").apply();

        // Apply dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        recreate();
    }

    private void setLightMode() {
        // Save the selected mode preference
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("selected_mode", "light").apply();

        // Apply light mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        recreate();
    }
    private void saveSettings(boolean shouldClearTasks) {
        // Save the settings and perform any necessary operations

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.edit().putString("selected_mode", "dark").apply();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("shouldClearTasks", shouldClearTasks);
        setResult(RESULT_OK, resultIntent);
        finish();
    }


}
