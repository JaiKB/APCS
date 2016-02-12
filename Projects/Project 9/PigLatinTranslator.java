
/**
 * This class checks if a letter is a vowel, translates a one word English word to Pig Latin, and translates one Pig Latin word to English
 * 
 * @author Jai Bansal 
 */
public class PigLatinTranslator implements TranslatorInterface {   
    
    /**
     * Empty constructor because constructor is not needed 
     */
    public PigLatinTranslator() {
        
    }
    
    /**
     * Checks if a letter is a vowel or not
     * @param s the letter to put in the method
     * @return true if it is a vowel and false if it isn't a vowel
     */
    public boolean isVowel(String s) {
        if(s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o") || s.equalsIgnoreCase("u") || s.equalsIgnoreCase("y")){
            return true; 
        }   
        return false; 
    }
    
    /**
     * Translates from English to Pig Latin
     * @param s one English word to put into the method
     * @return Pig Latin translation of the English word
     */
    public String translateE2P(String s) {
        int position = 0;  
        for(int i = 0; i < s.length(); i++) {
           if(isVowel(s.substring(0, 1))){
               return s.substring(0, 1) + "way"; 
            }
           if(isVowel(s.substring(i, i+1))) {
               position = i; 
               break; 
            }
        }
        
        return s.substring(position, s.length()) + s.substring(0, position) + "ay";
    }
    
    /**
     * Translates Pig Latin to English
     * @param s one Pig Latin word to put into the method
     * @return English translation of the Pig Latin word
     */
    public String translateP2E(String s) {
        return s;  
    }
}
