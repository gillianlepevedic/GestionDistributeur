
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Distributeur {
    private Map<String, Integer> lesBillets = new HashMap<>();
    private GestionFichier leFichier = new GestionFichier("distributeur1.txt");
    private boolean probleme;

    public Distributeur() throws FileNotFoundException {
        lesBillets= leFichier.lireFichier();
        probleme = false;
    }

    private void afficheUnBillet(String nomClef){
        System.out.println("Il y a " + lesBillets.get(nomClef) + " billets de " + nomClef);
    }

    private void ajouterUnBillets(String nomClef){
        lesBillets.replace(nomClef, lesBillets.get(nomClef)+1);
    }

    private void enleverUnBillets(String nomClef){
        lesBillets.replace(nomClef, lesBillets.get(nomClef)-1);
    }

    public void afficherTout(){
        for (String clef : lesBillets.keySet()){
            afficheUnBillet(clef);
        }
    }

    public void demanderAjouterBillets(LectureClavier clavierGigi){
        String montant;
        int nbbillets;
        System.out.println("Donner le montant du billets que vous rajouter");
        montant = clavierGigi.demandeRegex("[0-9]+", "Donner un nombres");
        while (! lesBillets.containsKey(montant + " euros")){
            System.out.println("Le billet de " + montant + " euros n'existe pas reessayer ");
            montant = clavierGigi.demandeRegex("[0-9]+", "Donner un nombres");
        }
        System.out.println("Donner le nombres de billets que vous rajouter");
        nbbillets = clavierGigi.demandeEntier();

        for (int i = 0; i <= nbbillets-1; i++){
            ajouterUnBillets(montant + " euros");
        }
        leFichier.ecrireFichier(lesBillets);
        System.out.println("Billets rajouter");
    }

    public void checkUp(){
        for (String clef : lesBillets.keySet()){
             System.out.print("Billet de " + clef);
            if (lesBillets.get(clef) < 5){
                System.out.println(" :insuffisance");
            }else
                System.out.println(" :ok");
        }
        if (probleme){
            System.out.println("Le systeme a detecte un probleme");
        }else{
            System.out.println("Le systeme n'a pas detecter de defaillance");
        }
    }

}