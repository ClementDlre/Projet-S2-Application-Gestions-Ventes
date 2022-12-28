package fr.univartois.butinfo.ihm.model.gestionvehicules;

/**
 * Un objet de la classe véhicule est un véhicule.
 * Il est caractérisé par son numéro d'immatriculation, son année de mise en circulation,
 * son modèle, sa marque et son kilométrage.
 * @author Jonathan
 *
 */
public abstract class Vehicule {
	/**
	 * Le numéro d'immatriculation
	 */
    private String numImma;
    
    /**
     * L'année de mise en circulation
     */
    private int anCircu;
    
    /**
     * Le modèle du véhicule
     */
    private String modele;

    /**
     * La marque du véhicule
     */
    private String marque;
    
    /**
     * Le kilométrage du véhicule
     */
    private double kilometrage;
    
    /**
     * Constructeur créant un véhicule
     * @param numImma - Le numéro d'immatriculation du véhicule
     * @param modele - Le modèle du véhicule
     * @param marque - La marque du véhicule
     * @param kilometrage - Le kilométragedu véhicule
     * @param anCircu - L'année de mise en circulation du véhicule
     */
    protected Vehicule(String numImma, String modele, String marque, double kilometrage, int anCircu) {
    	this.numImma = numImma;
    	this.modele = modele;
    	this.marque = marque;
    	this.kilometrage = kilometrage;
    	this.anCircu = anCircu;
    }

    /**
     * Méthode retournant le numéro d'immatriculation du véhicule
     * @return String - Le numéro d'immatriculation du véhicule
     */
    public String getNumImma() {
        return this.numImma;
    }

    /**
     * Méthode permettant de mettre à jour le numéro d'immatriculation du véhicule
     * @param numImma - Le nouveau numéro d'immatriculation du véhicule
     */
    public void setNumImma(String numImma) {
        this.numImma = numImma;
    }

    /**
     * Méthode retournant le modèe du véhicule
     * @return String - Le modèle du véhicule
     */
    public String getModele() {
        return this.modele;
    }

    /**
     * Méthode permettant de mettre à jour le modèle du véhicule
     * @param modele - Le nouveau modèle du véhicule
     */
    public void setModel(String modele) {
        this.modele = modele;
    }

    /**
     * Méthode retournant la marque du véhicule
     * @return String - La marque du véhicule
     */
    public String getMarque() {
        return this.marque;
    }

    /**
     * Méthode permettant de mettre à jour la marque du véhicule
     * @param marque - La nouvelle marque du véhicule
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     * Méthode retournant le kilométrage du véhicule
     * @return Le kilométrage du véhicule
     */
    public double getKilometrage() {
        return this.kilometrage;
    }

    /**
     * Méthode permettant de mettre à jour le kilométrage du véhicule
     * @param kilometrage - Le nouveau kilométrage du véhicule
     */
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    /**
     * Méthode retournant l'année de mise en circulation du véhicule
     * @return int - L'année de mise en circulation du véhicule
     */
    public int getAnCircu() {
        return this.anCircu;
    }

    /**
     * Méthode permettant de mettre à jour l'année de mise en circulation du véhicule
     * @param anCircu - La nouvelle année de mise en circulation du véhicule
     */
    public void setAnCircu(int anCircu) {
        this.anCircu = anCircu;
    }
    
    /**
     * Méthode retournant une chaîne de caractères contenant les informations du véhicule.
     * @return String - Les informations du véhicule.
     */
    public String toString() {
    	return "Immatriculation : " + this.numImma + ". Modèle : " + this.modele + ". Marque : " + this.marque + ". Kilomètrage : " + this.kilometrage + ". Année de mise en circulation : " + this.anCircu;
    }



    

}
