//316222512

package gameforms;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;

import java.awt.Color;
import java.util.ArrayList;

import interfaces.Sprite;
import interfaces.HitNotifier;
import velocity.Velocity;
import game.GameEnvironment;
import interfaces.HitListener;

import java.util.List;

import game.GameLevel;


/**
 * The Ball class, actually a circle, has a size (radius), color, and location, and they
 * can draw themselves on a DrawSurface.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Ball implements Sprite, HitNotifier {
    //define the fields
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private int height;
    private int width;
    private GameEnvironment environment;
    private List<HitListener> hitListeners;


    /**
     * This is the isBallInPaddle method which if the ball is in the paddle.
     *
     * @param paddle , a Paddle variable that indicate the paddle.
     * @return true if the ball is in the paddle, and false if not.
     */
    public Boolean isBallInPaddle(Paddle paddle) {
        //set the variables that indicate the the top left point of the paddle.
        double paddleStartX = paddle.getRectangle().getUpperLeft().getX(),
                paddleStartY = paddle.getRectangle().getUpperLeft().getY();
        //check if the ball is in the paddle
        if (center.getX() > paddleStartX && center.getX() < paddleStartX + paddle.getRectangle().getWidth()) {
            if (center.getY() > paddleStartY && center.getY() < paddleStartY + paddle.getRectangle().getHeight()) {
                //return true
                return true;
            }
        }
        //return false
        return false;
    }

    /**
     * This is the addToGame method which add the ball to the game.
     *
     * @param g , a Game variable that indicate the the game.Game calls.
     */
    public void addToGame(GameLevel g) {
        //check if the game is not null
        if (g != null) {
            //add the ball to the sprite
            g.addSprite(this);
        }
    }

    /**
     * This is the timePassed method which make the move of the ball.
     */
    public void timePassed() {
        //call the moveOneStep method to move the ball
        this.moveOneStep();
    }

    /**
     * This is the constructor method which gets the center point, the radius, the color, and the
     * height and the width of the screen that we are want to print the ball in.
     *
     * @param center   , A type of Point variable that symbolizes the center of the ball.
     * @param r        , A type of int variable that symbolizes the radius of the ball.
     * @param color    , A type of java.awt.Color that symbolizes the color of the ball.
     * @param velocity , A type of Velocity that symbolizes the velocity of the ball.
     * @param height   , A type of int that symbolizes the the height of the screen we are painting the ball in
     * @param width    , A type of int that symbolizes the width of the screen we are painting the ball in
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity velocity, int height, int width) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.height = height;
        this.width = width;
        this.velocity = new Velocity(velocity.getDX(), velocity.getDY());
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This is the constructor method which gets the center of the ball and the radius, the color, and the
     * game environment.
     *
     * @param center      , A type of double variable that symbolizes a x in a system of axes.
     * @param r           , A type of int variable that symbolizes the radius of the ball.
     * @param color       , A type of java.awt.Color that symbolizes the color of the ball.
     * @param velocity    , A type of Velocity that symbolizes the velocity of the ball.
     * @param environment , A type of GameEnvironment that symbolizes the game environment.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity velocity, GameEnvironment environment) {
        this.center = new Point(center.getX(), center.getY());
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(velocity.getDX(), velocity.getDY());
        this.environment = environment;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This is the constructor method which gets the 2 integer and the radius, the color, and the
     * game environment.
     *
     * @param x           , A type of double variable that symbolizes a x in a system of axes.
     * @param y           , A type of double variable that symbolizes a y in a system of axes.
     * @param r           , A type of int variable that symbolizes the radius of the ball.
     * @param color       , A type of java.awt.Color that symbolizes the color of the ball.
     * @param velocity    , A type of Velocity that symbolizes the velocity of the ball.
     * @param environment , A type of GameEnvironment that symbolizes the game environment.
     */
    public Ball(int x, int y, int r, java.awt.Color color, Velocity velocity, GameEnvironment environment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(velocity.getDX(), velocity.getDY());
        this.environment = environment;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This is the constructor method which gets the 2 integer and the radius, the color, and the
     * height and the width of the screen that we are want to print the ball in.
     *
     * @param x        , A type of double variable that symbolizes a x in a system of axes.
     * @param y        , A type of double variable that symbolizes a y in a system of axes.
     * @param r        , A type of int variable that symbolizes the radius of the ball.
     * @param color    , A type of java.awt.Color that symbolizes the color of the ball.
     * @param velocity , A type of Velocity that symbolizes the velocity of the ball.
     * @param height   , A type of int that symbolizes the the height of the screen we are painting the ball in
     * @param width    , A type of int that symbolizes the width of the screen we are painting the ball in
     */
    public Ball(int x, int y, int r, java.awt.Color color, Velocity velocity, int height, int width) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.height = height;
        this.width = width;
        this.velocity = new Velocity(velocity.getDX(), velocity.getDY());
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This is the get method which return the height field of the ball which show the height of the frame.
     *
     * @return a int variable which indicate the height field of the point, which shows the height of the frame.
     */
    public int getHeight() {
        //return the height of the frame
        return this.height;
    }

    /**
     * This is the get method which return the width field of the ball which show the width of the frame.
     *
     * @return a int variable which indicate the width field of the point, which shows the width of the frame.
     */
    public int getWidth() {
        //return the width of the frame
        return this.width;
    }

    /**
     * This is the get method which return the x rate of the center point of the ball.
     *
     * @return a int variable which indicate x rate of the center point of the ball
     */
    public int getX() {
        //return the x rate of the center of the ball
        return (int) this.center.getX();
    }

    /**
     * This is the get method which return the y rate of the center point of the ball.
     *
     * @return a int variable which indicate y rate of the center point of the ball.
     */
    public int getY() {
        //return the y rate of the center of the ball
        return (int) this.center.getY();
    }

    /**
     * This is the get method which return the radius of the ball.
     *
     * @return a int variable which indicate the radius of the ball.
     */
    public int getSize() {
        //return the radius of the ball
        return this.r;
    }

    /**
     * This is the get method which return the center point of the ball.
     *
     * @return a Point variable which indicate the center of the ball.
     */
    public Point getCenter() {
        //return the center of the ball
        return this.center;
    }

    /**
     * This is the get method which return the color of the ball.
     *
     * @return a int variable which indicate the color of the ball.
     */
    public java.awt.Color getColor() {
        //return the color of the ball
        return this.color;
    }

    /**
     * This is the drawOn method which gets a surface and draw on the surface the ball.
     *
     * @param surface , a DrawSurface variable.
     */
    public void drawOn(DrawSurface surface) {
        //set the color of the ball
        surface.setColor(getColor());
        //draw the ball with the rate of x,y and the radius
        surface.fillCircle(getX(), getY(), getSize());
        surface.setColor(Color.black);
        surface.drawCircle(getX(), getY(), getSize());

    }

    /**
     * This is the set method which set the velocity.
     *
     * @param v , Velocity variable.
     */
    public void setVelocity(Velocity v) {
        //sets the velocity
        this.velocity = v;
    }

    /**
     * This is the set method which set the velocity.
     *
     * @param dx , double variable, which indicate the difference in the x axes.
     * @param dy , double variable, which indicate the difference in the y axes.
     */
    public void setVelocity(double dx, double dy) {
        //set the velocity
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * This is the get method which return the velocity.
     *
     * @return the velocity.
     */
    public Velocity getVelocity() {
        //return the velocity
        return this.velocity;
    }

    /**
     * This is the moveOneStep method gets the gap between the frames, and change the center of the ball, by the
     * given velocity and that make the ball move, and checks if the ball are not cross the frame borders.
     *
     * @param gap , int variable which indicate the gap between the frames.
     */
    public void moveOneStep(int gap) {
        // checking if the center point is crossing the borders of the frame
        if (center.getX() + r >= this.getWidth() || center.getX() + r <= 2 * this.getSize() + gap) {
            if (center.getY() + r >= this.getHeight() || center.getY() + r <= 2 * this.getSize() + gap) {
                // if it is, make the velocity to be *-1 in x axes
                double newDx = -this.getVelocity().getDX();
                // if it is, make the velocity to be *-1 in y axes
                double newDy = -this.getVelocity().getDY();
                // makes the new velocity
                this.velocity = new Velocity(newDx, newDy);
                //change the center
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }
        }
        // checks if the x rates of the center are crossing the border
        if (center.getX() + r >= this.getWidth() || center.getX() + r <= 2 * this.getSize() + gap) {
            // if it is, make the velocity to be *-1 in x axes
            double newDx = -this.getVelocity().getDX();
            //set the new velocity
            this.velocity = new Velocity(newDx, this.getVelocity().getDY());
            //change the center by the new velocity
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        // checks if the y rates of the center are crossing the border
        if (center.getY() + r >= this.getHeight() || center.getY() + r <= 2 * this.getSize() + gap) {
            // if it is, make the velocity to be *-1 in y axes
            double newDy = -this.getVelocity().getDY();
            //set the new velocity
            this.velocity = new Velocity(this.getVelocity().getDX(), newDy);
            //change the center by the new velocity
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        //if the the center of the ball are not cross the border change the center by the given velocity
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * This is the moveOneStep method which check if the ball are going to intersect with a collidable object,
     * and changing the velocity and the center ass well.
     */
    public void moveOneStep() {
        //calculate the trajectory point.
        Point endTrajectory = new Point(this.center.getX() + this.velocity.getDX(),
                this.center.getY() + this.velocity.getDY());
        // calculate the trajectory line
        Line trajectory = new Line(this.center, endTrajectory);
        //check if there is a collision with a collidable
        if (this.environment.getClosestCollision(trajectory, velocity) != null) {
            //find the collision point
            Point collisionPoint = this.environment.getClosestCollision(trajectory, velocity).collisionPoint();
            // set the new center
            Point almostPoint = new Point(collisionPoint.getX() - velocity.getDX(),
                    collisionPoint.getY() - velocity.getDY());
            // try like the collision is at block
            try {
                // checking the block that is going to collide with
                Block block = (Block) this.environment.getClosestCollision(trajectory, velocity).collisionObject();
                //change the center
                this.center = almostPoint;
                //change the velocity
                velocity = block.hit(this, collisionPoint, velocity);
                return;
            } catch (Exception e) {
                // if it doesn't hit a block so the ball hit the paddle
                Paddle paddle = (Paddle) this.environment.getClosestCollision(trajectory, velocity).collisionObject();
                if (isBallInPaddle(paddle)) {
                    if (velocity.getDY() > 0) {
                        this.velocity = new Velocity(velocity.getDX(), -1 * velocity.getDY());
                    }
                    this.center = new Point(this.center.getX(), paddle.getRectangle().getUpperLeft().getY() - 1);
                    return;
                }
                //change the center of the ball
                this.center = almostPoint;
                //change the velocity
                this.velocity = paddle.hit(this, collisionPoint, velocity);
                return;
            }
        }
        //change the center
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * This is the addHitListener method which gets HitListener and add him to the HitListener list.
     *
     * @param hl , A type of HitListener variable that symbolizes the HitListener we are wanting to add to the list.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * This is the removeHitListener method which gets HitListener and remove him from the HitListener list.
     *
     * @param hl , A type of HitListener variable that symbolizes the HitListener we are wanting to
     *           remove from the list.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * This is the removeFromGame method which gets game variable and remove him from the game.
     *
     * @param game , A type of Game variable that symbolizes the game we are wanting to the ball from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * This is the notifyHit method which gets Block variable and notify that hit was occurred.
     *
     * @param hitter , A type of Block variable that symbolizes the block that was hit by the ball.
     */
    public void notifyHit(Block hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(hitter, this);
        }
    }
}