package bingocrud;

public class Player {
    private String name;      // Player's name
    private Card card;        // Player's Bingo card
    private boolean hasRow;   // To check if ROW has already been called
    private boolean hasBingo; // To check if BINGO has already been called

    // Constructor: Receives the name and creates a new card
    public Player(String name) {
        this.name = name;
        this.card = new Card(); // The player generates their own card upon creation
        this.hasRow = false;
        this.hasBingo = false;
    }

    // 1. GET NAME
    public String getName() {
        return this.name;
    }

    // 2. SET NAME (Corrected)
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("The name cannot be empty");
        } else {
            this.name = name; // Assignment happens here
        }
    }

    // 3. GET CARD (Corrected)
    // Must return the Card object, not request it as a parameter
    public Card getCard() {
        return this.card;
    }

    // 4. MARK NUMBER (Corrected based on requirements)
    // Receives the number called and tells the card to mark it
    public void markNumber(int number) {
        // Delegate the complex logic to the Card class
        // (Card searches for the number and sets -1 if it exists)
        boolean marked = card.markNumber(number); 
        
        if (marked) {
            System.out.println(this.name + " has marked number " + number);
        }
    }

    // 5. CHECK ROW (Corrected based on requirements)
    // Checks if there is a full row and updates hasRow to avoid calling it twice
    public boolean checkRow() {
        // If ROW has NOT been called yet AND the card has a line...
        if (!hasRow && card.checkLine()) {
            hasRow = true; // Update to avoid re-entering
            System.out.println("! " + this.name + " SHOUTS ROW!");
            return true;
        }
        return false;
    }

    // 6. CHECK BINGO (Corrected based on requirements)
    public boolean checkBingo() {
        // If BINGO has NOT been called yet AND the card has bingo...
        if (!hasBingo && card.checkBingo()) {
            hasBingo = true;
            System.out.println("!!! " + this.name + " SHOUTS BINGO !!!");
            return true;
        }
        return false;
    }

    // 7. SHOW CARD
    public void showCard() {
        System.out.println(this.name + "'s Card:");
        card.showCard();
    }
}