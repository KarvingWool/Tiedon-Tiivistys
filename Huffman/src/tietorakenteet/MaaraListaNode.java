package tietorakenteet;

/**
 * Class defining an object of the MaaraLista.
 *
 * @author JJV
 */
public class MaaraListaNode {

    /**
     * The char value of the object. A list may only contain one object per each
     * character value.
     */
    char c;
    /**
     * The frequency of this character in the original text.
     */
    int count;
    /**
     * The object on the left (before) this object on the list.
     */
    MaaraListaNode vasen = null;
    /**
     * The object on the right (after) this object on the list.
     */
    MaaraListaNode oikea = null;

    /**
     * The constructor for the class. Defines the char value and frequency of
     * the object.
     *
     * @param c Char value of the object.
     * @param count Frequency of the object.
     */
    public MaaraListaNode(char c, int count) {
        this.c = c;
        this.count = count;
    }

    /**
     * Sets the object on the left (before) this object.
     *
     * @param vasen
     */
    public void setVasen(MaaraListaNode vasen) {
        this.vasen = vasen;
    }

    /**
     * Sets the object on the right (after) this object.
     *
     * @param oikea
     */
    public void setOikea(MaaraListaNode oikea) {
        this.oikea = oikea;
    }

    /**
     * Returns the object on the left (before) this object.
     *
     * @return vasen
     */
    public MaaraListaNode getVasen() {
        return vasen;
    }

    /**
     * Returns the object on the right (after) this object.
     *
     * @return oikea
     */
    public MaaraListaNode getOikea() {
        return oikea;
    }

    /**
     * Returns the character specific to this object.
     *
     * @return c
     */
    public char getC() {
        return c;
    }

    /**
     * Returns the frequency of this objects character.
     *
     * @return count
     */
    public int getCount() {
        return count;
    }
}
