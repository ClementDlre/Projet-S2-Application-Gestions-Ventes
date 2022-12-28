package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Un objet de la classe Commercial correspond à une instance de la classe Conducteur.
 * Un commercial est un conducteur qui est assigné à une Voiture.
 * Il possède également un attribut nbVisitEffect qui correspond au nombre de visite qu'il a effectué.
 * @author Jonathan
 *
 */
public class Commercial extends Conducteur {
	/**
	 * Le nombre de visites effectuées
	 */
    private int nbVisitEffect;
    
    /**
     * La voiture assignée au commercial
     */
    private Voiture voiture;
    
    /**
     * Constructeur créant une instance de Commercial. Le nombre de visite effectuées est initialisé à 0.
     * @param nom - Le nom du commercial
     * @param prenom - Le prénom du commercial
     * @param numeroPermis - Le numéro de permis du commercial
     * @param typePermis - Le type de permis du commercial
     */
    public Commercial(String nom, String prenom, String numeroPermis, String typePermis) {
    	super(nom,prenom,numeroPermis,typePermis);
    	this.nbVisitEffect = 0;
    }
    
    /**
     * Méthode retournant le nombre de visites effectuées par le commercial
     * @return Le nombre de visite effectuées par le commercial
     */
    public int getNbVisitEffect() {
        return this.nbVisitEffect;
    }
    
    /**
     * Méthode permettant de modifier le nombre de visites effectuées par le commercial
     * @param nbVisitEffect - Le nouveau nombre de visites effectuées par le commercial
     */
    public void setNbVisitEffect(int nbVisitEffect) {
    	if (nbVisitEffect < 0) {
    		this.nbVisitEffect = nbVisitEffect;
    	}
    }
    
    /**
     * Méthode permettant d'assigner une voiture à un commercial.
     * Si le commercial n'avait pas de voiture assignée, la voiture est assignée.
     * Dans le cas contraire, on demande à l'utilisateur si on veut remplacer la voiture déjà assignée.
     * @param voiture - La voiture qu'on veut assigner au commercial.
     */
    public void assigneVoiture(Voiture voiture) {
    	if (this.voiture == null) {
    		this.voiture = voiture;
    	} else {
    		System.out.println("Le commercial : " + this.getPrenom() + " " + this.getNom() + " a déjà une voiture assignée : Numéro d'immatriculation : " + voiture.getNumImma() + " Modèle : " + voiture.getMarque() + " " + voiture.getModele());
    		System.out.println("Souhaitez-vous la remplacer ? (O/N) ");
    		
    		Scanner input = new Scanner(System.in);
    		String choix = input.nextLine();
    		ArrayList<String> choixPossibles = new ArrayList<String>(Arrays.asList("O", "N"));
    		
    		while (!(choixPossibles.contains(choix))) {
    			System.out.println("Erreur, entrez O si vous voulez remplacer la voiture, ou N dans le cas contraire");
    			choix = input.nextLine();
    		}
    		
    		if (choix.equals("O")) {
    			this.voiture = voiture;
    			System.out.println("La voiture a été remplacée.");
    		} else {
    			System.out.println("Rien n'a été effectué.");
    		}
    	}
    }
    
    /**
     * Méthode retournant la voiture assignée au commercial.
     * @return La voiture assignée au commercial.
     */
    public Voiture getVoiture() {
    	return this.voiture;
    }

    /**
     * Méthode retournant la catégorie du commercial
     * @return Une chaîne de caractère contenant la catégorie du commercial.
     */
	public String getCategorie() {
		return "Commercial";
	}


}
