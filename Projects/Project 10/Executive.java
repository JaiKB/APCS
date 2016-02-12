/**
 * Executive class that gives an executive with a name, address, phone, Social Security Number, and pay. 
 */
public class Executive extends Employee {
    
    private double rate; 
    private double bonus = 0; 
    
    /**
     * Creates an executive with a name, address, phone, Social Security Number, and payment. Superclasses Employee's constructor to do so
     * @param name Name of the Executive
     * @param address Address of the Executive
     * @param phone Phone # of the Executive
     * @param SSN Social Security # for the Executive 
     * @param rate How much the Executive gets paid
     */
    public Executive(String name, String address, String phone, String SSN, double rate) {
        super(name, address, phone, SSN, rate); 
    }
    
    /**
     * Gives how much the Executive is paid and adds on any bonus if avaiable 
     * @return executives payment plus bonus 
     */
    public double pay() {
        return super.pay() + bonus; 
    }
    
    /**
     * String representation of the objects, same as Employee
     * @return string representation of the objects same as Employee
     */
    public String toString() {
        return super.toString(); 
    }
    
    /**
     * Assigns the bonus variable to the amount of bonus given to the Executive
     */
    public void awardBonus(double execBonus) {
        bonus += execBonus; 
    }
}