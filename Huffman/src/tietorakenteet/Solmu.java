package tietorakenteet;

/**
 * The class defining a node in a tree.
 *
 * @author JJV
 */
public class Solmu implements Comparable {

    /**
     * The left child of this node. Can be null.
     */
    public Solmu vasen;
    /**
     * The right child of this node. Can be null.
     */
    public Solmu oikea;
    /**
     * The value of this node, also the sum of all the values of its children.
     */
    public int arvo;
    /**
     * The char assigned to this node. If the char has a value other than 0
     * we know its a leaf.
     */
    public char c = 0;

    /**
     * The constructor of this class. Assigns a value to arvo.
     *
     * @param int The value to assign this node.
     */
    public Solmu(int arvo) {
        this.arvo = arvo;
    }

    /**
     * Compares this object to another, and returns a positive or negative depending
     * on the arvo values of the two.
     * @param Solmu The node we want to compare this one to.
     * @return int Negative if the compared nodes "arvo" is larger than this
     * one, positive if not.
     */
    @Override
    public int compareTo(Object o) {
        Solmu compare = (Solmu) o;
        return this.arvo - compare.arvo;
    }

    /**
     * Returns this nodes left child.
     * @return Solmu vasen
     */
    public Solmu getVasen() {
        return vasen;
    }
/**
     * Returns this nodes right child.
     * @return Solmu oikea
     */
    public Solmu getOikea() {
        return oikea;
    }

    /**
     * Returns this nodes value.
     * @return int arvo
     */
    public int getArvo() {
        return arvo;
    }

    /**
     * Returns this nodes corresponding character.
     * @return char c
     */
    public char getC() {
        return c;
    }
}
