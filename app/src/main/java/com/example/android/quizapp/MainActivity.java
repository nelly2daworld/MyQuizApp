package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double finalScore = 0.00;
    boolean checked = false; //ensure we do not double count
    private TextView score = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.incorrect1);
        final Button button2 = findViewById(R.id.incorrect2);
        final Button button3 = findViewById(R.id.incorrect3);
        final Button button4 = findViewById(R.id.correct);


        // Register the onClick listener with the implementation above
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setEnabled(false);
                Toast toastMessage = Toast.makeText(getApplicationContext(),
                        "Your current score is " + finalScore,
                        Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setEnabled(false);
                Toast toastMessage = Toast.makeText(getApplicationContext(),
                        "Your current score is " + finalScore,
                        Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.setEnabled(false);
                Toast toastMessage = Toast.makeText(getApplicationContext(),
                        "Your current score is " + finalScore,
                        Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4.setEnabled(false);
                finalScore++;
                Toast toastMessage = Toast.makeText(getApplicationContext(),
                        "Your current score is " + finalScore,
                        Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });


//-------@@@@@@@@@@@@@@@@@@@@@@@@@ RADIOGROUP1 INFO @@@@@@@@@@@@@@@@@@@@@@@@@@@------------
        RadioGroup radioGroup = findViewById(R.id.RGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //find which radio button is selected
                if (checkedId == R.id.radio_button11) {
                    finalScore++;
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

//-------@@@@@@@@@@@@@@@@@@@@@@@@@ RADIOGROUP2 INFO @@@@@@@@@@@@@@@@@@@@@@@@@@@------------
        RadioGroup radioGroup2 = findViewById(R.id.Languages);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //find which radio button is selected
                if (checkedId == R.id.language3) {
                    finalScore++;
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

//-------@@@@@@@@@@@@@@@@@@@@@@@@@ CHECKBOX INFO @@@@@@@@@@@@@@@@@@@@@@@@@@@------------

        CheckBox ChkBox1 = findViewById(R.id.checkboxOne);
        CheckBox ChkBox2 = findViewById(R.id.checkboxTwo);
        CheckBox ChkBox3 = findViewById(R.id.checkboxThree);

        ChkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    finalScore += (0.33);
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        ChkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    finalScore += (0.33);
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        ChkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    finalScore += (0.33);
                    Toast.makeText(getApplicationContext(),
                            "Your current score is " + finalScore + " ",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //-------@@@@@@@@@@@@@@@@@@@@@@@@@ EDITTEXT INFO @@@@@@@@@@@@@@@@@@@@@@@@@@@------------
        final EditText edittext = findViewById(R.id.editText1);
        edittext.getText().toString();
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (edittext.getText().toString().equals("Bit") ||
                            edittext.getText().toString().equals("bit")) {
                        finalScore++;
                        Toast.makeText(getBaseContext(), "Your current score is " + finalScore++, Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });
        //-------@@@@@@@@@@@@@@ Move to ScoreActivity with Submit Button @@@@@@@@@@@@----------

        Button submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Your final Score is " + (finalScore / 6) * 100 + " %",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}





