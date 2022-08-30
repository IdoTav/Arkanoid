//316222512

package interfaces;

import biuoop.DrawSurface;
import game.GameLevel;

/**
 * The Sprite interface, is an interface that says that every object that is interfaces.Sprite must
 * have the drawOn method, timePassed method and the addToGame.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public interface Sprite {

    /**
     * The drawOn method will draw the sprite on the gui.
     *
     * @param d , DrawSurface variable that symbolize the surface that we will draw the sprite on.
     */
    void drawOn(DrawSurface d);

    /**
     * The timePassed method will move the sprite.
     */
    void timePassed();

    /**
     * The addToGame method will add the sprite to the game.
     *
     * @param g , Game variable which indicate the game that we are want the sprite to be added to.
     */
    void addToGame(GameLevel g);
}