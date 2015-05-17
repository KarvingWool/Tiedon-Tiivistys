package huffman;

import java.util.Scanner;
import tietorakenteet.*;

/**
 * The main class for the project. Nothing much is done here except the calls to
 * the respective classes to do their individual jobs.
 *
 * @author JJV
 */
public class Huffman {

    /**
     * The main method for the project. A Tiedostonkasittelija and
     * Puunksittelija object are created and then used for their respective
     * jobs.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Would you like to compress, or uncompress a file? (c/u): ");
        String kumpi = lukija.nextLine();

        if (kumpi.equals("c")) {
            System.out.print("Give source of the text document you wish to compress, eg. test.txt: ");
            String teksti = lukija.nextLine();
            System.out.print("Give wished name of compressed file, eg. comp.dat: ");
            String comp = lukija.nextLine();
            Tiedostonkasittelija tk = new Tiedostonkasittelija(teksti);
            Puunkasittelija pk = new Puunkasittelija(tk.scan());
            tk.luoKompTiedosto(comp, pk.getListaUusista(), pk.getPrintattavaPuu());
//            System.out.println(tk.getCharCount());
        } else if (kumpi.equals("u")) {
            System.out.print("Give the name of compressed file, eg. comp.dat: ");
            String comp = lukija.nextLine();
            System.out.print("Give wished name for uncompressed file: ");
            String newname = lukija.nextLine();
            System.out.print("Encoding of the text document, ANSI (a) or UTF-8 (8): ");
            String enc = lukija.nextLine();
            if (enc.equals("a")) {
                Tulkki tulkki = new Tulkki(newname, comp, false);
            } else if (enc.equals("8")) {
                Tulkki tulkki = new Tulkki(newname, comp, true);
            } else {
                System.out.println("Please insert 8 or a");
            }
            
//            System.out.println(tulkki.charCount);
        } else {
            System.out.println("Please enter 'c' or 'u' next time.");
        }

    }
}
