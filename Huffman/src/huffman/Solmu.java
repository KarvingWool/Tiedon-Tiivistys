package huffman;

/**
 * The class defining a node in a tree.
 * @author JJV
 */
public class Solmu implements Comparable{
    /**
     * The left child of this node. Can be null.
     */
    Solmu vasen;
    /**
     * The right child of this node. Can be null.
     */
    Solmu oikea;
    /**
     * The value of this node, also the sum of all the values of its children.
     */
    int arvo;
    
    /**
     * The char assigned to this node.
     * If a char is assigned, we know this node is a leaf.
     */
    char c;
    
    /**
     * The constructor of this class. Assigns a value to arvo.
     *@param int The value to assign this node. 
    */
     public Solmu(int arvo){
        this.arvo = arvo;
    }

     /**
      * 
      * @param Solmu The node we want to compare this one to.
      * @return int Negative if the compared nodes "arvo" is larger than this one, positive if not.
      */
    @Override
    public int compareTo(Object o) {
        Solmu compare = (Solmu) o;
        return this.arvo - compare.arvo;
    }
    
    
    
}
