
/**
 * Makes a circle and returns some properities of the cricle
 * 
 * @author Jai Bansal
 */
public class Circle extends Shape
{
    Point pointC; 
    double radius; 

    /**
     * Constructor for objects of class Circle
     * @param c Takes one point value to make the circle
     * @param radius Asks for how big the radius has to be
     */
    public Circle(Point c, double radius)
    {
        this.pointC = c; 
        this.radius = radius; 
    }
    
    /**
     * Gets the center point of the circle
     * @return the center point of the circle
     */
    public Point getCenter() 
    {   
        return this.pointC; 
    }
    /**
     * Gets the radius of the circle
     * @return radius of the circle
     */
    public double getRadius () 
    {
        return this.radius; 
    }
    /**
     * Gets the Perimeter/Circumference of the circle
     * @return perimeter/circumference of the circle
     */
    public double getPerimeter()
    {
        return 2*Math.PI*this.radius; 
    }
    /**
     * Gets the area of the circle
     * @return area of the circle
     */
    public double getArea() 
    {
        return Math.PI*Math.pow(this.radius, 2); 
    }
}
