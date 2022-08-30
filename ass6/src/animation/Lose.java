//316222512

package animation;

import biuoop.DrawSurface;
import game.GameLevel;
import interfaces.Animation;

import java.awt.Color;

/**
 * The Lose class is a class that displays a lose screen when the player lose.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class Lose implements Animation {
    private boolean stop;
    private GameLevel game;

    /**
     * This is the constructor method which creates a Lose object.
     *
     * @param game , A type of GameLevel that symbolizes the game.
     */
    public Lose(GameLevel game) {
        this.game = game;
        this.stop = false;
    }

    /**
     * This is the doOneFrame drawing on the surface one frame.
     *
     * @param d , A type of DrawSurface which is the surface that we are drawing on.
     */
    public void doOneFrame(DrawSurface d) {
        /*
        printing on the surface the losing screen
         */
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 57, d.getHeight() / 4, "Game Over", 60);
        d.setColor(new Color(189, 33, 39));
        d.drawText(d.getWidth() / 4 + 58, d.getHeight() / 4, "Game Over", 60);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 60, d.getHeight() / 4 + 1, "Game Over", 60);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 23, 10 * (d.getHeight() / 12) + 74, "Press space to continue", 36);
        final Color blue = new Color(37, 148, 186);
        d.setColor(blue);
        d.drawText(d.getWidth() / 4 + 24, 10 * (d.getHeight() / 12) + 74, "Press space to continue", 36);
        d.setColor(Color.black);
        d.drawText((d.getWidth() / 4) + 26, 10 * (d.getHeight() / 12) + 75, "Press space to continue", 36);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 - 20, d.getHeight() / 4 + 350,
                "Your Score Is: " + this.game.getScore().getValue(), 50);
        d.setColor(Color.black);
        d.drawCircle(400, 300, 70);
        d.drawCircle(400, 300, 71);
        d.setColor(Color.orange);
        d.fillCircle(400, 300, 70);
        d.setColor(Color.black);
        d.fillCircle(400, 330, 35);
        d.setColor(Color.orange);
        d.fillRectangle(365, 330, 79, 27);
        d.fillRectangle(370, 330, 50, 35);
        d.setColor(Color.black);
        d.fillCircle(370, 270, 7);
        d.fillCircle(425, 270, 7);
    }

    /**
     * This is the shouldStop method which checks if the animation need to stop.
     *
     * @return the is we need to stop the animation.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
