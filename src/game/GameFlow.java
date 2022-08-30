//316222512

package game;

import biuoop.GUI;
import counter.Counter;
import interfaces.LevelInformation;

import java.util.List;

/**
 * The GameFlow class is a class that runs all the levels.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-06-12
 */
public class GameFlow {
    private GUI gui;

    /**
     * This is the constructor method which creates a GameFlow object.
     *
     * @param gui , A type of GUI that symbolizes the gui.
     */
    public GameFlow(GUI gui) {
        this.gui = gui;
    }

    /**
     * This is the runLevels method which gets a list full of levels and running all the levels one by one.
     *
     * @param levels , A type of List which is all the levels we are wants to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        //set the score to 0
        Counter score = new Counter(0);
        // set the score to 7
        Counter lives = new Counter(7);
        //goes all over the levels
        for (int i = 0; i < levels.size(); i++) {
            // set the last level to be the winning level
            if (i == levels.size() - 1) {
                levels.get(i).setWinningLevel();
            }
            // create a new level
            GameLevel level = new GameLevel(levels.get(i), score, this.gui, lives);
            // initialize the level
            level.initialize();
            // if there is a blocks and balls run the level
            while (level.getCounterBlocks().getValue() > 0 && level.getCounterBalls().getValue() > 0) {
                level.run();
            }
            // if we lost we break
            if (level.getCounterBalls().getValue() == 0 && level.getLivesCounter().getValue() == 0) {
                break;
            }
        }
    }
}
