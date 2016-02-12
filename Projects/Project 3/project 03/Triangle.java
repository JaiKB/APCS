
/**
 * Creates three points to connect to form a triangle and returns properties of that triangle
 * @author Jai Bansal and Tony Brar
 */
public class Triangle
{
    private Point pointA;
    private Point pointB;
    private Point pointC;

    /**
     * Constructor for objects of class Triangle 
     * @param a First point of the triangle
     * @param b Second point of the triangle
     * @param c Third point of the triangle 
     */
    public Triangle(Point a, Point b, Point c)
    {
        this.pointA = a;
        this.pointB = b;
        this.pointC = c;
    }
    
    /**
     * Gets first point of the triangle
     * @return the first point of the triangle
     */
    public Point getPointA()
    {
        return this.pointA;
    }
    
    /**
     * Gets second point of the triangle
     * @return the second point of the triangle
     */
    public Point getPointB()
    {
        return this.pointB;
    }
    
    /**
     * Gets third point of the triangle
     * @return the third point of the triangle
     */
    public Point getPointC()
    {
        return this.pointC;
    }
    
    /**
     * Gets an array of sides of the triangle
     * @return array of the sides
     */
    public Line[] getSides()
    {
        Line[] sides = new Line[3];
        Line lineAB = new Line(pointA, pointB);
        Line lineBC = new Line(pointB, pointC);
        Line lineCA = new Line(pointC, pointA);
        sides[0] = lineAB;
        sides[1] = lineBC;
        sides[2] = lineCA;
        return sides;
    }
    
    /**
     * Gets the point of the center of the triangle 
     * @return point of the center of the triangle
     */
    public Point getCenter()
    {
        Point center = new Point((pointA.getX() + pointB.getX() + pointC.getX())/3, (pointA.getY() + pointB.getY() + pointC.getY())/3);
        return center; 
    }
    
    /** 
     * Gets the perimeter of the triangle
     * @return double value of the perimeter of the triangle 
     */
    public double getPerimeter() 
    {
        Line lineAB = new Line(pointA, pointB);
        Line lineBC = new Line(pointB, pointC);
        Line lineCA = new Line(pointC, pointA);
        return lineAB.getLength() + lineBC.getLength() + lineCA.getLength(); 
    }
    
    /**
     * Gets the area of the triangle 
     * @returns double value of the area of the triangle
     */
    public double getArea()
    {
        Line lineAB = new Line(pointA, pointB);
        Line lineBC = new Line(pointB, pointC);
        Line lineCA = new Line(pointC, pointA);
        double s = getPerimeter()/2; 
        return Math.sqrt(s*(s-lineAB.getLength())*(s-lineBC.getLength())*(s-lineCA.getLength()));
    }
    
    /**
     * Gets the string representation of the triangle
     * @return string representation of the triangle
     */
    public String toString()
    {
        return pointA.toString() + " <-> " + pointB.toString() + " <-> " + pointC.toString();
    }
    
    /**
     * Gets the altitude of the triangle
     * @return altitude of the triangle
     */
    public Line getAltitude() 
    {
        return null; 
    }
}
