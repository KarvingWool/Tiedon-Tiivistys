package huffman;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import tietorakenteet.MaaraLista;
import tietorakenteet.MaaraListaNode;

/**
 * The main class for the project. Nothing much is done here except the calls
 * to the respective classes to do their individual jobs.
 * @author JJV
 */

public class Huffman {

    /**
     * The main method for the project. A Tiedostonkasittelija and Puunksittelija object are
     * created and then used for their respective jobs.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Give source of the text document you wish to compress, eg. test.txt: ");
        String teksti = lukija.nextLine();
        System.out.print("Give wished name of compressed file, eg. comp.dat: ");
        String comp = lukija.nextLine();
        System.out.print("Give wished name for uncompressed file: ");
        String newname = lukija.nextLine();
        Tiedostonkasittelija tk = new Tiedostonkasittelija(teksti);
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        tk.luoKompTiedosto(comp, pk.getListaUusista());
        
        Tulkki tulkki = new Tulkki(pk.getRoot(), newname, comp, tk.charCount);

        
        
    }
}
