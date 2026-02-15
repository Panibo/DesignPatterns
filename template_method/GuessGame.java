import java.util.Random;
import java.util.Scanner;

public class GuessGame extends Game {

    private int correctNumber;
    private int winner = -1;

    private final Random rnd = new Random();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void initializeGame(int numberOfPlayers) {
        correctNumber = rnd.nextInt(0, 51);
        winner = -1;
        System.out.println("Guess a number between 0 and 50");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

@Override
public void playSingleTurn(int player) {
    while (true) {
        System.out.print("Player " + player + ", enter your guess: ");
        try {
            int guess = scanner.nextInt();
            if (guess == correctNumber) {
                winner = player;
            } else {
                System.out.println("Wrong guess!");
            }
            return;
        } catch (Exception e) {
            System.out.println("Invalid input. Try again.");
            scanner.nextLine();
        }
    }
}

    @Override
    public void displayWinner() {
        System.out.println("Player " + winner + " wins!");
        System.out.println("The correct number was " + correctNumber);
    }
}
