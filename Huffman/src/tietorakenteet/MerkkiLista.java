package tietorakenteet;

/**
 * The class for a list containing the needed Merkki objects.
 *
 * @author JJV
 */
public class MerkkiLista {

    /**
     * Length of the list.
     */
    int length = 0;
    /**
     * The first object on the list.
     */
    MerkkiListaNode alku = null;
    /**
     * The last object on the list.
     */
    MerkkiListaNode loppu = null;

    /**
     * The method to add objects to the list.
     *
     * @param Merkki The object that one wants to add to the list.
     */
    public void add(Merkki m) {
        MerkkiListaNode ln = new MerkkiListaNode(m);

        if (length == 0) {
            alku = ln;
            loppu = ln;
            length++;
        } else {
            loppu.oikea = ln;
            ln.vasen = loppu;
            loppu = ln;
            length++;
        }
    }

    /**
     * Returns the lists length.
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the first (leftmost) object in the list.
     *
     * @return alku
     */
    public MerkkiListaNode getAlku() {
        return alku;
    }
}
