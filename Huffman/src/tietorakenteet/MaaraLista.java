package tietorakenteet;

/**
 * The class of the list containing all the characters found in the text one
 * wants compressed, and the given characters frequency.
 *
 * @author JJV
 */
public class MaaraLista {

    /**
     * Length of the list.
     */
    int length = 0;
    /**
     * The first (leftmost) object of the list.
     */
    MaaraListaNode alku = null;
    /**
     * The last (rightmost) object of the list.
     */
    MaaraListaNode loppu = null;

    /**
     * Returns the object on the list that has the character value of c.
     *
     * @param c The wanted character value of the object.
     * @return Node with the character value of c, or null if the node doesn't
     * exist.
     */
    public MaaraListaNode contains(char c) {
        MaaraListaNode pointer = alku;

        if (alku == null) {
            return null;
        }
        if (alku.c == c) {
            return alku;
        }

        while (pointer.oikea != null) {
            pointer = pointer.oikea;
            if (pointer.c == c) {
                return pointer;
            }
        }
        return null;
    }

    /**
     * Adds an object to the list with the char value of c, and frequency of i.
     * If an object already exists in the list having the char value c, the
     * count of the already existing object is grown by i.
     *
     * @param c The wanted char value of the object.
     * @param i The frequency of the char specified.
     */
    public void add(char c, int i) {
        MaaraListaNode node = contains(c);
        if (node == null) {
            if (length == 0) {
                MaaraListaNode ln = new MaaraListaNode(c, i);
                alku = ln;
                loppu = ln;
                length++;
            } else {
                MaaraListaNode ln = new MaaraListaNode(c, i);
                loppu.oikea = ln;
                ln.vasen = loppu;
                loppu = ln;
                length++;
            }
        } else {
            node.count += i;
        }
    }

    /**
     * Returns the first object on the list.
     *
     * @return
     */
    public MaaraListaNode getAlku() {
        return alku;
    }

    /**
     * Returns the length of the list.
     *
     * @return
     */
    public int getLength() {
        return length;
    }
}
