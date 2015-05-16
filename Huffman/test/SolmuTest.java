
import tietorakenteet.Solmu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests that the Class for the Object Solmu is in working order.
 * @author JJV
 */
public class SolmuTest {
    
    /**
     * Tests that the Solmu classes constructor assigns the right values when creating
     * a new object.
     */
     @Test
     public void konstruktoriAlkuarvotOikein() {
         Solmu s = new Solmu(15);
         
         assertTrue(s.getVasen() == null);
         assertTrue(s.getOikea() == null);
         assertTrue(s.getArvo() == 15);
         assertTrue(s.getC() == 0);
     }
     
     
}
