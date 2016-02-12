public class Card {
    String cardRank; 
    String cardSuit; 
    int cardPointValue; 
    public Card(String cardRank, String cardSuit, int cardPointValue){
        this.cardRank = cardRank; 
        this.cardSuit = cardSuit; 
        this.cardPointValue = cardPointValue; 
    }
    
    public String suit() {
        return cardSuit; 
    }
    
    public String rank() {
        return cardRank; 
    }
    
    public int pointValue() {
        return cardPointValue;
    }
    
    public boolean matches(Card otherCard) {
        if(cardRank.equals(otherCard.rank()) && cardSuit.equals(otherCard.suit()) && cardPointValue == otherCard.pointValue()) {
            return true; 
        } else {
            return false; 
        }
    }
    
    public String toString() {
        return cardRank + " of " + cardSuit + " (point value = " + cardPointValue + ")\n"; 
    }
}