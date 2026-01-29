package bingocrud;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initialize the Caller system
        Caller caller = new Caller();
        
        // Initialize players
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        // Show initial cards
        p1.showCard();
        System.out.println(); 
        p2.showCard();

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
            p1.markNumber(currentNumber);
            p1.checkRow(); // Check for line
            if (p1.checkBingo()) {
                System.out.println("-----------------------------------------------");
                System.out.println("WINNER: " + p1.getName());
                gameOver = true;
            }

            // --- Player 2 Turn (only if game is not over) ---
            if (!gameOver) {
                p2.markNumber(currentNumber);
                p2.checkRow(); // Check for line
                if (p2.checkBingo()) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("WINNER: " + p2.getName());
                    gameOver = true;
                }
            }
        }
        
        System.out.println("-----------------------------------------------");
        System.out.println("Game Finished.");
        sc.close();
    }
}