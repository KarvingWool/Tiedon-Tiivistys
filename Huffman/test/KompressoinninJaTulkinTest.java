
import huffman.Puunkasittelija;
import huffman.Tiedostonkasittelija;
import huffman.Tulkki;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
 * The test class testing that the original text is that same as the text generated
 * from uncompressing the compressed file created from the original.
 */
public class KompressoinninJaTulkinTest {

    /**
     * Creates a small text file with an unchanging content.
     * It then compresses that, decompresses the result, and compares the original
     * to the newly created character by character.
     */
    @Test
    public void tekstiSamaPienellaSyotteella() {
        File file = new File("test/testitiedostoja/testausta.txt");
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

        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/testausta.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto("test/testitiedostoja/testausta.dat", pk.getListaUusista(), pk.getPrintattavaPuu());

        Tulkki tulkki = new Tulkki("test/testitiedostoja/uncomptestausta.txt", "test/testitiedostoja/testausta.dat");

        StringBuilder newtext = new StringBuilder();
        File newFile = new File("test/testitiedostoja/uncomptestausta.txt");
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
    
    /**
     * Tests whether the text in guttenberg.txt is line by line identical to the 
     * text created by compressing the original and uncompressing the output back 
     * into readable text.
     */
    @Test
    public void toimiikoSuurellaSyotteella(){
        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/guttenberg.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto("test/testitiedostoja/gut.dat", pk.getListaUusista(), pk.getPrintattavaPuu());

        Tulkki tulkki = new Tulkki("test/testitiedostoja/uncompgut.txt", "test/testitiedostoja/gut.dat");

        BufferedReader lukija  = null;
        BufferedReader lukija2 = null;
        try {
            FileReader reader = new FileReader("test/testitiedostoja/guttenberg.txt");
            FileReader reader2 = new FileReader("test/testitiedostoja/uncompgut.txt.txt");
            lukija = new BufferedReader(reader);
            lukija2 = new BufferedReader(reader2);
            long writecount = 0;
            while(writecount<tk.getCharCount()){
                
                String s1 = lukija.readLine();
                String s2 = lukija.readLine();
                
                if(!s1.contains(s2)){
                    assertTrue(false);
                }
                writecount += s1.length();
            }
            
            
        } catch (Exception e){
            System.out.println("Problems......");
        }
        
    }
    
    
    /**
     * Creates a file with 10000 random characters with the number representation
     * between 32 and 128 (to avoid problems appending certain ascii characters into
     * the new file). This method then proceeds to compress and then uncompress
     * the file, and then compare the result to the original character by character.
     */
    @Test
    public void toimiikoSuurellaRandomisoidullaSyotteella(){
       File file = new File("test/testitiedostoja/randtestausta.txt");
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

        Tiedostonkasittelija tk = new Tiedostonkasittelija("test/testitiedostoja/randtestausta.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto("test/testitiedostoja/randtestausta.dat", pk.getListaUusista(), pk.getPrintattavaPuu());

        Tulkki tulkki = new Tulkki("test/testitiedostoja/randuncomptestausta.txt", "test/testitiedostoja/randtestausta.dat");

        StringBuilder newtext = new StringBuilder();
        File newFile = new File("test/testitiedostoja/randuncomptestausta.txt");
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
