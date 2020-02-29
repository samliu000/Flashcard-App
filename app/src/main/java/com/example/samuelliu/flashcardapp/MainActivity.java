package com.example.samuelliu.flashcardapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Question).setElevation(20);

        findViewById(R.id.ps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.ps).setBackgroundColor(Color.parseColor("#fc6565"));
                findViewById(R.id.kc).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.sf).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.kc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.kc).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.ps).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.sf).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.sf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.sf).setBackgroundColor(Color.parseColor("#FC6565"));
                findViewById(R.id.kc).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.ps).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.closed_eye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.sf).setVisibility(View.INVISIBLE);
                findViewById(R.id.kc).setVisibility(View.INVISIBLE);
                findViewById(R.id.ps).setVisibility(View.INVISIBLE);
                findViewById(R.id.closed_eye).setVisibility(View.INVISIBLE);
                findViewById(R.id.open_eye).setVisibility(View.VISIBLE);
                findViewById(R.id.sf).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.kc).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.ps).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.open_eye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.sf).setVisibility(View.VISIBLE);
                findViewById(R.id.kc).setVisibility(View.VISIBLE);
                findViewById(R.id.ps).setVisibility(View.VISIBLE);
                findViewById(R.id.closed_eye).setVisibility(View.VISIBLE);
                findViewById(R.id.open_eye).setVisibility(View.INVISIBLE);
            }
        });



    }
}
