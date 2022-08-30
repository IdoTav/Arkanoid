//316222512

package collidables;

import interfaces.Collidable;
import geometry.Point;

/**
 * CollisionInfo class, is a class that has the information of the collision point, such as the
 * object that the ball has collide with, and the collision point.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class CollisionInfo {
    private Point collosionPoint;
    private Collidable collisionObject;

    /**
     * This is the constructor method which gets the collosion point and the collide object.
     *
     * @param collosionPoint  , A type of Point variable that symbolizes the collosion point.
     * @param collisionObject , A type of Collidable variable that symbolizes
     *                        object that the ball collide with.
     */
    public CollisionInfo(Point collosionPoint, Collidable collisionObject) {
        this.collosionPoint = collosionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * This is the get method which returns the collosion point.
     *
     * @return the collosion point.
     */
    public Point collisionPoint() {
        //return the collosion point
        return this.collosionPoint;
    }

    /**
     * This is the get method which returns the collosion object.
     *
     * @return the collosion object.
     */
    public Collidable collisionObject() {
        //return the collosion object.
        return this.collisionObject;
    }
}