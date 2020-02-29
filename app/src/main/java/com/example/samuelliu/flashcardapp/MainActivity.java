package com.example.samuelliu.flashcardapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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

        findViewById(R.id.addCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCard = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(addCard, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {

            // get new question and answer
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");

            // set question and answer views
            TextView questionView = (TextView) findViewById(R.id.Question);
            questionView.setText(question);

        }
    }
}
