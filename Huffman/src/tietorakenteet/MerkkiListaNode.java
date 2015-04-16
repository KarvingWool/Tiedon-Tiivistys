package tietorakenteet;

/**
 * An single object in the MerkkiLista list.
 *
 * @author JJV
 */
public class MerkkiListaNode {

    /**
     * The Merkki object that acts as this objects identifier.
     */
    Merkki m;
    /**
     * The object on the right (after) of this object in the list.
     */
    MerkkiListaNode oikea = null;
    /**
     * The object on the left (before) of this object in the list.
     */
    MerkkiListaNode vasen = null;

    /**
     * The constructor defining Merkki m.
     *
     * @param m
     */
    public MerkkiListaNode(Merkki m) {
        this.m = m;
    }

    /**
     * Returns the identifying Merkki object
     *
     * @return Merkki m
     */
    public Merkki getM() {
        return m;
    }

    /**
     * Returns the object on the right (after) this object on the list.
     *
     * @return
     */
    public MerkkiListaNode getOikea() {
        return oikea;
    }

    /**
     * Returns the object on the left (before) this object on the list.
     *
     * @return
     */
    public MerkkiListaNode getVasen() {
        return vasen;
    }
}
