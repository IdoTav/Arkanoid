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
 * The LevelFour class is a class have all the information for level three of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class LevelThree implements LevelInformation {
    private int numLevel = 3;
    private int win = 0;

    /**
     * This is the getNumberLevel method which returns the number of the level.
     *
     * @return the number of the level
     */
    public int getNumberLevel() {
        return this.numLevel;
    }

    /**
     * This is the numberOfBalls method which returns the number of balls.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * This is the initialBallVelocities method which initialize all the velocities for the balls.
     *
     * @return the the list of the velocities
     */
    public List<Velocity> initialBallVelocities() {
        //creates the list
        List<Velocity> ballVelocity = new ArrayList<Velocity>();
        // add the velocities
        ballVelocity.add(Velocity.fromAngleAndSpeed(205, 8));
        ballVelocity.add(Velocity.fromAngleAndSpeed(335, 8));
        //return the list
        return ballVelocity;
    }

    /**
     * This is the getBackGroundColor method which returns the background color.
     *
     * @return the the background color
     */
    public Color getBackGroundColor() {
        final Color color = new Color(25, 128, 6);
        return color;
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
        return "Green 3";
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
        return 90;
    }

    /**
     * This is the blocks method which returns a list full of the blocks of the level.
     *
     * @return the list of the blocks of the level
     */
    public List<Block> blocks() {
        //creates the list
        List<Block> blocks = new ArrayList<Block>();
        //set the start point
        int startX = 40, startY = 250;
        //set an array of colors
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.blue, Color.white};
        int j = 140, line = 0, index = 0;
        //creates the blocks
        while (j <= 220) {
            for (int i = line + 360; i <= 720; i += 40) {
                blocks.add(new Block(new Rectangle(new Point(i, j), 40, 20), colors[index]));
            }
            j += 20;
            line += 40;
            index++;
        }
        //return the list
        return blocks;
    }

    /**
     * This is the numberOfBlocksToRemove method which returns the number of block to remove.
     *
     * @return the number of block to remove.
     */
    public int numberOfBlocksToRemove() {
        return 40;
    }

    /**
     * This is the drawBackGround method which draw on the surface the background.
     *
     * @param d , Type of DrawSurface which indicate the surface we are drawing in.
     */
    public void drawBackGround(DrawSurface d) {
        //draw the background
        d.setColor(getBackGroundColor());
        d.fillRectangle(40, 40, 720, 600);
        Color color = new Color(42, 40, 40);
        d.setColor(color);
        d.fillRectangle(80, 400, 110, 200);
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                d.setColor(Color.white);
                d.fillRectangle(90 + j * 20, 410 + i * 40, 10, 30);
            }
        }
        color = new Color(52, 50, 50);
        d.setColor(color);
        d.fillRectangle(117, 340, 35, 60);
        color = new Color(64, 61, 61);
        d.setColor(color);
        d.fillRectangle(130, 150, 10, 190);
        d.setColor(Color.orange);
        d.fillCircle(135, 140, 10);
        d.setColor(Color.red);
        d.fillCircle(135, 140, 8);
        d.setColor(Color.WHITE);
        d.fillCircle(135, 140, 4);
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