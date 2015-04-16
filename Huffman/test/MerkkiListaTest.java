
import huffman.Merkki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MerkkiLista;
import tietorakenteet.MerkkiListaNode;

/**
 *
 * @author JJV
 */
public class MerkkiListaTest {

    public MerkkiListaTest() {
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
