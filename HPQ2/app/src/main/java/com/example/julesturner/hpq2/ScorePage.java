package com.example.julesturner.hpq2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScorePage extends AppCompatActivity {
    String scoreFinal;
    int changingScore;
    String textName;
    TextView name;
    TextView score;
    int houseNum;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        scoreFinal = bundle.getString("scoreFinal");
        changingScore = bundle.getInt("changingScore");
        textName = bundle.getString("textName");
        houseNum = bundle.getInt("houseNum");

        //Gryffindor
        if (houseNum == 1) {
            setContentView(R.layout.activity_score_page1);
        }
        //Ravenclaw
        if (houseNum == 2) {
            setContentView(R.layout.activity_score_page2);
        }
        //Hufflefuff
        if (houseNum == 3) {
            setContentView(R.layout.activity_score_page3);
        }
        //Slytherin
        if (houseNum == 4) {
            setContentView(R.layout.activity_score_page4);
        }

        Button button = findViewById(R.id.button80);
        name = findViewById(R.id.textView7);
        score = findViewById(R.id.Score);
        name.setText(textName + "'s Final Score is: ");
        score.setText(scoreFinal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeUserToHouse = new Intent(getApplicationContext(), Home.class);
                startActivity(takeUserToHouse);
            }
        });
    }
}
