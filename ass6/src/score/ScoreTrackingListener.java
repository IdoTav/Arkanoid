//316222512

package score;

import gameforms.Ball;
import gameforms.Block;
import counter.Counter;
import interfaces.HitListener;

/**
 * The ScoreTrackingListener class implement and application a class that when hit is occurred update the score.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * This is the constructor method which gets Counter and create the ScoreTrackingListener.
     *
     * @param scoreCounter , A type of Counter variable that symbolizes the current score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This is the hitEvent method which we are calling when hit was occurred.
     *
     * @param beingHit , a Block variable which indicate the block that getting hit.
     * @param hitter   , a Ball variable which indicate the ball that is hitting the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //increasing the score by 5
        this.currentScore.increase(5);
    }
}