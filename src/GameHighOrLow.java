import java.util.Scanner;

public class GameHighOrLow {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("******************** Welcome in High Low Card Game ********************");
        System.out.println("Enter 'start' to starting the game.");
        String start = scanner.nextLine().toLowerCase();
        if (!start.equals("start")) {
            System.out.println("Buy see you soon");
            return;
        }
        System.out.println("The game is starting ....");
        System.out.println("With this program you can easy to play your favorite game");
        System.out.println("Your balance in the game depends on correct answers");
        System.out.println("You have to predict whether the next card will be lower or higher");
        System.out.print("Before we start enter your balance here:");

        int balance = scanner.nextInt();


        do {
            int money = play(balance);
        } while (true);


    }

    private static int play(int balance) {
        Deck deck = new Deck();
        Card currentCard;
        Card nextCard;
        String answer;
        deck.shuffle();

        currentCard = deck.dealCard();

        System.out.println("The first card is the " + currentCard);
        System.out.println("Make a bet");
        int currentBet = checkTheBalanceWithCurrentBet(balance);

        System.out.println("Your bet is " + currentBet);


        while (true) {
            System.out.println("What will be the next card 'L' or 'H' or shuffle, bet , start");
            do {
                answer = scanner.next();
                if (checkTheCommand(answer)) {
                    System.out.println("Please enter the valid command 'L' or 'H' or 'shuffle' or 'bet' or 'start'?");
                }
            } while (checkTheCommand(answer));

            if (answer.equals("shuffle")) {
                shuffleTheDeck(currentCard);
                continue;
            }

            nextCard = deck.dealCard();
            System.out.println("Next card is " + nextCard);

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The cards are the same");
                // we do nothing
            } else if (nextCard.getValue() > currentCard.getValue()) {
                if (answer.equals("H")) {
                    System.out.println("Correct answer");
                    balance += currentBet * 2;
                } else {
                    System.out.println("Your answer is not  correct");
                    balance -= currentBet;
                }
            } else if (nextCard.getValue() < currentCard.getValue()) {
                if (answer.equals("L")) {
                    System.out.println("Correct answer");
                    balance += currentBet * 2;
                } else {
                    System.out.println("Your answer is not correct");
                    balance -= currentBet;
                }
            }
            System.out.println("Card in the deck: " + deck.cardLeft());
            System.out.print("Your balance is: " + balance + "$$ Make a bet:");


            currentBet = checkTheBalanceWithCurrentBet(balance);
            currentCard = nextCard;
            //TODO when the cards are 0 -> shuffle
        }
    }


    private static int checkTheBalanceWithCurrentBet(int balance) {
        int currentBet;
        do {
            currentBet = scanner.nextInt();
            if (balance < currentBet) {
                System.out.println("There is not enough money in the balance");
                System.out.printf("Please enter a valid sum, your balance is %d $$%n", balance);
            }
        } while (balance < currentBet);

        return currentBet;
    }


    private static void shuffleTheDeck(Card currentCard) {
        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("The cards have shuffled");
        Card firstCard = deck.dealCard();
        firstCard(currentCard);
        System.out.println("The cards in the deck are: " + deck.cardLeft());
    }

    private static int firstCard(Card currentCard) {
        System.out.println("The first card is the " + currentCard);
        System.out.println("Make a bet");
        int currentBet = scanner.nextInt();
        //TODO to validate  currentBet only integers;
        return currentBet;
    }


    private static boolean checkTheCommand(String answer) {
        return !answer.equals("H") && !answer.equals("L") &&
                !answer.equals("shuffle") && !answer.equals("bet") &&
                !answer.equals("start");
    }


}
