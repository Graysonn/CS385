package com.example.andrew.andyminiblue;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    int score=0;
    String userScore;
    int compscore=0;
    int wincount=0;
    int losscount=0;
    String pcScore;
    int ace=0;
    int compace=0;
    deck deck1 = new deck();
    public Button addCard;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button;
        //Button addCard;
        Button reset;
        addCard=(Button) findViewById(R.id.addCard);
        addCard.setOnClickListener(this);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        reset=(Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

        TextView scr = (TextView) findViewById(R.id.Score);
        TextView compscr = (TextView) findViewById(R.id.PCScore);
        scr.setText("Player:0");
        compscr.setText("Computer:0");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.andrew.andyminiblue/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.andrew.andyminiblue/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        TextView scr=(TextView) findViewById(R.id.Score);
        final TextView compscr=(TextView) findViewById(R.id.PCScore);
        TextView WinCount=(TextView) findViewById(R.id.WinCount);
        TextView LossCount=(TextView) findViewById(R.id.LossCount);




        switch (v.getId()) {
            case R.id.button:
                String str1 = "You Win";

                while(compscore<16) {

                    card card2 = deck1.getCard();
                    if (card2.getValue() == 1 && compscore < 11) {
                        compscore += 11;
                        compace++;
                    } else if(compscore>10)
                    {
                        compscore+=10;
                    }
                    else{
                        compscore += card2.getValue();
                    }
                    if (compscore > 21 & compace > 0) {
                        compscore -= 10;
                        compace--;
                    }
                    pcScore="Computer: "+compscore;
                    compscr.setText(pcScore);

                }
                if((score>compscore && score<22) || (score<22 && compscore>21))
                {
                    Toast.makeText(v.getContext(), str1, Toast.LENGTH_SHORT).show();
                    wincount++;
                    WinCount.setText("No. of Wins: "+wincount);
                }
                else {
                    Toast.makeText(v.getContext(), "You Lose", Toast.LENGTH_SHORT).show();
                    losscount++;
                    LossCount.setText("No. of Loss': "+losscount);
                }
                break;

            case R.id.addCard:
                card card1=deck1.getCard();
                Toast.makeText(v.getContext(), "Your new card is "+card1.getRank()+" of "+card1.getSuit(), Toast.LENGTH_SHORT).show();
                if (card1.getValue()==1 && score<11)
                {
                    score+=11;
                    ace++;
                }
                else if(card1.getValue()>10)
                {
                    score+=10;
                }
                else
                {
                    score+=card1.getValue();
                }
                if(score>21 & ace>0)
                {
                    score-=10;
                    ace--;
                }

                userScore = "Player: "+score;
                scr.setText(userScore);
                if(score>21) {
                    Toast.makeText(v.getContext(), "BUST", Toast.LENGTH_LONG).show();
                    addCard.setEnabled(false);
                }
                break;
            case R.id.reset:
                reset();
                break;
            default:
                break;
        }
    }

    public void reset()
    {
        TextView scr=(TextView) findViewById(R.id.Score);
        TextView compscr=(TextView) findViewById(R.id.PCScore);
        score=0;
        compscore=0;
        scr.setText("Player: 0");
        compscr.setText("Computer: 0");
        deck1 = new deck();
        addCard.setEnabled(true);
    }


}
