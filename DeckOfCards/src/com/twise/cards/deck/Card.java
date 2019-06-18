package com.twise.cards.deck;

public abstract class Card {

    protected Suit suit; // The suit of the card: CLUB, DIAMOND, HEART, SPADE
    protected String name = this.getClass().getSimpleName();

    protected Card(Suit suit) {
        this.suit = suit;
    }

    public String toString()
    {
        return name + " of " + suit;
    }
}
