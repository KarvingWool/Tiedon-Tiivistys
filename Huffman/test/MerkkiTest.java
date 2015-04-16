
import tietorakenteet.Merkki;
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
public class MerkkiTest {
    
    public MerkkiTest() {
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
