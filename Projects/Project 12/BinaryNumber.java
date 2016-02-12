/**
 * Takes a number in int form or String form and converts it to Binary and can run Binary operations
 * @author Jai Bansal
 */
public class BinaryNumber implements BinaryNumberInterface{

    private boolean[] bits = new boolean[9]; 

    /**
     * Constructor for BinaryNumber class that takes a number input and coverts it to Binary
     * @param number The number input the user gives to convert to Binary 
     */
    public BinaryNumber (int number) {
        if (number < -256 || number > 255) {
            throw new IllegalArgumentException("Number N/A"); 
        }

        if(number < 0) {
            number += 512; 
        }

        for(int i = 8; i >= 0; i--) {
            if((number / (int)Math.pow(2, i) > 0)) {
                bits[8-i] = true; 
                number -= (int)Math.pow(2, i); 
            } else {
                bits[8-i] = false;
            }
        }

    }

    /**
     * Second Constructor for BinaryNumber class, takes a string and converts it to Binary
     * @param str String input to convert to Binary 
     */
    public BinaryNumber (String str) {
        if(str.substring(0, 2).equals("0b") && str.length() == 11){
            str = str.substring(2); 
            for(int i = 0; i < str.length(); i++) {
                if(str.substring(i, i + 1).equals("1")){
                    bits[i] = true; 
                } else {
                    bits[i] = false; 
                }
            }
        } else {
            throw new IllegalArgumentException("Number N/A"); 
        }
    }

    /**
     * Third constructor for binary where the state variable gets the binary boolean paramater array
     * @param bits Boolean array for the Binary Number 
     */
    private BinaryNumber (boolean[] bits) {
        this.bits = bits; 
    }

    /**
     * Adds two Binary numbers 
     * @param x the binary number to add to the first binary number 
     * @return the binary sum of the two numbers added together 
     */
    public BinaryNumber add(BinaryNumber x) {
        boolean sum[] = new boolean[9]; 
        boolean carry[] = new boolean[10]; 

        for(int i = 8; i >= 0; i--){
            if(bits[i] == false && x.bits[i] == false) {
                if(carry[i] == true) {
                    sum[i] = true;
                } else {
                    sum[i] = false; 
                }
            }

            if(bits[i] == true && x.bits[i] == true) {
                if(carry[i] == true) {
                    sum[i] = true; 
                    if(i == 0){
                        break; 
                    }
                    carry[i - 1] = true; 
                } else {
                    sum[i] = false; 
                    if(i == 0) {
                        break; 
                    }
                    carry[i-1] = true; 
                }
            } else if(bits[i] == true || x.bits[i] == true) {
                if(carry[i] == true) {
                    sum[i] = false; 
                } else {
                    sum[i] = true; 
                }
            }
        } 

        return new BinaryNumber(sum); 
    }

    /**
     * Converts the binary number to it's negitive value expect -256 which just stays -256
     * @return the negitive value for the binary number in binary 
     */
    public BinaryNumber negate() {
        boolean result[] = new boolean[9]; 
        int pos = 0; 

        for(int i = 8; i >= 0; i--) {
            if(bits[i] == true) {
                result[i] = true; 
                pos = i; 
                break; 
            }
        }

        for(int i = pos - 1; i >= 0; i--) {
            result[i] = !bits[i]; 
            // Result = the opposite (!) of bits. 
        }

        return new BinaryNumber(result); 
    }

    /**
     * Subtracts two binary numbers
     * @param x The binary number to subtract to the orignal binary number 
     * @return the differnce of the two binary numbers in binary 
     */
    public BinaryNumber subtract(BinaryNumber x) {
        return new BinaryNumber(this.add(x.negate()).bits);
    }

    /**
     * Shifts all the values in the binary array to the left 
     * @return the shifted left version of the orginial binary array
     */
    public BinaryNumber shiftLeft() {
        boolean result[] = new boolean[9]; 
        result[8] = false; 
        for(int i = 8; i >= 0; i--) {
            if(i == 0) {
                break; 
            }
            result[i - 1] = bits[i]; 
        }

        return new BinaryNumber(result); 
    }

