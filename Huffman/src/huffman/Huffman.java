package huffman;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    static ArrayList<Merkki> listaUusista;

    public static void main(String[] args) {

        listaUusista = new ArrayList<Merkki>();

        File tiedosto = new File("file.txt");

        try {
            Scanner lukija = new Scanner(tiedosto);
            HashMap<Character, Integer> maarat = scan(lukija);
            Solmu root = luoPuu(maarat);
            String s = "";
            treeTraversal(root, s);



        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    public static HashMap scan(Scanner lukija) {
        HashMap<Character, Integer> maarat = new HashMap<Character, Integer>();
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();

            for (int i = 0; i < rivi.length(); i++) {
                char c = rivi.charAt(i);
                if (maarat.containsKey(c)) {
                    int apu = maarat.get(c);
                    maarat.remove(c);
                    maarat.put(c, apu + 1);
                } else {
                    maarat.put(c, 1);
                }
            }
        }
        return maarat;
    }

    public static void luoTiedosto(Scanner lukija) {

        try {
            DataOutputStream os = new DataOutputStream(new FileOutputStream("comp.dat"));

            



        } catch (Exception e) {
        }

    }

    public static void treeTraversal(Solmu s, String str) {

        if (s.vasen == null && s.oikea == null) {
            Merkki m = new Merkki(s.c, str);
            listaUusista.add(m);
        }

        if (s.vasen != null) {
            String newS = new String(str += '1');
            treeTraversal(s.vasen, newS);
        }
        if (s.oikea != null) {
            String newS = new String(str += '0');
            treeTraversal(s.oikea, newS);
        }
    }

    public static Solmu luoPuu(HashMap<Character, Integer> maarat) {
        Solmu root = null;

        PriorityQueue<Solmu> pq = new PriorityQueue<Solmu>();
        for (char c : maarat.keySet()) {
            Solmu s = new Solmu(maarat.get(c));
            s.c = c;
            pq.add(s);
        }

        while (!pq.isEmpty()) {
            Solmu eka = pq.poll();

            if (pq.isEmpty()) {
                root = eka;
                break;
            }

            Solmu toka = pq.poll();

            Solmu vanhempi = new Solmu(eka.arvo + toka.arvo);
            vanhempi.vasen = eka;
            vanhempi.oikea = toka;
            pq.add(vanhempi);
        }
        return root;
    }
}
