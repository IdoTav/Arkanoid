//316222512

package counter;

/**
 * Counter class, is a class that helps us to count an important information about the game,
 * such as how many block are remains or the score of the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class Counter {
    private int counter;

    /**
     * This is the constructor method which gets the collosion point and the collide object.
     *
     * @param counter , A type of int variable that symbolizes the counter of the thing we are counting.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * This is the increase method which increase the counter.
     *
     * @param number , A type of int variable that we are want to add to the counter
     */
    public void increase(int number) {
        //increase the counter
        this.counter += number;

    }

    /**
     * This is the decrease method which decrease the counter.
     *
     * @param number , A type of int variable that we are want to lessen to the counter
     */
    public void decrease(int number) {
        //decrease the counter by number
        this.counter -= number;
    }

    /**
     * This is the getValue method returns the counter.
     *
     * @return the int number of the counter.
     */
    public int getValue() {
        return this.counter;

    }
}