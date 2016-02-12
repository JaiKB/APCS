
/**
 * Project 1 dealing with state variables, methods, and constructors using Technology/Smartphone related 
 * variables
 * 
 * @author Jai Bansal
 */
public class Technology
{
    // instance variables - replace the example below with your own
    private int devices; 
    private String deviceName; 
    private int cost; 
    /**
     * Constructor for objects of class Technology
     * @param number Number of smartphone devices
     * @param name Name of the smartphone device
     * @param money How much money the smartphoen costs
     */
    public Technology(int number, String name, int money)
    {
        // initialise instance variables
        this.devices = number; 
        this.deviceName = name; 
        this.cost = money; 
    }
    
    /**
     * Adds 1 to the number of devices 
     */
    
    public void addDevices(){
        this.devices += 1;
    }
    
    /**
     * @param newName Sets the current name to the new name assigned
     * Sets a new name for the device
     * @return new device name 
     */
    public String setName(String newName) {
       this.deviceName = newName;
       return deviceName; 
    }
    
    /**
     * Changes the cost by adding 10 to it. 
     */
    public void changeCost() {
       this.cost = this.cost + 10; 
    }
}
