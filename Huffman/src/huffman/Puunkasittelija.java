package huffman;

import tietorakenteet.*;

/**
 * The class that handles the manipulations of the "Solmu" class objects,
 * constructing them into a tree which is used to assign new binary values
 * to characters.
 * @author JJV
 */

public class Puunkasittelija {
    /**
     * The root of the constructed tree.
     */
    private Solmu root;
    /**
     * The list containing Merkki objects that store the new binary values
     * of the given characters.
     */
    private MerkkiLista listaUusista;

    /**
     * The constructor of the class. The tree is constructed and new binary values 
     * to characters are assigned in this method through calls to methods luoPuu()
     * and UudetArvot(). The root of the tree is assigned to "root" and the 
     * created list is stored in listaUusista.
     * @param MaaraLista A list containing the characters found in a file and the 
     * number of times it occurred.
     */
    public Puunkasittelija(MaaraLista maarat){
        
        root = luoPuu(maarat);
        listaUusista = new MerkkiLista();
        uudetArvot(root, new String(""));
        
    }
    
    
    /**
     * This method creates a tree consisting of Solmu objects, and returns the
     * trees root. The tree is constructed using the info in the given HashMap in
     * its parameters.
     * @param MaaraLista The characters and their frequency in the scanned text file.
     * @return Solmu The root of the created tree.
     */
    public static Solmu luoPuu(MaaraLista maarat) {
        Solmu root = null;
        MaaraListaNode ln = maarat.getAlku();
        MinimiKeko mk = new MinimiKeko(maarat.getLength());
        
        while(ln != null){
            Solmu s = new Solmu(ln.getCount());
            s.c = ln.getC();
            mk.add(s);
            ln = ln.getOikea();
        }
//        for (char c : maarat.keySet()) {
//            Solmu s = new Solmu(maarat.get(c));
//            s.c = c;
//            pq.add(s);
//        }

        while (mk.getTail() != 1) {
            mk.take();
            root = mk.getKeko()[0];
        }
        return root;
    }
    
    /**
     * The recursive method traverses the tree, creates a Merkki object for each found
     * character and assigns it a new binary value according to its placing in the tree.
     * All the Merkki objects are stored into listaUusista.
     * @param s The root of the tree one wants traversed.
     * @param str An empty string.
     */
    
    public void uudetArvot(Solmu s, String str) {

        if (s.vasen == null && s.oikea == null) {
            Merkki m = new Merkki(s.c, str);
            listaUusista.add(m);
        }

        if (s.vasen != null) {
            String newS = new String(str + '1');
            uudetArvot(s.vasen, newS);
        }
        if (s.oikea != null) {
            String newS = new String(str + '0');
            uudetArvot(s.oikea, newS);
        }
    }
    
    /**
     * Returns the root of this classes tree.
     * @return Solmu root
     */
    public Solmu getRoot(){
        return this.root;
    }
    /**
     * Returns the list of the Merkki objects.
     * @return ArrayList listUusista
     */
    public MerkkiLista getListaUusista(){
        return this.listaUusista;
    }
    
}
