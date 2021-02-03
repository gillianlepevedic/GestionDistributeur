
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Distributeur {
    private Map<String, Integer> lesBillets = new HashMap<>();

    public Distributeur() throws FileNotFoundException {
        GestionFichier leFichier = new GestionFichier("distributeur1.txt");
        lesBillets= leFichier.lireFichier();
    }

    public void afficheBillet(){
        System.out.println(lesBillets.entrySet());
    }
}