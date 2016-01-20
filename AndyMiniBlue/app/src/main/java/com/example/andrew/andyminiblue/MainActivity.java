package com.example.andrew.andyminiblue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startgame;
    Button stats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        //declare and initialise the buttons that are used, new game button and stats screen button, turn on onClickListener for both
        startgame = (Button) findViewById(R.id.newGamebutton);
        startgame.setOnClickListener(this);
        stats= (Button) findViewById(R.id.statsButton);
        stats.setOnClickListener(this);

    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        //if clicked use a switch statement to check which button was pressed
        //use an intent to send the user to the relevant screen
        switch (v.getId()) {
            case R.id.newGamebutton:
                Intent intent = new Intent("android.intent.action.GAMESCREEN");
                startActivity(intent);
                break;
            case R.id.statsButton:
                Intent intentStat = new Intent("android.intent.action.STATISTICS");
                startActivity(intentStat);
                break;
        }

    }
}
