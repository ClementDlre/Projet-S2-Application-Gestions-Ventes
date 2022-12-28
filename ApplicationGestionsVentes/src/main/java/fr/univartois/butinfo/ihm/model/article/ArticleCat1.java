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
public class ArticleCat1 extends Article {
    /**
     * La teneur en sucre du bonbon
     */
    protected double teneurEnSucre;
    /**
     * L'acidité du bonbon
     */
    protected double acidite;
    /**
     * Le gout du bonbon
     */
    protected Gout gout;

    /**
     * Constructeur permettant de créer un nouvel article avec comme catégorie "Bonbon acidulé".
     * Son numéro de référence est généré automatiquement. Les autres informations sont
     * saisies au clavier avec la méthode saisirInfos().
     */
    public ArticleCat1() {
        this.categorie = "Bonbon acidulé";
    }

    public ArticleCat1(String designation, Double prix, int quantite, double teneurEnSucre, double acidite, Gout gout) {
    	super("Bonbon acidulé",designation,prix,quantite);
    	this.teneurEnSucre = teneurEnSucre;
    	this.acidite = acidite;
    	this.gout = gout;
	}

	/**
     * Méthode permettant de saisir la désignation, le prix et la
     * quantité en stock d'un article, ainsi que le gout, la teneur
     * en sucre et l'acidité. La catégorie n'est pas saisie.
     * Il faut qu'elle soit initialisée par ailleurs.
     */
    public void saisirInfos() {
        int gout;
        this.designation = Util.saisirChaine("Quelle est la désignation de l'article ?");
        this.prix = Util.saisirDoublePositif("Quel est son prix ?");
        this.quantiteStock = Util.saisirEntierPositif("Quelle est la quantité de l'article ?");

        this.teneurEnSucre = Util.saisirDoublePositif("Quelle est la teneur en sucre de votre Bonbon ?");
        this.acidite = Util.saisirDoublePositif("Quelle est l'acidité de votre Bonbon ?");

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
     * Méthode (redéfinition de toString()) retournant une représentation
     * textuelle. Cette représentation contient la référence, la désignation,
     * la catégorie, le prix unitaire et la quantité en stock de l'article.
     * @return Représentation textuelle de l'article.
     */
    public String toString() {
        return "->Désignation : "+this.designation+"\n->Catégorie : "+this.categorie+"\n->Prix : "+this.prix+"\n->Quantité : "+this.quantiteStock+"\n->Référence : "+this.reference+"\n->Gout : "+this.gout+"\n->Teneur en Sucre : "+this.teneurEnSucre+"\n->Acidité du produit : "+this.acidite;
    }
    
    /**
     * Méthode retournant le goût du bonbon
     * @return Le goût du bonbon
     */
    public Gout getGout() {
    	return this.gout;
    }
    
    /**
     * Méthode retournant la teneur en sucre du bonbon
     * @return La teneur en sucre du bonbon
     */
    public Double getTeneurEnSucre() {
    	return this.teneurEnSucre;
    }
    
    /**
     * Méthode retournant l'acidité du bonbon
     * @return L'acidité du bonbon
     */
    public Double getAcidite() {
    	return this.acidite;
    }

    /**
     * Méthode permettant de mettre à jour le gout du bonbon
     * @param gout - Le nouveau gout du bonbon
     */
	public void setGout(Gout gout) {
		this.gout = gout;
	}

	/**
	 * Méthode permettant de mettre à jour l'acidité du bonbon
	 * Si acidite < 0, on change l'acidité à 0
	 * @param acidite - La nouvelle acidité du bonbon
	 */
	public void setAcidite(double acidite) {
		if (acidite < 0) {
			this.acidite = 0;
		} else {
			this.acidite = acidite;
		}
		
	}

	/**
	 * Méthode permettant de mettre à jour la teneur en sucre du bonbon
	 * Si teneurEnSucre < 0, on change la teneur en sucre à 0
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
