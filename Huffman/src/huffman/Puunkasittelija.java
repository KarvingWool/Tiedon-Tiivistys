package huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Puunkasittelija {
    private Solmu root;
    private ArrayList<Merkki> listaUusista;
    
    public Puunkasittelija(HashMap<Character, Integer> maarat){
        
        root = luoPuu(maarat);
        listaUusista = new ArrayList();
        uudetArvot(root, new String(""));
        
    }
    
    public static Solmu luoPuu(HashMap<Character, Integer> maarat) {
        Solmu root = null;

        PriorityQueue<Solmu> pq = new PriorityQueue();
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
    
    
    public void uudetArvot(Solmu s, String str) {

        if (s.vasen == null && s.oikea == null) {
            Merkki m = new Merkki(s.c, str);
            listaUusista.add(m);
        }

        if (s.vasen != null) {
            String newS = new String(str += '1');
            uudetArvot(s.vasen, newS);
        }
        if (s.oikea != null) {
            String newS = new String(str += '0');
            uudetArvot(s.oikea, newS);
        }
    }
    
    
    public Solmu getRoot(){
        return this.root;
    }
    
    public ArrayList getListaUusista(){
        return this.listaUusista;
    }
    
}
