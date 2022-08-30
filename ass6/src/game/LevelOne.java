//316222512

package game;

import biuoop.DrawSurface;
import gameforms.Block;
import geometry.Point;
import geometry.Rectangle;
import interfaces.LevelInformation;
import interfaces.Sprite;
import velocity.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The LevelFour class is a class have all the information for level one of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class LevelOne implements LevelInformation {
    private int numLevel = 1;
    private int win = 0;

    /**
     * This is the numberOfBalls method which returns the number of balls.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * This is the initialBallVelocities method which initialize all the velocities for the balls.
     *
     * @return the the list of the velocities
     */
    public List<Velocity> initialBallVelocities() {
        //creates the list
        List<Velocity> ballVelocity = new ArrayList<Velocity>();
        //add the velocity
        ballVelocity.add(Velocity.fromAngleAndSpeed(-89, 6));
        //return the list
        return ballVelocity;
    }

    /**
     * This is the getNumberLevel method which returns the number of the level.
     *
     * @return the number of the level
     */
    public int getNumberLevel() {
        return this.numLevel;
    }

    /**
     * This is the getBackGroundColor method which returns the background color.
     *
     * @return the the background color
     */
    public Color getBackGroundColor() {
        return Color.black;
    }

    /**
     * This is the paddleSpeed method which returns the paddle speed.
     *
     * @return the the paddle speed
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * This is the levelName method which returns the level name.
     *
     * @return the the level name
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * This is the getBackground method which returns the background of the level.
     *
     * @return the background of the level
     */
    public Sprite getBackground() {
        return new BackGround();
    }

    /**
     * This is the paddleHeight method which returns the paddle height.
     *
     * @return the paddle height.
     */
    public int paddleHeight() {
        return 15;
    }

    /**
     * This is the paddleHeight method which returns the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 80;
    }

    /**
     * This is the blocks method which returns a list full of the blocks of the level.
     *
     * @return the list of the blocks of the level
     */
    public List<Block> blocks() {
        //creates the list
        List<Block> blocks = new ArrayList<Block>();
        //add the block
        blocks.add(new Block(new Rectangle(new Point(390, 180), 30, 30), Color.red));
        //return the list
        return blocks;
    }

    /**
     * This is the numberOfBlocksToRemove method which returns the number of block to remove.
     *
     * @return the number of block to remove.
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }

    /**
     * This is the drawBackGround method which draw on the surface the background.
     *
     * @param d , Type of DrawSurface which indicate the surface we are drawing in.
     */
    public void drawBackGround(DrawSurface d) {
        //draw the background
        d.setColor(Color.black);
        d.fillRectangle(40, 40, 720, 600);
        d.setColor(Color.blue);
        d.drawCircle(405, 195, 140);
        d.drawCircle(405, 195, 100);
        d.drawCircle(405, 195, 60);
        d.drawLine(405, 40, 405, 175);
        d.drawLine(405, 217, 405, 352);
        d.drawLine(240, 195, 385, 195);
        d.drawLine(425, 195, 570, 195);
    }

    /**
     * This is the setWinningLevel method which change the win key to be 1.
     */
    public void setWinningLevel() {
        this.win = 1;
    }

    /**
     * This is the getWinningLevel method which return the winning level.
     *
     * @return the winning level.
     */
    public int getWinningLevel() {
        return this.win;
    }

}
