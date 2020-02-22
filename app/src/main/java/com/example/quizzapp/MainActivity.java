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
    private RadioGroup answer1, answer2, answer3, answer4, answer5, answer6;
    private EditText nameAnswer;
    private CheckBox funCheckbox, cultureCheckbox, moviesCheckbox;
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
                    Toast.makeText(MainActivity.this, "It's super fun indeed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cultureCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cultureCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Learning about different cultures is always interesting", Toast.LENGTH_SHORT).show();
                }
            }
        });
        moviesCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moviesCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Movies are great :)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        answer5 = findViewById(R.id.answer5);
        answer6 = findViewById(R.id.answer6);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                String name = nameAnswer.getText().toString();

                if (answer1.getCheckedRadioButtonId() == R.id.correct_answer1) {
                    score++;
                }
                if (answer2.getCheckedRadioButtonId() == R.id.correct_answer2) {
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

                if (score == 6) {
                    Toast.makeText(MainActivity.this, "WOW " + name + " you answered all of them correctly!", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "WOW " + name + " you answered all of them correctly");
                    score = 0;
                } else {
                    Toast.makeText(MainActivity.this, "Correct answers: " + score + " /6 \n" + "you could do better " + name, Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "you could do better " + name);
                    score = 0;
                }
            }
        });
    }
}
