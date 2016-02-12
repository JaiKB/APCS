/**
 * HourlyEmployee class that creates a name, address, phone, Social Security Number, and payment for the HourlyEmployee
 */
public class HourlyEmployee extends Employee {
    
    private int hours = 0;
    
    /**
     * Creates an HourlyEmployee with a name, address, phone, Social Security Number, and their payment
     * @param name Name of Hourly Employee
     * @param address Address of Hourly Employee
     * @param phone Phone # of Hourly Employee
     * @param SSN Social Security # of Employee
     * @param rate How much Hourly Employee makes per hour 
     */
    public HourlyEmployee(String name, String address, String phone, String SSN, double rate) {
        super(name, address, phone, SSN, rate); 
    }
    
    /**
     * Gives the amount earned per hour times how many hours the Hourly Employee worked
     * @return how much the hourly employee has earned depending on the hours worked
     */
    public double pay() {
        return super.pay() * hours;  
    }
    
     /**
     * Adds the amount of hours worked for the Hourly Employee
     */
    public void addHours(int moreHours){
        hours = hours + moreHours; 
    }
    
    /**
     * Gives the toString method same as Employee with Current Hours added on 
     * @return same toString method as Employee with Current Hours added on
     */
    public String toString() {
        return super.toString() + "Current Hours: " + hours + "\n";  
    }
    
}