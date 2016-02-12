/**
 * A class representing a Cartesian 2-D point.
 *
 * @author Rob Schreiber
 */
public class Point {
    private double xVal;
    private double yVal;
    /**
     * Creates a Point object
     * @param  x The Point's x value
     * @param  y The Point's y value
     */
    public Point (double x, double y) {
        xVal = x;
        yVal = y;
    }
    /**
     * Returns the Point's X Value.
     * @return The Point's X Value
     */
    public double getX() {
        return xVal;
    }
    /**
     * Returns the Point's Y Value.
     * @return The Point's Y Value.
     */
    public double getY() {
        return yVal;
    }
    /**
     * Creates a String representation of the Point
     * @return A String representing the Point in the form (x, y).
     */
    public String toString() {
        return "(" + xVal + ", " + yVal +")";
    }
}