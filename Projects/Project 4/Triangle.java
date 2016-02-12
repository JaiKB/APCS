/**
 * A class representing a triangle.
 *
 * @author Rob Schreiber
 */
public class Triangle {
    private Point pointA, pointB, pointC;
    /**
     * Creates a triangle from 3 points
     * @param  a The first point
     * @param  b The second point
     * @param  c The third point
     */
    public Triangle(Point a, Point b, Point c) {
        pointA = a;
        pointB = b;
        pointC = c;
    }
    /**
     * Returns the first point
     * @return The Triangle's first point
     */
    public Point getPointA() {
        return pointA;
    }
    /**
     * Returns the second point
     * @return The Triangle's second point
     */
    public Point getPointB() {
        return pointB;
    }
    /**
     * Returns the third point
     * @return The Triangle's third point
     */
    public Point getPointC() {
        return pointC;
    }
    /**
     * Returns 3 lines that represent the sides of the triangle
     * @return An array of 3 lines reprenting the Triangle's 3 sides
     */
    public Line[] getSides() {
        Line line1 = new Line(pointA, pointB);
        Line line2 = new Line(pointB, pointC);
        Line line3 = new Line(pointC, pointA);
        Line[] sides = {line1, line2, line3};
        return sides;
    }
    /**
     * Calculates and returns the perimeter of the triangle
     * @return the triangle's perimeter
     */
    public double getPerimeter() {
        double perimeter = 0;
        Line[] sides = getSides();
        for (Line l : sides) {
            perimeter += l.getLength();
        }
        return perimeter;
    }
    /**
     * Calculates and returns an altitude of the triangle
     * @return An altitude of the triangle
     */
    public Line getAltitude() {
        Line base = new Line(pointB, pointC);
        double altitudeSlope = base.getPerpSlope();
        //D is a point on BC such that AD perp BC
        double ax = pointA.getX();
        double bx = pointB.getX();
        double cx = pointC.getX();
        double ay = pointA.getY();
        double by = pointB.getY();
        double cy = pointC.getY();
        //Vertical case:
        if (Double.isInfinite(base.getSlope()))
            return new Line(pointA, new Point(ax, by));
        //There has to be an easier way...
        //This sorcery brought to you by Wolfram Alpha
        double dx = (ax*bx/(by-cy) - ax*cx/(by-cy) - ay*cy/(by-cy) +
                     ay*by/(by-cy) + cx*(by-cy)/(bx-cx) - cy) /
                    ((by-cy)/(bx-cx) + bx/(by-cy) - cx/(by-cy));
        double dy = base.getSlope()*(dx - cx) + cy;

        return new Line(pointA, new Point(dx, dy));
    }
    /**
     * Calculates and returns the area of the triangle
     * This one uses 1/2 b*h
     * @return the area of the triangle
     */
    public double getArea() {
        Line alt = getAltitude();
        Line base = new Line(pointB, pointC);
        double area = 0.5 * alt.getLength() * base.getLength();
        return area;
    }
    /**
     * Calculates and returns the area of the triangle
     * This one uses 1/2 a*b cos(C)
     * @return the area of the triangle
     */
    public double getArea2() {
        Line side1 = new Line(pointA, pointB);
        Line side2 = new Line(pointA, pointC);
        double angleCAB = Math.acos(((pointB.getX() - pointA.getX()) * (pointC.getX() - pointA.getX())  +
                                     (pointB.getY() - pointA.getY()) * (pointC.getY() - pointA.getY())) /
                                     (side1.getLength() * side2.getLength()));
        double area = 0.5 * side1.getLength() * side2.getLength() * Math.sin(angleCAB);
        return area;
    }
    public double getArea3() {
        double s = getPerimeter()/2;
        double product = s;
        for (Line side : getSides()) {
            product *= s - side.getLength();
        }
        return Math.sqrt(product);
    }
    /**
     * Calculates and returns the center of the triangle
     * @return the center of the triangle
     */
    public Point getCenter() {
        double centerX = (pointA.getX() + pointB.getX() + pointC.getX()) / 3;
        double centerY = (pointA.getY() + pointB.getY() + pointC.getY()) / 3;
        return new Point(centerX, centerY);
    }
    /**
     * Returns a string version of the Triangle
     * @return A string version of the Triangle
     */
    public String toString() {
        return pointA.toString() + " <-> " + pointB.toString() + " <-> " + pointC.toString();
    }
}