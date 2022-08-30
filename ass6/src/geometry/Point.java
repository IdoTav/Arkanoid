//ID: 316222512

package geometry;

/**
 * The Point class implement and application a point
 * that has a x, y and can measure the distance to other points
 * and if it equal to another point.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Point {
    // define the x field
    private double x;
    // define the y field
    private double y;

    /**
     * This is the constructor method which gets
     * x and y, and build the point.
     *
     * @param x , A type of double variable that symbolizes a x in a system of axes.
     * @param y , A type of double variable that symbolizes a y in a system of axes.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This is the distance method which gets a geometry.Point
     * and return the distance from exact geometry.Point to other point.
     *
     * @param other , A type of Point which we want to find
     *              the distance between the getting point to
     *              that point.
     * @return a double variable that indicate the distance between the two points.
     */
    public double distance(Point other) {
        //Finding the distance on the X-axis.
        double distanceX = this.x - other.getX();
        //Finding the distance on the X-axis
        double distanceY = this.y - other.getY();
        // return the total distance
        return Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
    }

    /**
     * This is the equals method which gets a Point
     * and return TRUE if the points are equals and FALSE if not.
     *
     * @param other , A type of Point which we want to check
     *              if the point is equal to the other point.
     * @return a boolean variable, TRUE if the points are equal and false if they are not.
     */
    public boolean equals(Point other) {
        double epsilon = 0.00001;
        // Checks if the X and Y rates are equal
        if (Math.abs(getX() - other.getX()) < epsilon && Math.abs(getY() - other.getY()) < epsilon) {
            // if they do return true
            return true;
        }
        // else return false
        return false;
    }

    /**
     * This is the get method which return the x field of the point.
     *
     * @return a double variable which indicate the x field of the point.
     */
    public double getX() {
        //return the x field.
        return this.x;
    }

    /**
     * This is the get method which return the y field of the point.
     *
     * @return a double variable which indicate the y field of the point.
     */
    public double getY() {
        //return the y field.
        return this.y;
    }
}