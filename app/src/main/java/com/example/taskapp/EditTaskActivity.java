package com.example.taskapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class EditTaskActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the task title and description from the edit texts.
                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();
                // Create a new Intent to return to the MainActivity.
                Intent intent = new Intent(EditTaskActivity.this, MainActivity.class);
                // Add the task title and description to the Intent.
                intent.putExtra("title", title);
                intent.putExtra("description", description);
                // Set the result of the activity to the Intent.
                setResult(RESULT_OK, intent);
                // Finish the activity.
                finish();
            }
        });
    }
}
