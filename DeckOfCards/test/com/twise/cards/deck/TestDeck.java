package com.twise.cards.deck;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeck {

    private Deck deck = null;

    @Before
    public void setup(){
        deck = new Deck();
    }

    @After
    public void teardown(){
        deck = null;
    }

    @Test
    public void testDeckHas52Cards(){
        assertEquals(52, deck.getNumberOfRemainingCards());
    }

    @Test
    public void testDealOneCard(){
        // Should start with 52 cards
        assertEquals(52, deck.getNumberOfRemainingCards());

        Card card = deck.dealOneCard();

        // Card should not be null
        assertNotNull(card);

        // Remaining cards should be 51
        assertEquals(51, deck.getNumberOfRemainingCards());
    }

    @Test
    public void testDealAllCards(){

        // Deal all cards
        for(int i = 0; i < 52; i++){
            deck.dealOneCard();
        }

        // Should have 0 cards remaining in deck
        assertEquals(0, deck.getNumberOfRemainingCards());

        // Calling deal again should result in 'null'
        Card card = deck.dealOneCard();

        assertNull(card);
    }

    @Test
    public void testDeckGeneratedSame(){
        // Deck is always generated the same way in the same order
        Deck deck2 = new Deck();

        for(int i = 0; i < 52; i++){
            Card card1 = deck.dealOneCard();
            Card card2 = deck2.dealOneCard();
            assertEquals(card1.toString(), card2.toString());
        }
    }

    @Test
    public void testShuffle(){
        // Assumption: Deck is always generated the same way in the same order
        // So the cards should be in the same order.

        Deck deck2 = new Deck();

        // Calling shuffle should cause there to be at least one difference
        deck2.shuffle();

        // Verify that shuffling hasn't mutated the number of cards in either deck
        assertEquals(52, deck2.getNumberOfRemainingCards());
        assertEquals(52, deck.getNumberOfRemainingCards());

        for(int i = 0; i < 52; i++){
            Card card1 = deck.dealOneCard();
            Card card2 = deck2.dealOneCard();

            assertFalse(card1.toString().equalsIgnoreCase(card2.toString()));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumberHigh(){
        // Only valid NumberCard values are 2-10
        NumberCard card = new NumberCard(Suit.CLUBS, 11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidNumberLow(){
        // Only valid NumberCard values are 2-10
        NumberCard card = new NumberCard(Suit.CLUBS, 1);
    }

}
