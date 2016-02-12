/**
 * Abstract super class for all the other classes.
 * @author Jai Bansal 
 */
public abstract class StaffMember {
    
    private 
    
    String name; 
    private String address; 
    private String phone; 
    
    /**
     * Constuctor creates name, address, and phone objects
     * @param name Takes a String representation for name
     * @param address Takes a String representation for address
     * @param phone Takes a String representation for phone
     */
    public StaffMember(String name, String address, String phone){  
        this.name = name; 
        this.address = address; 
        this.phone = phone;    
    }
    
    /**
     * Makes a string representation of name, address, and phone
     * @return string representation for name, address, and phone
     */
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phone + "\n"; 
    }
    
    /**
     * Abstract method that is implemented in other methods to be caleed. 
     */
    public abstract double pay(); 
}