/**
 * Employee class that creates a name, address, phone, Social Security Number, and returns the pay for the Employee
 * @author Jai Bansal 
 */
public class Employee extends StaffMember {
    
    private String SSN; 
    private double rate; 
    
    /**
     * Creats an employee with a name, address, phone, Social Security Number, and his pay. 
     * @param name Name of the employee
     * @param address Address of the employee  
     * @param phone Phone # of the employee
     * @param SSN Social Security # for the employee
     * @param rate How much the employee gets paid 
     */
    public Employee(String name, String address, String phone, String SSN, double rate) {
        super(name, address, phone); 
        this.SSN = SSN; 
        this.rate = rate; 
    }
    
    /**
     * Gives the amount paid to the employee
     * @return payment of the employee
     */
    public double pay() {
        return rate;  
    }
    
    /**
     * Gives the String representation just like StaffMember's toString method but with Social Security added on
     * @return string represetation just like StaffMember's toString method but with Social Security added on 
     */
    public String toString() {
        return super.toString() + "Social Security Number: " + SSN + "\n";  
    }
}