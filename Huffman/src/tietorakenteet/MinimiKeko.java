package tietorakenteet;

/**
 * A PriorityQueue like data structure to house Solmu objects.
 *
 * @author JJV
 */
public class MinimiKeko {

    /**
     * The array containing all the Solmu objects.
     */
    Solmu[] keko;
    /**
     * The pointer to the first open spot in the array.
     */
    int tail = 0;

    /**
     * The Classes constructor. Creates the array, and assigns it its maximum
     * size.
     */
    public MinimiKeko(int koko) {
        keko = new Solmu[koko];
    }

    /**
     * This metho adds a Solmu to the end of the array, and then moves it to its
     * rightful place, increasing the tail variables value by one.
     *
     * @param Solmu s The Object one wants to add to the heap.
     */
    public void add(Solmu s) {
        int pointer = tail;
        keko[pointer] = s;

        while (true) {
            if (keko[pointer / 2].arvo > s.arvo) {
                Solmu apu = keko[pointer / 2];
                keko[pointer / 2] = s;
                keko[pointer] = apu;
                pointer = pointer / 2;
            } else {
                break;
            }
        }


        tail++;
    }

    /**
     * Combines the two smallest Solmu objects in the heap into one, and adds
     * the newly created Solmu to the heap.
     */
    public void take() {

        Solmu eka = keko[0];
        keko[0] = keko[tail - 1];
        tail--;
        heapify();

        Solmu toka = keko[0];
        keko[0] = keko[tail - 1];
        tail--;
        heapify();

        Solmu vanhempi = new Solmu(eka.arvo + toka.arvo);
        vanhempi.vasen = eka;
        vanhempi.oikea = toka;
        add(vanhempi);
    }

    /**
     * A helping method to make sure the minimum heaps requirements are still
     * met after the taking out of a Solmu. Decreases the tail variables value.
     */
    public void heapify() {

        int pointer = 0;
        while (true) {
            if (pointer * 2 + 1 == tail) {
                if (keko[pointer].arvo > keko[pointer * 2].arvo) {
                    Solmu apu = keko[pointer];
                    keko[pointer] = keko[pointer * 2];
                    keko[pointer * 2] = apu;
                    pointer = pointer * 2;
                }
                break;
            } else if (pointer * 2 >= tail) {
                break;
            } else {
                if (keko[pointer].arvo > keko[pointer * 2].arvo || keko[pointer].arvo > keko[(pointer * 2) + 1].arvo) {
                    Solmu apu = keko[pointer];
                    if (keko[pointer * 2].arvo > keko[(pointer * 2) + 1].arvo) {
                        keko[pointer] = keko[(pointer * 2) + 1];
                        keko[(pointer * 2) + 1] = apu;
                        pointer = pointer * 2 + 1;
                    } else {
                        keko[pointer] = keko[pointer * 2];
                        keko[pointer * 2] = apu;
                        pointer = pointer * 2;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Returns the tail variables value.
     *
     * @return tail
     */
    public int getTail() {
        return tail;
    }

    /**
     * Returns the array encompassing the heap.
     *
     * @return keko
     */
    public Solmu[] getKeko() {
        return keko;
    }
}
