//316222512

package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * The Rectangle class, rectangle has a upper left point width and height, rectangle also know to find all the
 * intersection points with lines.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * This is the constructor method which gets upper left point, width and height and build a rectangle.
     *
     * @param upperLeft , A type of Point variable that symbolizes the upper left point of the rectangle.
     * @param width     , A type of double variable that symbolizes the width of the rectangle.
     * @param height    , double variable that symbolize the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * This is the intersectionPoints method which find out all the intersection point with a given line between the
     * rectangle.
     *
     * @param line , A type of Lien variable that symbolizes the line that we want to find the intersection point
     *             between the line and the rectangle.
     * @return return arrayList of all the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // create arraylist of geometry.Point
        List<Point> intersectionL = new ArrayList<Point>();
        //set the point variables
        Point lowerLeft = new Point(upperLeft.getX(), upperLeft.getY() + getHeight());
        Point upperRight = new Point(upperLeft.getX() + getWidth(), upperLeft.getY());
        Point lowerRight = new Point(upperLeft.getX() + getWidth(), upperLeft.getY() + getHeight());
        //set the geometry.Line variables
        Line line1 = new Line(lowerLeft, upperLeft), line2 = new Line(lowerRight, upperRight);
        Line line3 = new Line(upperLeft, upperRight), line4 = new Line(lowerLeft, lowerRight);
        //check if there is an intersection point
        if (line1.intersectionWith(line) != null) {
            //add to the arraylist
            intersectionL.add(line1.intersectionWith(line));
        }
        //check if there is an intersection point
        if (line3.intersectionWith(line) != null) {
            //add to the arraylist
            intersectionL.add(line3.intersectionWith(line));
        }
        //check if there is an intersection point
        if (line2.intersectionWith(line) != null) {
            //add to the arraylist
            intersectionL.add(line2.intersectionWith(line));
        }
        //check if there is an intersection point
        if (line4.intersectionWith(line) != null) {
            //add to the arraylist
            intersectionL.add(line4.intersectionWith(line));
        }
        //return the arrayList
        return intersectionL;
    }

    /**
     * This is the get method which return the width of the rectangle.
     *
     * @return return the width of the rectangle.
     */
    public double getWidth() {
        //return the width
        return this.width;
    }

    /**
     * This is the get method which return the height of the rectangle.
     *
     * @return return the height of the rectangle.
     */
    public double getHeight() {
        //return the height
        return this.height;
    }

    /**
     * This is the get method which return the upper left point of the rectangle.
     *
     * @return return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        //return the upper left point
        return this.upperLeft;
    }

    /**
     * This is the setUpperLeft method which set the upper left point.
     *
     * @param x , A int type which indicate the x axes.
     * @param y , A int type which indicate the y axes
     */
    public void setUpperLeft(int x, int y) {
        this.upperLeft = new Point(x, y);
    }
}