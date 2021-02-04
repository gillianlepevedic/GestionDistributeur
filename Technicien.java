import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Technicien {
    public static void main(String[] args) throws FileNotFoundException{
        int choix = -1;
		Scanner clavier = new Scanner(System.in).useLocale(Locale.US);
		LectureClavier clavierGigi = new LectureClavier(clavier);
        Distributeur distributeur = new Distributeur();

        while (choix != 0){
			choix = menu(clavierGigi);
			
			switch(choix) { 
				case 0: 
					System.out.println("Fin programme");
					break; 
				case 1: 
					System.out.println("Affichage Tout");
					distributeur.afficherTout();
				break; 
				case 2: 
					System.out.println("CheckUp");
                    distributeur.checkUp();
					break; 
				case 3: 
					System.out.println("Ajoute de billets");
                    distributeur.demanderAjouterBillets(clavierGigi);
					break; 
				default: System.out.println("Erreur : Choix inconnue");
			}
		}
    }

    private static int menu(LectureClavier clavierGigi){
		//Initialisation des variables
		int mode =-1;
		//Affiche et demande l'action
		System.out.print("Menu Calculatrice\n0 : Quitter\n1 : Afficher Tout\n2 : CheckUp\n3 : Ajouter des billets\n");
		mode = clavierGigi.demandeEntierInterval(0, 3);//demander un entier
		//retourne le choix
		return mode;
	}
}