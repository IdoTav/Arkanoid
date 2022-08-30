//316222512

package game;

import biuoop.DrawSurface;
import gameforms.Block;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Sprite;

import java.awt.Color;

/**
 * The BackGround class is a class that creates the background for the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class BackGround implements Sprite {
    private Block topBlock = new Block(new Rectangle(new Point(0, 20), 800, 20), Color.gray);
    private Block downBlock = new Block(new Rectangle(new Point(0, 600), 800, 40), Color.gray);
    private Block rightBlock = new Block(new Rectangle(new Point(0, 40), 40, 600), Color.gray);
    private Block leftBlock = new Block(new Rectangle(new Point(760, 40), 40, 600), Color.gray);

    /**
     * This is the drawOn method which draws the block in the surface.
     *
     * @param d , a DrawSurface variable that represent the surface that we are drawing the block on.
     */
    public void drawOn(DrawSurface d) {
        //draw the top block
        topBlock.drawOn(d);
        //draw the down block
        downBlock.drawOn(d);
        //draw the right block
        rightBlock.drawOn(d);
        // draw the left block
        leftBlock.drawOn(d);
    }

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
        //add the blocks for the game
        topBlock.addToGame(g);
        downBlock.addToGame(g);
        rightBlock.addToGame(g);
        leftBlock.addToGame(g);
    }
}
