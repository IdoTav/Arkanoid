//ID: 316222512

package geometry;

import velocity.Velocity;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * The Line class connects two points - a start point and an end point.
 * geometry.Line have length, and may intersect with other lines and it can also tell if
 * it is the same as another line segment.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Line {
    //define the start point
    private Point start;
    //define the end point
    private Point end;

    /**
     * This is the constructor method which gets
     * start and end points are create a line.
     *
     * @param start , A type of geometry.Point variable that symbolizes a start point in a system of axes.
     * @param end   , A type of geometry.Point variable that symbolizes an end point in a system of axes.
     */
    public Line(Point start, Point end) {
        if (start.getX() <= end.getX()) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    /**
     * This is the constructor method which gets 4 doubles,
     * and create a line.
     *
     * @param x1 , A type of double variable that symbolizes a x coordinate in a system of axes.
     * @param y1 , A type of double variable that symbolizes a y coordinate in a system of axes.
     * @param x2 , A type of double variable that symbolizes a x coordinate in a system of axes.
     * @param y2 , A type of double variable that symbolizes a y coordinate in a system of axes.
     */
    public Line(double x1, double y1, double x2, double y2) {
        // checks what is the start x
        if (x1 <= x2) {
            // create the start and end points
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            //creates the start and end points
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
    }

    /**
     * This is the length method which calculate the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        //return the length of the line.
        return start().distance(end);
    }

    /**
     * This is the middle method which returns the middle point of the line.
     *
     * @return the middle point of the line.
     */
    public Point middle() {
        // find the middle X coordinate.
        double middleX = (start.getX() + end.getX()) / 2;
        // find the middle Y coordinate.
        double middleY = (start.getY() + end.getY()) / 2;
        //return the the middle point
        return new Point(middleX, middleY);
    }

    /**
     * This is the start method which returns start point of the line.
     *
     * @return the the start point of the line.
     */
    public Point start() {
        //return the start point of the line
        return this.start;
    }

    /**
     * This is the end method which returns start point of the line.
     *
     * @return the the end point of the line.
     */
    public Point end() {
        //return the end point of the line.
        return this.end;
    }

    /**
     * This is the findIncline method which gets a geometry.Line variable and return his incline.
     *
     * @param other , A line variable that we want to find his incline
     * @return a double variable that he is the incline of the line.
     */
    private double findIncline(Line other) {
        // Finding the change in the X-axis
        double inclineX = other.start().getX() - other.end().getX();
        //Finding the change in the Y-axis
        double inclineY = other.start().getY() - other.end().getY();
        // if the change in the X-axis is 0
        if (inclineX == 0) {
            //return the incline is infinity
            inclineX = Double.POSITIVE_INFINITY;
            return inclineX;
        }
        //return the incline.
        return inclineY / inclineX;
    }

    /**
     * This is the findIncline method which gets a geometry.Line variable and return his incline.
     *
     * @return a double variable that he is the incline of the line.
     */
    private double findIncline() {
        // Finding the change in the X-axis
        double inclineX = this.start().getX() - this.end().getX();
        // Finding the change in the Y-axis
        double inclineY = this.start().getY() - this.end().getY();
        // if the change in the X-axis is 0
        if (inclineX == 0) {
            //return the incline is infinity
            inclineX = Double.POSITIVE_INFINITY;
            return inclineX;
        }
        //return the incline
        return inclineY / inclineX;
    }

    /**
     * This is the findFreeVariable method which gets a geometry.Line variable and return his free variable.
     *
     * @param other , A line variable that we want to find his free variable
     * @return a double variable that he is the free variable of the line.
     */
    private double findFreeVariable(Line other) {
        // find the incline.
        double incline = findIncline(other);
        // check if the incline is infinity
        if (incline == Double.POSITIVE_INFINITY) {
            //return 0
            return 0;
        }
        // find the free Variable
        double fVariable = other.start().getY() - incline * (other.start().getX());
        //return the free variable
        return fVariable;
    }

    /**
     * This is the findFreeVariable method which gets a geometry.Line variable and return his free variable.
     *
     * @return a double variable that he is the free variable of the line.
     */
    private double findFreeVariable() {
        // find the incline.
        double incline = findIncline();
        // check if the incline is infinity
        if (incline == Double.POSITIVE_INFINITY) {
            //return 0
            return 0;
        }
        // find the free Variable
        double fVariable = start.getY() - incline * (start().getX());
        //return the free variable
        return fVariable;
    }

    /**
     * This is the isPoint method which finds out if the line is actually a point.
     *
     * @return a boolean variable , TRUE if the line is point and false if the line is not point.
     */
    private boolean isPoint() {
        //checks if the start point equals to the end point
        if (start().getX() == end().getX() && start().getY() == end().getY()) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the isPoint method which finds out if the line is actually a point.
     *
     * @param other , a geometry.Line variable which we want to check if he is a point
     * @return a boolean variable , TRUE if the line is point and false if the line is not point.
     */
    private boolean isPoint(Line other) {
        //checks if the start point equals to the end point
        if (other.start().getX() == other.end().getX()
                && other.start().getY() == other.end().getY()) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the isInfinityIncline method which finds out if the line has infinity incline.
     *
     * @return a boolean variable , TRUE if the line has infinity incline and
     * false if he hasn't got infinity incline.
     */
    private boolean isInfinityIncline() {
        //checks if the line has an infinity incline and its not a point
        if (start().getX() == end().getX() && start().getY() != end().getY()) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the isInfinityIncline method which finds out if the line has infinity incline.
     *
     * @param other , A line variable that we want to check if he has an infinity incline
     * @return a boolean variable , TRUE if the line has infinity incline and
     * false if he hasn't got infinity incline.
     */
    private boolean isInfinityIncline(Line other) {
        //checks if the line has an infinity incline and its not a point
        if (other.start().getX() == other.end().getX()
                && other.start().getY() != other.end().getY()) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the isLine method which finds out if the line is a normal line.
     *
     * @return a boolean variable , TRUE if the line is a normal line and
     * false if the line is not normal line.
     */
    private boolean isLine() {
        // checks if the line has an incline
        if (start().getX() != end().getX()) {
            // if he has return true
            return true;
        }
        // return false
        return false;
    }

    /**
     * This is the isLine method which finds out if the line is a normal line.
     *
     * @param other , a geometry.Line variable that we want to check if the line is a normal line or not.
     * @return a boolean variable , TRUE if the line is a normal line and
     * false if the line is not normal line.
     */
    private boolean isLine(Line other) {
        // checks if the line has an incline
        if (other.start().getX() != other.end().getX()) {
            // if he has return true
            return true;
        }
        // return false
        return false;
    }

    /**
     * This is the pointAndInfinityIncline method which finds out there is an intersection x point.
     *
     * @param other , a geometry.Line variable we want to check if there is an intersection point with
     * @return a Double variable , the x rate if there is an intersection point and infinity if there is not
     */
    private double pointAndInfinityIncline(Line other) {
        //define the variables
        double startX = start().getX(), startY = start().getY(), oEndY = other.end().getY();
        double endY = end().getY(), oStartX = other.start().getX(), oStartY = other.start().getY();
        //checking if there is a point and infinity incline
        if (isPoint() && isInfinityIncline(other)) {
            // checks if they have the same X, and the y is in the range
            if (startX == oStartX && startY >= oStartY && startY <= oEndY) {
                return startX;
            }
            // checks if they have the same X, and the y is in the range
            if (startX == oStartX && startY <= oStartY && startY >= oEndY) {
                return startX;
            }
        }
        //checking if there is a point and infinity incline
        if (isPoint(other) && isInfinityIncline()) {
            // checks if they have the same X, and the y is in the range
            if (oStartX == startX && oStartY >= startY && oStartY <= endY) {
                return oStartX;
            }
            // checks if they have the same X, and the y is in the range
            if (oStartX == startX && oStartY <= startY && oStartY >= endY) {
                return oStartX;
            }
        }
        //return infinity because they not intersecting
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the pointAndLine method which finds out there is an intersection x point.
     *
     * @param other , a geometry.Line variable we want to check if there is an intersection point with
     * @return a Double variable , the x rate if there is an intersection point and infinity if there is not
     */
    private double pointAndLine(Line other) {
        //define the variables
        double startX = start().getX(), startY = start().getY(), oEndY = other.end().getY();
        double endY = end().getY(), oStartX = other.start().getX(), oStartY = other.start().getY(), endX = end().getX();
        double oEndX = other.end().getX();
        //checks if there is a point and line
        if (isPoint() && isLine(other)) {
            // checks if the x of the point exists in the normal line (by the line script)
            if ((findIncline(other) * startX) + findFreeVariable(other) == startY) {
                // checks if the start y is in the range
                if (startY >= oStartY && startY <= oEndY && startX >= oStartX && startX <= oEndX) {
                    return startX;
                }
                // checks if the start y is in the range
                if (startY <= oStartY && startY >= oEndY && startX <= oStartX && startX >= oEndX) {
                    return startX;
                }
            }
        }
        // check if the line is point and the other line is a normal line
        if (isPoint(other) && isLine()) {
            // checks if the x of the point exists in the normal line (by the line script)
            if ((findIncline() * oStartX) + findFreeVariable() == oStartY) {
                // checks if the start y is in the range
                if (oStartY >= startY && oStartY <= endY && oStartX >= startX && oStartX <= endX) {
                    return oStartX;
                }
                // checks if the start y is in the range
                if (oStartY <= startY && oStartY >= endY && oStartX <= startX && oStartX >= endX) {
                    return oStartX;
                }
            }
        }
        //return infinity if they are not intersected
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the infinityInclineAndLine method which finds out there is an intersection x point.
     *
     * @param other , a geometry.Line variable we want to check if there is an intersection point with
     * @return a Double variable , the x rate if there is an intersection point and infinity if there is not
     */
    private double infinityInclineAndLine(Line other) {
        //define the variables
        double startX = start().getX(), endX = end().getX(), startY = start().getY(), oEndY = other.end().getY();
        double endY = end().getY(), oStartX = other.start().getX(), oEndX = other.end().getX();
        double oStartY = other.start().getY();
        //checks if one line has infinity incline and the other is normal line
        if (isInfinityIncline() && isLine(other)) {
            // define a double variable the will be the potential intersection y.
            double rangeY = (startX * findIncline(other)) + findFreeVariable(other);
            // checks if the startX is in the range of the normal line
            if (startX >= oStartX && startX <= oEndX) {
                // check if the potential intersection Y is in the startY and endY range
                if (rangeY >= startY && rangeY <= endY) {
                    return startX;
                }
                // check if the potential intersection Y is in the startY and endY range
                if (rangeY >= endY && rangeY <= startY) {
                    return startX;
                }
            }
            //checks if the startX is in the range of the normal line
            if (startX >= oEndX && startX <= oStartX) {
                // check if the potential intersection Y is in the startY and endY range
                if (rangeY >= startY && rangeY <= endY) {
                    return startX;
                }
                // check if the potential intersection Y is in the startY and endY range
                if (rangeY >= endY && rangeY <= startY) {
                    return startX;
                }
            }
        }
        //checks if one line has infinity incline and the other is normal line
        if (isInfinityIncline(other) && isLine()) {
            // define a double variable the will be the potential intersection y.
            double rangeY = (oStartX * findIncline()) + findFreeVariable();
            // checks if the other line start x is in the range of the normal line xs.
            if (oStartX >= startX && oStartX <= endX) {
                // checks if the potential intersection Y is in the range of the other line ys
                if (rangeY >= oStartY && rangeY <= oEndY) {
                    return oStartX;
                }
                // checks if the potential intersection Y is in the range of the other line ys
                if (rangeY >= endY && rangeY <= oStartY) {
                    return oStartX;
                }
            }
            // checks if the other line start x is in the range of the normal line xs.
            if (oStartX >= endX && startX <= startX) {
                // checks if the potential intersection Y is in the range of the other line ys
                if (rangeY >= oStartY && rangeY <= oEndY) {
                    return oStartX;
                }
                // checks if the potential intersection Y is in the range of the other line ys
                if (rangeY >= endY && rangeY <= oStartY) {
                    return oStartX;
                }
            }
        }
        //return infinity if the line are not intersecting
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the infinityIncline method which finds out there is an intersection x point.
     *
     * @param other , a geometry.Line variable we want to check if there is an intersection point with
     * @return a Double variable , the x rate if there is an intersection point and infinity if there is not
     */
    private double infinityIncline(Line other) {
        //define the variables
        double startX = start().getX(), startY = start().getY(), oEndY = other.end().getY();
        double endY = end().getY(), oStartY = other.start().getY();
        // if they do have, check if start y is bigger the the end y
        if (startY > endY && oStartY > oEndY) {
            // checks if the distance between the start and the end of the other line is equal to the
            // sum between the start and the end points
            if (start().distance(other.end()) == start().distance(end()) + other.start().distance(other.end())) {
                return startX;
            }
        }
        // if they do have, check if start y is bigger the the end y
        if (startY < endY && oStartY < oEndY) {
            // checks if the distance between the end and the start of the other line is equal to the sum between
            // the start and the end points
            if (end().distance(other.start()) == end().distance(start()) + other.end().distance(other.start())) {
                return startX;
            }
        }
        // if they do have, check if start y is bigger the the end y
        if (startY > endY && oStartY < oEndY) {
            // checks if the distance between the start and the end of the other line is equal to the
            // sum between the start and the end points
            if (start().distance(other.start()) == end().distance(start()) + other.end().distance(other.start())) {
                return startX;
            }
        }
        // if they do have, check if start y is bigger the the end y
        if (startY < endY && oStartY > oEndY) {
            // checks if the distance between the end and the start of the other line is equal to the sum between
            // the start and the end points
            if (end().distance(other.end()) == end().distance(start()) + other.end().distance(other.start())) {
                return startX;
            }
        }
        //return infinity if the line are not intersected
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the twoLine method which finds out there is an intersection x point.
     *
     * @param other , a geometry.Line variable we want to check if there is an intersection point with
     * @return a Double variable , the x rate if there is an intersection point and infinity if there is not
     */
    private double twoLine(Line other) {
        //define the variables
        double startX = start().getX(), endX = end().getX(), startY = start().getY(), oEndY = other.end().getY();
        double endY = end().getY(), oStartX = other.start().getX(), oEndX = other.end().getX();
        double equationX = findIncline() - findIncline(other), equationY = findFreeVariable(other) - findFreeVariable();
        double intersectionX = equationY / equationX, oStartY = other.start().getY();
        double intersectionY = findIncline() * intersectionX + findFreeVariable();
        // checks if the two line are normal lines
        if (isLine() && isLine(other)) {
            // checks if the lines are equals
            if (findIncline() == findIncline(other) && findFreeVariable() == findFreeVariable(other)) {
                //checks if the start x is equal to the other line x and the start y is the same ass the end y
                if (startX == oEndX && startY == oEndY) {
                    return startX;
                }
                //checks if the end x is the same as the other start x and the end y is the same as the start other y
                if (endX == oStartX && endY == oStartY) {
                    return startX;
                }
            }
            // checks if the inclines are equals and the free variable is no equals.
            if (findIncline() == findIncline(other) && findFreeVariable() != findFreeVariable(other)) {
                return Double.POSITIVE_INFINITY;
            }
            // checks if the end X is lower the the other start X or the other end x is smaller then the start X
            if (endX < oStartX || oEndX < startX) {
                return Double.POSITIVE_INFINITY;
            }
            // checks if the intersection X is the the range between the startX and the end x
            // and in the range between other start x and other end X
            if (intersectionX >= startX && intersectionX >= oStartX
                    && intersectionX <= endX && intersectionX <= oEndX) {
                // checks if the intersection Y is the the range between the startY and the end y
                // and in the range between other start y and other end Y
                if (intersectionY >= startY && intersectionY <= endY
                        && intersectionY >= oStartY && intersectionY <= oEndY) {
                    return intersectionX;
                }
                // checks if the intersection Y is the the range between the startY and the end y
                // and in the range between other start y and other end Y
                if (intersectionY >= startY && intersectionY <= endY
                        && intersectionY <= oStartY && intersectionY >= oEndY) {
                    return intersectionX;
                }
                // checks if the intersection Y is the the range between the startY and the end y
                // and in the range between other start y and other end Y
                if (intersectionY <= startY && intersectionY >= endY
                        && intersectionY <= oEndY && intersectionY >= oStartY) {
                    return intersectionX;
                }
                // checks if the intersection Y is the the range between the startY and the end y
                // and in the range between other start y and other end Y
                if (intersectionY <= startY && intersectionY >= endY
                        && intersectionY >= oEndY && intersectionY <= oStartY) {
                    return intersectionX;
                }
            }
        }
        //return infinity if the line are not intersected
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the findIntersectionX method which find the intersection x.
     *
     * @param other , a geometry.Line variable that we want to find the intersection x with the line.
     * @return a double variable, return the intersection x if he's exists and return infinity if not.
     */
    private double findIntersectionX(Line other) {
        // checks if the two lines are points
        if (isPoint() && isPoint(other)) {
            // if both of them are points checks if they are equals
            if (this.equals(other)) {
                return start().getX();
            }
        }
        //checks if one line is point and the other line has infinity incline
        if (isPoint() && isInfinityIncline(other)) {
            if (pointAndInfinityIncline(other) != Double.POSITIVE_INFINITY) {
                return pointAndInfinityIncline(other);
            }
        }
        //checks if one line is point and the other line has infinity incline
        if (isPoint(other) && isInfinityIncline()) {
            if (pointAndInfinityIncline(other) != Double.POSITIVE_INFINITY) {
                return pointAndInfinityIncline(other);
            }
        }
        // check if the line is point and the other line is a normal line
        if (isPoint() && isLine(other)) {
            if (pointAndLine(other) != Double.POSITIVE_INFINITY) {
                return pointAndLine(other);
            }
        }
        // check if the line is point and the other line is a normal line
        if (isPoint(other) && isLine()) {
            if (pointAndLine(other) != Double.POSITIVE_INFINITY) {
                return pointAndLine(other);
            }
        }
        // checks if both of the line has an infinity incline
        if (isInfinityIncline() && isInfinityIncline(other)) {
            if (infinityIncline(other) != Double.POSITIVE_INFINITY) {
                return infinityIncline(other);
            }
        }
        // checks if one line has an infinity incline and the other is a normal line
        if (isInfinityIncline() && isLine(other)) {
            if (infinityInclineAndLine(other) != Double.POSITIVE_INFINITY) {
                return infinityInclineAndLine(other);
            }
        }
        // checks if the one line has infinity incline and the other line is a normal line
        if (isInfinityIncline(other) && isLine()) {
            if (infinityInclineAndLine(other) != Double.POSITIVE_INFINITY) {
                return infinityInclineAndLine(other);
            }
        }
        //checks if the two line are normal lines
        if (isLine() && isLine(other)) {
            if (twoLine(other) != Double.POSITIVE_INFINITY) {
                return twoLine(other);
            }
        }
        //return infinity
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the findIntersectionY method which find the intersection y.
     *
     * @param other , a geometry.Line variable that we want to find the intersection y with the line.
     * @return a double variable, return the intersection y if he's exists and return infinity if not.
     */
    private double findIntersectionY(Line other) {
        // define the variables
        double startX = start().getX(), endX = end().getX(), startY = start().getY();
        // define the variables
        double endY = end().getY(), oStartX = other.start().getX(), oEndX = other.end().getX();
        // define the variables
        double oStartY = other.start().getY(), oEndY = other.end().getY();
        // define the variables
        double intersectionX = findIntersectionX(other);
        // checks if the two line are points
        if (isPoint() && isPoint(other)) {
            // checks if the two points are equals
            if (this.equals(other)) {
                //return startY
                return startY;
            }
        }
        // checks if one line is point and the other has an infinity incline and the intersectionX is no infinity
        if (isPoint() && isInfinityIncline(other) && intersectionX != Double.POSITIVE_INFINITY) {
            //return startY
            return startY;
        }
        // checks if one line is point and the other has an infinity incline and the intersectionX is no infinity
        if (isPoint(other) && isInfinityIncline() && intersectionX != Double.POSITIVE_INFINITY) {
            //return startY
            return oStartY;
        }
        //checks if one line is a point and the other line is a normal line and the intersection X is not infinity
        if (isPoint() && isLine(other) && intersectionX != Double.POSITIVE_INFINITY) {
            //return startY
            return startY;
        }
        //checks if one line is a point and the other line is a normal line and the intersection X is not infinity
        if (isPoint(other) && isLine() && intersectionX != Double.POSITIVE_INFINITY) {
            //return oStartY
            return oStartY;
        }
        // checks if the two line has infinity incline and the intersection X is not infinity
        if (isInfinityIncline() && isInfinityIncline(other) && intersectionX != Double.POSITIVE_INFINITY) {
            // checks if the start equals to the other line start
            if (start().equals(other.start())) {
                //return startY
                return startY;
            }
            //checks if the start equals to the other line end
            if (start().equals(other.end())) {
                //return startY
                return startY;
            }
            //checks if the end equals to the other line start
            if (end().equals(other.start())) {
                //return endY
                return endY;
            }
            //checks if the end equals to the other line end
            if (end().equals(other.end())) {
                //return endY
                return endY;
            }
        }
        // checks if one line has infinity incline and the other is normal line and the intersectionX is not infinity
        if (isInfinityIncline() && isLine(other) && intersectionX != Double.POSITIVE_INFINITY) {
            //return the intersectionX (by the script)
            return (startX * findIncline(other)) + findFreeVariable(other);
        }
        // checks if one line has infinity incline and the other is normal line and the intersectionX is not infinity
        if (isInfinityIncline(other) && isLine() && intersectionX != Double.POSITIVE_INFINITY) {
            //return the intersectionX (by the script)
            return (oStartX * findIncline()) + findFreeVariable();
        }
        //checks if the two lines are normal lines and the intersectionX is not infinity
        if (isLine() && isLine(other) && intersectionX != Double.POSITIVE_INFINITY) {
            // define the variables
            double equationX = findIncline() - findIncline(other);
            // define the variables
            double equationY = findFreeVariable(other) - findFreeVariable();
            // define the variables
            double intersectionEquationX = equationY / equationX;
            // define the variables
            return findIncline() * intersectionEquationX + findFreeVariable();
        }
        //return infinity
        return Double.POSITIVE_INFINITY;
    }

    /**
     * This is the isIntersecting method which find says if the lines are intersect.
     *
     * @param other , a Line variable that we want to find if he is intersect with the other line.
     * @return a boolean variable, return TRUE if the lines intersect and FALSE if not.
     */
    public boolean isIntersecting(Line other) {
        //checking if the intersection X and Y are not infinity
        if (findIntersectionX(other) != Double.POSITIVE_INFINITY
                && findIntersectionY(other) != Double.POSITIVE_INFINITY) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the intersectionWith method which find the intersection point of two given lines.
     *
     * @param other , a Line variable that we want to find the intersection points.
     * @return a Point variable, return the geometry.Point if there is a intersection point, and return null if not.
     */
    public Point intersectionWith(Line other) {
        // checks if the two lines are intersecting
        if (isIntersecting(other)) {
            //return the geometry.Point
            return new Point(findIntersectionX(other), findIntersectionY(other));
        }
        //return null
        return null;
    }

    /**
     * This is the equals method which find if two given lines are equals.
     *
     * @param other , a Line variable that we want to find if he is equal to other line.
     * @return a boolean variable, return TRUE if the two lines are equals and FALSE if not.
     */
    public boolean equals(Line other) {
        //checks if the start of the first line equal to the start of the other line
        if (start().getX() == other.start().getX() && end().getX() == other.end().getX()
                && start().getY() == other.start().getX() && end().getX() == other.end.getX()) {
            //return true
            return true;
        }
        //checks f the end of the line equal to the start of the line, and the start of the line equal to the
        //end of the line
        if (end().getX() == other.start().getX() && start().getX() == other.end().getX()
                && end().getY() == other.start().getY() && start().getY() == other.end().getY()) {
            //return true
            return true;
        }
        //return false
        return false;
    }

    /**
     * This is the closestIntersectionToStartOfLine method which find the closest intersection point to start of line.
     *
     * @param rect , a Rectangle variable that symbolize the rectangle that we are want to check if there is a
     *             intersection between the ball and the rectangle.
     * @return a Point variable, that is the closest intersection point..
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //set the new line
        Line line = new Line(this.start(), this.end());
        // create a array list of points
        List<Point> intersectionL = new ArrayList<Point>();
        // find all the intersection points
        intersectionL = rect.intersectionPoints(line);
        //if there is no intersection points return null
        if (rect.intersectionPoints(line).isEmpty()) {
            return null;
        }
        //create a distance array
        double[] distanceArray = new double[intersectionL.size()];
        //go all over the intersection points
        for (int i = 0; i < intersectionL.size(); i++) {
            // find the distance between the start of the line
            double distance = this.start().distance(intersectionL.get(i));
            //puts it on the array
            distanceArray[i] = distance;
        }
        // sort the array
        Arrays.sort(distanceArray);
        // go all over the intersection points
        for (int i = 0; i < intersectionL.size(); i++) {
            // check for the closest intersection point
            if (distanceArray[0] == this.start().distance(rect.intersectionPoints(line).get(i))) {
                //return the closest intersection point
                return rect.intersectionPoints(line).get(i);
            }
        }
        //return null
        return null;
    }

    /**
     * This is the closestIntersectionToStartOfLine method which find the closest intersection point to start of line.
     *
     * @param rect , a gRectangle variable that symbolize the rectangle that we are want to check if there is a
     *             intersection between the ball and the rectangle.
     * @param v    , Velocity variable that symbolize the velocity of the ball.
     * @return a geometry.Point variable, that is the closest intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect, Velocity v) {
        //set the new line
        Line line = new Line(this.start(), this.end());
        // create a array list of points
        List<Point> intersectionL = new ArrayList<Point>();
        // find all the intersection points
        intersectionL = rect.intersectionPoints(line);
        //if there is no intersection points return null
        if (rect.intersectionPoints(line).isEmpty()) {
            return null;
        }
        //create a distance array
        double[] distanceArray = new double[intersectionL.size()];
        //go all over the intersection points
        for (int i = 0; i < intersectionL.size(); i++) {
            // find the distance between the start of the line
            double distance = this.start().distance(intersectionL.get(i));
            //puts it on the array
            distanceArray[i] = distance;
        }
        // sort the array
        Arrays.sort(distanceArray);
        // check the direction of the ball
        if (v.getDX() < 0 && v.getDY() < 0) {
            // go all over the distance array
            for (int i = 0; i < intersectionL.size(); i++) {
                //check for the closest intersection point from the start of the line
                if (distanceArray[intersectionL.size() - 1]
                        == this.start().distance(rect.intersectionPoints(line).get(i))) {
                    //return the collision info
                    return rect.intersectionPoints(line).get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() > 0 && v.getDY() > 0) {
            // go all over the distance array
            for (int i = 0; i < intersectionL.size(); i++) {
                //check for the closest intersection point from the start of the line
                if (distanceArray[0] == this.start().distance(rect.intersectionPoints(line).get(i))) {
                    //return the collision info
                    return rect.intersectionPoints(line).get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() > 0 && v.getDY() < 0) {
            // go all over the distance array
            for (int i = 0; i < intersectionL.size(); i++) {
                //check for the closest intersection point from the start of the line
                if (distanceArray[0] == this.start().distance(rect.intersectionPoints(line).get(i))) {
                    //return the collision info
                    return rect.intersectionPoints(line).get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() < 0 && v.getDY() > 0) {
            // go all over the distance array
            for (int i = 0; i < intersectionL.size(); i++) {
                //check for the closest intersection point from the start of the line
                if (distanceArray[intersectionL.size() - 1]
                        == this.start().distance(rect.intersectionPoints(line).get(i))) {
                    //return the collision info
                    return rect.intersectionPoints(line).get(i);
                }
            }
        }
        //return null
        return null;
    }
}
