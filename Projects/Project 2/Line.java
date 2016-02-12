
/**
 * Creates a line for the two given points and gives slope, midpoint, perpindicular slope, length, and string representation of that line values. 
 * 
 * @author Jai Bansal 
 */
public class Line
{
    private Point pointA; 
    private Point pointB; 

    /**
     * Constructor for objects of class Line
     * @param pointA Variable for first point value 
     * @param pointB Variable for the second value
     */
    public Line(Point a, Point b)
    {
        this.pointA = a; 
        this.pointB = b; 
    }
    /**
     * @return the first point value 
     */
    public Point getPointA()
    {
        return this.pointA; 
    }
    /**
     * @return the second point value
     */
    public Point getPointB() 
    {
        return this.pointB; 
    }
    /**
     * @returns the slope of the line
     * @param x1 X value of Point A
     * @param x2 X value of Point B
     * @param y1 Y value of Point A
     * @param y2 Y value of Point B
     */
    public double getSlope()
    {
        double x1; 
        double x2; 
        double y1; 
        double y2;
        
        x1 = this.pointA.getX(); 
        x2 = this.pointB.getX(); 
        y1 = this.pointA.getY(); 
        y2 = this.pointB.getY(); 
        
        return (y2 - y1)/(x2 - x1); 
        
    }
    /**
     * @return the length of the line
     * @param x1 X value of Point A
     * @param x2 X value of Point B
     * @param y1 Y value of Point A
     * @param y2 Y value of Point B
     */
    public double getLength() 
    {
        
        double x1 = this.pointA.getX(); 
        double x2 = this.pointB.getX(); 
        double y1 = this.pointA.getY(); 
        double y2 = this.pointB.getY();
        
        return Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))); 
    
    }
    /**
     *@return the midpoint of the line
     *@param x1 X value of Point A
     *@param x2 X value of Point B
     *@param y1 Y value of Point A
     *@param y2 Y value of Point B
     */
    public Point getMidpoint() 
    {
        double x1 = this.pointA.getX(); 
        double x2 = this.pointB.getX(); 
        double y1 = this.pointA.getY(); 
        double y2 = this.pointB.getY(); 
        
        double midpointX = (x1 + x2)/2; 
        double midpointY = (y1 + y2)/2; 
        
        Point midpoint = new Point(midpointX, midpointY); 
        
        return midpoint; 
        
    }
        
    /**
     * @return a slope perpendicular to the slope of this line
     * @param x1 X value of Point A
     * @param x2 X value of Point B
     * @param y1 Y value of Point A
     * @param y2 Y value of Point B
     * 
     */
    public double getPerpSlope() 
    {
        double x1; 
        double x2; 
        double y1; 
        double y2;
        
        x1 = this.pointA.getX(); 
        x2 = this.pointB.getX(); 
        y1 = this.pointA.getY(); 
        y2 = this.pointB.getY(); 
        
        return -((x2 - x1)/(y2 - y1)); 
       
        
    }
    /**
     * @return a string representation of the line
     * @param x1 X value of Point A
     * @param x2 X value of Point B
     * @param y1 Y value of Point A
     * @param y2 Y value of Point B
     */
    public String toString() 
    {
        return pointA.toString() + " -> " + pointB.toString(); 
    }
    /**
     * @returns the perpindicular bisector of the line generated but right now it returns null. 
     */
    public Line getPerpBisector() 
    {
        /**
        double x1 = this.pointA.getX(); 
        double x2 = this.pointB.getX(); 
        double y1 = this.pointA.getY(); 
        double y2 = this.pointB.getY(); 
        
        double midpointX = (x1 + x2)/2; 
        double midpointY = (y1 + y2)/2; 
        
        double length;
        
        double perpSlope; 
        
        double yNew; 
        double xNew; 
        
        Point midpoint = new Point(midpointX, midpointY); 
        
        length = Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2))); 
        
        perpSlope = -((x2 - x1)/(y2 - y1));
        
        if (perpSlope > 0) {
        yNew = (Math.sqrt(((Math.pow(length, 2))/((Math.pow(perpSlope, 2))+ 1)))) + midpointY;
        xNew = (Math.sqrt(((Math.pow(perpSlope, 2))*(Math.pow(length, 2)))/((Math.pow(perpSlope, 2))+ 1))) + midpointX; 
        Point perpBisector = new Point(xNew, yNew); 
        return new Line(midpoint, perpBisector);  
    } else if(perpSlope < 0) {
        yNew = (-(Math.sqrt(((Math.pow(length, 2))/((Math.pow(perpSlope, 2))+ 1)))))+ + midpointY;
        xNew = (Math.sqrt(((Math.pow(perpSlope, 2))*(Math.pow(length, 2)))/((Math.pow(perpSlope, 2))+ 1))) + midpointX; 
        Point perpBisector = new Point(xNew, yNew); 
        return new Line(midpoint, perpBisector);   
    }
    */

       
        return null; 
    }
    
}   
