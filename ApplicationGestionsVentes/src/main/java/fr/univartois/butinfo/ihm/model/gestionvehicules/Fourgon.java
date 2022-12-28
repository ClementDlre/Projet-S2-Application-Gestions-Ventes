package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Une instance de la classe Fourgon correspond à un fourgon.
 * Un fourgon possède un numéro d'immatriculation, un modèle, une marque, un kilométrage,
 * une année de mise en circulation, un poids de chargement maximal et un volume de chargement maximal.
 * Il peut être assigné à un seul Livreur.
 * @author Moi
 *
 */
public class Fourgon extends Vehicule {
	/**
	 * Le poids maximal de chargement du fourgon
	 */
    private double poidsMax;
    
    /**
     * Le volume maximal du fourgon
     */
    private double volumeMax;
    
    /**
     * Le livreur assigné au fourgon.
     */
    private Livreur livreur;
    
    /**
     * Constructeur créant un Fourgon.
     * @param numImma - Le numéro d'immatriculation du fourgon
     * @param modele - Le modèle du fourgon
     * @param marque - La marque du fourgon
     * @param kilometrage - Le kilométrage du fourgon
     * @param anCircu - L'année de mise en circulation du fourgon
     * @param poidsMax - Le poids maximal de chargement du fourgon
     * @param volumeMax - Le volume maximal du fourgon
     */
    public Fourgon(String numImma, String modele, String marque, double kilometrage, int anCircu, double poidsMax, double volumeMax) {
    	super(numImma,modele,marque,kilometrage,anCircu);
    	this.poidsMax = poidsMax;
    	this.volumeMax = volumeMax;
    }

    /**
     * Méthode retournant le poids maximal de chargement du fourgon
     * @return Le poids maximal de chargement du fourgon
     */
    public double getPoidsMax() {
        return this.poidsMax;
    }

    /**
     * Méthode retournant le volume maximal du fourgon
     * @return Le volume maximal du fourgon
     */
    public double getVolumeMax() {
        return this.volumeMax;
    }
    
    /**
     * Méthode permettant d'assigner un livreur au fourgon.
     * Si le fourgon n'avait pas de livreur assigné, le livreur assigné.
     * Dans le cas contraire, on demande à l'utilisateur s'il veut remplacer le livreur assigné au fourgon.
     * @param livreur
     */
    public void assigneLivreur(Livreur livreur) {
    	if (this.livreur == null) {
    		this.livreur = livreur;
    	} else {
    		System.out.println("Le fourgon d'immatriculation : " + this.getNumImma() + " a déjà un livreur assigné : " + livreur.getPrenom() + " " + livreur.getNom());
    		System.out.println("Souhaitez-vous le remplacer ? (O/N) ");
    		
    		Scanner input = new Scanner(System.in);
    		String choix = input.nextLine();
    		ArrayList<String> choixPossibles = new ArrayList<String>(Arrays.asList("O", "N"));
    		
    		while (!(choixPossibles.contains(choix))) {
    			System.out.println("Erreur, entrez O si vous voulez remplacer le livreur, ou N dans le cas contraire");
    			choix = input.nextLine();
    		}
    		
    		if (choix.equals("O")) {
    			this.livreur = livreur;
    			System.out.println("Le livreur a été remplacé.");
    		} else {
    			System.out.println("Rien n'a été effectué.");
    		}
    	}
    	
    }

    /**
     * Méthode retournant une chaîne de caractères contenant les informations du fourgon.
     * @return String - Les informations du fourgon
     */
    public String toString() {
    	if (this.livreur == null) {
    		return super.toString() + ". Poids max : " + this.poidsMax + "kg. Volume max : " + this.volumeMax + ". Livreur assigné : Aucun";
    	} else {
    		return super.toString() + ". Poids max : " + this.poidsMax + "kg. Volume max : " + this.volumeMax + ". Livreur assigné : " + livreur.toString();
    	}
    	
    }

    /**
     * Méthode retournant la catégorie du fourgon
     * @return La catégorie du fourgon
     */
	public String getCategorie() {
		return "Fourgon";
	}

	/**
	 * Méthode retournant le livreur assigné au fourgon.
	 * @return Livreur - Le livreur assigné au fourgon
	 */
	public Livreur getLivreur() {
		return this.livreur;
	}
	
	/**
	 * Méthode permettant de mettre à jour le poids maximal de chargement du fourgon
	 * @param poids - Le nouveau poids maximal de chargement du fourgon
	 */
	public void setPoids(double poids) {
		this.poidsMax = poids;
	}
	
	/**
	 * Méthode permettant de mettre à jour le volume maximal du fourgon
	 * @param volume - Le nouveau volume maximal du fourgon.
	 */
	public void setVolume(double volume) {
		this.volumeMax = volume;
	}



}
