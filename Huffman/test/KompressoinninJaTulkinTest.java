
import huffman.Puunkasittelija;
import huffman.Tiedostonkasittelija;
import huffman.Tulkki;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
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
public class KompressoinninJaTulkinTest {

    public KompressoinninJaTulkinTest() {
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
    public void tekstiSamaPienellaSyotteella() {
        File file = new File("testausta.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Problem creating file");
        }
        FileWriter fr = null;
        String test = "Katsotaan tuleeko samana ulos!Ja toinen rivi";
        try {
            fr = new FileWriter(file);
            fr.append(test);

        } catch (Exception e) {
            System.out.println("Problem creating writer.");
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("not able to close");
            }
        }

        Tiedostonkasittelija tk = new Tiedostonkasittelija("testausta.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto("testausta.dat", pk.getListaUusista());

        Tulkki tulkki = new Tulkki(pk.getRoot(), "uncomptestausta.txt", "testausta.dat", tk.getCharCount());

        StringBuilder newtext = new StringBuilder();
        File newFile = new File("uncomptestausta.txt");
        try {
            Scanner lukija = new Scanner(newFile);
            while (lukija.hasNextLine()) {
                String s = lukija.nextLine();
                newtext.append(s);
            }

            assertEquals(newtext.toString(), test);

        } catch (Exception e) {
            System.out.println("Problem reading text");
        }
    }
    
    
    
    @Test
    public void toimiikoSuurellaRandomisoidullaSyotteella(){
       File file = new File("randtestausta.txt");
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Problem creating file");
        }
        FileWriter fr = null;
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        
        for(int i= 0; i<10000;i++){
            sb.append((char) (32 + r.nextInt(94)));
        }
        String test = "Katsotaan tuleeko samana ulos!Ja toinen rivi";
        try {
            fr = new FileWriter(file);
            fr.append(sb.toString());

        } catch (Exception e) {
            System.out.println("Problem creating writer.");
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("not able to close");
            }
        }

        Tiedostonkasittelija tk = new Tiedostonkasittelija("randtestausta.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto("randtestausta.dat", pk.getListaUusista());

        Tulkki tulkki = new Tulkki(pk.getRoot(), "randuncomptestausta.txt", "randtestausta.dat", tk.getCharCount());

        StringBuilder newtext = new StringBuilder();
        File newFile = new File("randuncomptestausta.txt");
        try {
            Scanner lukija = new Scanner(newFile);
            while (lukija.hasNextLine()) {
                String s = lukija.nextLine();
                newtext.append(s);
            }

            assertEquals(newtext.toString(), sb.toString());

        } catch (Exception e) {
            System.out.println("Problem reading text");
        } 
    }
    
}
