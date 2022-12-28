package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Un objet de la classe Voiture correspond à une instance de la classe Vehicule
 * Une voiture est caractérisé par son commercial.
 * @author Jonathan
 *
 */
public class Voiture extends Vehicule {
	/**
	 * Le commercial assigné à la voiture
	 */
    private Commercial commercial;
    
    /**
     * Constructeur créant une Voiture
     * @param numImma - Le numéro d'immatriculation du véhicule
     * @param modele - Le modèle du véhicule
     * @param marque - La marque du véhicule
     * @param kilometrage - Le kilométrage du véhicule
     * @param anCircu - L'année de mis een circulation du véhicule
     */
    public Voiture(String numImma, String modele, String marque, double kilometrage, int anCircu) {
    	super(numImma,modele,marque,kilometrage,anCircu);
    }
    
    /**
     * Méthode permettant d'assigner un commercial à la voiture.
     * Si le voiture n'avait pas de commercial assigné, le commercial est assigné à la voiture.
     * Sinon, on demande à l'utilisateur s'il veut remplacer le commercial déjà assigné.
     * @param commercial - Le commercial qu'on veut assigner.
     */
    public void assigneCommercial(Commercial commercial) {
    	if (this.commercial == null) {
    		this.commercial = commercial;
    	} else {
    		System.out.println("La voiture d'immatriculation : " + this.getNumImma() + " a déjà un commercial assigné : " + commercial.getPrenom() + " " + commercial.getNom());
    		System.out.println("Souhaitez-vous le remplacer ? (O/N) ");
    		
    		Scanner input = new Scanner(System.in);
    		String choix = input.nextLine();
    		ArrayList<String> choixPossibles = new ArrayList<String>(Arrays.asList("O", "N"));
    		
    		while (!(choixPossibles.contains(choix))) {
    			System.out.println("Erreur, entrez O si vous voulez remplacer le commercial, ou N dans le cas contraire");
    			choix = input.nextLine();
    		}
    		
    		if (choix.equals("O")) {
    			this.commercial = commercial;
    			System.out.println("Le commercial a été remplacé.");
    		} else {
    			System.out.println("Rien n'a été effectué.");
    		}
    	}
    }
    
    /**
     * Méthode retournant une chaîne de caractères indiquant quel commercial est assigné à la voiture.
     * @return String - Une chaîne de caractères indiquant quel commercial est assigné à la voiture.
     */
    public String toString() {
    	if (this.commercial == null) {
    		return super.toString() + ". Commercial assigné: Aucun";
    	} else {
    		return super.toString() + ". Commercial assigné : " + commercial.toString();
    	}
    }
    
    /**
     * Méthode retournant une chaîne contenant la catégorie de la voiture
     * @return String - Une chapine contenant la catégorie de la voiture
     */
    public String getCategorie() {
    	return "Voiture";
    }

    /**
     * Méthode retournant le commercial assigné à la voiture
     * @return Commercial - Le commercial assigné à la voiture.
     */
	public Commercial getCommercial() {
		return this.commercial;
	}

}
