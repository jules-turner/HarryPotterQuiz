package com.example.julesturner.hpq2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    MediaPlayer player;
    static ArrayList<Integer> array = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText inputName = (EditText)findViewById(R.id.editText);
        Button Start =(Button)findViewById(R.id.button1);
        for (int j = 1; j <= 20; j++) {
            array.add(j);
        }

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textName = inputName.getText().toString();
                AssetFileDescriptor afd = null;
                try {
                    afd = getAssets().openFd("hedwigTheme.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player = new MediaPlayer();
                try {
                    player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.start();
                Intent takeUserToHouse = new Intent(getApplicationContext(), House.class);
                takeUserToHouse.putExtra("textName", textName);
                takeUserToHouse.putExtra("array", array);
                startActivity(takeUserToHouse);
            }
        });

        Button helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog alert = new AlertDialog.Builder(Home.this).create();
                alert.setTitle("Welcome to the Harry Potter Quiz!");
                alert.setMessage("1) Enter your name into the space provided                   2) Pick your " +
                        "Hogwarts house -- if you do not know it go to www.pottermore.com/sorting                3) Take " +
                        "the quiz and take note of your score at the top -- at the end of the quiz" +
                        " it will show you your total score" +
                        "IMPORTANT NOTE: DO NOT CLICK BACK ONCE YOU START PLAYING ");
                alert.setButton(Dialog.BUTTON_POSITIVE,"Turn Music Off",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        player.pause();
                    }
                });
                alert.show();
            }
        });
    }
}