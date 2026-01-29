package bingocrud;

public class Player {
    private String name;      
    private Card card;        
    private boolean hasRow;   // Flag to check if ROW was already called
    private boolean hasBingo; // Flag to check if BINGO was already called

    // Constructor: Sets name and creates a new Card
    public Player(String name) {
        this.name = name;
        this.card = new Card(); 
        this.hasRow = false;
        this.hasBingo = false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("The name cannot be empty");
        } else {
            this.name = name; 
        }
    }

    public Card getCard() {
        return this.card;
    }

    // Marks the number on the player's card
    public void markNumber(int number) {
        boolean marked = card.markNumber(number); 
        
        if (marked) {
            System.out.println(this.name + " has marked number " + number);
        }
    }

    // Checks for a full row and announces it only once
    public boolean checkRow() {
        if (!hasRow && card.checkLine()) {
            hasRow = true; 
            System.out.println(this.name + " SHOUTS ROW!");
            return true;
        }
        return false;
    }

    // Checks for a full card (Bingo)
    public boolean checkBingo() {
        if (!hasBingo && card.checkBingo()) {
            hasBingo = true;
            System.out.println(this.name + " SHOUTS BINGO!");
            return true;
        }
        return false;
    }

    // Displays the player's card
    public void showCard() {
        System.out.println(this.name + " Card:");
        card.showCard();
    }
}