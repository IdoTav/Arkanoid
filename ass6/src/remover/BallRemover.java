//316222512

package remover;

import game.GameLevel;
import gameforms.Ball;
import gameforms.Block;
import counter.Counter;
import interfaces.HitListener;

/**
 * The BallRemover class implement and application a class that knows
 * to remove the ball from the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * This is the constructor method which gets Game and Counter and create the BallRemover.
     *
     * @param game           , A type of Game variable that symbolizes the current.
     * @param remainingBalls , A type of Counter variable that symbolizes the amount of balls.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * This is the hitEvent method which we are calling when hit was occurred.
     *
     * @param beingHit , a Block variable which indicate the block that getting hit.
     * @param hitter   , a Ball variable which indicate the ball that is hitting the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        // checks if the hit is on the lower block
        if (beingHit.getCollisionRectangle().getUpperLeft().getX() >= 0
                && beingHit.getCollisionRectangle().getUpperLeft().getX() <= 800) {
            if (beingHit.getCollisionRectangle().getUpperLeft().getY() == 600) {
                // if he is remove the ball from the game
                hitter.removeFromGame(this.game);
                // and decrease the amount of balls by 1.
                this.game.getCounterBalls().decrease(1);
            }
        }
    }
}
