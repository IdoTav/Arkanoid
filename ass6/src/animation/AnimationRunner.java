//316222512

package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import interfaces.Animation;

/**
 * The AnimationRunner class runs the animation of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;

    /**
     * This is the constructor method which creates AnimationRunner object.
     *
     * @param framesPerSecond , A type of int variable that symbolizes the frames.
     * @param gui             , A type of GUI variable that symbolizes the gui.
     */
    public AnimationRunner(int framesPerSecond, GUI gui) {
        this.framesPerSecond = framesPerSecond;
        this.gui = gui;
        this.sleeper = new biuoop.Sleeper();
    }

    /**
     * This is the run method which which runs the animation.
     *
     * @param animation , A type of Animation which indicate the animation we are running
     */
    public void run(Animation animation) {
        //set the amount of frames
        int millisecondsPerFrame = 1000 / framesPerSecond;
        // while the animation is not should stop
        while (!animation.shouldStop()) {
            // timing
            long startTime = System.currentTimeMillis();
            // create the surface
            DrawSurface d = gui.getDrawSurface();
            // doing one frame
            animation.doOneFrame(d);
            //shows the gui
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}