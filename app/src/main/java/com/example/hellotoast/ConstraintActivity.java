package com.example.hellotoast;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConstraintActivity extends AppCompatActivity {

    private int counter=0;
    private Button bCounter;
    private Button bToast;
    private TextView counterTextView;

    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_INDEX);
        }

        counterTextView = findViewById(R.id.text_view);

        counterTextView.setText(String.valueOf(counter));

        bToast = findViewById(R.id.toast_button);
        bToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "Counter = " + String.valueOf(counter);
                Toast.makeText(getApplicationContext(),number, Toast.LENGTH_SHORT).show();
            }
        });

        bCounter = findViewById(R.id.counter_button);
        bCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                counterTextView.setText(String.valueOf(counter));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, counter);
    }

}
