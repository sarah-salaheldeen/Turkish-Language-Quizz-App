package com.example.quizzapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    private RadioGroup answer3, answer4, answer5, answer6, answer7, answer8;
    private EditText nameAnswer, answer2;
    private CheckBox funCheckbox, cultureCheckbox, moviesCheckbox, answer1_1, answer1_2, answer1_3;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameAnswer = findViewById(R.id.name_answer);

        funCheckbox = findViewById(R.id.fun_checkbox);
        cultureCheckbox = findViewById(R.id.culture_checkbox);
        moviesCheckbox = findViewById(R.id.movies_checkbox);

        funCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (funCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, R.string.learning_is_fun, Toast.LENGTH_SHORT).show();
                }
            }
        });
        cultureCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cultureCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, R.string.cultures_people, Toast.LENGTH_SHORT).show();
                }
            }
        });
        moviesCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moviesCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, R.string.movies_are_great, Toast.LENGTH_SHORT).show();
                }
            }
        });

        answer1_1 = findViewById(R.id.correct_answer1_1);
        answer1_2 = findViewById(R.id.correct_answer1_2);
        answer1_3 = findViewById(R.id.answer1_3);

        answer2 = findViewById(R.id.answer2);

        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);
        answer6 = findViewById(R.id.answer6);
        answer7 = findViewById(R.id.answer7);
        answer8 = findViewById(R.id.answer8);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String name = nameAnswer.getText().toString();

                if (answer1_1.isChecked() && answer1_2.isChecked() && !answer1_3.isChecked()){
                    score++;
                }
                if (answer2.getText().toString().trim().equals(getString(R.string.Arabic)) || answer2.getText().toString().trim().equals(getString(R.string.arabic))) {
                    score++;
                }
                if (answer3.getCheckedRadioButtonId() == R.id.correct_answer3) {
                    score++;
                }
                if (answer4.getCheckedRadioButtonId() == R.id.correct_answer4) {
                    score++;
                }
                if (answer5.getCheckedRadioButtonId() == R.id.correct_answer5) {
                    score++;
                }
                if (answer6.getCheckedRadioButtonId() == R.id.correct_answer6) {
                    score++;
                }
                if (answer7.getCheckedRadioButtonId() == R.id.correct_answer7) {
                    score++;
                }
                if (answer8.getCheckedRadioButtonId() == R.id.correct_answer8) {
                    score++;
                }

                if (score == 8) {
                    Toast.makeText(MainActivity.this, getString(R.string.wow) + " " + name + " " + getString(R.string.answered_correctly), Toast.LENGTH_LONG).show();
                    score = 0;
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.correct_answers) + " " + score + " /8 \n" + " " + getString(R.string.do_better) + " " + name, Toast.LENGTH_LONG).show();
                    score = 0;
                }
            }
        });
    }
}
