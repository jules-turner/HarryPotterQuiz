package com.example.julesturner.hpq2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int QuestionNum;
    private TextView Question;
    private int houseNum;
    static String textName;
    static TextView name;
    static TextView score;
    static String scoreFinal;
    static int changingScore;

    //Strings
    static String q;
    static String a1;
    static String na1;
    static String na2;
    static String na3;
    static String na4;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Random r;

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    static ArrayList<Integer> array = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        houseNum = bundle.getInt("houseNum");
        array = bundle.getIntegerArrayList("array");
        textName = bundle.getString("textName");

        changingScore = 0;

        //Gryffindor
        if (houseNum == 1) {
            setContentView(R.layout.activity_main1);
        }
        //Ravenclaw
        if (houseNum == 2) {
            setContentView(R.layout.activity_main2);
        }
        //Hufflefuff
        if (houseNum == 3) {
            setContentView(R.layout.activity_main3);
        }
        //Slytherin
        if (houseNum == 4) {
            setContentView(R.layout.activity_main4);
        }

        callEverything(na1, na2, na3, na4, a1, r, button1, button2, button3, button4, q, Question);

    }


    @SuppressLint("SetTextI18n")
    private void callEverything(String na1, String na2, String na3, String na4, String a1, Random r, Button button1, Button button2, Button button3, Button button4, String q, TextView question) {

        Log.i("!!!!!!!!!!!", "HERE is the starting array : " + array);


        //Random num generator -- HAVE TO CHANGE THIS DEPENDING ON DATABASE NUM OF QUESTIONS
        r = new Random();
        //QuestionNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);

        //Collections.shuffle(array);
        QuestionNum = array.get(r.nextInt(array.size()));
        Log.i("!!!!!!!!!!", "!!!!!!!!!!! QuestionNum = " + QuestionNum);

        //QUESTION STUFF --
        name = findViewById(R.id.textView7);
        score = findViewById(R.id.Score);
        //declared at top --
        Question = findViewById(R.id.Question);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        //Question Database Query
        q = databaseAccess.getQuestions(QuestionNum).toString();
        //na1 == answer
        a1 = databaseAccess.getAnswer(QuestionNum).toString();
        //na1, na2,na3,na3 are possible answers
        na1 = databaseAccess.getNA1(QuestionNum).toString();
        na2 = databaseAccess.getNA2(QuestionNum).toString();
        na3 = databaseAccess.getNA3(QuestionNum).toString();
        na4 = databaseAccess.getNA4(QuestionNum).toString();

        //REMOVES [] around database Query
        q = q.substring(0, q.length() - 1);
        q = q.substring(1);
        a1 = a1.substring(0, a1.length() - 1);
        a1 = a1.substring(1);
        na1 = na1.substring(0, na1.length() - 1);
        na1 = na1.substring(1);
        na2 = na2.substring(0, na2.length() - 1);
        na2 = na2.substring(1);
        na3 = na3.substring(0, na3.length() - 1);
        na3 = na3.substring(1);
        na4 = na4.substring(0, na4.length() - 1);
        na4 = na4.substring(1);

        //REMOVES [] around database Query
        Question.setText(q);
        //Setting text buttons to query strings from database
        button1.setText(na1);
        button2.setText(na2);
        button3.setText(na3);
        button4.setText(na4);
        //QUESTION STUFF--

        //BUTTON SHIT --------------------------------------
        final String finalA1 = a1;final String finalNa = na1;final String finalNa4 = na1;final String finalNa5 = na2;final String finalNa6 = na3;final String finalNa7 = na4;final String finalA4 = a1;final Random finalR = r;final Button finalButton = button1;final Button finalButton1 = button2;final Button finalButton2 = button3;final Button finalButton3 = button4;final String finalQ = q;final String finalNa24 = na1;final String finalNa25 = na2;final String finalNa26 = na3;final String finalNa27 = na4;final String finalA9 = a1;final Random finalR5 = r;final Button finalButton20 = button1;final Button finalButton21 = button2;final Button finalButton22 = button3;final Button finalButton23 = button4;final String finalQ5 = q;
        button1.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.i("!!!!!!!!!!!", " Its getting here HERE!");
                if (finalNa.contentEquals(finalA1)) {
                    Log.i("!!!!!!!!!!!", " Its getting here!");
                    changingScore = changingScore + 10;
                    Log.i("!!!!!!!!!!!", "Changing Score : " + changingScore);
                    scoreFinal = changingScore + " ";
                    name.setText(textName + "'s Score: ");
                    score.setText(scoreFinal);
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa4, finalNa5, finalNa6, finalNa7, finalA4, finalR, finalButton, finalButton1, finalButton2, finalButton3, finalQ, Question);

                } else {
                    changingScore = changingScore - 5;
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa24, finalNa25, finalNa26, finalNa27, finalA9, finalR5, finalButton20, finalButton21, finalButton22, finalButton23, finalQ5, Question);
                }
            }
        });

        final String finalNa1 = na2;final String finalA2 = a1;final String finalNa8 = na1;final String finalNa9 = na2;final String finalNa10 = na3;final String finalNa11 = na4;final String finalA5 = a1;final Random finalR1 = r;final Button finalButton4 = button1;final Button finalButton5 = button2;final Button finalButton6 = button3;final Button finalButton7 = button4;final String finalQ1 = q;final String finalNa20 = na1;final String finalNa21 = na2;final String finalNa22 = na3;final String finalNa23 = na4;final String finalA8 = a1;final Random finalR4 = r;final Button finalButton16 = button1;final Button finalButton17 = button2;final Button finalButton18 = button3;final Button finalButton19 = button4;final String finalQ4 = q;
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.i("!!!!!!!!!!!", " Its getting here HERE!");
                if (finalNa1.contentEquals(finalA2)) {
                    Log.i("!!!!!!!!!!!", " Its getting here!");
                    changingScore = changingScore + 10;
                    Log.i("!!!!!!!!!!!", "Changing Score : " + changingScore);
                    scoreFinal = changingScore + " ";
                    name.setText(textName + "'s Score: ");
                    score.setText(scoreFinal);
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa8, finalNa9, finalNa10, finalNa11, finalA5, finalR1, finalButton4, finalButton5, finalButton6, finalButton7, finalQ1, Question);
                } else {
                    changingScore = changingScore - 5;
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa20, finalNa21, finalNa22, finalNa23, finalA8, finalR4, finalButton16, finalButton17, finalButton18, finalButton19, finalQ4, Question);
                }
            }
        });

        final String finalA3 = a1;final String finalNa3 = na3;final String finalNa12 = na1;final String finalNa13 = na2;final String finalNa14 = na3;final String finalQ2 = q;final Button finalButton8 = button4;final Button finalButton9 = button3;final Button finalButton10 = button2;final Button finalButton11 = button1;final Random finalR2 = r;final String finalA6 = a1;final String finalNa15 = na4;final String finalNa28 = na1;final String finalNa29 = na2;final String finalNa30 = na3;final String finalNa31 = na4;final String finalA10 = a1;final String finalQ6 = q;final Button finalButton24 = button4;final Button finalButton25 = button3;final Button finalButton26 = button2;final Button finalButton27 = button1;final Random finalR6 = r;
        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.i("!!!!!!!!!!!", " Its getting here HERE!");
                if (finalNa3.contentEquals(finalA3)) {
                    Log.i("!!!!!!!!!!!", " Its getting here!");
                    changingScore = changingScore + 10;
                    Log.i("!!!!!!!!!!!", "Changing Score : " + changingScore);
                    scoreFinal = changingScore + " ";
                    name.setText(textName + "'s Score: ");
                    score.setText(scoreFinal);
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa12, finalNa13, finalNa14, finalNa15, finalA6, finalR2, finalButton11, finalButton10, finalButton9, finalButton8, finalQ2, Question);
                } else {
                    changingScore = changingScore - 5;
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa28, finalNa29, finalNa30, finalNa31, finalA10, finalR6, finalButton27, finalButton26, finalButton25, finalButton24, finalQ6, Question);
                }
            }
        });

        final String finalA = a1;final String finalNa2 = na4;final String finalNa16 = na1;final String finalNa17 = na2;final String finalNa18 = na3;final String finalNa19 = na4;final Button finalButton12 = button4;final String finalQ3 = q;final Button finalButton13 = button3;final Button finalButton14 = button2;final Button finalButton15 = button1;final Random finalR3 = r;final String finalA7 = a1;final String finalQ7 = q;final Button finalButton28 = button4;final Button finalButton29 = button3;final Button finalButton30 = button2;final Button finalButton31 = button1;final Random finalR7 = r;final String finalA11 = a1;final String finalNa32 = na4;final String finalNa33 = na3;final String finalNa34 = na2;final String finalNa35 = na1;
        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Log.i("!!!!!!!!!!!", " Its getting here HERE!");
                if (finalNa2.contentEquals(finalA)) {
                    Log.i("!!!!!!!!!!!", " Its getting here!");
                    changingScore = changingScore + 10;
                    Log.i("!!!!!!!!!!!", "Changing Score : " + changingScore);
                    scoreFinal = changingScore + " ";
                    name.setText(textName + "'s Score: ");
                    score.setText(scoreFinal);
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa16, finalNa17, finalNa18, finalNa19, finalA7, finalR3, finalButton15, finalButton14, finalButton13, finalButton12, finalQ3, Question);
                } else {
                    changingScore = changingScore - 5;
                    array.remove(Integer.valueOf(QuestionNum));
                    Log.i("!!!!!!!!!!", "This is the array Now  !!!!!!!!     : " + array);
                    if (array.size() < 1) {
                        Log.i("!!!!!!!!!!!!!", "it is getting to alert placement");
                        callScorePage();
                    }
                    callEverything(finalNa35, finalNa34, finalNa33, finalNa32, finalA11, finalR7, finalButton31, finalButton30, finalButton29, finalButton28, finalQ7, Question);
                }
            }
        });
        //End of Button 4---
        scoreFinal = changingScore + " ";
        name.setText(textName + "'s Score: ");
        score.setText(scoreFinal);
    }

    private void callScorePage() {
        Log.i("Hello", "!!! finalScore : "+ scoreFinal);
        Intent takeUserToScore = new Intent(getApplicationContext(), ScorePage.class);
        takeUserToScore.putExtra("scoreFinal", scoreFinal);
        takeUserToScore.putExtra("changingScore", changingScore);
        takeUserToScore.putExtra("textName", textName);
        takeUserToScore.putExtra("houseNum", houseNum);
        startActivity(takeUserToScore);
    }
}