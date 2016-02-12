/**
 * A class representing a Line Segment.
 *
 * @author Rob Schreiber
 */
public class Line {
    private Point pointA;
    private Point pointB;
    /**
     * Creates a Line object from the two supplied points
     * 
     * @param a The point to use for point a
     * @param b The point to use for point b
     */
    public Line(Point a, Point b) {
        pointA = a;
        pointB = b;
    }
    /**
     * Calculates the slope of the line segment.
     *
     * @return The slope of the Line object.
     */
    public double getSlope() {
        if (pointA.getX() - pointB.getX() == 0) return Double.POSITIVE_INFINITY;
        else {
            return (pointA.getY() - pointB.getY()) / (pointA.getX() - pointB.getX());
        }
    }
    /**
     * Calculates the length of the line segment.
     *
     * @return The length of the Line object.
     */
    public double getLength() {
        return Math.sqrt(Math.pow((pointA.getY() - pointB.getY()), 2) + Math.pow((pointA.getX() - pointB.getX()), 2));
    }
    /**
     * Calculates the midpoint of the line segment.
     *
     * @return A Point representing the middle of the Line object.
     */
    public Point getMidpoint() {
        return new Point((pointA.getX() + pointB.getX())/2.0, (pointA.getY() + pointB.getY())/2.0);
    }
    /**
     * Returns the first point of the line segment.
     *
     * @return The first point of the Line.
     */
    public Point getPointA() {
        return pointA;
    }
    /**
     * Returns the second point of the line segment.
     *
     * @return The second point of the Line.
     */
    public Point getPointB() {
        return pointB;
    }
    /**
     * Returns the slope of line segments perpendicular to this one
     * @return The slope perpendicular to this line.
     */
    public double getPerpSlope() {
        return -(1 / getSlope());
    }
    /**
     * Returns a line segment of the same length as this line with
     * a slope perpendicular to this line running through this line's
     * midpoint
     * @return A same-length perpendicular bisector Line
     */
    public Line getPerpBisector() {
        Point mid = getMidpoint();
        double offLinePointX = 0.5 * (getPointA().getX() + 
                                      2 * getPointA().getY() +
                                      getPointB().getX() -
                                      2 * getPointB().getY());
        double offLinePointY = getPerpSlope() * (offLinePointX - mid.getX()) + mid.getY();
        return new Line(mid, new Point(offLinePointX, offLinePointY));
    }

    public String toString() {
        return pointA.toString() + " -> " + pointB.toString();
    }
}