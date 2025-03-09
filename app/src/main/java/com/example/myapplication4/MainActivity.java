package com.example.myapplication4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextName = findViewById(R.id.editTextName);
        Button buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("username", editTextName.getText().toString());
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textViewDate = findViewById(R.id.textViewDate);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            long dateInMillis = data.getLongExtra("selectedDate", 0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            String formattedDate = sdf.format(dateInMillis);
            textViewDate.setText(formattedDate);
        }
    }
}