package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Une objet de la classe Livreur correspond à une instance de la classe Conducteur.
 * Un Livreur est un conducteur qui est assigné à un Fourgon
 * Il possède également un attribut contenant le nombre d'heures conduites.
 * @author Jonathan
 *
 */
public class Livreur extends Conducteur {
	/**
	 * Le nombre d'heures conduites
	 */
    private int nbHeurCond;
    
    /**
     * Le fourgon assigné au livreur
     */
    private Fourgon fourgon;
    
    /**
     * Constructeur créant un Livreur
     * Le nombre d'heures conduites est initialisé à 0
     * @param nom - Le nom du livreur
     * @param prenom - Le prénom du livreur
     * @param numeroPermis - Le numéro de permis du livreur
     * @param typePermis - Le type de permis du livreur
     */
    public Livreur(String nom, String prenom, String numeroPermis, String typePermis) {
    	super(nom,prenom,numeroPermis,typePermis);
    	this.nbHeurCond = 0;
    }

    /**
     * Méthode retournant le nombre d'heures de conduite du Livreur
     * @return - Le nombre d'heures de conduite du livreur
     */
    public int getNbHeurCond() {
        return this.nbHeurCond;
    }
    
    /**
     * Méthode mettant à jour le nombre d'heures de conduite du livreur
     * @param nbHeurCond - Le nouveau nombre d'heures de conduite du livreur
     */
    public void setNbHeurCond(int nbHeurCond) {
        this.nbHeurCond = nbHeurCond;
    }

    /**
     * Méthode permettant d'assigner un fourgon au livreur.
     * Si le livreur n'avait pas de fourgon assigné, le fourgon est assigné.
     * Sinon on demande à l'utilisateur s'il veut remplacer le fourgon déjà assigné.
     * @param fourgon - Le fourgon à assigner
     */
    public void assigneFourgon(Fourgon fourgon) {
    	if (this.fourgon == null) {
    		this.fourgon = fourgon;
    	} else {
    		System.out.println("Le livreur : " + this.getPrenom() + " " + this.getNom() + " a déjà un fourgon assigné : Numéro d'immatriculation : " + fourgon.getNumImma() + " Modèle : " + fourgon.getMarque() + " " + fourgon.getModele());
    		System.out.println("Souhaitez-vous le remplacer ? (O/N) ");
    		
    		Scanner input = new Scanner(System.in);
    		String choix = input.nextLine();
    		ArrayList<String> choixPossibles = new ArrayList<String>(Arrays.asList("O", "N"));
    		
    		while (!(choixPossibles.contains(choix))) {
    			System.out.println("Erreur, entrez O si vous voulez remplacer le fourgon, ou N dans le cas contraire");
    			choix = input.nextLine();
    		}
    		
    		if (choix.equals("O")) {
    			this.fourgon = fourgon;
    			System.out.println("Le fourgon a été remplacé.");
    		} else {
    			System.out.println("Rien n'a été effectué.");
    		}
    	}
    }
    
    /**
     * Méthode retournant le fourgon assigné au livreur
     * @return Fourgon - Le fourgon assigné au livreur
     */
    public Fourgon getFourgon() {
    	return this.fourgon;
    }

    /**
     * Méthode retournant la catégorie du livreur
     * @return String - La catégorie du livreur.
     */
	public String getCategorie() {
		return "Livreur";
	}

}
