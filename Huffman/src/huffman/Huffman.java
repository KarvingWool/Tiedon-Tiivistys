package huffman;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    public static void main(String[] args) {

        Tiedostonkasittelija tk = new Tiedostonkasittelija("file.txt");
        Puunkasittelija pk = new Puunkasittelija(tk.scan());
        
        tk.luoTiedosto("comp.dat", pk.getListaUusista());
    }
}
