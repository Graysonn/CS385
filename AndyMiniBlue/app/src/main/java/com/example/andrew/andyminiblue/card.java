package com.example.andrew.andyminiblue;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/**
 * Created by Andrew Garrad on 13-Dec-15.
 */
public class card extends Drawable {

    private int rank;
    private int suit;
    private int face;

    //constructor, takes in a int and sets the rank and suit accordingly
    public card(int val)
    {
        rank=1+val%13;
        suit=val/13;
    }

    //method to return the suit of the cards, only used in original testing
    public String getSuit()
    {
        if(suit==3)
            return "diamonds";
        else if(suit ==2)
            return "hearts";
        else if(suit ==1)
            return "spades";
        else
            return "clubs";
    }

    //method to return the String rank of the card, only used in original testing
    public String getRank()
    {
        String Rank=""+rank;
        if(rank==1)
            return"Ace";
        else if(rank<11)
            return Rank;
        else if(rank==11)
            return "Jack";
        else if(rank==12)
            return "Queen";
        else if(rank==13)
            return "King";
        else
            return ("error "+Rank);

    }

    //method that returns the value of the card, for face cards (Jack, Queen, King) returns 10, otherwise it returns the rank
    public int getValue()
    {

        if(rank>10)
            return 10;
        else
            return rank;
    }

    //method to return the Id of the face of the card uses a nested switch statement (first switch is the suit, inner switch is the value
    //for each result return the drawable of the relevant card
    public int getFace(){
        switch (suit) {
            //suit=0, Clubs
            case 0:
                switch (rank) {
                    case 1:
                        face = R.drawable.clubs1;
                        break;
                    case 2:
                        face = R.drawable.clubs2;
                        break;
                    case 3:
                        face = R.drawable.clubs3;
                        break;
                    case 4:
                        face = R.drawable.clubs4;
                        break;
                    case 5:
                        face = R.drawable.clubs5;
                        break;
                    case 6:
                        face = R.drawable.clubs6;
                        break;
                    case 7:
                        face = R.drawable.clubs7;
                        break;
                    case 8:
                        face = R.drawable.clubs8;
                        break;
                    case 9:
                        face = R.drawable.clubs9;
                        break;
                    case 10:
                        face = R.drawable.clubs10;
                        break;
                    case 11:
                        face = R.drawable.clubs11;
                        break;
                    case 12:
                        face = R.drawable.clubs12;
                        break;
                    case 13:
                        face = R.drawable.clubs13;
                        break;
                    default:
                        face = R.drawable.redcardback;
                        break;
                }
                break;

            //suit=1, Spades
            case 1:
                switch (rank) {
                    case 1:
                        face = R.drawable.spades1;
                        break;
                    case 2:
                        face = R.drawable.spades2;
                        break;
                    case 3:
                        face = R.drawable.spades3;
                        break;
                    case 4:
                        face = R.drawable.spades4;
                        break;
                    case 5:
                        face = R.drawable.spades5;
                        break;
                    case 6:
                        face = R.drawable.spades6;
                        break;
                    case 7:
                        face = R.drawable.spades7;
                        break;
                    case 8:
                        face = R.drawable.spades8;
                        break;
                    case 9:
                        face = R.drawable.spades9;
                        break;
                    case 10:
                        face = R.drawable.spades10;
                        break;
                    case 11:
                        face = R.drawable.spades11;
                        break;
                    case 12:
                        face = R.drawable.spades12;
                        break;
                    case 13:
                        face = R.drawable.spades13;
                        break;
                    default:
                        face = R.drawable.redcardback;
                        break;
                }
                break;

            //suit=2, Hearts
            case 2:
                switch (rank) {
                    case 1:
                        face = R.drawable.hearts1;
                        break;
                    case 2:
                        face = R.drawable.hearts2;
                        break;
                    case 3:
                        face = R.drawable.hearts3;
                        break;
                    case 4:
                        face = R.drawable.hearts4;
                        break;
                    case 5:
                        face = R.drawable.hearts5;
                        break;
                    case 6:
                        face = R.drawable.hearts6;
                        break;
                    case 7:
                        face = R.drawable.hearts7;
                        break;
                    case 8:
                        face = R.drawable.hearts8;
                        break;
                    case 9:
                        face = R.drawable.hearts9;
                        break;
                    case 10:
                        face = R.drawable.hearts10;
                        break;
                    case 11:
                        face = R.drawable.hearts11;
                        break;
                    case 12:
                        face = R.drawable.hearts12;
                        break;
                    case 13:
                        face = R.drawable.hearts13;
                        break;
                    default:
                        face = R.drawable.redcardback;
                        break;
                }
                break;

            //suit=3, Diamonds
            case 3:
                switch (rank) {
                    case 1:
                        face = R.drawable.diamonds1;
                        break;
                    case 2:
                        face = R.drawable.diamonds2;
                        break;
                    case 3:
                        face = R.drawable.diamonds3;
                        break;
                    case 4:
                        face = R.drawable.diamonds4;
                        break;
                    case 5:
                        face = R.drawable.diamonds5;
                        break;
                    case 6:
                        face = R.drawable.diamonds6;
                        break;
                    case 7:
                        face = R.drawable.diamonds7;
                        break;
                    case 8:
                        face = R.drawable.diamonds8;
                        break;
                    case 9:
                        face = R.drawable.diamonds9;
                        break;
                    case 10:
                        face = R.drawable.diamonds10;
                        break;
                    case 11:
                        face = R.drawable.diamonds11;
                        break;
                    case 12:
                        face = R.drawable.diamonds12;
                        break;
                    case 13:
                        face = R.drawable.diamonds13;
                        break;
                    default:
                        face = R.drawable.redcardback;
                        break;
                }
                break;

        }
        return face;

    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
