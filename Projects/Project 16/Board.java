import java.util.ArrayList; 
import java.util.List; 
/**
 * Board Class to run the card game
 * @author Jai Bansal 
 */
public abstract class Board {
    private int size; 
    private String[] ranks; 
    private String[] suits; 
    private int[] pointValues; 
    private Deck deck; 
    ArrayList<Card> table; 
    /**
     * Constructor for the Board class that sets the size, ranks, suits, pointvalues and makes a new deck with those values
     * @param size Size of the Board
     * @param ranks String Array with all the ranks of the cards
     * @param suits String Array with all the suits of the cards
     * @param pointValues int Array with all the point values of the cards
     */
    public Board(int size, String [] ranks, String[] suits, int[] pointValues) {
        this.size = size; 
        this.ranks = ranks; 
        this.suits = suits;
        this.pointValues = pointValues; 
        deck = new Deck(ranks, suits, pointValues); 
        newGame(); 
    }

    /**
     * Method to run when a new game is started. Creates a new table array list, shuffles the deck, and add's values to the array list
     */
    public void newGame() {
        table = new ArrayList<Card>(); 
        deck.shuffle(); 
        for(int i = 0; i < size; i++) {
            table.add(i, deck.deal()); 
        }
    }

    /**
     * Gives the amount of cards on the table
     * @return size of the cards on the table
     */
    public int size() {
        int tableSize = 0; 
        for(int i = 0; i < size; i++) {
            if(table.get(i) == null) {
                tableSize = tableSize; 
            } else {
                tableSize++; 
            }
        }

        return tableSize; 
    }

    /**
     * Checks to see if there are any cards on the table
     * @return if there are cards on the table
     */
    public boolean isEmpty() {
        return size() == 0; 
    }

    /**
     * Deals the cards for the game onto the table
     * @return dealt cards on the table
     */
    public void deal(int k) {
        table.remove(k); 
        table.add(k, deck.deal()); 
    }
    
    /**
     * Gives the size of the deck
     * @return size of the deck
     */
    public int deckSize() {
        return deck.size(); 
    }

    /**
     * Gets the card specified at that position
     * @param k Position of card to get
     * @return card at that poisition
     */
    public Card cardAt(int k) {
        return table.get(k);
    }

    /**
     * Replaces the selected Cards with new cards from the deck or else removes them if the deck is empty
     * @param selectedCards the selected cards to replace 
     */
    public void replaceSelectedCards(List<Integer>selectedCards) {
        if(isLegal(selectedCards)) {
            for(int i = 0; i < selectedCards.size(); i++) {
                table.set(selectedCards.get(i), deck.deal()); 
            }
        
        }
    }

    /**
     * Gives the indexes of the cards on the table
     * @return card indexes on the table
     */
    public List<Integer> cardIndexes() {
        ArrayList<Integer> cardIndexes = new ArrayList<Integer>(); 
        for(int i = size(); i > 0; i--) {
            cardIndexes.add(i); 
        } 
        return cardIndexes; 
    }

    /**
     * Gives all the cards in String form
     * @return String format of the cards
     */
    public String toString() {
        String str = ""; 
        int x = 1; 
        for(int i = 0; i < table.size(); i++){
            str += x + ":" + table.get(i).toString() + "\n"; 
            x++; 
        }  
        return str; 
    }

    /**
     * Checks to see if the game is won
     * @return if game is won or not
     */
    public boolean gameIsWon() {
        if(deck.isEmpty() && isEmpty()) {
            return true; 
        } else {
            return false; 
        }
    }

    /**
     * Deals out the cards for that game
     */
    private void dealMyCards() {
        for(int i = 0; i < table.size(); i++) {
            table.set(i, deck.deal()); 
        }
    }

    /**
     * Abstract method overriden in Elevens Board for isLegal
     */
    public abstract boolean isLegal(List<Integer> selectedCards); 

    /**
     * Abstract method overriden in Elevens Board for anotherPlayIsPossible
     */
    public abstract boolean anotherPlayIsPossible(); 
}