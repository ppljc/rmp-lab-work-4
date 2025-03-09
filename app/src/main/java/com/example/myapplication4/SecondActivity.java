package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

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
            Calendar calendar = Calendar.getInstance();
            calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
            long dateInMillis = calendar.getTimeInMillis();

            Intent resultIntent = new Intent();
            resultIntent.putExtra("selectedDate", dateInMillis);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}