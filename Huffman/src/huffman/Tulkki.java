package huffman;

import tietorakenteet.Solmu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * The class that translates the compressed file back into a readable format.
 * 
*/
public class Tulkki {

    /**
     * The root of the tree used to uncompress the file.
     */
    Solmu root;
    /**
     * The amount of characters in the original text.
     */
    long charCount;

    /**
     * The constructor of this class. Assigns a Solmu object to root and calls
     * to luoLuettavaTiedosto to create a readable file from the given
     * compressed file.
     *
     * @param Solmu The root of a tree.
     * @param String tiedosto Name of the compressed file.
     * @param String newname Name wished for uncompressed file.
     */
    public Tulkki(String newname, String tiedosto) {
        luoLuettavaTiedosto(newname, tiedosto);
    }

    /**
     * This method creates a readable text file out of the given compressed
     * file.
     *
     * @param String file The name of the compressed file.
     * @param String newname The wished name for uncompressed file.
     */
    public void luoLuettavaTiedosto(String newname, String file) {

        File readable = new File(newname);
        FileWriter fr = null;
        try {
            readable.createNewFile();
        } catch (Exception e) {
            System.out.println("Creating new readable file failed.");
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            fr = new FileWriter(readable);




            // Reading and creating tree from compressed file.
            int length = fis.read();
            int[] array = new int[length];
            int puuCounter = 0;
            while (puuCounter < length) {
                array[puuCounter] = fis.read();
                puuCounter++;
            }

            Puunkasittelija uusi = new Puunkasittelija(array);
            root = uusi.getRoot();

//             Reading charcount and compressed data from compressed file.
            byte[] longs = new byte[8];
            fis.read(longs, 0, 8);
            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.put(longs);
            buffer.flip();
            charCount = buffer.getLong();

            long charcounter = 0;
            String bits = "";
            int counter = 0;
            Solmu s = root;
            while (fis.available() > 0) {
                int read = fis.read();
                String bi = Integer.toBinaryString(read);
                int ero = 8 - bi.length();
                while (ero > 0) {
                    bits += "0";
                    ero--;
                }
                bits += bi;


                while (counter < bits.length()) {
                    if (s.oikea == null) {
                        if (charcounter != charCount) {
                            if (s.c == '\n') {
                                fr.append(System.lineSeparator());
                            } else {
                                fr.append(s.c);
                            }
                        }
                        bits = bits.substring(counter);
                        s = root;
                        counter = -1;
                        charcounter++;

                    } else if (bits.charAt(counter) == '1') {
                        s = s.vasen;
                    } else {
                        s = s.oikea;
                    }
                    counter++;
                }


            }

        } catch (Exception e) {
            System.out.println("Failed writing back into readable text.");
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (Exception e) {
                    System.out.println("Problems closing");
                }
            }
        }
    }
}
