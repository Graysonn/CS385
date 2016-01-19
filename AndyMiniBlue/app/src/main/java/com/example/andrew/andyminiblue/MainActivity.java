package com.example.andrew.andyminiblue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        startgame = (Button) findViewById(R.id.newGamebutton);
        startgame.setOnClickListener(this);

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
        switch (v.getId()) {
            case R.id.newGamebutton:
                Intent intent = new Intent("android.intent.action.GAMESCREEN");
                startActivity(intent);
        }

    }
}
