package huffman;

public class Merkki {
    char merkki;
    String newBits;

    public Merkki(char merkki, String newBits) {
        this.merkki = merkki;
        this.newBits = newBits;
    }
    
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
