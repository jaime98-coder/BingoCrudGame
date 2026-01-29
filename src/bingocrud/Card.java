package bingocrud;

import java.util.Random;

public class Card {
    // 3x5 Matrix and Random object
    int[][] card = new int[3][5];
    Random rd = new Random();

    // Constructor: Automatically fill the card upon creation
    public Card() {
        fillCard();
    }

    // Generate a number (private because it is for internal use)
    private int generateNumber() {
        int cardNumber;
        // nextInt(1, 100) generates numbers from 1 to 99
        cardNumber = rd.nextInt(1, 100); 
        return cardNumber;
    }

    // Fill the matrix without duplicates
    public void fillCard() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                
                int num;
                boolean repeated;

                do {
                    num = generateNumber();
                    repeated = false; // Assume it is new

                    // Iterate through the entire matrix to check if 'num' already exists
                    for (int r = 0; r < card.length; r++) {
                        for (int c = 0; c < card[r].length; c++) {
                            if (card[r][c] == num) {
                                repeated = true; // Found it! It is repeated
                            }
                        }
                    }
                    // If 'repeated' is true, the loop repeats to find another number
                } while (repeated);

                // If we reach here, the number is unique; save it
                card[i][j] = num;
            }
        }
    }

    // Show card
    public void showCard() {
        System.out.println("┌──────────────────────────────┐");
        for (int i = 0; i < card.length; i++) {
            System.out.print("│ "); // Left border
            for (int j = 0; j < card[i].length; j++) {
                
                // If it is -1, show an X; otherwise, show the number
                if (card[i][j] == -1) {
                    System.out.print(" X \t");
                } else {
                    // Conditional to add a leading 0 if less than 10 (formatting)
                    System.out.print((card[i][j] < 10 ? "0" : "") + card[i][j] + "\t");
                }
                
            }
            System.out.println("│"); // Right border and new line
        }
        System.out.println("└──────────────────────────────┘");
    }

    // --- NECESSARY METHODS FOR GAME LOGIC ---

    // 1. Mark number
    public boolean markNumber(int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = -1; // Mark with -1
                    return true;
                }
            }
        }
        return false;
    }

    // 2. Check Row
    public boolean checkLine() {
        for (int i = 0; i < card.length; i++) {
            int counter = 0;
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == -1) {
                    counter++;
                }
            }
            if (counter == 5) return true; // Full row found
        }
        return false;
    }

    // 3. Check Bingo
    public boolean checkBingo() {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] != -1) return false;
            }
        }
        return true;
    }
}