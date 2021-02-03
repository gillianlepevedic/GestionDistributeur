
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Distributeur {
    private HashMap<String, Integer> lesBillets = new HashMap<>();

    public Distributeur() throws FileNotFoundException {
        GestionFichier leFichier = new GestionFichier("distributeur1.txt");
        lesBillets= leFichier.lireFichier();
    }

    public void afficheBillet(){
        for (String mapKey : lesBillets.keySet()) {
			System.out.println(mapKey + "->" + lesBillets.get(mapKey));		
		}
    }
}