

import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MinimiKeko;
import tietorakenteet.Solmu;

/**
 * Tests the working order of the MinimiKeko Class.
 * @author JJV
 */
public class MinimiKekoTest {

    /**
     * Tests whether the addition of objects to the heap works sorts the objects
     * into the right order.
     */
    @Test
    public void lisaaminenToimii() {
        Solmu a = new Solmu(5);
        a.c = 'a';
        Solmu b = new Solmu(7);
        b.c = 'b';
        Solmu c = new Solmu(9);
        c.c = 'c';
        Solmu d = new Solmu(1);
        d.c = 'd';
        Solmu e = new Solmu(3);
        e.c = 'e';


        MinimiKeko mk = new MinimiKeko(5);
        mk.add(a);
        mk.add(b);
        mk.add(c);
        mk.add(d);
        mk.add(e);

        assertEquals(mk.getTail(), 5);
        Solmu[] keko = mk.getKeko();
        assertEquals(keko[0].arvo, 1);
        assertEquals(keko[0].c, 'd');

        assertEquals(keko[1].arvo, 3);
        assertEquals(keko[1].c, 'e');
    }

    /**
     * Tests whether the joining of two objects in the heap and then adding the
     * end result creates an object of accurate proportions and sets it in its
     * right place.
     */
    @Test
    public void liittäminenToimii() {
        Solmu a = new Solmu(5);
        a.c = 'a';
        Solmu b = new Solmu(7);
        b.c = 'b';
        Solmu c = new Solmu(9);
        c.c = 'c';
        Solmu d = new Solmu(1);
        d.c = 'd';
        Solmu e = new Solmu(3);
        e.c = 'e';
        Solmu f = new Solmu(8);
        f.c = 'f';
        Solmu g = new Solmu(15);
        g.c = 'g';
        Solmu h = new Solmu(2);
        h.c = 'h';
        Solmu i = new Solmu(20);
        i.c = 'i';
        Solmu j = new Solmu(18);
        j.c = 'j';

        MinimiKeko mk = new MinimiKeko(10);
        mk.add(a);
        mk.add(b);
        mk.add(c);
        mk.add(d);
        mk.add(e);
        mk.add(f);
        mk.add(g);
        mk.add(h);
        mk.add(i);
        mk.add(j);

        Solmu[] keko = mk.getKeko();

        mk.take(); // 1+2
        assertEquals(keko[0].arvo, 3);
        mk.take(); // 3+3
        assertEquals(keko[0].arvo, 5);
        mk.take(); // 5+6
        assertEquals(keko[0].arvo, 7);
        assertEquals(keko[0].c, 'b');
        mk.take(); // 7+8
        assertEquals(keko[0].arvo, 9);
    }

    /**
     * Tests whether the variable tail is accurate through multiple additions and
     * merges.
     */
    @Test
    public void tailOnTarkka() {
        Solmu a = new Solmu(5);
        a.c = 'a';
        Solmu b = new Solmu(7);
        b.c = 'b';
        Solmu c = new Solmu(9);
        c.c = 'c';
        Solmu d = new Solmu(1);
        d.c = 'd';
        Solmu e = new Solmu(3);
        e.c = 'e';
        Solmu f = new Solmu(8);
        f.c = 'f';
        Solmu g = new Solmu(15);
        g.c = 'g';
        Solmu h = new Solmu(2);
        h.c = 'h';
        Solmu i = new Solmu(20);
        i.c = 'i';
        Solmu j = new Solmu(18);
        j.c = 'j';

        MinimiKeko mk = new MinimiKeko(10);
        assertEquals(mk.getTail(), 0);
        mk.add(a);
        mk.add(b);
        mk.add(c);
        mk.add(d);
        assertEquals(mk.getTail(), 4);
        mk.add(e);
        mk.add(f);
        mk.add(g);
        assertEquals(mk.getTail(), 7);
        mk.add(h);
        mk.add(i);
        mk.add(j);
        assertEquals(mk.getTail(), 10);
        mk.take(); // 1+2
        assertEquals(mk.getTail(), 9);
        mk.take(); // 3+3
        mk.take(); // 5+6
        mk.take(); // 7+8
        assertEquals(mk.getTail(), 6);
    }
    
    @Test
    public void lapsetAinaSuurempia(){
        Solmu a = new Solmu(5);
        a.c = 'a';
        Solmu b = new Solmu(7);
        b.c = 'b';
        Solmu c = new Solmu(9);
        c.c = 'c';
        Solmu d = new Solmu(1);
        d.c = 'd';
        Solmu e = new Solmu(3);
        e.c = 'e';
        Solmu f = new Solmu(8);
        f.c = 'f';
        Solmu g = new Solmu(15);
        g.c = 'g';
        Solmu h = new Solmu(2);
        h.c = 'h';
        Solmu i = new Solmu(20);
        i.c = 'i';
        Solmu j = new Solmu(18);
        j.c = 'j';

        MinimiKeko mk = new MinimiKeko(10);
        mk.add(a);
        mk.add(b);
        mk.take();
        mk.add(c);
        mk.add(d);
        mk.add(e);
        mk.take();
        mk.add(f);
        mk.add(g);
        mk.add(h);
        mk.add(i);
        mk.add(j);
        mk.take(); 
        mk.take();
        
        Solmu[] keko = mk.getKeko();
        for(int z =0; z<mk.getTail()/2;z++){
            if(keko[z].arvo>keko[z*2].arvo || keko[z].arvo>keko[(z*2)+1].arvo){
                assertTrue(false);
            }
        }
        
        
    }
}
