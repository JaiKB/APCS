import java.util.ArrayList;
import java.util.List; 

/**
 * Class that runs the board game for Elevens
 * @author Jai Bansal
 */
public class ElevensBoard extends Board {

    private static final int BOARD_SIZE = 9; 
    private static final String[] RANKS = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String [] SUITS = {"hearts", "spades", "diamonds", "clubs"}; 
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0}; 

    /**
     * Constructor for ElevensBoard, uses super to use constructor from Abstract Board class 
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Checks to see if the move for Elevens Game is legal
     * @param selectedCards Cards to see if the move is legal for
     * @return if the move is legal or not
     */
    public boolean isLegal(List<Integer> selectedCards) {
        boolean jack = false; 
        boolean queen = false; 
        boolean king = false; 
        boolean JQK = false; 
        if(selectedCards.size() == 2) {
            if(cardAt(selectedCards.get(0)).pointValue() + cardAt(selectedCards.get(1)).pointValue() == 11){
                return true;  
            } else {
                return false; 
            }
        } else if(selectedCards.size() == 3) {
            for(int i = 0; i < 3; i++) {
                if((cardAt(selectedCards.get(i)).rank().equals("jack"))){
                    jack = true; 
                } 
                if((cardAt(selectedCards.get(i)).rank().equals("queen"))){
                    queen = true; 
                } 
                if((cardAt(selectedCards.get(i)).rank().equals("king"))){
                    king = true; 
                } 
            }

            if(jack && queen && king) {
                JQK = true; 
            }   
            return JQK; 
        } else {
            return false; 
        }
    }

    /**
     * See's if another play is possible in the game
     * @return if another play is possible in the game
     */
    public boolean anotherPlayIsPossible() {
        if(containsPairSum11() || containsJQK()) {
            return true; 
        } else {
            return false; 
        }
    }

    /**
     * Checks to see if the game has a pair that add up to 11
     * @return if the game has a pair that adds up to 11
     */
    private boolean containsPairSum11() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(cardAt(i).pointValue() + cardAt(j).pointValue() == 11) {
                    return true; 
                } 
            }
        }
        return false; 
    }

    /**
     * Checks to see if the game has a Jack, Queen, and King on the table
     * @return if the game has a Jack, Queen, and King on the table 
     */
    private boolean containsJQK() {
        boolean jack = false; 
        boolean queen = false; 
        boolean king = false; 
        boolean JQK = false; 
        for(int i = 0; i < 9; i++) {
            if(cardAt(i).rank().equals("jack")) {
                jack = true; 
            } 
            if(cardAt(i).rank().equals("queen")) {
                queen = true; 
            }
            if(cardAt(i).rank().equals("king")) {
                king = true; 
            }
        }

        if(jack && queen && king) {
            JQK = true; 
        }
        return JQK;
    }
}