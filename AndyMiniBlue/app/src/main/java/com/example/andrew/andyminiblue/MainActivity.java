package com.example.andrew.andyminiblue;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {



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

    boolean isBackOfCardShowing =true;

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

        cardface=(ImageView) findViewById(R.id.card);
//        card.setImageResource(R.drawable.redcardback);

        TextView compscr = (TextView) findViewById(R.id.PCScore);
        scr.setText("Player:0");
        compscr.setText("Computer:0");

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

        TextView scr=(TextView) findViewById(R.id.Score);
        final TextView compscr=(TextView) findViewById(R.id.PCScore);
        TextView WinCount=(TextView) findViewById(R.id.WinCount);
        TextView LossCount=(TextView) findViewById(R.id.LossCount);
        final TextView cent= (TextView) findViewById(R.id.textView2);
        cardface= (ImageView) findViewById(R.id.card);

        switch (v.getId()) {
            case R.id.button:
                String str1 = "You Win";

                while(compscore<16) {


                    compscore+=drawcard();

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
                card1=deck1.getCard();

                if(cardcount==0) {
                    ((ImageView) findViewById(R.id.card)).setVisibility(findViewById(R.id.card).VISIBLE);
                    ((ImageView) findViewById(R.id.card)).clearAnimation();
                    ((ImageView) findViewById(R.id.card)).setAnimation(ani1);
                    ((ImageView) findViewById(R.id.card)).startAnimation(ani1);
                    cardcount++;
                } else if(cardcount==1) {
                    ((ImageView) findViewById(R.id.card2)).setVisibility(findViewById(R.id.card2).VISIBLE);
                    ((ImageView) findViewById(R.id.card2)).clearAnimation();
                    ((ImageView) findViewById(R.id.card2)).setAnimation(ani3);
                    ((ImageView) findViewById(R.id.card2)).startAnimation(ani3);
                    cardcount++;
                } else if(cardcount==2) {
                    ((ImageView) findViewById(R.id.card3)).setVisibility(findViewById(R.id.card3).VISIBLE);
                    ((ImageView) findViewById(R.id.card3)).clearAnimation();
                    ((ImageView) findViewById(R.id.card3)).setAnimation(ani4);
                    ((ImageView) findViewById(R.id.card3)).startAnimation(ani4);
                    cardcount++;
                } else if(cardcount==3) {
                    ((ImageView) findViewById(R.id.card4)).setVisibility(findViewById(R.id.card4).VISIBLE);
                    ((ImageView) findViewById(R.id.card4)).clearAnimation();
                    ((ImageView) findViewById(R.id.card4)).setAnimation(ani5);
                    ((ImageView) findViewById(R.id.card4)).startAnimation(ani5);
                    cardcount++;
                }else if(cardcount==4) {
                    ((ImageView) findViewById(R.id.card5)).setVisibility(findViewById(R.id.card4).VISIBLE);
                    ((ImageView) findViewById(R.id.card5)).clearAnimation();
                    ((ImageView) findViewById(R.id.card5)).setAnimation(ani6);
                    ((ImageView) findViewById(R.id.card5)).startAnimation(ani6);
                    cardcount++;
                }


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
        cardcount=0;
        compcardcount=0;
        ((ImageView)findViewById(R.id.card)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card2)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card3)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card4)).setImageResource(R.drawable.redcardback);
        ((ImageView)findViewById(R.id.card5)).setImageResource(R.drawable.redcardback);
    }
    public int drawcard()
    {
        TextView cent= (TextView) findViewById(R.id.textView2);
        card1 = deck1.getCard();

        if(compcardcount==0) {
            ((ImageView) findViewById(R.id.comCard1)).setVisibility(findViewById(R.id.comCard1).VISIBLE);
            ((ImageView) findViewById(R.id.comCard1)).clearAnimation();
            ((ImageView) findViewById(R.id.comCard1)).setAnimation(PCani1);
            ((ImageView) findViewById(R.id.comCard1)).startAnimation(PCani1);
            compcardcount++;
        } else if(compcardcount==1) {
            findViewById(R.id.compCard2);
            ((ImageView) findViewById(R.id.compCard2)).setVisibility(View.VISIBLE);
            ((ImageView) findViewById(R.id.compCard2)).clearAnimation();
            ((ImageView) findViewById(R.id.compCard2)).setAnimation(PCani2);
            ((ImageView) findViewById(R.id.compCard2)).startAnimation(PCani2);
            compcardcount++;
        } else if(compcardcount==2) {
            ((ImageView) findViewById(R.id.compCard3)).setVisibility(findViewById(R.id.compCard3).VISIBLE);
            ((ImageView) findViewById(R.id.compCard3)).clearAnimation();
            ((ImageView) findViewById(R.id.compCard3)).setAnimation(PCani3);
            ((ImageView) findViewById(R.id.compCard3)).startAnimation(PCani3);
            compcardcount++;
        } else if(compcardcount==3) {
            ((ImageView) findViewById(R.id.compCard4)).setVisibility(findViewById(R.id.compCard4).VISIBLE);
            ((ImageView) findViewById(R.id.compCard4)).clearAnimation();
            ((ImageView) findViewById(R.id.compCard4)).setAnimation(PCani4);
            ((ImageView) findViewById(R.id.compCard4)).startAnimation(PCani4);
            compcardcount++;
        }else if(compcardcount==4) {
            ((ImageView) findViewById(R.id.compCard5)).setVisibility(findViewById(R.id.compCard5).VISIBLE);
            ((ImageView) findViewById(R.id.compCard5)).clearAnimation();
            ((ImageView) findViewById(R.id.compCard5)).setAnimation(PCani5);
            ((ImageView) findViewById(R.id.compCard5)).startAnimation(PCani5);
            compcardcount++;
        }


        //Toast.makeText(v.getContext(), "Computer's new card is "+card2.getRank()+" of "+card2.getSuit(), Toast.LENGTH_SHORT).show();
        cent.setText("current card's score is " + card1.getValue());

        if (card1.getValue() == 1 && compscore < 11) {

            compace++;
            return  11;
        } else if(card1.getValue()>10)
        {
            return 10;
        }
        else{
            return card1.getValue();
        }

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation==ani1) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.card)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.card)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.card)).clearAnimation();
            ((ImageView)findViewById(R.id.card)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.card)).startAnimation(ani2);
        } else if (animation==ani3) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.card2)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.card2)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.card2)).clearAnimation();
            ((ImageView)findViewById(R.id.card2)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.card2)).startAnimation(ani2);
        } else if (animation==ani4) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.card3)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.card3)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.card3)).clearAnimation();
            ((ImageView)findViewById(R.id.card3)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.card3)).startAnimation(ani2);
        } else if (animation==ani5) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.card4)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.card4)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.card4)).clearAnimation();
            ((ImageView)findViewById(R.id.card4)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.card4)).startAnimation(ani2);
        } else if (animation==ani6) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.card5)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.card5)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.card5)).clearAnimation();
            ((ImageView)findViewById(R.id.card5)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.card5)).startAnimation(ani2);
        }else if (animation==PCani1) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.comCard1)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.comCard1)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.comCard1)).clearAnimation();
            ((ImageView)findViewById(R.id.comCard1)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.comCard1)).startAnimation(ani2);
        }else if (animation==PCani2) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.compCard2)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.compCard2)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.compCard2)).clearAnimation();
            ((ImageView)findViewById(R.id.compCard2)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.compCard2)).startAnimation(ani2);
        }else if (animation==PCani3) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.compCard3)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.compCard3)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.compCard3)).clearAnimation();
            ((ImageView)findViewById(R.id.compCard3)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.compCard3)).startAnimation(ani2);
        }else if (animation==PCani4) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.compCard4)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.compCard4)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.compCard4)).clearAnimation();
            ((ImageView)findViewById(R.id.compCard4)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.compCard4)).startAnimation(ani2);
        }else if (animation==PCani5) {
            if (isBackOfCardShowing) {
                ((ImageView)findViewById(R.id.compCard5)).setImageResource(card1.getFace());
            } else {
                ((ImageView)findViewById(R.id.compCard5)).setImageResource(R.drawable.redcardback);
            }
            ((ImageView)findViewById(R.id.compCard5)).clearAnimation();
            ((ImageView)findViewById(R.id.compCard5)).setAnimation(ani2);
            ((ImageView)findViewById(R.id.compCard5)).startAnimation(ani2);
        }else {
            isBackOfCardShowing=true;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
