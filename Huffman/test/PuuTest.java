
import huffman.Merkki;
import huffman.Puunkasittelija;
import huffman.Solmu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void noNodesHaveOnlyOneChild(){
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);
        hm.put('e', 1);
        hm.put('f', 15);
        hm.put('h', 3);
        hm.put('i', 10);
        hm.put('j', 3);
        
        Puunkasittelija pk = new Puunkasittelija(hm);
        Solmu root = pk.getRoot();
        int[] array = new int[1];
        treeTraversalNoSingleChildren(root, array);
        
        assertEquals(array[0], 0);
    }
    
    /**
     * A recursive method to help determine whether any nodes have only 1 child.
     * @param Solmu Root of the tree
     * @param int[] Array that holds a 0 if no exceptions were found, otherwise a 1.
     */
    public void treeTraversalNoSingleChildren(Solmu root, int[] array){
        if(root.getOikea() == null || root.getVasen() == null){
            if(root.getOikea() != null || root.getVasen() != null){
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
        HashMap<Character, Integer> hm = new HashMap();

        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);

        Puunkasittelija pk = new Puunkasittelija(hm);

        Solmu root = pk.getRoot();

        assertTrue(treeTraversalValueOrder(root, Integer.MAX_VALUE));
    }

    /**
     * A recursive method to help test that a parent nodes children have a lower
     * arvo.
     * @param Solmu Root of the tree.
     * @param boolean returns false if a child is found with a higher value than its
     * parent.
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
        HashMap<Character, Integer> hm = new HashMap();

        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);

        Puunkasittelija pk = new Puunkasittelija(hm);

        Solmu root = pk.getRoot();
        ArrayList<Integer> check = new ArrayList();
        treeTraversalCharChecking(root, check);
        assertTrue(check.isEmpty());
    }

    /**
     * A recursive method to help check that no non-leaf has a character assigned to them.
     * @param Solmu Root of the tree
     * @param ArrayList List that is added to if a non-leaf with a character is found.
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
    public void allLeavesHaveChar(){
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);
        
        Puunkasittelija pk = new Puunkasittelija(hm);
        Solmu root = pk.getRoot();
        ArrayList<Integer> check = new ArrayList();
        treeTraversalLeavesHaveChar(root, check);
        assertTrue(check.isEmpty());
    }
    
    /**
     * A recursive method to help check that all leaves have a char assigned.
     * @param Solmu Root of the tree
     * @param ArrayList List that is added to if a leaf with no char is found.
     */
    public void treeTraversalLeavesHaveChar(Solmu root, ArrayList list){
        
        if(root.getOikea() == null){
            if(root.getC() == 0){
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
    public void mostFrequentLettersShortest(){
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);
        hm.put('e', 1);
        hm.put('f', 15);
        hm.put('h', 3);
        
        Puunkasittelija pk = new Puunkasittelija(hm);
        Solmu root = pk.getRoot();
        
        HashMap<Integer, Integer> lengths = new HashMap();
        
        for(int i =0;i<pk.getListaUusista().size();i++){
            for(int n = i+1;n<pk.getListaUusista().size();n++){
                if(hm.get(pk.getListaUusista().get(i).getMerkki()) > hm.get(pk.getListaUusista().get(n).getMerkki()) && pk.getListaUusista().get(i).getNewBits().length() >pk.getListaUusista().get(n).getNewBits().length()){
                    assertTrue(false);
                } else if (hm.get(pk.getListaUusista().get(n).getMerkki()) > hm.get(pk.getListaUusista().get(i).getMerkki()) && pk.getListaUusista().get(n).getNewBits().length() >pk.getListaUusista().get(i).getNewBits().length()){
                    assertTrue(false);
                }
            }
        }
    }
    
    
    /**
     * A test to make sure all the characters in the given Map are added into the tree.
     */
    @Test
    public void allCharactersAddedToTree(){
        HashMap<Character, Integer> hm = new HashMap();
        hm.put('a', 5);
        hm.put('b', 3);
        hm.put('c', 9);
        hm.put('d', 7);
        hm.put('e', 1);
        hm.put('f', 15);
        hm.put('h', 3);
        
        Puunkasittelija pk = new Puunkasittelija(hm);
        Solmu root = pk.getRoot();
        int[] array = new int[1];
        treeTraversalAllAdded(root, array);
        assertEquals(array[0], 7);
    }
    
    /**
     * A recursive method to help check that all characters from given map are 
     * added to the tree.
     * @param Solmu Root of the tree.
     * @param int[] Array for counting how many leaves have been encountered.
    */
     public void treeTraversalAllAdded(Solmu root, int[] array){
        
        if(root.getOikea() == null){
            array[0]++;
        } else {
            treeTraversalAllAdded(root.getOikea(), array);
            treeTraversalAllAdded(root.getVasen(), array);
        }
        
    }
    
}
