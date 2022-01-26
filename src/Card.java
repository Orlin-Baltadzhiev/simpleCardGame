public class Card {
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    public final static int ACE = 14;
    public final static int KING = 13;
    public final static int JACK = 12;
    public final static int QUEEN = 11;

    private final int suit;
    private final int value;


    public Card(int value, int suit) {
        this.suit = suit;
        this.value = value;
    }


    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getValueAsAString(){
        return switch (this.value) {
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "JACK";
            case 12 -> "QUEEN";
            case 13 -> "KING";
            default -> "ACE";
        };
    }

    public String getSuitAsAString(){
        return switch (this.suit) {
            case SPADES -> "Spades";
            case HEARTS -> "Hearts";
            case DIAMONDS -> "Diamonds";
            default -> "CLUBS";
        };
    }


    public String toString() {
        return getValueAsAString() + " of " + getSuitAsAString();
    }
}
