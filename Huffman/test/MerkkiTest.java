
import tietorakenteet.Merkki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The class that tests the class of the object Merkki.
 */
public class MerkkiTest {
    
    
    /**
     * Tests the the Merkki classes constructor assigns the right values to the 
     * object when a new one is created.
     */
    
     @Test
     public void konstruktoriToimii() {
         Merkki m = new Merkki('c', "01101");
         assertEquals(m.getMerkki(), 'c');
         assertEquals(m.getNewBits(), "01101");
     }
     
}
