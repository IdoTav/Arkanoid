//316222512

package animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;


/**
 * The KeyPressStoppableAnimation class is mainly to avoiding in duplicates a code,
 * and to make easier bug fixes.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private Boolean stop;
    private Boolean isPressed;

    /**
     * This is the constructor method which creates a KeyPressStoppableAnimation object.
     *
     * @param sensor    , A type of KeyboardSensor that symbolizes the keyboard.
     * @param key       , A type of String variable that symbolizes the button we are clicking.
     * @param animation , A type of Animation that symbolizes the animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isPressed = true;
    }

    /**
     * This is the doOneFrame drawing on the surface one frame.
     *
     * @param d , A type of DrawSurface which is the surface that we are drawing on.
     */
    public void doOneFrame(DrawSurface d) {
        // calling that animation doOneFrame method
        this.animation.doOneFrame(d);
        // check if key button was pressed
        if (this.sensor.isPressed(this.key)) {
            // check if he already been pressed
            if (isAlreadyPressed()) {
                //returns
                return;
            }
            // change stop to be true
            this.stop = true;
        } else {
            // else change stop to be false
            setPressed();
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

    /**
     * This is the isAlreadyPressed method which returns the pressed field.
     *
     * @return is the key button already been pressed
     */
    private boolean isAlreadyPressed() {
        return this.isPressed;
    }

    /**
     * This is the setPressed method which sets the isPressed field.
     */
    private void setPressed() {
        this.isPressed = false;
    }
}
