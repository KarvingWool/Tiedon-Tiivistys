package huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

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

        Tiedostonkasittelija tk = new Tiedostonkasittelija("file.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        
        tk.luoTiedosto("comp.dat", pk.getListaUusista());
    }
}
