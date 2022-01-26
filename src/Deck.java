import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    private Card[] deck;
    private int cardUsed = 50;


    public Deck() {
        int cardCounter = 0;
        deck = new Card[52];
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 2; value <= 14; value++) {
                deck[cardCounter++] = new Card(value, suit);
            }
        }

    }

    public void shuffle() {
        for (int i = deck.length - 1; i > 0; i--) {
            int random = (int) (Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }

    }

    public int cardLeft() {
        return deck.length;
    }

    public Card dealCard() {

        if (cardLeft() == 0)
            throw new IllegalArgumentException("There no more card in the deck");
        removeLastCard();
        return deck[cardUsed--];
    }

    public void removeLastCard() {
        Card[] deckWithoutLastCard = new Card[deck.length - 1];
        if (cardLeft() == 0)
            throw new IllegalArgumentException("There no more card in the deck");
        for (int i = 0; i < deck.length; i++) {
            if (deckWithoutLastCard.length == i)
                continue;
            deckWithoutLastCard[i] = deck[i];
        }
        deck = new Card[deckWithoutLastCard.length];
        for (int i = 0; i < deckWithoutLastCard.length; i++) {
            deck[i] = deckWithoutLastCard[i];
        }

    }
}
