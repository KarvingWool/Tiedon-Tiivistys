
import tietorakenteet.Merkki;
import huffman.Tiedostonkasittelija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostoTest {

    public TiedostoTest() {
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
     * A test to check that the bitToInt method returns the right integer values for
     * the given bit set.
     */
    @Test
    public void bitToInt() {
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test.txt");
        int[] a = new int[8];
        a[7] = 1;
        a[5] = 1;
        a[4] = 1;
        int[] b = new int[8];
        int[] c = new int[8];
        c[5] = 1;
        assertEquals(tk.bitsToInt(a), 13);
        assertEquals(tk.bitsToInt(b), 0);
        assertEquals(tk.bitsToInt(c), 4);
    }
}
