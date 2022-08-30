//316222512

package sprites;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * The SpriteCollection class, has arrayList of all the sprites, and can draw all of them, add them to the arrayList,
 * and move all of them.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public class SpriteCollection {
    private List<Sprite> spriteList = new ArrayList<Sprite>();

    /**
     * This is the get method which return the spriteList.
     *
     * @return return the spriteList.
     */
    public List<Sprite> getSpriteList() {
        //return the spriteList
        return this.spriteList;
    }

    /**
     * This is the addSprite method which add sprite to the spriteList.
     *
     * @param s , Sprite variable which we want to add to the spriteList.
     */
    public void addSprite(Sprite s) {
        //check if the sprite is already in the spriteList
        if (spriteList.contains(s)) {
            //if he is return
            return;
        }
        //else add him.
        spriteList.add(s);
    }

    /**
     * This is the notifyAllTimePassed method which makes all the sprites move.
     */
    public void notifyAllTimePassed() {
        //go all over the spriteList
        for (int i = 0; i < spriteList.size(); i++) {
            //move them with the timePassed method
            spriteList.get(i).timePassed();
        }
    }

    /**
     * This is the drawAllOn method which draws all the sprites on the surface.
     *
     * @param d , DrawSurface variable that we want to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        //go all over the spriteList
        for (int i = 0; i < spriteList.size(); i++) {
            //draw them on the surface with the drawOn method
            spriteList.get(i).drawOn(d);
        }
    }
}