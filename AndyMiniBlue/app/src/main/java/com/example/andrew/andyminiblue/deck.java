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
}



