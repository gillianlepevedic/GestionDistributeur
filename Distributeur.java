
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Distributeur {
    private Map<String, Integer> lesBillets = new HashMap<>();
    private GestionFichier leFichier = new GestionFichier("distributeur1.txt");

    public Distributeur() throws FileNotFoundException {
        lesBillets= leFichier.lireFichier();
    }

    public void afficheBillet(){
        System.out.println(lesBillets.entrySet());
        leFichier.ecrireFichier(lesBillets);
    }
}