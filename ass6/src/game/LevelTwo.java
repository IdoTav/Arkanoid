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
 * The LevelFour class is a class have all the information for level two of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class LevelTwo implements LevelInformation {
    private int numLevel = 2;
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
        return 10;
    }

    /**
     * This is the initialBallVelocities method which initialize all the velocities for the balls.
     *
     * @return the the list of the velocities
     */
    public List<Velocity> initialBallVelocities() {
        //creates a list
        List<Velocity> ballVelocity = new ArrayList<Velocity>();
        //add the velocities
        for (int i = 0; i < this.numberOfBalls() * 15; i += 15) {
            ballVelocity.add(Velocity.fromAngleAndSpeed(205 + i, 7));
        }
        //return the list
        return ballVelocity;
    }

    /**
     * This is the getBackGroundColor method which returns the background color.
     *
     * @return the the background color
     */
    public Color getBackGroundColor() {
        return Color.white;
    }

    /**
     * This is the paddleSpeed method which returns the paddle speed.
     *
     * @return the the paddle speed
     */
    public int paddleSpeed() {
        return 1;
    }

    /**
     * This is the levelName method which returns the level name.
     *
     * @return the the level name
     */
    public String levelName() {
        return "Wide Easy";
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
        return 600;
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
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            // add the blocks to the list
            if (i == 0 || i == 1) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.red));
            }
            if (i == 2 || i == 3) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.orange));
            }
            if (i == 4 || i == 5) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.yellow));
            }
            if (i == 6 || i == 7 || i == 8) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.green));
            }
            if (i == 9 || i == 10) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.blue));
            }
            if (i == 11 || i == 12) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.pink));
            }
            if (i == 13 || i == 14) {
                blocks.add(new Block(new geometry.Rectangle(new Point(startX + i * 48, startY), 48,
                        22), Color.CYAN));
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
        return 15;
    }

    /**
     * This is the drawBackGround method which draw on the surface the background.
     *
     * @param d , Type of DrawSurface which indicate the surface we are drawing in.
     */
    public void drawBackGround(DrawSurface d) {
        //draw the background
        d.setColor(Color.white);
        d.fillRectangle(40, 40, 720, 600);
        d.setColor(new Color(235, 252, 42));
        for (int i = 0; i <= 60; i++) {
            d.drawLine(160, 140, 40 + 14 * i, 250);
        }
        d.setColor(Color.yellow);
        d.fillCircle(160, 140, 70);
        d.setColor(Color.orange);
        d.fillCircle(160, 140, 60);
        d.setColor(new Color(255, 169, 8));
        d.fillCircle(160, 140, 50);
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


