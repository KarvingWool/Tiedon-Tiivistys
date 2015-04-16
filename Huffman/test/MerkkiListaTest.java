
import tietorakenteet.Merkki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MerkkiLista;
import tietorakenteet.MerkkiListaNode;

/**
 * Tests the MerkkiLista and MerkkiListaNode classes.
 * @author JJV
 */
public class MerkkiListaTest {

    /**
     * Tests whether the addition of Merkki objects to the list works in the 
     * desired way.
     */
    @Test
    public void lisaaminenOnnistuu() {
        MerkkiLista ml = new MerkkiLista();
        Merkki a = new Merkki('a', "101");
        Merkki b = new Merkki('b', "10111");
        Merkki c = new Merkki('c', "10100");
        Merkki d = new Merkki('d', "00");

        ml.add(a);
        ml.add(b);
        ml.add(c);
        ml.add(d);

        MerkkiListaNode node = ml.getAlku();
        assertEquals(node.getM().getMerkki(), 'a');
        assertEquals(node.getM().getNewBits(), "101");

        node = node.getOikea();
        assertEquals(node.getM().getMerkki(), 'b');
        assertEquals(node.getM().getNewBits(), "10111");

        node = node.getOikea();
        assertEquals(node.getM().getMerkki(), 'c');
        assertEquals(node.getM().getNewBits(), "10100");

        node = node.getOikea();
        assertEquals(node.getM().getMerkki(), 'd');
        assertEquals(node.getM().getNewBits(), "00");
    }

    /**
     * Tests whether the variable describing the size of the list is accurate.
     */
    @Test
    public void listanKokoOikea() {
        MerkkiLista ml = new MerkkiLista();
        Merkki a = new Merkki('a', "101");
        Merkki b = new Merkki('b', "10111");
        Merkki c = new Merkki('c', "10100");
        Merkki d = new Merkki('d', "00");

        assertEquals(ml.getLength(), 0);
        ml.add(a);
        assertEquals(ml.getLength(), 1);
        ml.add(b);
        assertEquals(ml.getLength(), 2);
        ml.add(c);
        assertEquals(ml.getLength(), 3);
        ml.add(d);
    }
}
