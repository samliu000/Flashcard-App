package com.example.samuelliu.flashcardapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Question).setElevation(20);

        findViewById(R.id.prompt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.prompt1).setBackgroundColor(Color.parseColor("#fc6565"));
                findViewById(R.id.prompt3).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.prompt2).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.prompt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.prompt3).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.prompt1).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.prompt2).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.prompt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.prompt2).setBackgroundColor(Color.parseColor("#FC6565"));
                findViewById(R.id.prompt3).setBackgroundColor(Color.parseColor("#40d12a"));
                findViewById(R.id.prompt1).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.closed_eye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.prompt2).setVisibility(View.INVISIBLE);
                findViewById(R.id.prompt3).setVisibility(View.INVISIBLE);
                findViewById(R.id.prompt1).setVisibility(View.INVISIBLE);
                findViewById(R.id.closed_eye).setVisibility(View.INVISIBLE);
                findViewById(R.id.open_eye).setVisibility(View.VISIBLE);
                findViewById(R.id.prompt2).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.prompt3).setBackgroundColor(Color.parseColor("#d2cced"));
                findViewById(R.id.prompt1).setBackgroundColor(Color.parseColor("#d2cced"));
            }
        });

        findViewById(R.id.open_eye).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.prompt2).setVisibility(View.VISIBLE);
                findViewById(R.id.prompt3).setVisibility(View.VISIBLE);
                findViewById(R.id.prompt1).setVisibility(View.VISIBLE);
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

        findViewById(R.id.editCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editTheCard = new Intent(MainActivity.this, AddCardActivity.class);

                TextView questionView = findViewById(R.id.Question);
                TextView answerView = findViewById(R.id.prompt3);
                TextView wrongAnswer1View = findViewById(R.id.prompt1);
                TextView wrongAnswer2View = findViewById(R.id.prompt2);
                editTheCard.putExtra("Question", questionView.getText());
                editTheCard.putExtra("Answer", answerView.getText());
                editTheCard.putExtra("WrongAnswer1", wrongAnswer1View.getText());
                editTheCard.putExtra("WrongAnswer2", wrongAnswer2View.getText());

                startActivityForResult(editTheCard, 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == 100 || requestCode == 200) && data != null) {

            // get new question and answer
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");
            String wrongAnswer1 = data.getExtras().getString("wrongAnswer1");
            String wrongAnswer2 = data.getExtras().getString("wrongAnswer2");

            // set question and answer views
            TextView questionView = (TextView) findViewById(R.id.Question);
            questionView.setText(question);

            TextView answerView = (TextView) findViewById(R.id.prompt3);
            answerView.setText(answer);

            TextView wrongAnswer1View = (TextView) findViewById(R.id.prompt2);
            wrongAnswer1View.setText(wrongAnswer1);

            TextView wrongAnswer2View = (TextView) findViewById(R.id.prompt1);
            wrongAnswer2View.setText(wrongAnswer2);

            if(requestCode == 100) {
                Snackbar.make(findViewById(R.id.Question),
                        "Card created successfully!",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
            else if(requestCode == 200) {
                Snackbar.make(findViewById(R.id.Question),
                        "Card edited successfully!",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }

        }


    }
}
