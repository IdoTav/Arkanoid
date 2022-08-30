//316222512

package game;

import biuoop.DrawSurface;
import gameforms.Block;
import geometry.Point;
import interfaces.LevelInformation;
import interfaces.Sprite;
import velocity.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The LevelFour class is a class have all the information for level four of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class LevelFour implements LevelInformation {
    private int numLevel = 4;
    private int win = 0;

    /**
     * This is the numberOfBalls method which returns the number of balls.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
        return 3;
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
     * This is the initialBallVelocities method which initialize all the velocities for the balls.
     *
     * @return the the list of the velocities
     */
    public List<Velocity> initialBallVelocities() {
        //creates the list
        List<Velocity> ballVelocity = new ArrayList<Velocity>();
        //create the velocities and add them to the list
        ballVelocity.add(Velocity.fromAngleAndSpeed(205, 10));
        ballVelocity.add(Velocity.fromAngleAndSpeed(335, 10));
        ballVelocity.add(Velocity.fromAngleAndSpeed(-89, 10));
        //return the list
        return ballVelocity;
    }

    /**
     * This is the getBackGroundColor method which returns the background color.
     *
     * @return the the background color
     */
    public Color getBackGroundColor() {
        //create the color
        return new Color(26, 120, 180);
    }

    /**
     * This is the paddleSpeed method which returns the paddle speed.
     *
     * @return the the paddle speed
     */
    public int paddleSpeed() {
        return 20;
    }

    /**
     * This is the levelName method which returns the level name.
     *
     * @return the the level name
     */
    public String levelName() {
        return "Final Four";
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
        //creates the lost
        List<Block> blocks = new ArrayList<Block>();
        //set the start point
        int startX = 40, startY = 120;
        // set an array of colors
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.green, Color.white, Color.pink, Color.cyan};
        //creates the blocks
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + 48 * j, 120 + 22 * i),
                        48, 22), colors[i]));
            }
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
        return 105;
    }

    /**
     * This is the drawBackGround method which draw on the surface the background.
     *
     * @param d , Type of DrawSurface which indicate the surface we are drawing in.
     */
    public void drawBackGround(DrawSurface d) {
        // draw the background
        d.setColor(getBackGroundColor());
        d.fillRectangle(40, 40, 720, 600);
        d.setColor(Color.white);
        for (int i = 0; i <= 9; i++) {
            d.drawLine(140 + 10 * i, 460, 100 + 10 * i, 600);
            d.drawLine(600 + 10 * i, 350, 520 + 10 * i, 600);
        }
        Color color = new Color(193, 187, 187);
        d.setColor(color);
        d.fillCircle(600, 350, 30);
        d.fillCircle(620, 380, 30);
        d.fillCircle(140, 460, 30);
        d.fillCircle(160, 480, 30);
        color = new Color(186, 182, 182);
        d.setColor(color);
        d.fillCircle(640, 350, 30);
        d.fillCircle(180, 450, 30);
        color = new Color(175, 169, 169);
        d.setColor(color);
        d.fillCircle(660, 380, 30);
        d.fillCircle(680, 350, 30);
        d.fillCircle(200, 480, 35);
        d.fillCircle(220, 450, 30);
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
