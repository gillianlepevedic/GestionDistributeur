import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionFichier {
    private String nomFichier;

    public GestionFichier(String nomfic){
        nomFichier = nomfic;
    }

    public Map<String, Integer> lireFichier() throws FileNotFoundException {

        FileInputStream file = new FileInputStream(nomFichier);
        Map<String, Integer> lesBillets = new HashMap<>();
        Scanner scannerDeFichier = new Scanner(file);
        String nomBillet ="";
        int nbBillet=-1;

        try {
            if (scannerDeFichier.nextLine().equals("Billets :")){
                System.out.println("Lecture des billet");


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
                System.out.println("Fin de la lecture");
                
                scannerDeFichier.close();
            }else{
                System.out.println("Erreur : Le fichier n'est pas au bon format");
            }
        }
        catch (java.util.NoSuchElementException e){
            System.out.println("Erreur : Lecture imposible");
            lesBillets.clear();
        }
        scannerDeFichier.close();
        return lesBillets; 
    }

    public void ecrireFichier(Map<String, Integer> lesBillets){
        ecrireEntete();
        ecrireCorp(lesBillets);
    }

    private void ecrireEntete(){
        try(FileWriter lefichier = new FileWriter(nomFichier);){
            lefichier.write("Billets :\n");
        }
        catch (IOException e){
              System.out.println("Erreur : Vidage impossible");
        }
    }

    private void ecrireCorp(Map<String, Integer> lesBillets){

        try (FileWriter lefichier = new FileWriter(nomFichier, true);){

            for (String i : lesBillets.keySet()){
                lefichier.write(i + "\n");
                lefichier.write(lesBillets.get(i)+1 + "\n");
            }
            System.out.println("Ecriture du fichier reussi");
        }
        catch (IOException e){
              System.out.println("Erreur : Imposible d'ecrire");
        }
    }
}