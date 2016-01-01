package com.example.andrew.andyminiblue;

/**
 * Created by Andrew on 13-Dec-15.
 */
public class card {

    private int rank;
    private int suit;

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
        return rank;
    }


}
