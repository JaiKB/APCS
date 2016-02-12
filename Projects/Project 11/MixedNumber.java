/**
 * Mixed Number class that adds, substracts, multiplies, divides rational numbers and mixed numbers. 
 * @author Jai Bansal
 */
public class MixedNumber implements MixedNumberInterface {
    private int whole; 
    private int num; 
    private int den; 

    /**
     * Constructor class for Mixed Number that sets the state variables equal to the user input. Checks if 
     * the whole number is negitive and makes numerator positive in that case. 
     * @param whole Whole number for the mixed number
     * @param num Numerator for mixed number
     * @param den Denominator for mixed number
     */
    public MixedNumber(int whole, int num, int den) {
        this.num = num; 
        this.den = den; 
        this.whole = whole; 
        
        if(whole < 0) { 
            num *= -1; 
        }
        
        if(whole == 0) {
            this.whole = num / den; 
            this.num = num % den; 
            this.den = den; 
        }
          
        RationalNumber rational = new RationalNumber(((whole*den) + num), den); 
        int gcf = gcf(rational.getNumerator(), rational.getDenominator()); 
        this.num /= gcf; 
        this.den /= gcf; 
         
    }

    /**
     * Gets the numerator for the mixed number
     * @return numerator for mixed number
     */
    public int getNumerator() {
        return num; 
    }

    /**
     * Get the denominator for the mixed number
     * @return denominator for mixed number
     */
    public int getDenominator() {
        return den; 
    }

    /**
     * Gets the whole number for the mixed number
     * @return whole number for mixed number
     */
    public int getWhole() {     
        return whole; 
    }

    /**
     * Adds a rational and a mixed number
     * @param x rational number input to be added to the mixed number
     * @return the sum of the rational number added to the mixed number as a mixed number
     */
    public MixedNumber add(RationalNumber x) {
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = (finalNum * x.getDenominator()) + ((x.getNumerator() * finalDen)); 
        finalDen = finalDen * x.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed; 
    }

    /**
     * Adds a two mixed numbers 
     * @param x Mixed number input to be added to the first mixed number
     * @return the sum of the two mixed numbers as a mixed number 
     */
    public MixedNumber add(MixedNumber x) {
        RationalNumber rational = x.convertToRational();
        
        
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = (finalNum * rational.getDenominator()) + ((rational.getNumerator() * finalDen)); 
        finalDen = finalDen * rational.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed; 
    }

    /**
     * Subtracts a mixed and rational number
     * @param x Rational Number input to be subtracted from the Mixed Number
     * @return difference of the two numbers as a mixed number
     */
    public MixedNumber subtract(RationalNumber x) {      
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = (finalNum * x.getDenominator()) - ((x.getNumerator() * finalDen)); 
        finalDen = finalDen * x.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed; 
    }

    /**
     * Subtracts two mixed numbers
     * @param x Mixed Number input to be subtracted from the first mixed number
     * @return difference of the two mixed numbers as a mixed number
     */
    public MixedNumber subtract(MixedNumber x) {
        RationalNumber rational = x.convertToRational();
      
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = (finalNum * rational.getDenominator()) - ((rational.getNumerator() * finalDen)); 
        finalDen = finalDen * rational.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed; 
    }

    /**
     * Mulitplies a mixed and rational number
     * @param x Rational Number input to be multiplied to the mixed number
     * @return product of the mixed number and rational number as a mixed number
     */
    public MixedNumber multiply(RationalNumber x) {
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = finalNum * x.getNumerator(); 
        finalDen = finalDen * x.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed;
    }

    /**
     * Multiplies two mixed number 
     * @param x Mixed Number input to be multiplied to the first mixed number
     * @param product of the two numbers as a mixed number 
     */
    public MixedNumber multiply(MixedNumber x) {
        RationalNumber rational = x.convertToRational(); 
        
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = finalNum * rational.getNumerator(); 
        finalDen = finalDen * rational.getDenominator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed;
    }

    /**
     * Divides a rational and mixed number
     * @param x Rational number input to be divided by the mixed number
     * @return the quotient of the mixed and rational numbers as a mixed number
     */
    public MixedNumber divide(RationalNumber x) {
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = finalNum * x.getDenominator();
        finalDen = finalDen * x.getNumerator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed;
    }

    /**
     * Divides two mixed numbers
     * @param x Mixed number input to be divided by the first mixed number 
     * @return the quotient of the two mixe numbers as a mixed number 
     */
    public MixedNumber divide(MixedNumber x) {
         RationalNumber rational = x.convertToRational(); 
        
        int finalNum = (whole*den) + num; 
        int finalDen = den; 
        
        finalNum = finalNum * rational.getDenominator(); 
        finalDen = finalDen * rational.getNumerator(); 
        
        RationalNumber finalRational = new RationalNumber(finalNum, finalDen); 
        MixedNumber finalMixed = finalRational.convertToMixed(); 
        
        return finalMixed;
    }
    
    /**
     * Converts a mixed number to a rational number
     * @return rational number form of the mixed number 
     */
    public RationalNumber convertToRational() {
        int finalNum = (whole * den) + num; 
        int finalDen = den; 
        
        return new RationalNumber(finalNum, finalDen); 
    }

    /**
     * Mixed number string representation
     * @return representation of a mixed number as a String 
     */
    public String toString() {
        return whole + " " + num + " / " + den; 
    }
    
    /**
     * Finds the greatest common factor among two numbers
     * @return the greatest common facotor of two numbers
     */
    private int gcf(int a, int b) {
        a = Math.abs(a); 
        b = Math.abs(b); 
        if(b > a) return gcf(b, a); 
        if(b == 0) return a; 
        return gcf(b, a % b); 
    }
}