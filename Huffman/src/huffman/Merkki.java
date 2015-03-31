package huffman;

/**
 * This class contains a character and its corresponding new set of bits.
 * @author JJV
 */
public class Merkki {
    /**
     * This objects corresponding character.
     */
    char merkki;
    
    /**
     * The string of 1 and 0, that is the characters new set of bits.
     */
    String newBits;

    /**
     * The classes constructor, assigning the objects character and string of bits.
     * @param char The character of this object.
     * @param String A string of 1 and 0 corresponding to the characters new bitset.
     */
    public Merkki(char merkki, String newBits) {
        this.merkki = merkki;
        this.newBits = newBits;
    }
    
    /**
     * Converts the bits in the string into an integer value.
     * @return int Integer value of the binary string newBits.
     */
    public int bitsToInt(){
        
        int count = 0;
        
        for(int i=newBits.length()-1;i>=0;i--){
            if(newBits.charAt(i)==1){
                count += Math.pow(2, newBits.length()-1-i);
            }
        }
        
        return count;
    }
    
}
