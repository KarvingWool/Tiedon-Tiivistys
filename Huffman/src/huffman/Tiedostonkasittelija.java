package huffman;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The class that all the manipulations of files are handled in.
 * Reading the file is done here, and so is the creating of the compressed file.
 * @param String A String containing the name of the source file, eg. "teksti.txt".
 */
public class Tiedostonkasittelija {

    /**
     * The scanner used to read the source file or write a new file.
     */
    private Scanner lukija;
    
    /**
     * The file object used to refer to either the source file,
     * or the created new file.
     */
    File tiedosto;

    /**
     * The constructor for the class. It assigns a new file to "tiedosto" according to the
     * string given as a parameter, and then tries to to attach this file to
     * a newly created scanner.
     * @param String A String containing the name of the source file, eg. "teksti.txt"
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
     * This method goes through the assigned file and keeps count of how many
     * of each character are found in that file. The numbers are saved into a
     * hashmap that is then returned.
     * @return HashMap
     */
    public HashMap scan() {
        HashMap<Character, Integer> maarat = new HashMap();
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

    /**
     * This method creates a compressed file whose name is given in the parameters.
     * The new values are assigned according to the ArrayList provided.
     * @param String The name of the file which one wants to compress, eg. "text.txt".
     * @param ArrayList A list of the new binary values of each character.
     */
    public void luoTiedosto(String file, ArrayList<Merkki> listaUusista) {


        tiedosto = new File(file);
        try {
            lukija = new Scanner(tiedosto);
            DataOutputStream os = new DataOutputStream(new FileOutputStream("comp.dat"));

            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();

                for (int i = 0; i < rivi.length(); i++) {
                    char c = rivi.charAt(i);
                    Merkki kopioitava = null;
                    for (int z = 0; z < listaUusista.size(); z++) {
                        if (listaUusista.get(z).merkki == c) {
                            kopioitava = listaUusista.get(z);
                            break;
                        }
                    }
                    os.write(kopioitava.bitsToInt());
                }
            }

            os.close();

        } catch (Exception e) {
        }
    }
}
