/**
 * Editor2 is an implmentation of the editor 
 * @author Jai Bansal 
 */
public class  Editor2 implements Ed
{ 
    private String text; 
    private int position; 
    
  /**
   * Constructor creates the objects for text and position
   * @param text The string input of what the user wants to type in
   * @param pos The position the user wants to have in that string
   */
    public Editor2(String text, int pos) {
        this.text = text; 
        position = pos; 
    }
    
  /**
   * Creating an empty editor where the text is nothing and the position is 0
   */ 
    public Editor2() {
        text = ""; 
        position = 0; 
    }
    
  /**
   * Gets the part left of the cursor for the text
   * @return left part of the cursor or first part of the string
   */
    public String getFirst(){
        String first = text.substring(0, position); 
        return first; 
    }
    
  /**
   * Gets the part right of the cursor for the text
   * @return right part of the cursor or last part of the string
   */  
    public String getRest() {
        String rest = text.substring(position, text.length()); 
        return rest; 
    }
    
  /**
   * Moves the cursor to the right 
   * @return new Editor2 object with a new cursor position and text
   */
    public Ed rightArrow() {
        if(position == text.length()) {
            return this; 
        }
        position = position + 1; 
        return new Editor2(text, position); 
    }
    
  /**
   * Moves the cursor to the left
   * @return new Editor2 object with a new cursor position and text
   */ 
    public Ed leftArrow() {
        if(position == 0) {
            return this; 
        }
        position = position - 1;
        return new Editor2(text, position); 
    }
    
  /**
   * Deletes character to the right of the cursor
   * @return new text with one character deleted to the right and updated position
   */
    public Ed delete() {
        if(position == text.length()){
            return this;
        }
        String newText = text.substring(0, position) + text.substring(position + 1, text.length()); 
        return new Editor2(newText, position); 
    }
    
  /**
   * Deletes the character to the left of the cursor
   * @return new Editor2 object with text with one character deleted to the left and updated position
   */  
    public Ed backspace() {
        if(position == 0) {
            return this; 
        }
        String newText = text.substring(0, position - 1) + text.substring(position, text.length());
        position = position - 1; 
        return new Editor2(newText, position); 
    }
    
  /**
   * Inserts any character the user types in 
   * @param c Takes in the new string to put in
   * @return new Editor2 object with new text inserted and position updated 
   */
    public Ed insertString(String c)
    {
        String newText = text.substring(0, position) + c; 
        return new Editor2(newText, position + 1); 
    }  
    
  /**
   * Moves the cursor all the way to the left of the text
   * @return new Editor2 object with new text and position equalling 0 
   */
    public Ed homeKey() {
        position = 0; 
        return new Editor2(text, position); 
    }
    
  /**
   * Moves the cursor all the way to the right of the text
   * @return new Editor2 object with new text and position equalling all the way to the right of the string
   */
    public Ed endKey() {
        position = text.length(); 
        return new Editor2(text, position); 
    }
    
  /**
   * Gives a string representation of what is being displayed 
   * @return string representation of the string being displayed 
   */
    public String toString() {
        String first = text.substring(0, position); 
        String rest = text.substring(position, text.length()); 
        return first + "|" + rest; 
    }
}