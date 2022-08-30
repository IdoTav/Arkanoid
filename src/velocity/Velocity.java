//316222512

package velocity;


import geometry.Point;

/**
 * The Velocity class connects two points - a start point and an end point.
 * Line have length, and may intersect with other lines and it can also tell if
 * it is the same as another line segment.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Velocity {
    //define the field
    private double dx;
    //define the field
    private double dy;

    /**
     * This is the constructor method which gets the change in the x axes, and the
     * change in the y axes and create the velocity.
     *
     * @param dx , A type of double variable that symbolizes the change in the x axes.
     * @param dy , A type of double variable that symbolizes the change in the y axes.
     */
    public Velocity(double dx, double dy) {
        // define the change in the x axes
        this.dx = dx;
        // define the change in the y axes
        this.dy = dy;
    }

    /**
     * This is the get method which return the dx field of the ball.
     *
     * @return a double variable which indicate the change in the x axes
     */
    public double getDX() {
        //return the dx
        return this.dx;
    }

    /**
     * This is the get method which return the dy field of the ball.
     *
     * @return a double variable which indicate the change in the y axes.
     */
    public double getDY() {
        //return the dy
        return this.dy;
    }

    /**
     * This is the applyToPoint method which return the point that we want the ball to move next.
     *
     * @param p , a variable which indicate the current center of the ball.
     * @return a Point variable which indicate next center of the ball
     */
    public Point applyToPoint(Point p) {
        // define the new x of the center of the ball
        double newX = p.getX() + getDX();
        // define the new y of the center of the ball
        double newY = p.getY() + getDY();
        //return the new center of the ball.
        return new Point(newX, newY);
    }

    /**
     * This is the fromAngleAndSpeed method which return the velocity from the given angle and speed.
     *
     * @param angle , a variable which indicate the angle of the ball.
     * @param speed , a variable which indicate the speed of the ball.
     * @return a Velocity variable which indicate the velocity of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double rAngle = Math.toRadians(angle);
        double dx = speed * Math.cos(rAngle);
        double dy = speed * Math.sin(rAngle);
        return new Velocity(dx, dy);
    }
}