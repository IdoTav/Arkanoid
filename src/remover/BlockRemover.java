//316222512

package remover;

import game.GameLevel;
import gameforms.Ball;
import gameforms.Block;
import score.ScoreTrackingListener;
import counter.Counter;
import interfaces.HitListener;

/**
 * The BlockRemover class implement and application a class that knows
 * to remove the blocks from the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * This is the constructor method which gets Game and Counter and create the BlockRemover.
     *
     * @param game          , A type of Game variable that symbolizes the current game.
     * @param removedBlocks , A type of Counter variable that symbolizes the amount of blocks.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * This is the hitEvent method which we are calling when hit was occurred.
     *
     * @param beingHit , a Block variable which indicate the block that getting hit.
     * @param hitter   , a Ball variable which indicate the ball that is hitting the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove the block from the game
        beingHit.removeFromGame(this.game);
        //remove the block from the HitListener
        beingHit.removeHitListener(this);
        //decrease the amount of blocks by 1
        this.game.getCounterBlocks().decrease(1);
        // increase the score
        ScoreTrackingListener scoring = new ScoreTrackingListener(this.game.getScore());
        //calling the hitEvent method
        scoring.hitEvent(beingHit, hitter);
    }
}