    /**
     * Shifts all the values of the binary array to the right 
     * @return the shifted right version of the original binary array
     */
    public BinaryNumber uShiftRight() {
        boolean result[] = new boolean[9]; 
        result[0] = false; 
        for(int i = 0; i <= 8; i++) {
            if(i == 8) {
                break; 
            }
            result[i + 1] = bits[i]; 
        }

        return new BinaryNumber(result); 
    }

    /**
     * Looks at the two binary numbers and if it is "True True" it returns True or else False. 
     * @param x The binary number to compare to the orignal binary number 
     * @return the compared "and" version of both the Binary numbers in binary 
     */
    public BinaryNumber and(BinaryNumber x) {
        boolean result[] = new boolean[9]; 
        for(int i = 8; i >= 0; i--) {
            if(bits[i] == true && x.bits[i] == true){
                result[i] = true; 
            } else {
                result[i] = false; 
            }
        }

        return new BinaryNumber(result); 
    }
    
    /**
     * Looks at two binary bumber and if it is True in either one it returns true or else false 
     * @param x the binary number to compare to the orginal binary number
     * @return the compared "or" version of both the Binary numbers in binary
     */
    public BinaryNumber or(BinaryNumber x) {
        boolean result[] = new boolean[9];
        for(int i = 8; i >= 0; i--){
            if(bits[i] == true || x.bits[i] == true) {
                result[i] = true; 
            } else {
                result[i] = false; 
            }
        }

        return new BinaryNumber(result); 
    }

    /**
     * Looks at two binary number and if they are the opposite of each other it returns True or else False. 
     * @param x The binary number to compare to the orginal binary number
     * @return the compared "xOr" version of both the Binary numbers in binary 
     */
    public BinaryNumber xOr(BinaryNumber x) {
        boolean result[] = new boolean[9]; 
        for(int i = 8; i >= 0; i--) {
            if(bits[i] != x.bits[i]){
                result[i] = true;  
            } else {
                result[i] = false; 
            }
        }

        return new BinaryNumber(result); 
    }

    /**
     * Converts the binary number to an int
     * @return int version of the binary number 
     */
    public int toInt() {
        int result = 0; 
        for(int i = 8; i >= 0; i--) {
            if(bits[i] == true){
                result += Math.pow(2, 8 - i); 
            } 
        }

        if(result > 255) {
            result -= 512; 
        }

        return result; 
    }

    /**
     * Converts the binary array to a String
     * @return String version of the binary array 
     */
    public String toBinaryString() {
        String result = ""; 
        for(int i = 0; i <= 8; i++){
            if(bits[i] == true){
                result += "1"; 
            } else {
                result += "0";
            }
        }

        return result; 
    }

    /**
     * Converts the Binary to a hex String
     * @return Hex string version of the binary number 
     */
    public String toHexString() {
        String hex = "0x"; 
        BinaryNumber num = this;
        int sum = 0;
        
        
        if(bits[0] == true) {
            hex = "-0x"; 
            num = this.negate(); 
        }

        for(int i = 4; i >= 1; i--) {
            if(num.bits[i] == true) {
                sum += Math.pow(2, 4 - i); 
            }
        }

        if(sum > 9){
            char a = (char)((int)'A' + (sum - 10)); 
            hex += a; 
        } else {
            hex += sum;
        }
        
        for(int i = 8; i >= 5; i--) {
            if(num.bits[i] == true){
                sum += Math.pow(2, 8 - i); 
            }
        }
        
        if(sum > 9){
            char a = (char)((int)'A' + (sum - 10)); 
            hex += a; 
        } else {
            hex += sum;
        }
        
        if(this.toInt() == -256){
            hex = "-0x100"; 
        }
        
        return hex; 
        
    }
    
    /**
     * The to string version of the Binary Number
     * @return To string version of the Binary Number 
     */
    public String toString() {
        return toBinaryString(); 
    }
}
