import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionFichier {
    private FileInputStream file;

    public GestionFichier(String nomfic) throws FileNotFoundException {
        file = new FileInputStream(nomfic);
    }

    public Map<String, Integer> lireFichier() {
        Map<String, Integer> lesBillets = new HashMap<>();


        try {
            String nomBillet ="";
            int nbBillet=-1;
            Scanner scannerDeFichier = new Scanner(file);

            while (scannerDeFichier.hasNext()) {                 
                nomBillet = scannerDeFichier.nextLine();
                nbBillet = scannerDeFichier.nextInt();
                if (scannerDeFichier.hasNext()){
                    scannerDeFichier.nextLine();
                }

                if ((nomBillet.compareTo("") !=0) && nbBillet !=-1 ){
                    lesBillets.put(nomBillet, nbBillet);
                }

            }
            
            scannerDeFichier.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
        return lesBillets;
             
    }
}