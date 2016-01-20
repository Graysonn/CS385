package com.example.andrew.andyminiblue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //declare and initialise the TextViews for number of wins, losses and the percentage of wins
        TextView wincount= (TextView) findViewById(R.id.winStat);
        TextView losscount =(TextView) findViewById(R.id.lossStat);
        TextView percent=(TextView) findViewById(R.id.PercentWin);

        //connect to and open the database
        GameDb mydb;
        mydb=new GameDb(this);
        mydb.open();
        mydb.createGame(0, 0);

        //set the textViews to show the number of wins and losses taken from the database
        wincount.setText("No. of Wins: " + mydb.getWins());
        losscount.setText("No. of Losses: " + mydb.getLoss());

        //calculate the percentage of wins, need to parse the strings as doubles,
        double percentage=100*Double.parseDouble(mydb.getWins())/(Double.parseDouble(mydb.getLoss())+Double.parseDouble(mydb.getWins()));

        //set the textView to show the percentage
        percent.setText(String.format("Percent won: %.2f",percentage));

    }

}
