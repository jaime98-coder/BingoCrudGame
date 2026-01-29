package bingocrud;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Scanner to read user input (Enter key)
        Scanner sc = new Scanner(System.in);
        
        // Initialize the Caller (the system that draws numbers)
        Caller caller = new Caller();
        
        // Create two players with their respective names
        // The constructor automatically creates a random Card for each player
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        // Display the initial cards for both players
        System.out.println("--- INITIAL CARDS ---");
        p1.showCard();
        System.out.println(); // Empty line for better formatting
        p2.showCard();

        // Boolean flag to control the game loop
        boolean gameOver = false;
        
        System.out.println("\n--- BINGO GAME STARTS ---");
        System.out.println("Press [ENTER] to draw the next number...");

        // Main Game Loop
        while (!gameOver) {
            // Wait for the user to press Enter
            sc.nextLine();

            // 1. Draw a number from the Caller
            int currentNumber = caller.drawNumber();

            // Check if we ran out of numbers (optional safety check)
            if (currentNumber == -1) {
                System.out.println("No more numbers left. Game Over.");
                break;
            }

            System.out.println(">> NUMBER DRAWN: [ " + currentNumber + " ]");

            // --- PLAYER 1 TURN ---
            
            // A. Mark the number on the card
            p1.markNumber(currentNumber);
            
            // B. Check for ROW (The method prints "ROW" if found)
            p1.checkRow();
            
            // C. Check for BINGO (The method prints "BINGO" if found)
            if (p1.checkBingo()) {
                System.out.println("\n***********************************");
                System.out.println("   WINNER: " + p1.getName());
                System.out.println("***********************************");
                gameOver = true; // Stop the loop
            }

            // --- PLAYER 2 TURN (Only if the game is not over) ---
            if (!gameOver) {
                
                // A. Mark the number
                p2.markNumber(currentNumber);
                
                // B. Check for ROW
                p2.checkRow();
                
                // C. Check for BINGO
                if (p2.checkBingo()) {
                    System.out.println("\n***********************************");
                    System.out.println("   WINNER: " + p2.getName());
                    System.out.println("***********************************");
                    gameOver = true; // Stop the loop
                }
            }
            
            // Optional: Show cards after every turn to see progress (Can be commented out)
            // p1.showCard();
            // p2.showCard();
        }
        
        // Close the scanner resource
        System.out.println("Game Finished.");
        sc.close();
    }
}