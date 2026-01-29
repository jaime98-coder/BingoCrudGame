package bingocrud;

import java.util.Random;

public class Card {
    // 3x5 grid for the numbers and Random object
    int[][] card = new int[3][5];
    Random rd = new Random();

    // Constructor: Automatically fills the card when created
    public Card() {
        fillCard();
    }

    // Generates a random number between 1 and 99
    private int generateNumber() {
        int cardNumber;
        cardNumber = rd.nextInt(1, 100); 
        return cardNumber;
    }

    // Fills the matrix ensuring no numbers are repeated
    public void fillCard() {
        // Iterate through rows
        for (int i = 0; i < card.length; i++) {
            // Iterate through columns
            for (int j = 0; j < card[i].length; j++) {
                
                int num;
                boolean repeated;

                // Loop to generate a valid unique number
                do {
                    num = generateNumber();
                    repeated = false; 

                    // Check if the number already exists in the grid
                    for (int r = 0; r < card.length; r++) {
                        for (int c = 0; c < card[r].length; c++) {
                            if (card[r][c] == num) {
                                repeated = true; // Number found, it is a duplicate
                            }
                        }
                    }
                } while (repeated); // Repeat if duplicate found

                // Assign the unique number to the position
                card[i][j] = num;
            }
        }
    }

    // Prints the card to the console
    public void showCard() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                // If value is -1, print X (marked), otherwise print number
                if (card[i][j] == -1) {
                    System.out.print("X\t");
                } else {
                    System.out.print(card[i][j] + "\t");
                }
            }
            System.out.println(); // New line after each row
        }
    }

    // Searches for a number and marks it as -1 if found
    public boolean markNumber(int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = -1; // Mark as found
                    return true;
                }
            }
        }
        return false; // Number not in card
    }

    // Checks if any row is completely marked
    public boolean checkLine() {
        for (int i = 0; i < card.length; i++) {
            int counter = 0;
            // Count marked numbers in the current row
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == -1) {
                    counter++;
                }
            }
            // If all 5 numbers are marked, return true
            if (counter == 5) return true; 
        }
        return false;
    }

    // Checks if the entire card is marked
    public boolean checkBingo() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                // If any number is not -1, it is not Bingo yet
                if (card[i][j] != -1) return false;
            }
        }
        return true;
    }
}