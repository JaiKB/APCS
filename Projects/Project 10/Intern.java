/**
 * Intern class that creates an intern with a name, address, phone, pay, and a toString method. 
 * @author Jai Bansal
 */
public class Intern extends StaffMember {
    
    /**
     * Creates an Intern with a name, address, and a phone
     * @param name Name of the Intern
     * @parm address Address of the Intern
     * @param phone Phone # of the Intern
     */
    public Intern(String name, String address, String phone) {      
        super(name, address, phone);        
    }
    
   /**
    * Gives the pay for the intern in this case always 0
    * @return pay for the intern
    */
    public double pay() {
        return 0.0; 
    }
    
    /**
     * The String representation of the Intern's name, address, and phone
     * @return string representation of the Intern's name, address, and phone
     */
    public String toString() {
        return super.toString(); 
    }
}