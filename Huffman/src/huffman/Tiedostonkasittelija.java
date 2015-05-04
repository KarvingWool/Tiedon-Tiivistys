package huffman;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.util.Scanner;
import tietorakenteet.*;

/**
 * The class that all the manipulations of files are handled in. Reading the
 * file is done here, and so is the creating of the compressed file.
 *
 * @param String A String containing the name of the source file, eg.
 * "teksti.txt".
 */
public class Tiedostonkasittelija {

    /**
     * The scanner used to read the source file or write a new file.
     */
    private Scanner lukija;
    /**
     * The file object used to refer to either the source file, or the created
     * new file.
     */
    File tiedosto;
/**
 * The amount of characters in the text.
 */
    long charCount =-1;
    
    /**
     * The constructor for the class. It assigns a new file to "tiedosto"
     * according to the string given as a parameter, and then tries to to attach
     * this file to a newly created scanner.
     *
     * @param String A String containing the name of the source file, eg.
     * "teksti.txt"
     */
    public Tiedostonkasittelija(String file) {
        tiedosto = new File(file);

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

    /**
     * This method goes through the assigned file and keeps count of how many of
     * each character are found in that file. The numbers are saved into a
     * hashmap that is then returned.
     *
     * @return HashMap
     */
    public MaaraLista scan() {

        MaaraLista lista = new MaaraLista();
        while (lukija.hasNextLine()) {

            String rivi = lukija.nextLine();
            for (int i = 0; i <= rivi.length(); i++) {
                char c;
                charCount++;
                if (i == rivi.length()) {
                    c = 10;
                } else {
                    c = rivi.charAt(i);
                }
                lista.add(c, 1);
            }
        }
        return lista;
    }

    /**
     * This method creates a compressed file whose name is given in the
     * parameters. The new values are assigned according to the ArrayList
     * provided.
     *
     * @param String The name of the file which one wants to compress, eg.
     * "text.txt".
     * @param ArrayList A list of the new binary values of each character.
     */
    public void luoKompTiedosto(String file, MerkkiLista listaUusista, int[] printattavaPuu) {

        try {
            lukija = new Scanner(tiedosto);
            DataOutputStream os = new DataOutputStream(new FileOutputStream(file));

            
            // Writing huffman tree to file.
            os.write(printattavaPuu.length);
            int arrayPointer =0;
            while(arrayPointer<printattavaPuu.length){
                os.write(printattavaPuu[arrayPointer]);
                arrayPointer++;
            }

            // Writing charcount and compressed data to file.
            
            os.writeLong(charCount);
            int[] buffer = new int[8];
            int pointer = 0;
            
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                for (int i = 0; i <= rivi.length(); i++) {
                    char c;
                    if (i == rivi.length()) {
                        if(!lukija.hasNextLine()){
                            break;
                        }
                        c = 10;
                    } else{
                        c = rivi.charAt(i);
                    }
                    Merkki kopioitava;
                    MerkkiListaNode node = listaUusista.getAlku();
                    while (node != null) {
                        if (node.getM().getMerkki() == c) {
                            kopioitava = node.getM();
                            

                            for (int n = 0; n < kopioitava.newBits.length(); n++) {

                                if (kopioitava.newBits.charAt(n) == '1') {
                                    buffer[pointer] = 1;
                                } else {
                                    buffer[pointer] = 0;
                                }
                                pointer++;

                                if (pointer > 7) {
                                    pointer = 0;
                                    os.write(bitsToInt(buffer));
                                }
                            }

                            break;
                        }
                        node = node.getOikea();
                    }
                }
            }
            
            
            if (pointer != 0) {
                while (pointer < 8) {
                    buffer[pointer] = 0;
                    pointer++;
                    
                }
                os.write(bitsToInt(buffer));
            }

            os.close();

        } catch (Exception e) {
            System.out.println("Failed writing compressed file.");
        }
    }

    /**
     * Converts the bits in the given array into an integer value.
     *
     * @param int[] The array of 1 and 0 that one wants to convert to an int
     * value.
     * @return int Integer value of the binary string newBits.
     */
    public int bitsToInt(int[] bits) {

        int count = 0;

        for (int i = 7; i >= 0; i--) {
            if (bits[i] == 1) {
                count += Math.pow(2, 8 - 1 - i);
            }
        }

        return count;
    }
    /**
     * Returns the charCount, the number of characters in the original text.
     * @return long charCount.
     */
    public long getCharCount(){
        return charCount;
    }
}
