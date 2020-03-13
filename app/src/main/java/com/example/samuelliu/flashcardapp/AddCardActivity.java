package com.example.samuelliu.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        // update the fields
        String startingQuestion = getIntent().getStringExtra("Question");
        String startingAnswer = getIntent().getStringExtra("Answer");
        String startingWrongAns1 = getIntent().getStringExtra("WrongAnswer1");
        String startingWrongAns2 = getIntent().getStringExtra("WrongAnswer2");

        // set fields
        TextView questionView = findViewById(R.id.QuestionPrompt);
        TextView answerView = findViewById(R.id.AnswerPrompt);
        TextView wrongAnswer1View = findViewById(R.id.WrongPrompt1);
        TextView wrongAnswer2View = findViewById(R.id.WrongPrompt2);
        ((EditText) findViewById(R.id.QuestionPrompt)).setText(startingQuestion);
        ((EditText) findViewById(R.id.AnswerPrompt)).setText(startingAnswer);
        ((EditText) findViewById(R.id.WrongPrompt1)).setText(startingWrongAns1);
        ((EditText) findViewById(R.id.WrongPrompt2)).setText(startingWrongAns2);


        findViewById(R.id.Cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // end activity
                finish();
            }
        });

        findViewById(R.id.Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get text from EditText views
                String question =
                        ((EditText) findViewById(R.id.QuestionPrompt)).getText().toString();
                String answer =
                        ((EditText) findViewById(R.id.AnswerPrompt)).getText().toString();
                String wrongAnswer1 =
                        ((EditText) findViewById(R.id.WrongPrompt1)).getText().toString();
                String wrongAnswer2 =
                        ((EditText) findViewById(R.id.WrongPrompt2)).getText().toString();

                if(question.equals("") || answer.equals("") || wrongAnswer1.equals("") ||
                        wrongAnswer2.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Must fill in all fields", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    toast.show();

                    // end method
                    return;
                }

                // create new intent for data sendback
                Intent data = new Intent();
                data.putExtra("question", question);
                data.putExtra("answer", answer);
                data.putExtra("wrongAnswer1", wrongAnswer1);
                data.putExtra("wrongAnswer2", wrongAnswer2);
                setResult(RESULT_OK, data);

                // return to orig activity
                finish();
            }
        });

    }
}
