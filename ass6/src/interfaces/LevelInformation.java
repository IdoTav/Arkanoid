//316222512

package interfaces;

import biuoop.DrawSurface;
import velocity.Velocity;
import gameforms.Block;

import java.awt.Color;
import java.util.List;

/**
 * The LevelInformation interface, is an interface that says that every object that is LevelInformation must
 * implements all the method that in the interface.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public interface LevelInformation {

    /**
     * This is the numberOfBalls method which returns the number of balls.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * This is the initialBallVelocities method which initialize all the velocities for the balls.
     *
     * @return the the list of the velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * This is the paddleSpeed method which returns the paddle speed.
     *
     * @return the the paddle speed
     */
    int paddleSpeed();

    /**
     * This is the blocks method which returns a list full of the blocks of the level.
     *
     * @return the list of the blocks of the level
     */
    int paddleWidth();

    /**
     * This is the levelName method which returns the level name.
     *
     * @return the the level name
     */
    String levelName();

    /**
     * This is the getBackground method which returns the background of the level.
     *
     * @return the background of the level
     */
    Sprite getBackground();

    /**
     * This is the blocks method which returns a list full of the blocks of the level.
     *
     * @return the list of the blocks of the level
     */
    List<Block> blocks();

    /**
     * This is the numberOfBlocksToRemove method which returns the number of block to remove.
     *
     * @return the number of block to remove.
     */
    int numberOfBlocksToRemove();

    /**
     * This is the paddleHeight method which returns the paddle width.
     *
     * @return the paddle width.
     */
    int paddleHeight();

    /**
     * This is the drawBackGround method which draw on the surface the background.
     *
     * @param d , Type of DrawSurface which indicate the surface we are drawing in.
     */
    void drawBackGround(DrawSurface d);

    /**
     * This is the getBackGroundColor method which returns the background color.
     *
     * @return the the background color
     */
    Color getBackGroundColor();

    /**
     * This is the getNumberLevel method which returns the number of the level.
     *
     * @return the number of the level
     */
    int getNumberLevel();

    /**
     * This is the setWinningLevel method which change the win key to be 1.
     */
    void setWinningLevel();

    /**
     * This is the getWinningLevel method which return the winning level.
     *
     * @return the winning level.
     */
    int getWinningLevel();
}
