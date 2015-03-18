package huffman;

public class Solmu implements Comparable{
    Solmu vasen;
    Solmu oikea;
    int arvo;
    
    public Solmu(int arvo){
        this.arvo = arvo;
    }

    @Override
    public int compareTo(Object o) {
        Solmu compare = (Solmu) o;
        return this.arvo - compare.arvo;
    }
    
    
    
}
