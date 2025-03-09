package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewName = findViewById(R.id.textViewName);
        DatePicker datePicker = findViewById(R.id.datePicker);
        Button buttonOk = findViewById(R.id.buttonOk);

        String name = getIntent().getStringExtra("username");
        textViewName.setText(name);

        buttonOk.setOnClickListener(v -> {
            long dateInMillis = datePicker.getCalendarView().getDate();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedDate", dateInMillis);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}