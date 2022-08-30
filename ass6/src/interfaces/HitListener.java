//316222512

package interfaces;

import gameforms.Ball;
import gameforms.Block;

/**
 * The HitListener interface, is an interface that says that every object that is HitListener must
 * have the hitEvent method.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public interface HitListener {

    /**
     * This is the hitEvent method which we are calling when hit was occurred.
     *
     * @param beingHit , a Block variable which indicate the block that getting hit.
     * @param hitter   , a Ball variable which indicate the ball that is hitting the block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}