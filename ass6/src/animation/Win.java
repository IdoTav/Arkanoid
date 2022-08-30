//316222512

package animation;

import biuoop.DrawSurface;
import game.GameLevel;
import interfaces.Animation;

import java.awt.Color;

/**
 * The Win class is a class that displays a win screen when the player wins.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class Win implements Animation {
    private boolean stop;
    private GameLevel game;

    /**
     * This is the constructor method which creates a Win object.
     *
     * @param game , A type of GameLevel that symbolizes the game.
     */
    public Win(GameLevel game) {
        this.game = game;
        this.stop = false;
    }

    /**
     * This is the shouldStop method which checks if the animation need to stop.
     *
     * @return the is we need to stop the animation.
     */
    public boolean shouldStop() {
        return this.stop;
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
        d.drawText(d.getWidth() / 4 + 57, d.getHeight() / 4, "You Win!", 60);
        d.setColor(new Color(32, 231, 208));
        d.drawText(d.getWidth() / 4 + 58, d.getHeight() / 4, "You Win!", 60);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 60, d.getHeight() / 4 + 1, "You Win!!", 60);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 + 23, 10 * (d.getHeight() / 12) + 81, "Press space to continue", 36);
        final Color blue = new Color(37, 148, 186);
        d.setColor(blue);
        d.drawText(d.getWidth() / 4 + 24, 10 * (d.getHeight() / 12) + 80, "Press space to continue", 36);
        d.setColor(Color.black);
        d.drawText((d.getWidth() / 4) + 26, 10 * (d.getHeight() / 12) + 80, "Press space to continue", 36);
        d.setColor(Color.black);
        d.drawText(d.getWidth() / 4 - 20, d.getHeight() / 4 + 350,
                "Your Score Is: " + this.game.getScore().getValue(), 50);
        d.setColor(Color.black);
        d.drawCircle(400, 300, 70);
        d.drawCircle(400, 300, 71);
        d.setColor(Color.orange);
        d.fillCircle(400, 300, 70);
        d.setColor(Color.black);
        d.fillCircle(400, 320, 35);
        d.setColor(Color.orange);
        d.fillRectangle(360, 270, 80, 35);
        d.setColor(Color.red);
        d.fillCircle(400, 350, 6);
        d.setColor(Color.WHITE);
        d.fillCircle(400, 302, 33);
        d.setColor(Color.orange);
        d.fillRectangle(345, 260, 100, 60);
        d.setColor(Color.black);
        d.fillCircle(375, 275, 7);
        d.fillCircle(420, 275, 7);
        final Color color = new Color(182, 117, 33);
        d.setColor(color);
        d.fillCircle(398, 300, 9);
        d.setColor(Color.orange);
        d.fillCircle(398, 293, 11);
        d.setColor(Color.white);
        d.fillCircle(360, 325, 2);
        d.fillCircle(365, 315, 2);
        d.fillCircle(357, 318, 2);
        d.fillCircle(440, 325, 2);
        d.fillCircle(435, 315, 2);
        d.fillCircle(443, 318, 2);
    }
}

