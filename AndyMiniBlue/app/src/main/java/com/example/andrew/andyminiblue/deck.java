package com.example.andrew.andyminiblue;


public class deck {
    //create an array of 52 cards
    card cards[] = new card[52];

    //constructor class that sets each of the cards to equal a new card sequentially
    public deck()
    {

        for (int i = 0; i < 52; i++) {
            cards[i] = new card(i);
        }
    }

    //method to get a card from the deck, takes a random card and ensures that it hasn't been played before
    public card getCard()
    {
        boolean played=false;
        card ans;
        ans = null;
        //run until a new card is found
        while(played==false) {
            int val = ((int) (52 * Math.random()));

            //test if card has already been used
            if (cards[val] == null) {
                played = false;
            } else {
                //if it hasn't been played, set answer to that card, and remove it from the deck (card array)
                ans = cards[val];
                cards[val] = null;
                //set played equal to true, a card has been found
                played = true;
            }
        }
        //return the card that was found
        return ans;
    }

    //method to determine probabilty as a percentage of card making player go bust
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



