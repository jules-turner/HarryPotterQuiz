package com.example.julesturner.hpq2;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import java.util.ArrayList;

public class House extends AppCompatActivity {
    private int houseNum;
    String textName;
    static ArrayList<Integer> array = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);


        Bundle bundle = getIntent().getExtras();
        textName = bundle.getString("textName");
        array = bundle.getIntegerArrayList("array");

        //Gryffindor House Button START
        Button GryButton = findViewById(R.id.GryButton);
        GryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houseNum = 1;
                Intent takeUserToMain = new Intent(getApplicationContext(), MainActivity.class);
                takeUserToMain.putExtra("textName", textName);
                takeUserToMain.putExtra("houseNum", houseNum);
                takeUserToMain.putExtra("array", array);
                startActivity(takeUserToMain);
            }
        });
        //Gryffindor House Button END


        //Ravenclaw House Button START
        Button RavButton = findViewById(R.id.RavButton);
        RavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houseNum = 2;
                Intent takeUserToMain = new Intent(getApplicationContext(), MainActivity.class);
                takeUserToMain.putExtra("textName", textName);
                takeUserToMain.putExtra("houseNum", houseNum);
                takeUserToMain.putExtra("array", array);
                startActivity(takeUserToMain);
            }
        });
        //Ravenclaw House Button END


        //Hufflepuff House Button START
        Button HuffButton = findViewById(R.id.HuffButton);
        HuffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houseNum = 3;
                Intent takeUserToMain = new Intent(getApplicationContext(), MainActivity.class);
                takeUserToMain.putExtra("houseNum", houseNum);
                takeUserToMain.putExtra("textName", textName);
                takeUserToMain.putExtra("array", array);
                startActivity(takeUserToMain);
            }
        });
        //Hufflepuff House Button END


        //Slytherin House Button START
        Button SlyButton = findViewById(R.id.SlyButton);
        SlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                houseNum = 4;
                Intent takeUserToMain = new Intent(getApplicationContext(), MainActivity.class);
                takeUserToMain.putExtra("houseNum", houseNum);
                takeUserToMain.putExtra("textName", textName);
                takeUserToMain.putExtra("array", array);
                startActivity(takeUserToMain);
            }
        });
        //Slytherin House Button END

        Button helpButton = (Button) findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(House.this).create();
                alert.setTitle("Welcome to the Harry Potter Quiz!");
                alert.setMessage("1) Enter your name into the space provided                   2) Pick your " +
                        "Hogwarts house -- if you do not know it go to www.pottermore.com/sorting                3) Take " +
                        "the quiz and take note of your score at the top -- at the end of the quiz" +
                        " it will show you your total score");
                alert.show();
            }
        });
    }
}
