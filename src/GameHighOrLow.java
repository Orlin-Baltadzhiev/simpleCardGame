import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;

public class GameHighOrLow {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("The game is starting ....");
        System.out.println("With this program you can easy to play your favorite game");
        System.out.println("Your points in the game depends on correct answers");
        System.out.println("You have to predict whether the next card will be lower or higher");
        System.out.print("Before we start enter your balance here:");
      
        int balance = scanner.nextInt();


        boolean playAgain;


        do {
            int currGamePoints;
            currGamePoints = play(balance);

            System.out.println("Do you want to play again? 'true' or 'false'");
            playAgain = scanner.nextBoolean();
        } while (playAgain);


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
        int currentBet = scanner.nextInt();
        balance -= currentBet;
        //todo check the balance-bet


        while (true) {
            System.out.println("Your bet is " + currentBet);
            System.out.println("What will be the next card 'L' or 'H' or shuffle, bet , start");
            do {
                answer = scanner.next();
                if(checkTheAnswer(answer)){
                    System.out.println("Please enter the valid command 'L' or 'H' or 'shuffle' or 'bet' or 'start'?");
                }

            } while (checkTheAnswer(answer));

            if(answer.equals("shuffle")){
                deck = new Deck();
                deck.shuffle();
                System.out.println("The cards have shuffled");
                continue;
            }

            nextCard = deck.dealCard();
            System.out.println("Next card is " + nextCard);

            if (nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The cards are the same");
                //TODO: we do nothing
            }
            else if(nextCard.getValue()> currentCard.getValue()){
                if(answer.equals("H")){
                    System.out.println("Correct answer");
                    balance+= currentBet*2;
                }else {
                    System.out.println("Your answer is not  correct");
                    //TODO: check the balance
                    balance -=currentBet;
                }
            }
            else if (nextCard.getValue() < currentCard.getValue()){
                if(answer.equals("L")){
                    System.out.println("Correct answer");
                    balance+= currentBet*2;
                }else {
                    System.out.println("Your answer is not correct");
                    //TODO: check the balance
                    balance -=currentBet;
                }
            }


            System.out.println(deck.cardLeft());
            System.out.print("Your balance is:"+ balance + "$$ Make a bet:");
            currentBet = scanner.nextInt();

        }


    }

    private static boolean checkTheAnswer(String answer) {
        return !answer.equals("H") && !answer.equals("L") &&
                !answer.equals("shuffle") && !answer.equals("bet") &&
                !answer.equals("start");
    }


}
