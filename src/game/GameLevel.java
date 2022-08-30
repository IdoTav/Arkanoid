//316222512

package game;

import animation.AnimationRunner;
import animation.CountdownAnimation;
import animation.PauseScreen;
import animation.Win;
import animation.Lose;
import animation.KeyPressStoppableAnimation;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameforms.Ball;
import gameforms.Block;
import gameforms.Paddle;
import geometry.Point;
import geometry.Rectangle;
import interfaces.LevelInformation;
import score.ScoreIndicator;
import sprites.SpriteCollection;
import counter.Counter;
import interfaces.Collidable;
import interfaces.Sprite;
import remover.BallRemover;
import remover.BlockRemover;

import java.awt.Color;

import interfaces.Animation;

/**
 * Game class, is a class that initialize and run the game.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation information;
    private Counter livesCounter;
    private Paddle paddle;

    /**
     * This is the constructor method which creates a GameLevel object.
     *
     * @param information  , a type of LevelInformation that symbolize the level information.
     * @param score        , a type of Counter that symbolize the score of the level.
     * @param gui          , A type of GUI that symbolizes the gui.
     * @param livesCounter , A type of Counter that symbolizes the lives
     */
    public GameLevel(LevelInformation information, Counter score, GUI gui, Counter livesCounter) {
        this.information = information;
        this.score = score;
        this.gui = gui;
        this.livesCounter = livesCounter;
    }

    /**
     * This is the getLivesCounter method which returns the lives counter.
     *
     * @return the lives counter
     */
    public Counter getLivesCounter() {
        return livesCounter;
    }

    /**
     * This is the shouldStop method which checks if the animation need to stop.
     *
     * @return the is we need to stop the animation.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * This is the doOneFrame drawing on the surface one frame.
     *
     * @param d , A type of DrawSurface which is the surface that we are drawing on.
     */
    public void doOneFrame(DrawSurface d) {
        this.keyboard = gui.getKeyboardSensor();
        //set the sleeper
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        //set the framePer second
        //set the color of the background
        this.information.drawBackGround(d);
        //draw all the sprite
        this.sprites.drawAllOn(d);
        //show the gui
        this.sprites.notifyAllTimePassed();
        // check if there is remain of 0 blocks
        if (this.counterBlocks.getValue() == 0) {
            // increase counter by 100
            this.score.increase(100);
            if (this.information.getWinningLevel() == 1) {
                Win win = new Win(this);
                KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(this.keyboard,
                        KeyboardSensor.SPACE_KEY, win);
                this.runner.run(key);
                if (key.shouldStop()) {
                    gui.close();
                    return;
                }
            }
            // close the gui
            this.running = false;
            //return
            return;
        }
        // check if there is remain of 0 balls and lives
        if (this.counterBalls.getValue() == 0 && this.getLivesCounter().getValue() == 1) {
            //create a lose object
            Lose lose = new Lose(this);
            // create a KeyPressStoppableAnimation
            KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    lose);
            // run the animation
            this.runner.run(key);
            // if the animation should stop
            if (key.shouldStop()) {
                // close the gui
                gui.close();
                return;
            }
        }
        // check if all the ball "dies" and the liveCounter is not 0
        if (this.counterBalls.getValue() == 0 && this.getLivesCounter().getValue() != 0) {
            //decrease the lives counter by 1
            this.getLivesCounter().decrease(1);
            //goes all over the balls in the level
            for (int i = 0; i < this.information.numberOfBalls(); i++) {
                // creates the balls
                Ball ball = new Ball(405, 500, 5, Color.white, this.information.initialBallVelocities().get(i),
                        environment);
                // increase the number of balls by 1
                this.counterBalls.increase(1);
                //add the ball remover
                BallRemover b = new BallRemover(this, this.counterBalls);
                // add the ball to the game
                ball.addToGame(this);
                // add to the hit listener
                ball.addHitListener(b);
            }
            // if the number of the level is 2
            if (this.information.getNumberLevel() == 2) {
                // create the paddle
                this.paddle.getRectangle().setUpperLeft(100, 570);
                // else create the paddle
            } else {
                this.paddle.getRectangle().setUpperLeft(380, 570);
            }
            // run the level
            this.run();
        }
        // if the user click on "p" or "P" or "פ"
        if (this.keyboard.isPressed("p") || this.keyboard.isPressed("P") || this.keyboard.isPressed("פ")) {
            // create a new pauseScreen
            PauseScreen pause = new PauseScreen();
            // create a pressStoppableAnimation
            KeyPressStoppableAnimation key = new KeyPressStoppableAnimation(this.keyboard,
                    KeyboardSensor.SPACE_KEY, pause);
            // run the animation
            this.runner.run(key);
        }
    }

    /**
     * This is the get method which returns the environment.
     *
     * @return the environment.
     */
    public GameEnvironment getEnvironment() {
        //return the environment
        return this.environment;
    }

    /**
     * This is the get method which returns the sprites.
     *
     * @return the sprites.
     */
    public SpriteCollection getSprites() {
        //return the sprites
        return this.sprites;
    }

    /**
     * This is the addCollidable method which gets a collidable and add it to the collidable list.
     *
     * @param c , Collidable variable, which indicate the collidable that we are want to add to the list.
     */
    public void addCollidable(Collidable c) {
        // checks if the collidable are already in the list
        if (environment.getGameEnvironment().contains(c)) {
            // if he is in the list return
            return;
        }
        // add the collidable to the list
        environment.getGameEnvironment().add(c);
    }

    /**
     * This is the get method which return the level information of the game .
     *
     * @return a int variable which indicate the height field of the point, which shows the height of the frame.
     */
    public LevelInformation getInformation() {
        return this.information;
    }

    /**
     * This is the addSprite method which gets a sprite and add it to the sprite list.
     *
     * @param s , Sprite variable, which indicate the sprite that we are want to add to the list.
     */
    public void addSprite(Sprite s) {
        // checks if the sprite are already in the list
        if (sprites.getSpriteList().contains(s)) {
            // if he is in the list return
            return;
        }
        // add the sprite to the list
        sprites.getSpriteList().add(s);
    }

    /**
     * This is the getCounterBlocks method which returns the counter of the blocks.
     *
     * @return the counter of the blocks.
     */
    public Counter getCounterBlocks() {
        return this.counterBlocks;
    }

    /**
     * This is the getCounterBlocks method which returns the counter of the balls.
     *
     * @return the counter of the blass.
     */
    public Counter getCounterBalls() {
        return this.counterBalls;
    }

    /**
     * This is the get core method which returns the counter of the score.
     *
     * @return the counter of the score.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * This is the initialize method which initialize the game.
     */
    public void initialize() {
        // create a new Counter
        this.counterBalls = new Counter(0);
        // create a new block counter
        this.counterBlocks = new Counter(0);
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        ScoreIndicator indicator = new ScoreIndicator(this);
        indicator.addToGame(this);
        biuoop.KeyboardSensor keyboard1 = gui.getKeyboardSensor();
        // create the balls
        for (int i = 0; i < this.information.numberOfBalls(); i++) {
            Ball ball = new Ball(405, 500, 5, Color.white, this.information.initialBallVelocities().get(i),
                    environment);
            this.counterBalls.increase(1);
            BallRemover b = new BallRemover(this, this.counterBalls);
            ball.addToGame(this);
            ball.addHitListener(b);
        }
        // add the background
        this.information.getBackground().addToGame(this);
        //creates the paddle
        if (this.information.getNumberLevel() == 2) {
            this.paddle = new Paddle(new Rectangle(new Point(100, 570), this.information.paddleWidth(),
                    this.information.paddleHeight()), Color.orange, keyboard1, this.information.paddleSpeed());
        } else {
            this.paddle = new Paddle(new Rectangle(new Point(380, 570), this.information.paddleWidth(),
                    this.information.paddleHeight()), Color.orange, keyboard1, this.information.paddleSpeed());
        }
        this.paddle.addToGame(this);
        // creates the blocks
        for (int i = 0; i < this.information.numberOfBlocksToRemove(); i++) {
            this.counterBlocks.increase(1);
            Block block = this.information.blocks().get(i);
            block.addToGame(this);
            BlockRemover p = new BlockRemover(this, this.counterBlocks);
            block.addHitListener(p);
        }
    }

    /**
     * This is the run method which start the animation loop.
     */
    public void run() {
        // or a similar method
        long time = System.currentTimeMillis();
        this.runner = new AnimationRunner(60, this.gui);
        this.runner.run(new CountdownAnimation(time, 3, this.sprites, this.information));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner = new AnimationRunner(60, this.gui);
        this.runner.run(this);
    }

    /**
     * This is the getCounterBlocks method which returns the counter of the balls.
     *
     * @param c , Collidable variable which indicate the collidable that we are want to remove from the game.
     */
    public void removeCollidable(Collidable c) {
        //remove c from the game
        this.environment.getGameEnvironment().remove(c);
    }

    /**
     * This is the getCounterBlocks method which returns the counter of the balls.
     *
     * @param s , Sprite variable which indicate the sprite that we are want to remove from the game.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteList().remove(s);
    }
}