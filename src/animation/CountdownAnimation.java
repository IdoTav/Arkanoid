//316222512

package animation;

import interfaces.Animation;
import interfaces.LevelInformation;
import sprites.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The CountdownAnimation class prints on the surface a count down, which after the count down
 * the animation start running.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private LevelInformation information;

    /**
     * This is the constructor method which creates CountdownAnimation object.
     *
     * @param numOfSeconds , A type of int variable that symbolizes the frames.
     * @param countFrom    , A type of GUI variable that symbolizes the gui.
     * @param gameScreen   , A type of SpriteCollection that symbolizes the game screen.
     * @param information  , A type LevelInformation that symbolizes the game information.
     */
    public CountdownAnimation(long numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              LevelInformation information) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.information = information;
    }

    /**
     * This is the doOneFrame drawing on the surface one frame.
     *
     * @param d , A type of DrawSurface which is the surface that we are drawing on.
     */
    public void doOneFrame(DrawSurface d) {
        double startTime = System.currentTimeMillis();
        double time = (startTime - this.numOfSeconds) / 1000;
        // set the color
        Color color = new Color(219, 218, 218);
        // if the time is between 0 sec and 0.7 sec
        if (time >= 0 && time < 0.7) {
            // draw the back ground
            this.information.drawBackGround(d);
            // draw the game screen
            this.gameScreen.drawAllOn(d);
            //set the color
            d.setColor(color);
            // print the 3 count down
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 40, "3", 50);
        }
        // if the time is between 0.7 sec and 1.3 sec
        if (time >= 0.7 && time < 1.4) {
            // draw the back ground
            this.information.drawBackGround(d);
            // draw the game screen
            this.gameScreen.drawAllOn(d);
            //set the color
            d.setColor(color);
            // print the 2 count down
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 40, "2", 50);
        }
        // if the time is between 1.3 sec and 1.8 sec
        if (time >= 1.4 && time < 2) {
            // draw the back ground
            this.information.drawBackGround(d);
            // draw the game screen
            this.gameScreen.drawAllOn(d);
            //set the color
            d.setColor(color);
            // print the 1 count down
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 40, "1", 50);
        }
        // if the time is bigger then 2
        if (time >= 2) {
            // draw the back ground
            this.information.drawBackGround(d);
            // draw the game screen
            this.gameScreen.drawAllOn(d);
            // set stop to be true
            this.stop = true;
            //return
            return;
        }
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
