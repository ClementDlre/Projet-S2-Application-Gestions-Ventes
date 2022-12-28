package fr.univartois.butinfo.ihm.model.gestionvehicules;

/**
 * Un objet de la classe conducteur est une personne qui peut conduire un véhicule.
 * Chaque conducteur a un nom (String), un prénom (String), un numero de permis (String) et un type de permis (String)
 * @author Jonathan
 *
 */
public abstract class Conducteur {
	/**
	 * Le nom du conducteur
	 */
    private String nom;
    
    /**
     * Le prénom du conducteur.
     */
    private String prenom;
    
    /**
     * Le numéro de permis du conducteur
     */
    private String numeroPermis;

    /**
     * Le type de permis du conducteur
     */
    private String typePermis;
    
    /**
     * Constructeur permettant de créer un objet de la classe Conducteur
     * @param nom - Le nom du conducteur
     * @param prenom - Le prénom du conducteur
     * @param numeroPermis - Le numéro de permis du conducteur
     * @param typePermis - Le type de permis du conducteur
     */
    protected Conducteur(String nom, String prenom, String numeroPermis, String typePermis) {
    	this.nom = nom;
    	this.prenom = prenom;
    	this.numeroPermis = numeroPermis;
    	this.typePermis = typePermis;
    }

    /**
     * Méthode retournant le nom du conducteur
     * @return Le nom du conducteur
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode permettant de mettre à jour le nom du conducteur
     * @param nom - Le nouveau nom du conducteur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode retournant le prénom du conducteur.
     * @return Le prénom du conducteur
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Méthode permettant de mettre à jour le prénom du conducteur.
     * @param prenom - Le nouveau prénom du conducteur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode retournant le numéro de permis du conducteur
     * @return Le numéro de permis du conducteur
     */
    public String getNumeroPermis() {
        return this.numeroPermis;
    }

    /**
     * Méthode permettant de mettre à jour le numéro de permis du conducteur.
     * @param numeroPermis - Le nouveau numéro de permis du conducteur
     */
    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    /**
     * Méthode retournant le type de permis du conducteur
     * @return Le type de permis du conducteur
     */
    public String getTypePermis() {
        return this.typePermis;
    }

    /**
     * Méthode permettant de mettre à jour le type de permis du conducteur
     * @param typePermis - Le nouveau type de permis du conducteur.
     */
    public void setTypePermis(String typePermis) {
        this.typePermis = typePermis;
    }
    
    /**
     * Méthode permettant de savoir si deux conducteurs sont égaux.
     * Deux conducteurs sont égaux s'ils ont le même nom et le même prénom
     * @param conducteur - Le conducteur à comparer
     * @return true si les conducteurs sont égaux, false sinon
     */
    public boolean equals(Conducteur conducteur) {
    	return ((this.nom.equals(conducteur.nom)) && (this.prenom.equals(conducteur.prenom)));
    }

    /**
     * Méthode retournant une chaîne de caractères contenant les informations du conducteur.
     * @return String - Les informations du conducteur.
     */
    public String toString() {
    	return this.prenom + " " + this.nom + ". Numéro permis : " + this.numeroPermis + ". Type permis : " + this.typePermis;
    }

}
