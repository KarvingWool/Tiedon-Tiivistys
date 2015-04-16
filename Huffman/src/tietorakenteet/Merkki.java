package tietorakenteet;

/**
 * This class contains a character and its corresponding new set of bits.
 * @author JJV
 */
public class Merkki {
    /**
     * This objects corresponding character.
     */
    public char merkki;
    
    /**
     * The string of 1 and 0, that is the characters new set of bits.
     */
    public String newBits;

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
     * Returns this objects character.
     * @return char merkki
     */
    public char getMerkki() {
        return merkki;
    }

    /**
     * Returns a string of 1 and 0 corresponding to this objects characters
     * new bitset.
     * @return String newBits
     */
    public String getNewBits() {
        return newBits;
    }
    
    
    
}
