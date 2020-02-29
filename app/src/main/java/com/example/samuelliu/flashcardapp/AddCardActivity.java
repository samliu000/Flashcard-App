package com.example.samuelliu.flashcardapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

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

                // create new intent for data sendback
                Intent data = new Intent();
                data.putExtra("question", question);
                data.putExtra("answer", answer);
                setResult(RESULT_OK, data);

                // return to orig activity
                finish();
            }
        });
    }
}
