import com.twise.cards.deck.Card;
import com.twise.cards.deck.Deck;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        Deck deck = new Deck();
        System.out.println(deck);

        deck.shuffle();

        System.out.println(deck);

        deck.shuffle();

        System.out.println(deck);

        Card c = deck.dealOneCard();

        System.out.println(c);

        System.out.println(deck);

        for (int i = 0; i < 52; i++){
            Card card = deck.dealOneCard();

            if (card == null){
                System.out.println("DECK EMPTY");
            }
            System.out.println(deck);
        }

        deck.shuffle();

        System.out.println(deck);

        Deck deck2 = new Deck();

        deck2.shuffle();

        for(int i = 0; i < 46; i++){
            deck2.dealOneCard();
        }

        System.out.println();
        System.out.println(deck2);
        deck2.shuffle();
        System.out.println(deck2);
    }
}
