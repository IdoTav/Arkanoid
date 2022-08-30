//316222512

package interfaces;

import gameforms.Ball;
import geometry.Point;
import geometry.Rectangle;
import velocity.Velocity;

/**
 * The Collidable interface, is an interface that says that every object that is collidable must
 * have the getCollisionRectangle method, and the hit method.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public interface Collidable {
    /**
     * The getCollisionRectangle method will return the rectangle that has collide with the ball.
     *
     * @return return the rectangle that has collide with the ball.
     */
    Rectangle getCollisionRectangle();

    /**
     * The hit method will return the new velocity of the ball after the collision between the ball and the
     * collidable object.
     *
     * @param currentVelocity , Velocity variable that symbolize the current velocity.
     * @param collisionPoint  , Point variable that symbolize the collision point.
     * @param hitter          , Ball variable that symbolize the hitter ball.
     * @return the new velocity after the collision point.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}