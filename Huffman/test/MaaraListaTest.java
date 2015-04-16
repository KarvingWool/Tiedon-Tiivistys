
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tietorakenteet.MaaraLista;
import tietorakenteet.MaaraListaNode;

/**
 * The test for the class MaaraLista and MaaraListaNode.
 * @author JJV
 */
public class MaaraListaTest {

    
    /**
     * Test whether adding object to the list has the desired results.
     */
     @Test
     public void listaanLisaysToimii() {
         MaaraLista lista = new MaaraLista();
         
         lista.add('f', 5);
         lista.add('g', 3);
         MaaraListaNode ln = lista.getAlku();
         assertEquals(ln.getC(), 'f');
         assertEquals(ln.getCount(), 5);
         assertEquals(ln.getOikea().getC(), 'g');
         assertEquals(ln.getOikea().getCount(), 3);
     }
     /**
      * Tests whether adding already present characters to the list gives the 
      * desired results.
      */
     @Test
     public void listastaLoytyvanCharinLisaysToimii(){
         MaaraLista lista = new MaaraLista();
         
         lista.add('f', 5);
         lista.add('g', 3);
         lista.add('f', 2);
         lista.add('f', 1);
         lista.add('g', 9);
         MaaraListaNode ln = lista.getAlku();
         assertEquals(ln.getC(), 'f');
         assertEquals(ln.getCount(), 8);
         assertEquals(ln.getOikea().getC(), 'g');
         assertEquals(ln.getOikea().getCount(), 12);
         assertEquals(ln.getOikea().getOikea(), null);
     }
     
     /**
      * Tests whether the size variable is accurate after multiple additions.
      */
     @Test
     public void listanKokoOikea(){
          MaaraLista lista = new MaaraLista();
         assertEquals(lista.getLength(), 0);
         lista.add('f', 5);
         assertEquals(lista.getLength(), 1);
         lista.add('g', 3);
         assertEquals(lista.getLength(), 2);
         lista.add('r', 2);
         assertEquals(lista.getLength(), 3);
         lista.add('l', 7);
         assertEquals(lista.getLength(), 4);
         lista.add('f', 1);
         
         assertEquals(lista.getLength(), 4);
         
     }
}
