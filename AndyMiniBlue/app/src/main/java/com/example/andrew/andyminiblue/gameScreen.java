package com.example.andrew.andyminiblue;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class gameScreen extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    int score=0;
    String userScore;
    int compscore=0;
    int wincount=0;
    int losscount=0;
    String pcScore;
    int cardcount=0;
    int compcardcount=0;
    int ace=0;
    int compace=0;
    deck deck1 = new deck();
    public Button addCard;
    public Button Stick;
    ImageView cardface;
    Animation ani1;
    Animation ani2;
    Animation ani3;
    Animation ani4;
    Animation ani5;
    Animation ani6;
    Animation PCani1;
    Animation PCani2;
    Animation PCani3;
    Animation PCani4;
    Animation PCani5;
    private card card1;
    MediaPlayer mp;
    MediaPlayer cf;
    GameDb mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //open the database
        mydb=new GameDb(this);
        mydb.open();
        mydb.createGame(0,0);

        //initialise the buttons and the mediaplayer for sounds
        Button reset;
        addCard=(Button) findViewById(R.id.addCard);
        addCard.setOnClickListener(this);
        Stick=(Button) findViewById(R.id.button);
        Stick.setOnClickListener(this);
        reset=(Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.winnerwinnercut);
        cf = MediaPlayer.create(getApplicationContext(), R.raw.cardflip);

        TextView scr = (TextView) findViewById(R.id.Score);

        cardface=(ImageView) findViewById(R.id.card);

        TextView compscr = (TextView) findViewById(R.id.PCScore);
        scr.setText("Player:0");
        compscr.setText("Computer:0");

        //initialise the animations, need one for each different imageView (10)
        ani1 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani1.setAnimationListener(this);
        ani2 = AnimationUtils.loadAnimation(this, R.anim.from_middle);
        ani2.setAnimationListener(this);
        ani3 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani3.setAnimationListener(this);
        ani4 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani4.setAnimationListener(this);
        ani5 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani5.setAnimationListener(this);
        ani6 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani6.setAnimationListener(this);
        PCani1 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        PCani1.setAnimationListener(this);
        PCani2 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        PCani2.setAnimationListener(this);
        PCani3 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        PCani3.setAnimationListener(this);
        PCani4 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        PCani4.setAnimationListener(this);
        PCani5 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        PCani5.setAnimationListener(this);
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
    public void onClick(final View v) {

        //declare and initialise the TextViews
        TextView scr=(TextView) findViewById(R.id.Score);
        final TextView compscr=(TextView) findViewById(R.id.PCScore);
        cardface= (ImageView) findViewById(R.id.card);
        TextView cent= (TextView) findViewById(R.id.textView2);

        //switch statement to determine which button was pressed
        switch (v.getId()) {
            case R.id.button:

                double prob;
                Handler mytimer=new Handler();

                //draw a new card
                card1 = deck1.getCard();

                //play the card flip sound
                cf.start();

                //check which card to animate,
                switch (compcardcount){
                    case 0:
                        findViewById(R.id.comCard1);
                        findViewById(R.id.comCard1).setVisibility(View.VISIBLE);
                        findViewById(R.id.comCard1).clearAnimation();
                        findViewById(R.id.comCard1).setAnimation(PCani1);
                        findViewById(R.id.comCard1).startAnimation(PCani1);
                        compcardcount++;
                        break;
                    case 1:
                        findViewById(R.id.compCard2);
                        findViewById(R.id.compCard2).setVisibility(View.VISIBLE);
                        findViewById(R.id.compCard2).clearAnimation();
                        findViewById(R.id.compCard2).setAnimation(PCani2);
                        findViewById(R.id.compCard2).startAnimation(PCani2);
                        compcardcount++;
                        break;
                    case 2:
                        findViewById(R.id.compCard3);
                        findViewById(R.id.compCard3).setVisibility(View.VISIBLE);
                        findViewById(R.id.compCard3).clearAnimation();
                        findViewById(R.id.compCard3).setAnimation(PCani3);
                        findViewById(R.id.compCard3).startAnimation(PCani3);
                        compcardcount++;
                        break;
                    case 3:
                        findViewById(R.id.compCard4);
                        findViewById(R.id.compCard4).setVisibility(View.VISIBLE);
                        findViewById(R.id.compCard4).clearAnimation();
                        findViewById(R.id.compCard4).setAnimation(PCani4);
                        findViewById(R.id.compCard4).startAnimation(PCani4);
                        compcardcount++;
                        break;
                    case 4:
                        findViewById(R.id.compCard5);
                        findViewById(R.id.compCard5).setVisibility(View.VISIBLE);
                        findViewById(R.id.compCard5).clearAnimation();
                        findViewById(R.id.compCard5).setAnimation(PCani5);
                        findViewById(R.id.compCard5).startAnimation(PCani5);
                        //reset compcardcount to allow it to reuse the first card if a 6th card is drawn
                        compcardcount=0;
                        break;
                }


                //increase the cards score by the correct amount
                if (card1.getValue() == 1 && compscore < 11) {
                    //Ace rules, 11 if it doesn't make you bust, need counter to allow for next card making bust
                    compace++;
                    compscore+=  11;
                } else if(card1.getValue()>10)
                {
                    compscore+= 10;
                }
                else{
                    compscore+= card1.getValue();
                }

                if (compscore > 21 & compace > 0) {
                    compscore -= 10;
                    compace--;
                }
                //update textview with new PC score
                pcScore="Computer: "+compscore;
                compscr.setText(pcScore);

                //if Computer's Score is less than 16 run another stick method after 1 second
                if(compscore<16){
                    mytimer.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Stick.performClick();
                        }
                    }, 1000);
                }
                else {
                    //run the end game method
                    endgame(v);
                }
                break;

            //if it is the 'hit me' button
            case R.id.addCard:
                //calculate probability
                prob = deck1.probability(score);

                //draw a new card and play the audio file
                card1=deck1.getCard();
                cf.start();

                //disable button to ensure two clicks don't happen too fast.
                addCard.setEnabled(false);

                //enable the button after .5 second
                addCard.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addCard.setEnabled(true);
                    }
                }, 500);

                //Run the relevant animation for the cardflip
                if(cardcount==0) {
                    findViewById(R.id.card);
                    findViewById(R.id.card).setVisibility(View.VISIBLE);
                    findViewById(R.id.card).clearAnimation();
                    findViewById(R.id.card).setAnimation(ani1);
                    findViewById(R.id.card).startAnimation(ani1);
                    cardcount++;
                } else if(cardcount==1) {
                    findViewById(R.id.card2);
                    findViewById(R.id.card2).setVisibility(View.VISIBLE);
                    findViewById(R.id.card2).clearAnimation();
                    findViewById(R.id.card2).setAnimation(ani3);
                    findViewById(R.id.card2).startAnimation(ani3);
                    cardcount++;
                } else if(cardcount==2) {
                    findViewById(R.id.card3);
                    findViewById(R.id.card3).setVisibility(View.VISIBLE);
                    findViewById(R.id.card3).clearAnimation();
                    findViewById(R.id.card3).setAnimation(ani4);
                    findViewById(R.id.card3).startAnimation(ani4);
                    cardcount++;
                } else if(cardcount==3) {
                    findViewById(R.id.card4);
                    findViewById(R.id.card4).setVisibility(View.VISIBLE);
                    findViewById(R.id.card4).clearAnimation();
                    findViewById(R.id.card4).setAnimation(ani5);
                    findViewById(R.id.card4).startAnimation(ani5);
                    cardcount++;
                }else if(cardcount==4) {
                    findViewById(R.id.card5);
                    findViewById(R.id.card5).setVisibility(View.VISIBLE);
                    findViewById(R.id.card5).clearAnimation();
                    findViewById(R.id.card5).setAnimation(ani6);
                    findViewById(R.id.card5).startAnimation(ani6);
                    //reset to 0 to allow for 6th card to be flipped on 1st card
                    cardcount=0;
                }

                //update the score
                if (card1.getValue()==1 && score<11)
                {
                    //special Ace rules
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
                    //allow for previous ace being played
                    score-=10;
                    ace--;
                }

                //update the score textview with the new score
                userScore = "Player: "+score;
                scr.setText(userScore);

                //test if user has gone bust
                if(score>21) {
                    Toast.makeText(v.getContext(), "BUST", Toast.LENGTH_LONG).show();
                    cent.setText(String.format("Probability of your last card not going bust:  %.2f", prob));
                    //disable button and after 1 second play as if user had hit the 'stick' button
                    addCard.setEnabled(false);
                    Handler mybusttimer= new Handler();
                    mybusttimer.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Stick.performClick();
                        }
                    }, 1000);
                }


                break;
            //if player hits the 'play again' button run the reset method
            case R.id.reset:
                reset();
                break;
            default:
                break;
        }
    }

    //endgame methd, final stage in game after stick leaves it's loop (computer score>16, && user chosen to finish or gone bust)
    public void endgame(View v)
    {

        //calculate the probabilty of next card making user bust
        double prob=deck1.probability(score);

        //declare and initialise the Textviews
        TextView cent= (TextView) findViewById(R.id.textView2);

        //define a win string
        String str1 = "You Win";

        //test who won,
        //user win
        if((score>compscore && score<22) || (score<22 && compscore>21))
        {
            //user win

            //play winning audio
            mp.start();

            //send win string to screen as a toast
            Toast.makeText(v.getContext(), str1, Toast.LENGTH_SHORT).show();

            //add the win to the database
            mydb.addWin();

        }
        //same score, test who has more cards
        else if(score==compscore)
        {
            if(cardcount<compcardcount)
            {
                //send the string saying you lose to the screen as a toast
                Toast.makeText(v.getContext(), "You Lose", Toast.LENGTH_SHORT).show();
                //add the loss to the database
                mydb.addLoss();
            }
            else if(cardcount>compcardcount)
            {
                //play the winning audio
                mp.start();

                //send the string to the screen as a toast
                Toast.makeText(v.getContext(), str1, Toast.LENGTH_SHORT).show();

                //add the win to the database
                mydb.addWin();

            }
            else
            {
                //tell the user that the game was a draw
                Toast.makeText(v.getContext(),"Draw Game",Toast.LENGTH_SHORT).show();
            }
        }
        //copmuter win
        else {
            //send toast to the screen saying you lose
            Toast.makeText(v.getContext(), "You Lose", Toast.LENGTH_SHORT).show();

            //add the loss to the database
            mydb.addLoss();
        }
        //set the textview to the probability of going bust
        cent.setText( String.format("Probabilty of next card not going bust:  %.2f", prob));
    }

    //reset method
    public void reset()
    {
        //declare and initialise textviews
        TextView scr=(TextView) findViewById(R.id.Score);
        TextView compscr=(TextView) findViewById(R.id.PCScore);

        //reset the scores and number of aces to 0
        score=0;
        compscore=0;
        ace=0;
        compace=0;

        //reset the textviews to say that each score is 0
        scr.setText("Player: 0");
        compscr.setText("Computer: 0");

        //set the deck to equal a new deck and enable the 'hit me' button
        deck1 = new deck();
        addCard.setEnabled(true);

        //reset the card count and reset all the card animations to show the back of the card, and to be invisible
        cardcount=0;
        compcardcount=0;
        ((ImageView)findViewById(R.id.card)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card2)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card3)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card4)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card5)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.comCard1)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.compCard2)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.compCard3)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.compCard4)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.compCard5)).setImageResource(R.drawable.redcardback);
        ((TextView) findViewById(R.id.textView2)).setText(" ");
        findViewById(R.id.card).setVisibility(View.INVISIBLE);
        findViewById(R.id.card2).setVisibility(View.INVISIBLE);
        findViewById(R.id.card3).setVisibility(View.INVISIBLE);
        findViewById(R.id.card4).setVisibility(View.INVISIBLE);
        findViewById(R.id.card5).setVisibility(View.INVISIBLE);
        findViewById(R.id.comCard1).setVisibility(View.INVISIBLE);
        findViewById(R.id.compCard2).setVisibility(View.INVISIBLE);
        findViewById(R.id.compCard3).setVisibility(View.INVISIBLE);
        findViewById(R.id.compCard4).setVisibility(View.INVISIBLE);
        findViewById(R.id.compCard5).setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //run the relevant animation, each animation runs for a different Image View, so 10 in total, 5 user cards, 5 computer cards
        if (animation==ani1) {
            ((ImageView)findViewById(R.id.card)).setImageResource(card1.getFace());
            findViewById(R.id.card).clearAnimation();
        }else if (animation==ani3){
            ((ImageView)findViewById(R.id.card2)).setImageResource(card1.getFace());
            findViewById(R.id.card2).clearAnimation();
        }else if (animation==ani4) {
            ((ImageView)findViewById(R.id.card3)).setImageResource(card1.getFace());
            findViewById(R.id.card3).clearAnimation();
        } else if (animation==ani5) {
            ((ImageView)findViewById(R.id.card4)).setImageResource(card1.getFace());
           findViewById(R.id.card4).clearAnimation();
        } else if (animation==ani6) {
            ((ImageView)findViewById(R.id.card5)).setImageResource(card1.getFace());
            findViewById(R.id.card5).clearAnimation();
        }else if (animation==PCani1) {
            ((ImageView)findViewById(R.id.comCard1)).setImageResource(card1.getFace());
            findViewById(R.id.comCard1).clearAnimation();
        }else if (animation==PCani2) {
            ((ImageView)findViewById(R.id.compCard2)).setImageResource(card1.getFace());
            findViewById(R.id.compCard2).clearAnimation();
        }else if (animation==PCani3) {
            ((ImageView)findViewById(R.id.compCard3)).setImageResource(card1.getFace());
            findViewById(R.id.compCard3).clearAnimation();
        }else if (animation==PCani4) {
            ((ImageView)findViewById(R.id.compCard4)).setImageResource(card1.getFace());
            findViewById(R.id.compCard4).clearAnimation();
        }else if (animation==PCani5) {
            ((ImageView)findViewById(R.id.compCard5)).setImageResource(card1.getFace());
            findViewById(R.id.compCard5).clearAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}
