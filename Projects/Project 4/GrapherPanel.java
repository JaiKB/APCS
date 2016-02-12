import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Grapher Panel creates a JFrame that displays Point, Line, and Polygon objects.
 * Objects to be drawn are stored in arrays and drawn in the paint method.
 * @author Rob Schreiber
 */
public class GrapherPanel extends JPanel{
    private Graphics g;
    private JFrame frame;
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Line> lines = new ArrayList<Line>();
    private ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    /**
     * Creates and displays a JFrame and adds a GrapherPanel object to it.
     */
    public GrapherPanel() {
        super();
        frame = new JFrame("Grapher");
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setSize(500, 525);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    /**
     * Draws the GrapherPanel and stored geometric objects.
     *
     * @param g Graphics object used for drawing.
     */
    protected void paintComponent(Graphics g) {
        this.g = g;
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.RED);
        g.drawLine(0, 250, 500, 250);
        g.drawLine(250, 0, 250, 500);
        for (int i = 0; i < 500; i += 25) {
            g.drawLine(i, 260, i, 240);
            g.drawLine(240, i, 260, i);
        }
        for (Point p : points) paintPoint(p);
        for (Line l : lines) paintLine(l);
        for (Polygon p : polygons) paintPolygon(p);
        for (Triangle t : triangles) paintTriangle(t);
        for (Circle t : circles) paintCircle(t);
    }
    /**
     * Draws a Point object on the GrapherPanel as a 5 pixel radius circle
     * centered on the Point object's x and y values scaled by 25 pixels
     * per integer value and centered around the origin at 250, 250.
     *
     * @param p The Point object to paint.
     */
    private void paintPoint(Point p) {
        g.setColor(Color.BLUE);
        g.fillOval(250 + (int)(p.getX()*25) - 5, 250 - (int)(p.getY()*25) - 5, 10, 10);
    }
    /**
     * Draws a Line object on the GrapherPanel as a 1 pixel wide line
     * ending on the points defining the Line object.
     *
     * @param The Line to paint.
     */
    private void paintLine(Line l) {
        g.setColor(Color.YELLOW);
        g.drawLine(250 + (int)(l.getPointA().getX() * 25),
                   250 - (int)(l.getPointA().getY() * 25),
                   250 + (int)(l.getPointB().getX() * 25),
                   250 - (int)(l.getPointB().getY() * 25));
    }
    /**
     * Draws a Polygon object on the GrapherPanel as a series of 1
     * pixel wide lines contained in the polygon's sides variable.
     *
     * @param The Polygon to paint.
     */
    private void paintPolygon(Polygon p) {
        g.setColor(Color.GREEN);
        for (Line l : p.getSides()) {
            g.drawLine(250 + (int)(l.getPointA().getX() * 25),
                   250 - (int)(l.getPointA().getY() * 25),
                   250 + (int)(l.getPointB().getX() * 25),
                   250 - (int)(l.getPointB().getY() * 25));
        }
    }
    /**
     * Draws a Circle object on the GrapherPanel as a series of 1
     * pixel wide lines contained in the Circle's sides variable.
     *
     * @param The Circle to paint.
     */
    private void paintCircle(Circle c) {
        g.setColor(Color.GREEN);
        g.drawOval((int)(c.getCenter().getX() - c.getRadius()),
                   (int)(c.getCenter().getY() - c.getRadius()),
                   (int)(c.getRadius() * 2),
                   (int)(c.getRadius() * 2));
    }
    /**
     * Draws a Triangle object on the GrapherPanel as a series of 1
     * pixel wide lines contained in the Triangle's sides variable.
     *
     * @param The Triangle to paint.
     */
    private void paintTriangle(Triangle t) {
        g.setColor(Color.GREEN);
        for (Line l : t.getSides()) {
            g.drawLine(250 + (int)(l.getPointA().getX() * 25),
                   250 - (int)(l.getPointA().getY() * 25),
                   250 + (int)(l.getPointB().getX() * 25),
                   250 - (int)(l.getPointB().getY() * 25));
        }
    }
    /**
     * Adds a Point object to the list of Points to draw.
     *
     * @param The Point to be added to the draw list.
     */
    public void plotPoint(Point p) {
        points.add(p);
        this.repaint();
    }
    /**
     * Adds a Line object to the list of Lines to draw.
     *
     * @param The Line to be added to the draw list.
     */
    public void plotLine(Line l) {
        lines.add(l);
        this.repaint();
    }
    /**
     * Adds a Polygon object to the list of Polygons to draw.
     *
     * @param The Polygon to be added to the draw list.
     */
    public void plotPolygon(Polygon p) {
        polygons.add(p);
        this.repaint();
    }
    /**
     * Adds a Triangle object to the list of Triangles to draw.
     *
     * @param The Triangle to be added to the draw list.
     */
    public void plotTriangle(Triangle p) {
        triangles.add(p);
        this.repaint();
    }
    /**
     * Adds a Circle object to the list of Circles to draw.
     *
     * @param The Circle to be added to the draw list.
     */
    public void plotCircle(Circle p) {
        circles.add(p);
        this.repaint();
    }
}
