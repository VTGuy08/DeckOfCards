package com.twise.cards.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck implements IDeck {

    private List<Card> cardList = new ArrayList<>();

    public Deck(){
        buildDeck();
    }

    /**
     * Randomly shuffles the remaining cards in the deck.
     */
    @Override
    public void shuffle() {
        Random generator = new Random();

        List<Card> shuffledCards = new ArrayList<>();

        int numCards = cardList.size();

        for(int i = 0; i < numCards; i++){
            int index = generator.nextInt(cardList.size());
            shuffledCards.add(cardList.remove(index));
        }

        cardList = shuffledCards;
    }

    /**
     * Returns a card to the caller as long as one exists.
     * @return A card if there is one, null if not.
     */
    @Override
    public Card dealOneCard() {
        if (cardList.isEmpty()){
            return null;
        }

        return cardList.remove(0);
    }

    /**
     * Return the number of cards remaining in the deck
     * @return An integer representing the number of cards remaining in the deck.
     */
    public int getNumberOfRemainingCards(){
        return cardList.size();
    }

    /**
     * Returns a boolean stating if the deck is empty.
     * @return True if empty, False if there are cards remaining.
     */
    public boolean isEmpty(){
        return cardList.isEmpty();
    }

    public String toString()
    {
        return "Deck: " + cardList.stream().map(c -> c.toString()).collect(Collectors.toList());
    }

    /**
     * Build a deck containing 52 cards.
     */
    private void buildDeck(){
        if(cardList.isEmpty()) {
            cardList.addAll(createSuit(Suit.CLUBS));
            cardList.addAll(createSuit(Suit.SPADES));
            cardList.addAll(createSuit(Suit.DIAMONDS));
            cardList.addAll(createSuit(Suit.HEARTS));
        }
    }

    /**
     * Construct a full suit of cards: Ace, Number Cards 2-10, Jack, Queen, King
     * @param suit The suit: Club, Spade, Diamond, Heart
     * @return The cards in the suit.
     */
    private List<Card> createSuit(Suit suit){
        List<Card> cards = new ArrayList<>();

        cards.add(new Ace(suit));

        for (int i = 2; i < 11; i++){
            cards.add(new NumberCard(suit, i));
        }

        cards.add(new Jack(suit));
        cards.add(new Queen(suit));
        cards.add(new King(suit));

        return cards;
    }

}
