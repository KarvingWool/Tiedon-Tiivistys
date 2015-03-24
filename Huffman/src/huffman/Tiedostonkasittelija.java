package huffman;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tiedostonkasittelija {

    private Scanner lukija;
    File tiedosto;

    public Tiedostonkasittelija(String file) {
        tiedosto = new File(file);

        try {
            lukija = new Scanner(tiedosto);
        } catch (Exception e) {
            System.out.println("File not found!");
        }
    }

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
