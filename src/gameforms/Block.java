//316222512

package gameforms;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import interfaces.Sprite;
import interfaces.HitNotifier;
import interfaces.HitListener;
import game.GameLevel;
import velocity.Velocity;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * The Block class, actually a rectangle, has a color, and location, and they
 * can draw themselves on a DrawSurface, and find the intersection point with line.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * This is the timePassed method which change the location of the block (for now this is a method without
     * an implement).
     */
    public void timePassed() {
        return;
    }

    /**
     * This is the addToGame method which add the block to the game.
     *
     * @param g , a Game variable that indicate the the game.Game calls.
     */
    public void addToGame(GameLevel g) {
        //check if g is not null
        if (g != null) {
            //add the block to the sprite
            g.addSprite(this);
            //add the block to the collidable
            g.addCollidable(this);
        }
    }

    /**
     * This is the constructor method which gets the rectangle and the color and build the block.
     *
     * @param rectangle , A type of Rectangle variable that symbolizes the rectangle that the block looks like.
     * @param color     , A type of Color variable that symbolizes the color of the block.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * This is the get method which returns the color of the block.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This is the get method which returns the collidable rectangle.
     *
     * @return the collidable rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * This is the drawOn method which draws the block in the surface.
     *
     * @param surface , a DrawSurface variable that represent the surface that we are drawing the block on.
     */
    public void drawOn(DrawSurface surface) {
        //set the color
        surface.setColor(getColor());
        //draw the the block
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //set the color
        surface.setColor(Color.black);
        //draw the rectangle.
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * This is the hit method which change the given velocity by the collision point.
     *
     * @param collisionPoint  , a Point variable that indicate the collision point
     * @param currentVelocity , a Velocity variable that indicate the current velocity.
     * @param hitter          , a Ball variable that indicate the ball that hit the block.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //set the variables
        double upperLeftX = this.getCollisionRectangle().getUpperLeft().getX(),
                upperLeftY = this.getCollisionRectangle().getUpperLeft().getY(),
                upperRightX = upperLeftX + this.getCollisionRectangle().getWidth(),
                upperRightY = upperLeftY, lowerLeftX = upperLeftX,
                lowerLeftY = upperLeftY + this.getCollisionRectangle().getHeight(),
                lowerRightX = upperRightX, lowerRightY = lowerLeftY;
        //create the points
        Point upperLeft = new Point(upperLeftX, upperLeftY), upperRight = new Point(upperRightX, upperRightY);
        Point lowerLeft = new Point(lowerLeftX, lowerLeftY), lowerRight = new Point(lowerRightX, lowerRightY);
        //check if there there collision with a corner
        if (collisionPoint.equals(lowerLeft)) {
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
        }
        //check if there there collision with a corner
        if (collisionPoint.equals(upperLeft)) {
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
        }
        //check if there there collision with a corner
        if (collisionPoint.equals(lowerRight)) {
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
            }
        }
        //check if there there collision with a corner
        if (collisionPoint.equals(upperRight)) {
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() > 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() < 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
            }
            // check if the ball is coming from a specific direction
            if (currentVelocity.getDX() < 0 && currentVelocity.getDY() > 0) {
                hitter.notifyHit(this);
                this.notifyHit(hitter);
                //change the velocity
                return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
            }
        }
        //checks if the collision point is on the lower line
        if (collisionPoint.getY() == lowerRightY
                && collisionPoint.getX() > lowerLeftX && collisionPoint.getX() < lowerRightX) {
            hitter.notifyHit(this);
            this.notifyHit(hitter);
            //change the velocity
            return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
        }
        //checks if the collision point is on the left line
        if (collisionPoint.getX() == lowerLeftX
                && collisionPoint.getY() > upperLeftY && collisionPoint.getY() < lowerLeftY) {
            hitter.notifyHit(this);
            this.notifyHit(hitter);
            //change the velocity
            return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
        }
        //checks if the collision point is on the right line
        if (collisionPoint.getX() == lowerRightX
                && collisionPoint.getY() > upperLeftY && (collisionPoint.getY() < lowerRightY)) {
            hitter.notifyHit(this);
            this.notifyHit(hitter);
            //change the velocity
            return new Velocity(-1 * currentVelocity.getDX(), currentVelocity.getDY());
        }
        //checks if the collision point is on the upper line
        if (collisionPoint.getY() == upperRightY
                && collisionPoint.getX() > upperLeftX && collisionPoint.getX() < upperRightX) {
            hitter.notifyHit(this);
            this.notifyHit(hitter);
            //change the velocity
            return new Velocity(currentVelocity.getDX(), -1 * currentVelocity.getDY());
        }
        //return null
        return null;
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
     * This is the removeFromGame method which gets game variable and remove him from the game.
     *
     * @param game , A type of Game variable that symbolizes the game we are wanting to the ball from.
     */
    public void removeFromGame(GameLevel game) {
        //remove from the collidable list
        game.removeCollidable(this);
        //remove from the Sprite list.
        game.removeSprite(this);
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
     * This is the notifyHit method which gets Ball variable and notify that hit was occurred.
     *
     * @param hitter , A type of Ball variable that symbolizes the block that was hit by the ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
