public class Tester {
    
    public static void main(String args[]) {
        String[] rank = {"1", "2", "3", "4"};
        String[] suit = {"Hearts", "Diamonds"};
        int[] point = {4, 3, 2, 1};
        Deck deck = new Deck(rank, suit, point ); 
        System.out.println(deck.toString() + "\n"); 
        deck.shuffle(); 
        System.out.println("Suffled: \n" + deck.toString() + "\n"); 
        deck.deal(); 
        deck.deal(); 
        System.out.println(deck.toString()); 
        deck.shuffle(); 
        
    }
    
}