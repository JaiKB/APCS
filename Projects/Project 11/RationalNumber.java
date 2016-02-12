/**
 * Rational Number class that adds, substracts, multiplies, divides rational numbers and mixed numbers. 
 * @author Jai Bansal
 */

public class RationalNumber implements RationalNumberInterface {

    private int num; 
    private int den; 
    
    /**
     * Constructor class for Rational Number that sets the state variables equal to the user input
     * @param num Numerator for Rational Number
     * @param den Denominator for Rational Number
     */
    public RationalNumber(int num, int den) {
        this.num = num; 
        this.den = den; 
        int gcf = gcf(this.num, this.den); 
        this.num /= gcf; 
        this.den /= gcf; 
    }
    
    /**
     * Gets the numerator for the mixed number
     * @return numerator for Rational Number 
     */
    public int getNumerator() {
        return num; 
    }
    
    /**
     * Get the denominator for the rational number
     * @return denominator for rational number 
     */
    public int getDenominator() {
        return den; 
    }
    
    /**
     * Adds two rational numbers 
     * @param x Rational Number input to be added to the first Rational Number
     * @return sum of the two rational numbers as a rational number 
     */
    public RationalNumber add(RationalNumber x) {
        int finalNum = (num * x.getDenominator()) + ((x.getNumerator() * den)); 
        int finalDen = den * x.getDenominator(); 
        
        return new RationalNumber(finalNum, finalDen); 
    }
    
    /**
     * Adds a rational and a mixed number
     * @param x Mixed Number input to be added to the rational number
     * @return the sum of the rational number added to the mixed number as a rational number 
     */
    public RationalNumber add(MixedNumber x) {
        RationalNumber mixed = x.convertToRational();
        
        int finalNum = (num * mixed.getDenominator()) + ((mixed.getNumerator() * den)); 
        int finalDen = den * mixed.getDenominator(); 
        
        return new RationalNumber(finalNum, finalDen); 
    }
    
    /**
     * Subtracts two rational number 
     * @param x Rational Number input to be subtracted to the first rational number
     * @return the difference of the two rational numbers as a rational number 
     */
    public RationalNumber subtract(RationalNumber x) {
        int finalNum = (num * x.getDenominator()) - ((x.getNumerator() * den)); 
        int finalDen = den * x.getDenominator(); 
        
        return new RationalNumber(finalNum, finalDen);  
    }
    
    /**
     * Subtracts a rational and a mixed number
     * @param x Mixed Number input to be subtracted from the rational number
     * @return the difference between the rational number and mixed number as a rational number 
     */
    public RationalNumber subtract(MixedNumber x) {
        RationalNumber mixed = x.convertToRational(); 
        int finalNum = (num * mixed.getDenominator()) - ((mixed.getNumerator() * den)); 
        int finalDen = den * mixed.getDenominator(); 

        return new RationalNumber(finalNum, finalDen);  
    }
    
    /**
     * Mulitplies two Rational Numbers
     * @param x Rational Number input to be multiplied to the first Rational Number
     * @return the product of the two rational numbers as a rational number 
     */
    public RationalNumber multiply(RationalNumber x) {
        int finalNum = num * x.getNumerator(); 
        int finalDen = den * x.getDenominator(); 
        
        return new RationalNumber(finalNum, finalDen); 
    }
    
    /**
     * Multiplies a rational and mixed number
     * @param x Mixed Number input to be multiplied to the first Rational Number
     * @return product of the rational and mixed number as a rational number 
     */
    public RationalNumber multiply(MixedNumber x) {
        RationalNumber mixed = x.convertToRational(); 
        int finalNum = num * mixed.getNumerator(); 
        int finalDen = den * mixed.getDenominator(); 

        return new RationalNumber(finalNum, finalDen); 
    }
    
    /**
     * Divides two rational numbers
     * @param x Rational Number input to be divided by the first Rational Number
     * @return the quotient of the two rational numbers as a rational number 
     */
    public RationalNumber divide(RationalNumber x) {
        int finalNum = num * x.getDenominator(); 
        int finalDen = den * x.getNumerator(); 

        return new RationalNumber(finalNum, finalDen); 
    }

    /**
     * Divides a rational and mixed number
     * @param x Mixed Number input to be divided by the rational number
     * @return the quotient of the rational and mixed number as a rational number 
     */
    public RationalNumber divide(MixedNumber x) {
        RationalNumber mixed = x.convertToRational(); 
        int finalNum = num * mixed.getDenominator(); 
        int finalDen = den * mixed.getNumerator(); 

        return new RationalNumber(finalNum, finalDen); 
    }

    /**
     * Converts a rational number to a mixed number
     * @return mixed number of the rational number 
     */
    public MixedNumber convertToMixed() { 
        int whole = num / den; 
        int finalNum = num % den; 
        int finalDen = den; 

        return new MixedNumber(whole, finalNum, finalDen); 
    }
    
    /**
     * The string representation of a rational number 
     * @return string representation of a rational number 
     */
    public String toString() {
        return num + " / " + den;  
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