
package fr.univartois.butinfo.ihm.model.article;

import fr.univartois.butinfo.ihm.model.util.*;

/**
 * Un objet de la classe Article correspond à un article/produit
 * vendu par l'entreprise. Chaque article considéré se vend à l'unité
 * (il ne se vend pas par exemple au kilo). Chaque article a un numéro
 * de référence (un entier) qui lui est propre et qui permet de l'identifier,
 * une catégorie (une chaîne de caractères), une désignation (une chaîne de caractères),
 * un prix à l'unité en euros (un double) et une quantité en stock (un entier).
 * @author bastien
 * @version 04/04/2022
 */
public class ArticleCat2 extends Article implements Livrable {
    /**
     * La teneur en sucre du bonbon
     */
    protected double teneurEnSucre;
    /**
     * Le gout du bonbon
     */
    protected Gout gout;
    /**
     * La hauteur du colis
     */
    protected int hauteurColis;
    /**
     * La largeur du colis
     */
    protected int largeurColis;
    /**
     * La profondeur du colis
     */
    protected int profondeurColis;
    /**
     * Le poids du colis
     */
    protected double poidsColis;

    /**
     * Constructeur permettant de créer un nouvel article avec comme catégorie "Bonbon acidulé".
     * Son numéro de référence est généré automatiquement. Les autres informations sont
     * saisies au clavier avec la méthode saisirInfos().
     */
    public ArticleCat2() {
        this.categorie = "Bonbon non-acidulé";
    }

    public ArticleCat2(String designation, Double prix, int quantite, double teneurEnSucre, int hauteur, int largeur,
			int profondeur, Double poids, Gout gout) {
    	super("Bonbon non-acidulé",designation,prix,quantite);
    	this.teneurEnSucre = teneurEnSucre;
    	this.hauteurColis = hauteur;
    	this.largeurColis = largeur;
    	this.profondeurColis = profondeur;
    	this.poidsColis = poids;
    	this.gout = gout;
    	
	}

	/**
     * Méthode permettant de saisir la désignation, le prix et la
     * quantité en stock d'un article, ainsi que le gout, et la
     * teneur en sucre. La catégorie n'est pas saisie.
     * Il faut qu'elle soit initialisée par ailleurs.
     */
    @Override
    public void saisirInfos() {
        int gout;
        this.designation = Util.saisirChaine("Quelle est la désignation de l'article ? ");
        this.prix = Util.saisirDoublePositif("Quel est son prix ? ");
        this.quantiteStock = Util.saisirEntierPositif("Quelle est la quantité de l'article ?");
        this.teneurEnSucre = Util.saisirDoublePositif("Quelle est la teneur en sucre de votre Bonbon ?");
        this.hauteurColis = Util.saisirEntierPositif("Quelle est la hauteur du colis pour l'article ?");
        this.largeurColis = Util.saisirEntierPositif("Quelle est la largeur du colis pour l'article ?");
        this.profondeurColis = Util.saisirEntierPositif("Quelle est la profondeur du colis pour l'article ?");
        this.poidsColis = Util.saisirDoublePositif("Quelle est le poids de votre colis ?");

        gout = Util.saisirEntier(1, 5, "Choisissez le gout : 1. Fraise, 2. Cerise, 3. Mangue, 4. Citron, 5. Piment");
        switch (gout) {
            case 1 -> this.gout = Gout.Fraise;
            case 2 -> this.gout = Gout.Cerise;
            case 3 -> this.gout = Gout.Mangue;
            case 4 -> this.gout = Gout.Citron;
            default -> this.gout = Gout.Piment;
        }
    }

    /**
     * Méthode indiquant la hauteur du colis de l'article en cm.
     * @return La hauteur du colis en cm.
     */
    public int getHauteurColis() {
        return this.hauteurColis;
    }

    /**
     * Méthode indiquant la largeur du colis de l'article en cm.
     * @return La largeur du colis en cm.
     */
    public int getLargeurColis() {
        return this.largeurColis;
    }

    /**
     * Méthode retournant le poids du colis en Kg.
     * @return Le poids du colis en KG
     */
    public double getPoidsKgColis() {
        return this.poidsColis;
    }

    /**
     * Méthode indiquant la profondeur du colis de l'article en cm.
     * @return La profondeur du colis en cm.
     */
    public int getProfondeurColis() {
        return this.profondeurColis;
    }

    /**
     * Méthode (redéfinition de toString()) retournant une représentation
     * textuelle. Cette représentation contient la référence, la désignation,
     * la catégorie, le prix unitaire et la quantité en stock de l'article.
     * @return Représentation textuelle de l'article.
     */
    public String toString() {
        return "->Désignation : "+this.designation+"\n->Catégorie : "+this.categorie+"\n->Prix : "+this.prix+"\n->Quantité : "+this.quantiteStock+"\n->Référence : "+this.reference+"\n->Gout : "+this.gout+"\n->Teneur en Sucre : "+this.teneurEnSucre+"\n->Poids du colis : "+this.poidsColis+"\n->Profondeur du colis : "+this.profondeurColis+"\n->Largeur du colis : "+this.largeurColis+"\n->Hauteur du colis : "+this.hauteurColis;
    }
    
    /**
     * Méthode retournant le gout du bonbon
     * @return Le gout du bonbon
     */
    public Gout getGout() {
    	return this.gout;
    }
    
    /**
     * Méthode permettant de mettre à jour le gout du bonbon
     * @param gout - Le nouveau gout du bonbon
     */
    public void setGout(Gout gout) {
    	this.gout = gout;
    }
    
    /**
     * Méthode retournant la teneur en sucre du bonbon
     * @return La teneur en sucre du bonbon
     */
    public Double getTeneurEnSucre() {
    	return this.teneurEnSucre;
    }

    /**
     * Méthode permettant de mettre à jour la profondeur du colis
     * @param profondeurColis - La nouvelle profondeur du colis
     */
	public void setProfondeurColis(int profondeurColis) {
		this.profondeurColis = profondeurColis;
	}

	/**
	 * Méthode permettant de mettre à jour la largeur du colis
	 * @param largeurColis - La nouvelle largeur du colis
	 */
	public void setLargeurColis(int largeurColis) {
		this.largeurColis = largeurColis;
	}

	/**
	 * Méthode permettant de mettre à jour la hauteur du colis
	 * @param hauteurColis - La nouvelle hauteur du colis
	 */
	public void setHauteurColis(int hauteurColis) {
		this.hauteurColis = hauteurColis;
	}

	/**
	 * Méthode permettant de mettre à jour le poids du colis
	 * Si on indique un poids < 0, le poids est mis à 1.5
	 * @param poidsColis - Le nouveau poids du colis
	 */
	public void setPoidsColis(Double poidsColis) {
		if (poidsColis < 0) {
			this.poidsColis = 1.5;
		} else {
			this.poidsColis = poidsColis;
		}
		
	}

	/**
	 * Méthode permettant de mettre à jour la teneur en sucre du bonbon.
	 * Si on indique une teneur en sucre inférieur à 0, la teneur en sucre est mise à 0.
	 * @param teneurEnSucre - La nouvelle teneur en sucre du bonbon
	 */
	public void setTeneurEnSucre(double teneurEnSucre) {
		if (teneurEnSucre < 0) {
			this.teneurEnSucre = 0;
		} else {
			this.teneurEnSucre = teneurEnSucre;
		}
		
	}


}
