//316222512

package game;

import collidables.CollisionInfo;
import gameforms.Block;
import gameforms.Paddle;
import geometry.Line;
import interfaces.Collidable;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import velocity.Velocity;

/**
 * GameEnvironment class, is a class that has a arraylist of collidable, and can get the close
 * collosion point from line and can add more collidable to the array list.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class GameEnvironment {
    private List<Collidable> collidable = new ArrayList<Collidable>();

    /**
     * This is the get method which return the collidable array list.
     *
     * @return a interfaces.Collidable array list variable which indicate all the collidables in the game
     */
    public List<Collidable> getGameEnvironment() {
        //return the array list
        return this.collidable;
    }

    /**
     * This is the addCollidable method which add a collidable object to the array list.
     *
     * @param c , Collidable variable that we are want to add to the collidable array list.
     */
    public void addCollidable(Collidable c) {
        //checks if the collaidable is already in the array list
        if (collidable.contains(c)) {
            //if he is we are not add him
            return;
        }
        //add the collidable
        collidable.add(c);
    }

    /**
     * This is the getClosestCollision method which add a collidable object to the array list.
     *
     * @param trajectory , Line variable which indicate the line that we are want to find the closest collision point
     * @param v          , Velocity variable which indicate the current velocity of the ball.
     * @return return the information about the intersection point(the point, and the object that intersect)
     */
    public CollisionInfo getClosestCollision(Line trajectory, Velocity v) {
        //set the collision array list
        List<CollisionInfo> p = new ArrayList<CollisionInfo>();
        // go all over the collidable array list
        for (int i = 0; i < collidable.size(); i++) {
            int index = 0;
            //check if the collidable is a block
            try {
                Block block = (Block) collidable.get(i);
                // check if the closest intersection is not null
                if (trajectory.closestIntersectionToStartOfLine(block.getCollisionRectangle(), v) != null) {
                    //add the collision info to the array list
                    p.add(new CollisionInfo(trajectory.closestIntersectionToStartOfLine(block.getCollisionRectangle(),
                            v), block));
                    index++;
                }
            } catch (Exception e) {
                Paddle paddle = (Paddle) collidable.get(i);
                if (trajectory.closestIntersectionToStartOfLine(paddle.getCollisionRectangle(), v) != null) {
                    p.add(new CollisionInfo(trajectory.closestIntersectionToStartOfLine(paddle.getCollisionRectangle(),
                            v), paddle));
                    index++;
                }
            }
        }
        //set the distance array
        double[] distanceArray = new double[p.size()];
        //go all over the p array list
        for (int i = 0; i < p.size(); i++) {
            // find the distance between the start of the line to the collision point
            double distance = trajectory.start().distance(p.get(i).collisionPoint());
            //enter the distance into the array
            distanceArray[i] = distance;
        }
        //sort the array
        Arrays.sort(distanceArray);
        // check the direction of the ball
        if (v.getDX() < 0 && v.getDY() < 0) {
            // go all over the distance array
            for (int i = 0; i < p.size(); i++) {
                //check for the closesest intersection point from the start of the line
                if (distanceArray[p.size() - 1] == trajectory.start().distance(p.get(i).collisionPoint())) {
                    //return the collision info
                    return p.get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() > 0 && v.getDY() > 0) {
            // go all over the distance array
            for (int i = 0; i < p.size(); i++) {
                //check for the closesest intersection point from the start of the line
                if (distanceArray[0] == trajectory.start().distance(p.get(i).collisionPoint())) {
                    //return the collision info
                    return p.get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() > 0 && v.getDY() < 0) {
            // go all over the distance array
            for (int i = 0; i < p.size(); i++) {
                //check for the closesest intersection point from the start of the line
                if (distanceArray[0] == trajectory.start().distance(p.get(i).collisionPoint())) {
                    //return the collision info
                    return p.get(i);
                }
            }
        }
        // check the direction of the ball
        if (v.getDX() < 0 && v.getDY() > 0) {
            // go all over the distance array
            for (int i = 0; i < p.size(); i++) {
                //check for the closesest intersection point from the start of the line
                if (distanceArray[p.size() - 1] == trajectory.start().distance(p.get(i).collisionPoint())) {
                    //return the collision info
                    return p.get(i);
                }
            }
        }
        //return null
        return null;
    }

}