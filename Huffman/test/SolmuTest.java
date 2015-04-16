
import tietorakenteet.Solmu;
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
public class SolmuTest {
    
    public SolmuTest() {
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
