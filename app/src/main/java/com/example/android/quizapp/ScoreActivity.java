package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);

        Button emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(v->onEmailButtonPressed());
    }

    public void onEmailButtonPressed() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Quiz Score");
        intent.putExtra(Intent.EXTRA_TEXT, ""); //enter a string for the email body
        intent.putExtra(Intent.EXTRA_CC, "");
        intent.putExtra(Intent.EXTRA_BCC, "");
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        } else {
            Toast.makeText(this, "The activity could not be resolved.", Toast.LENGTH_SHORT).show();
        }
    }
}
