//316222512

package interfaces;

import biuoop.DrawSurface;

/**
 * The Animation interface, is an interface that says that every object that is Animation must
 * have the doOneFrame method, and the shouldStop method.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public interface Animation {

    /**
     * This is the doOneFrame drawing on the surface one frame.
     *
     * @param d , A type of DrawSurface which is the surface that we are drawing on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * This is the shouldStop method which checks if the animation need to stop.
     *
     * @return the is we need to stop the animation.
     */
    boolean shouldStop();
}
