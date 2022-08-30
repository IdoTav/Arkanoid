//316222512

package animation;

import interfaces.Animation;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The PauseScreen class is a class that displays a pause screen when the player clicks on the pause key.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * This is the constructor method which creates a Lose PauseScreen object.
     */
    public PauseScreen() {
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
        d.setColor(Color.gray);
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 110);
        d.setColor(Color.white);
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 108);
        final Color lightBlue = new Color(87, 141, 213);
        d.setColor(lightBlue);
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 100);
        d.setColor(Color.gray);
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 96);
        d.setColor(Color.black);
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 92);
        d.setColor(Color.white);
        d.fillRectangle(d.getWidth() / 2 - 50, d.getHeight() / 2 - 60, 40, 120);
        d.fillRectangle(d.getWidth() / 2 + 10, d.getHeight() / 2 - 60, 40, 120);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 23, 10 * (d.getHeight() / 12) - 1, "Press space to continue", 36);
        final Color blue = new Color(37, 148, 186);
        d.setColor(blue);
        d.drawText(d.getWidth() / 4 + 24, 10 * (d.getHeight() / 12) - 1, "Press space to continue", 36);
        d.setColor(Color.black);
        d.drawText((d.getWidth() / 4) + 26, 10 * (d.getHeight() / 12), "Press space to continue", 36);
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