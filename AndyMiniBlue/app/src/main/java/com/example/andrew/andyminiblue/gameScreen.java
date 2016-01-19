package com.example.andrew.andyminiblue;

import android.media.MediaPlayer;
import android.os.Bundle;
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
    ImageView cardface;
    Animation ani1;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        Button reset;
        addCard=(Button) findViewById(R.id.addCard);
        addCard.setOnClickListener(this);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        reset=(Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.winnerwinnercut);
        cf = MediaPlayer.create(getApplicationContext(), R.raw.cardflip);

        TextView scr = (TextView) findViewById(R.id.Score);

        cardface=(ImageView) findViewById(R.id.card);

        TextView compscr = (TextView) findViewById(R.id.PCScore);
        scr.setText("Player:0");
        compscr.setText("Computer:0");

        ani1 = AnimationUtils.loadAnimation(this, R.anim.to_middle);
        ani1.setAnimationListener(this);
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
        cardface= (ImageView) findViewById(R.id.card);

        switch (v.getId()) {
            case R.id.button:
                String str1 = "You Win";
                final TextView cent= (TextView) findViewById(R.id.textView2);
                double prob=deck1.probability(score);


                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally{
                            card1 =deck1.getCard();
                            cf.start();
                            findViewById(R.id.comCard1);
                            findViewById(R.id.comCard1).setVisibility(View.VISIBLE);
                            findViewById(R.id.comCard1).clearAnimation();
                            findViewById(R.id.comCard1).setAnimation(PCani1);
                            findViewById(R.id.comCard1).startAnimation(PCani1);
                            compcardcount++;
                            cent.setText("current card's score is " + card1.getValue());

                            if (card1.getValue() == 1 && compscore < 11) {
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
                            pcScore="Computer: "+compscore;
                            compscr.setText(pcScore);
                        }
                    }
                };
                timer.start();

                Thread timer2 = new Thread() {
                    public void run() {
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally{
                            card1 =deck1.getCard();
                            cf.start();
                            findViewById(R.id.compCard2);
                            findViewById(R.id.compCard2).setVisibility(View.VISIBLE);
                            findViewById(R.id.compCard2).clearAnimation();
                            findViewById(R.id.compCard2).setAnimation(PCani2);
                            findViewById(R.id.compCard2).startAnimation(PCani2);
                            compcardcount++;
                            cent.setText("current card's score is " + card1.getValue());

                            if (card1.getValue() == 1 && compscore < 11) {
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
                            pcScore="Computer: "+compscore;
                            compscr.setText(pcScore);
                        }
                    }
                };
                timer2.start();

                if(compscore<16) {


                    Thread timer3 = new Thread() {
                        public void run() {
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                card1 = deck1.getCard();
                                cf.start();
                                findViewById(R.id.compCard3);
                                findViewById(R.id.compCard3).setVisibility(View.VISIBLE);
                                findViewById(R.id.compCard3).clearAnimation();
                                findViewById(R.id.compCard3).setAnimation(PCani3);
                                findViewById(R.id.compCard3).startAnimation(PCani3);
                                compcardcount++;
                                cent.setText("current card's score is " + card1.getValue());

                                if (card1.getValue() == 1 && compscore < 11) {
                                    compace++;
                                    compscore += 11;
                                } else if (card1.getValue() > 10) {
                                    compscore += 10;
                                } else {
                                    compscore += card1.getValue();
                                }

                                if (compscore > 21 & compace > 0) {
                                    compscore -= 10;
                                    compace--;
                                }
                                pcScore = "Computer: " + compscore;
                                compscr.setText(pcScore);
                            }
                        }
                    };
                    timer3.start();
                }

                if(compscore<16) {
                    Thread timer4 = new Thread() {
                        public void run() {
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                card1 = deck1.getCard();
                                cf.start();
                                findViewById(R.id.compCard4);
                                findViewById(R.id.compCard4).setVisibility(View.VISIBLE);
                                findViewById(R.id.compCard4).clearAnimation();
                                findViewById(R.id.compCard4).setAnimation(PCani4);
                                findViewById(R.id.compCard4).startAnimation(PCani4);
                                compcardcount++;
                                cent.setText("current card's score is " + card1.getValue());

                                if (card1.getValue() == 1 && compscore < 11) {
                                    compace++;
                                    compscore += 11;
                                } else if (card1.getValue() > 10) {
                                    compscore += 10;
                                } else {
                                    compscore += card1.getValue();
                                }

                                if (compscore > 21 & compace > 0) {
                                    compscore -= 10;
                                    compace--;
                                }
                                pcScore = "Computer: " + compscore;
                                compscr.setText(pcScore);
                            }
                        }
                    };
                    timer4.start();
                }

                if(compscore<16) {
                    Thread timer5 = new Thread() {
                        public void run() {
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                card1 = deck1.getCard();
                                cf.start();
                                findViewById(R.id.compCard5);
                                findViewById(R.id.compCard5).setVisibility(View.VISIBLE);
                                findViewById(R.id.compCard5).clearAnimation();
                                findViewById(R.id.compCard5).setAnimation(PCani5);
                                findViewById(R.id.compCard5).startAnimation(PCani5);
                                compcardcount++;
                                cent.setText("current card's score is " + card1.getValue());

                                if (card1.getValue() == 1 && compscore < 11) {
                                    compace++;
                                    compscore += 11;
                                } else if (card1.getValue() > 10) {
                                    compscore += 10;
                                } else {
                                    compscore += card1.getValue();
                                }

                                if (compscore > 21 & compace > 0) {
                                    compscore -= 10;
                                    compace--;
                                }
                                pcScore = "Computer: " + compscore;
                                compscr.setText(pcScore);
                            }
                        }
                    };
                    timer5.start();
                }



                if((score>compscore && score<22) || (score<22 && compscore>21))
                {
                    mp.start();
                    Toast.makeText(v.getContext(), str1, Toast.LENGTH_SHORT).show();
                    wincount++;
                    WinCount.setText("No. of Wins: "+wincount);
                }
                else {
                    Toast.makeText(v.getContext(), "You Lose", Toast.LENGTH_SHORT).show();
                    losscount++;
                    LossCount.setText("No. of Losses: "+losscount);
                }

                cent.setText( String.format("Probabilty of next card not going bust:  %.2f", prob));
                break;

            case R.id.addCard:
                card1=deck1.getCard();
                cf.start();

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
