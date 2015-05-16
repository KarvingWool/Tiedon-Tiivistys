

import huffman.Tiedostonkasittelija;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MaaraLista;

/**
 * The tests to determine that the initial funcionality of the
 * Tiedostonkasittelija class is faultless. The testing of whether the class
 * produces the right compressed file is done in the KompressoinninJaTulkinTest
 * class.
 *
 * @author JJV
 */
public class TiedostoTest {

    /**
     * A test to check that the file assigned in the constructor is the right
     * one.
     */
    @Test
    public void konstruktoriinOikeaTiedosto() {
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/testausta.txt");
        assertTrue(tk.getFile().getName().equals("testausta.txt"));
    }

    /**
     * A test to check that the bitToInt method returns the right integer values
     * for the given bit set.
     */
    @Test
    public void bitToInt() {
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/testausta.txt");
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

    /**
     * A test to check that the character count of a text document is accurate.
     */
    @Test
    public void charcountOikea() {
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/testausta.txt");
        tk.scan();
        assertEquals(tk.getCharCount(), 44);
    }
    
    /**
     * A test to check that the list containing the frequency of the characters 
     * constructed on the basis of the text document is accurate.
     */
    @Test
    public void listaToistojenMaarastaOikea(){
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/testausta.txt");
        MaaraLista ml = tk.scan();

        assertEquals(ml.getLength(), 18);
        assertEquals(ml.getAlku().getC(), 'K');
        assertEquals(ml.getAlku().getCount(), 1);
        assertEquals(ml.getAlku().getOikea().getOikea().getOikea().getOikea().getC(), 'o');
        assertEquals(ml.getAlku().getOikea().getOikea().getOikea().getOikea().getCount(), 4);
    }
}
