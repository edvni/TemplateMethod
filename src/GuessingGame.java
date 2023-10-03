import java.util.Random;
import java.util.Scanner;

public class GuessingGame extends Game{
    private int numberToGuess;
    private int winningPlayer;
    private boolean isWinner;

    @Override
    void initializeGame() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
        winningPlayer = -1;
        isWinner = false;
        System.out.println("Guess the number between 1 and 100.");

    }

    @Override
    void makePlay(int player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + (player + 1) + ", enter your guess: ");
        int guess = scanner.nextInt();

        if (guess < numberToGuess) {
            System.out.println("Too low!");
        } else if (guess > numberToGuess) {
            System.out.println("Too high!");
        } else {
            System.out.println("Player " + (player + 1) + " guessed the right number!");
            winningPlayer = player + 1;
            isWinner = true;
        }
    }

    @Override
    boolean endOfGame() {
        return isWinner;
    }

    @Override
    void printWinner() {
        if (winningPlayer != -1) {
            System.out.println("Player " + (winningPlayer) + " wins!");
        } else {
            System.out.println("Game over. No one won.");
        }
    }
}