import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GestionFichier {
    private FileInputStream file;

    public GestionFichier(String nomfic) throws FileNotFoundException {
        file = new FileInputStream(nomfic);
    }

    public HashMap<String, Integer> lireFichier() {
        HashMap<String, Integer> lesBillets = new HashMap<>();


        try {
            String nomBillet ="";
            int nbBillet=-1;
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                //if (scanner.hasNextLine()) {                  
                    nomBillet = scanner.nextLine();
                    System.out.println(nomBillet);
                    nbBillet = scanner.nextInt();
                    System.out.println(nbBillet+1);
                    if (scanner.hasNext()){
                        scanner.nextLine();
                    }
                    
                //}

                /*if (scanner.hasNextInt()) {
                    nbBillet = scanner.nextInt();
                    System.out.println(nbBillet);
                    System.out.println("Tata");
                }*/


                if ((nomBillet.compareTo("") !=0) && nbBillet !=-1 ){
                    lesBillets.put(nomBillet, nbBillet);
                    nomBillet ="";
                    nbBillet = -1;
                }

            }
            
            scanner.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }   
        return lesBillets;
             
    }
}