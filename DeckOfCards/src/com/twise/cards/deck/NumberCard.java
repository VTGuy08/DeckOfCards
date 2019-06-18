package com.twise.cards.deck;

public class NumberCard extends Card {

    private int value;

    public NumberCard(Suit suit, int value) {
        super(suit);

        if(value > 10 || value < 2){
            throw new IllegalArgumentException("Value must be in the range of 2-10.");
        }

        this.value = value;
    }

    @Override
    public String toString()
    {
        return value +  " of " + suit;
    }
}
