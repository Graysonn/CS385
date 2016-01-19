package com.example.andrew.andyminiblue;

/**
 * Created by Andrew on 31-Dec-15.
 */
public class deck {
    card cards[] = new card[52];
    public deck()
    {

        for (int i = 0; i < 52; i++) {
            cards[i] = new card(i);
        }
    }

    public card getCard()
    {
        boolean played=false;
        card ans;
        ans = null;
        while(played==false) {
            int val = ((int) (52 * Math.random()));

            if (cards[val] == null) {
                played = false;
            } else {
                ans = cards[val];
                cards[val] = null;
                played = true;
            }


        }
        return ans;
    }

    public double probability(int score)
    {
        double yes=0;
        double no=0;
        for(int i=0;i<52;i++)
        {
            if(cards[i]==null)
            {}
            else if(score+cards[i].getValue()>21)
            {
                no++;
            }
            else
                yes++;
        }
        return 100.00*(yes/no);
    }
}



