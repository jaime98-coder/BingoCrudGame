package bingocrud;

import java.util.ArrayList;
import java.util.Collections;

public class Caller {
    // List to store the numbers (Bingo balls)
    private ArrayList<Integer> numbersBox = new ArrayList<>();

    // Constructor: Initializes the box with numbers 1 to 99 and shuffles them
    public Caller() {
        for (int i = 1; i <= 99; i++) {
            numbersBox.add(i);
        }
        // Shuffle the list to simulate random drawing
        Collections.shuffle(numbersBox);
    }

    // Method to draw a number from the box
    public int drawNumber() {
        // Check if there are numbers left
        if (numbersBox.isEmpty()) {
            return -1; // Return -1 if the box is empty
        }
        // Remove and return the first number from the list
        return numbersBox.remove(0); 
    }
}