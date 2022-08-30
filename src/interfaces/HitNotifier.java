//316222512

package interfaces;

/**
 * The HitNotifier interface, is an interface that says that every object that is HitNotifier must
 * have the addHitListener method and removeHitListener method.
 *
 * @author Ido Tavron
 * @version 1.0
 * @since 2021-05-23
 */
public interface HitNotifier {

    /**
     * This is the addHitListener method which gets HitListener and add him to the HitListener list.
     *
     * @param hl , A type of HitListener variable that symbolizes the HitListener we are wanting to add to the list.
     */
    void addHitListener(HitListener hl);

    /**
     * This is the removeHitListener method which gets HitListener and remove him from the HitListener list.
     *
     * @param hl , A type of HitListener variable that symbolizes the HitListener we are wanting to
     *           remove from the list.
     */
    void removeHitListener(HitListener hl);
}