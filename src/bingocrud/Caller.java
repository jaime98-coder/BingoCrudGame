package bingocrud;

import java.util.ArrayList;
import java.util.Collections;

public class Caller {
    // List to store numbers from 1 to 99
    private ArrayList<Integer> numbersBox = new ArrayList<>();

    // Constructor: Fills the list and shuffles it
    public Caller() {
        for (int i = 1; i <= 99; i++) {
            numbersBox.add(i);
        }
        // Randomize the order of numbers
        Collections.shuffle(numbersBox);
    }

    // Draws the next number from the list
    public int drawNumber() {
        if (numbersBox.isEmpty()) {
            return -1; // No numbers left
        }
        // Remove and return the first number
        return numbersBox.remove(0); 
    }
}