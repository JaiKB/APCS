import java.util.ArrayList; 
public class Deck {  
    ArrayList<Card> cardDeck = new ArrayList<Card>(); 
    int size = 0; 

    public Deck(String[] ranks, String[] suits, int[] values) {

        for(int i = 0; i < suits.length; i++) {
            for (int j=0; j < ranks.length; j++) {
                cardDeck.add(new Card(ranks[j], suits[i], values[j]));  
                size += 1; 
            }
        }
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true; 
        } else {
            return false; 
        }
    }

    public int size() {
        return size; 
    }

    public void shuffle() {
        for(int i = 0; i < cardDeck.size(); i++) {
            int rand = (int) (Math.random() * cardDeck.size()); 
            Card temp1 = cardDeck.get(i); 
            Card temp2 = cardDeck.get(rand); 
            cardDeck.set(i, temp2); 
            cardDeck.set(rand, temp1); 
        }
    }

    public Card deal() {
        size -= 1; 
        return cardDeck.get(size);     
    }

    public String toString() {
        String undealtCards = ""; 
        String dealtCards = ""; 
        for(int i = cardDeck.size() - 1; i >= size; i--){
            dealtCards += cardDeck.get(i).toString(); 
        }
        
        for(int i = size - 1; i >= 0; i--) {
            undealtCards += cardDeck.get(i).toString(); 
        }
        return "size = " + size + "\nUndealt Cards: \n" + undealtCards + "Dealt Cards: \n" + dealtCards; 
    }

}