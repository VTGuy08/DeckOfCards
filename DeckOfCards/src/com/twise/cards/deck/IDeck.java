package com.twise.cards.deck;

public interface IDeck {

    /**
     * Randomly shuffles the cards in the deck.
     */
    void shuffle();

    /**
     * Returns a card to the caller as long as one exists.
     * @return A card if there is one, null if not.
     */
    Card dealOneCard();
}
