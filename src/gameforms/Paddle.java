//ID: 316222512

package gameforms;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Sprite;
import interfaces.Collidable;
import velocity.Velocity;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import game.GameLevel;

import java.awt.Color;

/**
 * The Paddle class, paddle is a sprite and collidable object, that can move right and left,
 * and he is a rectangle,
 * has a color and keyboard sensor.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */

public class Paddle implements Sprite, Collidable {
    private Rectangle rectangle;
    private Color color;
    private biuoop.KeyboardSensor keyboard;
    private int speed;

    /**
     * This is the constructor method which gets rectangle and color and the keyboard, and build the paddle.
     *
     * @param rectangle , A type of geometry.Rectangle variable that symbolizes the rectangle that the paddle is.
     * @param color     , A type of Color variable that symbolizes the color of the paddle.
     * @param keyboard  , biuoop.KeyboardSensor variable that symbolize the keyboard
     * @param speed     , A int type which indicate the speed of the paddle
     */
    public Paddle(Rectangle rectangle, Color color, biuoop.KeyboardSensor keyboard, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    /**
     * This is the get method which return the keyboard.
     *
     * @return return the keyboard sensor.
     */
    public biuoop.KeyboardSensor getKeyboard() {
        //return the keyboard
        return this.keyboard;
    }

    /**
     * This is the get method which return the color of the paddle.
     *
     * @return return the color of the paddle.
     */
    public Color getColor() {
        //return the color
        return this.color;
    }

    /**
     * This is the get method which return the rectangle that the paddle is.
     *
     * @return return the rectangle that the paddle is.
     */
    public Rectangle getRectangle() {
        //return the paddle
        return this.rectangle;
    }

    /**
     * This is the moveLeft method which move the paddle left.
     */
    public void moveLeft() {
        //checks if the paddle going to get out of the border of the gui
        if (this.rectangle.getUpperLeft().getX() <= 40) {
            //return and don't move the paddle
            return;
        }
        //check if the left key was clicked
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            // if it got clicked move the paddle left
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() - this.speed,
                    rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * This is the moveRight method which move the paddle right.
     */
    public void moveRight() {
        //checks if the paddle going to get out of the border of the gui
        if (this.rectangle.getUpperLeft().getX() >= 760 - this.rectangle.getWidth()) {
            //return and don't move the paddle
            return;
        }
        //check if the right key was clicked
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            // if it got clicked move the paddle right
            this.rectangle = new Rectangle(new Point(rectangle.getUpperLeft().getX() + this.speed,
                    rectangle.getUpperLeft().getY()), this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * This is the timePassed method which call the moveLeft and moveRight methods and move the paddle.
     */
    public void timePassed() {
        //call moveLeft method
        this.moveLeft();
        //call moveRight method
        this.moveRight();

    }

    /**
     * This is the drawOn method which gets a surface and draw on the surface the paddle.
     *
     * @param d , a DrawSurface variable.
     */
    public void drawOn(DrawSurface d) {
        //set the color of the paddle
        d.setColor(getColor());
        // draw the rectangle of the ball
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //set the color
        d.setColor(Color.black);
        //draw the rectangle
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * This is the get method which returns the rectangle that was collide with the ball.
     *
     * @return returns the rectangle that was collide with the ball.
     */
    public Rectangle getCollisionRectangle() {
        //return the rectangle
        return this.rectangle;
    }

    /**
     * This is the hit method which change the given velocity by the collision point.
     *
     * @param collisionPoint  , a Point variable that indicate the collision point
     * @param currentVelocity , a Velocity variable that indicate the current velocity.
     * @param hitter          , a Ball variable that indicate the ball that hit the paddle.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //set the variables points
        Point endRegion1 = new Point(rectangle.getUpperLeft().getX() + (rectangle.getWidth()) / 5,
                rectangle.getUpperLeft().getY()),
                endRegion2 = new Point(endRegion1.getX() + (rectangle.getWidth()) / 5, endRegion1.getY()),
                endRegion3 = new Point(endRegion2.getX() + (rectangle.getWidth()) / 5, endRegion2.getY()),
                endRegion4 = new Point(endRegion3.getX() + (rectangle.getWidth()) / 5, endRegion3.getY()),
                endRegion5 = new Point(endRegion4.getX() + (rectangle.getWidth()) / 5, endRegion4.getY()),
                lowerLeft = new Point(rectangle.getUpperLeft().getX(), endRegion1.getY() + rectangle.getHeight()),
                lowerRight = new Point(endRegion5.getX(), endRegion5.getY() + rectangle.getHeight());
        //set the geometry.Line variables
        Line region1 = new Line(rectangle.getUpperLeft(), endRegion1), region2 = new Line(endRegion1, endRegion2),
                region3 = new Line(endRegion2, endRegion3), region4 = new Line(endRegion3, endRegion4),
                region5 = new Line(endRegion4, endRegion5), collisionLine = new Line(collisionPoint, collisionPoint);
        Line leftLine = new Line(lowerLeft, rectangle.getUpperLeft()), rightLine = new Line(lowerRight, endRegion5);
        Line lowerLine = new Line(lowerLeft, lowerRight);
        //check if the collision point is in the region1
        if (region1.isIntersecting(collisionLine)) {
            //change the velocity
            Velocity v = Velocity.fromAngleAndSpeed(300, Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                    + Math.pow(currentVelocity.getDY(), 2)));
            //check if the velocity got change in the angle that we wanted
            if (v.getDX() > 0) {
                // if not changed it
                return new Velocity(-1 * v.getDX(), v.getDY());
            }
            //return the velocity
            return v;
        }
        //check if the collision point is in the region2
        if (region2.isIntersecting(collisionLine)) {
            //change the velocity
            Velocity v = Velocity.fromAngleAndSpeed(330, Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                    + Math.pow(currentVelocity.getDY(), 2)));
            //check if the velocity got change in the angle that we wanted
            if (v.getDX() > 0) {
                // if not changed it
                return new Velocity(-1 * v.getDX(), v.getDY());
            }
            //return the velocity
            return v;
        }
        //check if the collision point is in the region3
        if (region3.isIntersecting(collisionLine)) {
            //change the velocity
            return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
        }
        //check if the collision point is in the region4
        if (region4.isIntersecting(collisionLine)) {
            //change the velocity
            Velocity v = Velocity.fromAngleAndSpeed(30, Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                    + Math.pow(currentVelocity.getDY(), 2)));
            //check if the velocity got change in the angle that we wanted
            if (v.getDY() > 0) {
                //change the velocity
                return new Velocity(v.getDX(), -1 * v.getDY());
            }
            //return the velocity
            return v;
        }
        //check if the collision point is in the region5
        if (region5.isIntersecting(collisionLine)) {
            //change the velocity
            Velocity v = Velocity.fromAngleAndSpeed(60, Math.sqrt(Math.pow(currentVelocity.getDX(), 2)
                    + Math.pow(currentVelocity.getDY(), 2)));
            //check if the velocity got change in the angle that we wanted
            if (v.getDY() > 0) {
                //change the velocity
                return new Velocity(v.getDX(), -1 * v.getDY());
            }
            //return the velocity
            return v;
        }
        //check if the ball is intersect with the left line of the paddle
        if (leftLine.isIntersecting(collisionLine)) {
            //change the velocity
            return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
        }
        //check if the ball is intersect with the right line of the paddle
        if (rightLine.isIntersecting(collisionLine)) {
            //change the velocity
            return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
        }
        //check if the ball is intersect with the lower line of the paddle
        if (lowerLine.isIntersecting(collisionLine)) {
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                //return the current velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
        }
        if (currentVelocity.getDY() > 0) {
            return currentVelocity;
        }
        //return current velocity
        return new Velocity((currentVelocity.getDX()), currentVelocity.getDY());
    }

    /**
     * This is the addToGame method which add the paddle to the game.
     *
     * @param g , a game.Game variable that indicate the the game.Game calls.
     */
    public void addToGame(GameLevel g) {
        //check if the game is not null
        if (g != null) {
            //add the paddle to the sprites
            g.addSprite(this);
            //add the paddle to the collidable
            g.addCollidable(this);
        }
    }
}