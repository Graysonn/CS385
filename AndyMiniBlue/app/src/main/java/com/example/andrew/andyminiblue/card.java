package com.example.andrew.andyminiblue;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/**
 * Created by Andrew on 13-Dec-15.
 */
public class card extends Drawable {

    private int rank;
    private int suit;
    private int face;

    public card(int val)
    {
        rank=1+val%13;
        suit=val/13;
    }

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

    public int getValue()
    {

        if(rank>10)
            return 10;
        else
            return rank;
    }


    public int getFace(){
        return R.drawable.spades1;
        /*switch (rank)
        {
            case 1:
                face=R.drawable.hearts1;
                break;
            case 2:
                face=R.drawable.hearts2;
                break;
            case 3:
                face=R.drawable.hearts3;
                break;
            case 4:
                face=R.drawable.hearts4;
                break;
            case 5:
                face=R.drawable.hearts5;
                break;
            case 6:
                face=R.drawable.hearts6;
                break;
            case 7:
                face=R.drawable.hearts7;
                break;
            case 8:
                face=R.drawable.hearts8;
                break;
            case 9:
                face=R.drawable.hearts9;
                break;
            case 10:
                face=R.drawable.hearts10;
                break;
            case 11:
                face=R.drawable.hearts11;
                break;
            case 12:
                face=R.drawable.hearts12;
                break;
            case 13:
                face=R.drawable.hearts13;
                break;
            default:
                face=R.drawable.redcardback;
                break;
        }
        return face;
        */
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
