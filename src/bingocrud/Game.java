package bingocrud;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initialize the Caller system
        Caller caller = new Caller();
        
        // Initialize players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Show initial cards
        player1.showCard();
        System.out.println(); 
        player2.showCard();

        boolean gameOver = false;
        
        System.out.println("BINGO GAME STARTS");
        System.out.println("Press ENTER to draw a number");

        // Main game loop
        while (!gameOver) {
            // Wait for user input
            sc.nextLine();

            // Draw a random number
            int currentNumber = caller.drawNumber();

            // Check if numbers ran out
            if (currentNumber == -1) {
                System.out.println("No more numbers left.");
                break;
            }

            System.out.println("Number drawn: " + currentNumber);

            // --- Player 1 Turn ---
            player1.markNumber(currentNumber);
            player1.checkRow(); // Check for line
            if (player1.checkBingo()) {
                System.out.println("-----------------------------------------------");
                System.out.println("WINNER: " + player1.getName());
                gameOver = true;
            }

            // --- Player 2 Turn (only if game is not over) ---
            if (!gameOver) {
                player2.markNumber(currentNumber);
                player2.checkRow(); // Check for line
                if (player2.checkBingo()) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("WINNER: " + player2.getName());
                    gameOver = true;
                }
            }
        }
        
        System.out.println("-----------------------------------------------");
        System.out.println("Game Finished.");
        sc.close();
    }
}
