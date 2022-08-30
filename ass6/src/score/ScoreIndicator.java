//316222512

package score;

import interfaces.Sprite;
import game.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The ScoreIndicator class implement and application a class that create a rectangle and
 * prints out the score.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class ScoreIndicator implements Sprite {
    private GameLevel game;

    /**
     * This is the constructor method which gets Game and Counter and create the BallRemover.
     *
     * @param game , A type of Game variable that symbolizes the current.
     */
    public ScoreIndicator(GameLevel game) {
        this.game = game;
    }

    /**
     * This is the addToGame method which add the score to the game.
     *
     * @param g , a Game variable that indicate the the game.Game calls.
     */
    public void addToGame(GameLevel g) {
        if (g != null) {
            // add the the sprite list
            g.addSprite(this);
        }
    }

    /**
     * This is the timePassed method which change the location of the block (for now this is a method without
     * an implement).
     */
    public void timePassed() {
        return;
    }

    /**
     * This is the drawOn method which draws the rectangle with the score in the surface.
     *
     * @param d , a DrawSurface variable that represent the surface that we are drawing the rectangle on.
     */
    public void drawOn(DrawSurface d) {
        // set the color
        final Color grayColor = new Color(211, 213, 213);
        d.setColor(grayColor);
        //create the rectangle
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.black);
        //prints on the rectangle the score
        d.drawText(350, 17, "Score:" + this.game.getScore().getValue(), 17);
        d.drawText(550, 17, "Level Name:" + this.game.getInformation().levelName(), 17);
        d.drawText(150, 17, "Lives:" + this.game.getLivesCounter().getValue(), 17);
    }
}
