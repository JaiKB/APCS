
/**
 * Creates polygon and returns properties of it. 
 * 
 * @author Jai Bansal
 */
public class Polygon extends Shape
{
    Line[] sides = new int[7]; 

    /**
     * Constructor for objects of class Polygon
     * @param Line[] sides Takes an array of line values for the polygon
     */
    public Polygon(Line[] sides)
    {
        this.sides = sides; 
    }
    /**
     * Gets the sides of the polygon 
     * @return sides of the polygon
     */
    public Line[] getSides() 
    {
        return sides; 
    }
    /**
     * Gets the peimeter of the polygon
     * @return perimeter of the polygon
     */
    public double getPerimeter()
    {
        double totalLength = 0; 
        
        for (Line x: sides)
        {
            totalLength = totalLength + x.getLength(); 
        }
        
        return totalLength; 
    }
    /** 
     * Gets the area of the polygon 
     * @return area of the polygon
     */
    public double getArea()
    { 
        
        return 1.0; 
    }
}
