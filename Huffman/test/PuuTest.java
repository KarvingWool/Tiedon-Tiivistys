
import huffman.Merkki;
import huffman.Puunkasittelija;
import tietorakenteet.Solmu;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.*;

/**
 *
 * @author JJV
 */
public class PuuTest {

    public PuuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * A test to check that all nodes have either two or zero children.
     */
    @Test
    public void noNodesHaveOnlyOneChild() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 5);
        lista.add('b', 3);
        lista.add('c', 9);
        lista.add('d', 7);
        lista.add('e', 1);
        lista.add('f', 15);
        lista.add('h', 3);
        lista.add('i', 10);
        lista.add('j', 3);

        Puunkasittelija pk = new Puunkasittelija(lista);
        Solmu root = pk.getRoot();
        int[] array = new int[1];
        treeTraversalNoSingleChildren(root, array);

        assertEquals(array[0], 0);
    }

    /**
     * A recursive method to help determine whether any nodes have only 1 child.
     *
     * @param Solmu Root of the tree
     * @param int[] Array that holds a 0 if no exceptions were found, otherwise
     * a 1.
     */
    public void treeTraversalNoSingleChildren(Solmu root, int[] array) {
        if (root.getOikea() == null || root.getVasen() == null) {
            if (root.getOikea() != null || root.getVasen() != null) {
                array[0] = 1;
            }
        } else {
            treeTraversalNoSingleChildren(root.getOikea(), array);
            treeTraversalNoSingleChildren(root.getVasen(), array);

        }
    }

    /**
     * Tests that a nodes children always have a lower arvo than their parent.
     */
    @Test
    public void treeNodeValuesInRightOrder() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 5);
        lista.add('b', 3);
        lista.add('c', 9);
        lista.add('d', 7);

        Puunkasittelija pk = new Puunkasittelija(lista);

        Solmu root = pk.getRoot();

        assertTrue(treeTraversalValueOrder(root, Integer.MAX_VALUE));
    }

    /**
     * A recursive method to help test that a parent nodes children have a lower
     * arvo.
     *
     * @param Solmu Root of the tree.
     * @param boolean returns false if a child is found with a higher value than
     * its parent.
     * @return
     */
    public boolean treeTraversalValueOrder(Solmu root, int higherVal) {

        if (higherVal < root.getArvo()) {
            return false;
        }

        if (root.getOikea() != null) {
            if (!treeTraversalValueOrder(root.getOikea(), root.getArvo())) {
                return false;
            }
        }
        if (root.getVasen() != null) {
            if (!treeTraversalValueOrder(root.getVasen(), root.getArvo())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks that only leaves have a character assigned to them.
     */
    @Test
    public void onlyLeavesHaveChar() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 5);
        lista.add('b', 3);
        lista.add('c', 9);
        lista.add('d', 7);

        Puunkasittelija pk = new Puunkasittelija(lista);

        Solmu root = pk.getRoot();
        ArrayList<Integer> check = new ArrayList();
        treeTraversalCharChecking(root, check);
        assertTrue(check.isEmpty());
    }

    /**
     * A recursive method to help check that no non-leaf has a character
     * assigned to them.
     *
     * @param Solmu Root of the tree
     * @param ArrayList List that is added to if a non-leaf with a character is
     * found.
     */
    public void treeTraversalCharChecking(Solmu root, ArrayList list) {

        char c = root.getC();
        if (c != 0) {
            if (root.getOikea() != null) {
                list.add(1);
            }
        } else {
            treeTraversalCharChecking(root.getOikea(), list);
            treeTraversalCharChecking(root.getVasen(), list);
        }
    }

    /**
     * A test checking that all leaves have a character assigned to them.
     */
    @Test
    public void allLeavesHaveChar() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 5);
        lista.add('b', 3);
        lista.add('c', 9);
        lista.add('d', 7);

        Puunkasittelija pk = new Puunkasittelija(lista);
        Solmu root = pk.getRoot();
        ArrayList<Integer> check = new ArrayList();
        treeTraversalLeavesHaveChar(root, check);
        assertTrue(check.isEmpty());
    }

    /**
     * A recursive method to help check that all leaves have a char assigned.
     *
     * @param Solmu Root of the tree
     * @param ArrayList List that is added to if a leaf with no char is found.
     */
    public void treeTraversalLeavesHaveChar(Solmu root, ArrayList list) {

        if (root.getOikea() == null) {
            if (root.getC() == 0) {
                list.add(1);
            }
        } else {
            treeTraversalLeavesHaveChar(root.getOikea(), list);
            treeTraversalLeavesHaveChar(root.getVasen(), list);
        }
    }

    /**
     * A test to check that the characters with the highest frequency get the
     * shortest bit representations.
     */
    @Test
    public void mostFrequentLettersShortest() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 1);
        lista.add('b', 3);
        lista.add('c', 5);
        lista.add('d', 7);
        lista.add('e', 10);
        lista.add('f', 14);
        lista.add('h', 19);
        lista.add('i', 32);

        Puunkasittelija pk = new Puunkasittelija(lista);
        MerkkiLista merkit = pk.getListaUusista();

        MerkkiListaNode eka = merkit.getAlku();
        MerkkiListaNode toka = merkit.getAlku();
        while(eka != null){
            toka = eka;
            while(toka != null){
                if(eka.getM().getMerkki()<toka.getM().getMerkki() && eka.getM().getNewBits().length()<toka.getM().getNewBits().length()){
                    assertTrue(false);
                }
                else if(eka.getM().getMerkki()>toka.getM().getMerkki() && eka.getM().getNewBits().length()>toka.getM().getNewBits().length()){
                    assertTrue(false);
                }
                toka = toka.getOikea();
            }
            eka = eka.getOikea();
        }


    }

    /**
     * A test to make sure all the characters in the given Map are added into
     * the tree.
     */
    @Test
    public void allCharactersAddedToTree() {
        MaaraLista lista = new MaaraLista();
        lista.add('a', 5);
        lista.add('b', 3);
        lista.add('c', 9);
        lista.add('d', 7);
        lista.add('e', 1);
        lista.add('f', 15);
        lista.add('h', 3);
        lista.add('i', 10);

        Puunkasittelija pk = new Puunkasittelija(lista);
        Solmu root = pk.getRoot();
        int[] array = new int[1];
        treeTraversalAllAdded(root, array);
        assertEquals(array[0], 8);
    }

    /**
     * A recursive method to help check that all characters from given map are
     * added to the tree.
     *
     * @param Solmu Root of the tree.
     * @param int[] Array for counting how many leaves have been encountered.
     */
    public void treeTraversalAllAdded(Solmu root, int[] array) {

        if (root.getOikea() == null) {
            array[0]++;
        } else {
            treeTraversalAllAdded(root.getOikea(), array);
            treeTraversalAllAdded(root.getVasen(), array);
        }

    }
}
