package com.example.samuelliu.flashcardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.Question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Question).setVisibility(View.INVISIBLE);
                findViewById(R.id.Answer).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.Answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.Question).setVisibility(View.VISIBLE);
            }
        });

    }
}
