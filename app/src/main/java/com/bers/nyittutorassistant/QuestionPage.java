package com.bers.nyittutorassistant;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

public class QuestionPage extends ComponentActivity implements AdapterView.OnItemSelectedListener {
    EditText titleBox;
    EditText hoursBox;
    EditText descriptionBox;
    Button finish;
    Spinner dropdown;
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void afterTextChanged(Editable s) {
            updateFinishButtonState();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_page);

        finish = findViewById(R.id.finish);
        titleBox = findViewById(R.id.titleBox);
        hoursBox = findViewById(R.id.hoursBox);
        descriptionBox = findViewById(R.id.descriptionBox);

        titleBox.addTextChangedListener(textWatcher);
        hoursBox.addTextChangedListener(textWatcher);
        descriptionBox.addTextChangedListener(textWatcher);

        dropdown = findViewById(R.id.tutorSpinner);

        String[] items = new String[]{"Select Name", "Jongho", "Kyungmin"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuestionPage.this, "Upload Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuestionPage.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        updateFinishButtonState();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    private void updateFinishButtonState() {
        if (!titleBox.getText().toString().isEmpty() && !hoursBox.getText().toString().isEmpty() && !descriptionBox.getText().toString().isEmpty() && !dropdown.getSelectedItem().toString().equals("Select Name")) {
            finish.setEnabled(true);
        } else {
            finish.setEnabled(false);
        }
    }
}
