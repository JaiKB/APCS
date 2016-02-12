
/**
 * Creates x and y point values, returns both the x and y point values and also a string representation of that point.
 * @author Jai Bansal
 */
public class Point
{
    // instance variables - replace the example below with your own
    private double x; 
    private double y; 

    /**
     * Constructor for objects of class Point
     *@param x The x value for the point
     *@param y The y value for the point
     */
    public Point(double x, double y)
    {
       this.x = x; 
       this.y = y; 
    }
    /**
     * @return The x value of the point
     */
    public double getX()
    {
        return this.x; 
    }
    /**
     * @return The y value of the point
     */
    public double getY()
    {
        return this.y; 
    }
    /**
     * @return The x and y value in string format 
     */
    public String toString()
    {
        return "(" + this.x + ", " + this.y + ")"; 
    }
}
