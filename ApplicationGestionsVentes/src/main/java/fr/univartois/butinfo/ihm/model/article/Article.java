package fr.univartois.butinfo.ihm.model.article;

import fr.univartois.butinfo.ihm.model.util.*;
import javafx.collections.ObservableList;

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
public class Article {
    /**
     *  La catégorie de l'article.
     */
    protected String categorie;
    /**
     * La désignation de l'article.
     */
    protected String designation;
    /**
     * Le nombre d'articles créés (qui sera notamment utilisé
     * pour la génération du numéro de référence de chaque article).
     */
    protected static int nbArticles = 0;
    /**
     * Le prix à l'unité.
     */
    protected double prix;
    /**
     * La quantité en stock.
     */
    protected int quantiteStock;
    /**
     * Le numéro de référence de l'article.
     */
    protected int reference;

    /**
     * Constructeur permettant de créer un nouvel article avec comme catégorie "Aucune".
     * Son numéro de référence est généré automatiquement. Les autres informations sont
     * saisies au clavier avec la méthode saisirInfos().
     */
    public Article() {
        this.saisirInfos();
        this.categorie = "Aucune";
        this.reference = this.nbArticles;
        this.nbArticles++;
    }

    /**
     * Méthode permettant de saisir la désignation, le prix et la
     * quantité en stock d'un article. La catégorie n'est pas saisie.
     * Il faut qu'elle soit initialisée par ailleurs.
     */
    public void saisirInfos() {
        this.designation = Util.saisirChaine("Quelle est la désignation de l'article ? ");
        this.prix = Util.saisirDoublePositif("Quel est son prix ? ");
        this.quantiteStock = Util.saisirEntierPositif("Quelle est la quantité de l'article ?");
    }

    /**
     * Constructeur permettant de créer un nouvel article. Son numéro
     * de référence est généré automatiquement.
     * @param categorie La catégorie de l'article.
     * @param designation La désignation de l'article.
     * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
     * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
     */
    protected Article(String categorie, String designation, double prix, int quantiteStock) {
        this.categorie = categorie;
        this.designation = designation;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.reference = this.nbArticles;
        this.nbArticles++;
    }

    /**
     * Constructeur permettant de créer un nouvel article avec comme catégorie
     * "Aucune". Son numéro de référence est généré automatiquement.
     * @param designation La désignation de l'article.
     * @param prix Le prix de l'article (si strictement inférieur à 0.0 alors 0.0 est mis comme prix).
     * @param quantiteStock La quantité initiale en stock de l'article (si strictement inférieure à 0 alors 0 est mis comme quantité).
     */
    public Article(String designation, double prix, int quantiteStock) {
        this.designation = designation;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.categorie = "Aucune";
        this.reference = this.nbArticles;
        this.nbArticles++;
    }

    /**
     * Méthode retournant le prix de l'article.
     * @return Le prix de l'article.
     */
    public double getPrix() {
        return this.prix;
    }

    /**
     * Méthode permettant de modifier le prix d'un article.
     * Dans le cas où le prix donné en paramètre est strictement
     * inférieur à 0.0, la valeur 0.0 est mise comme prix.
     * @param prix Le nouveau prix de l'article.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Méthode retournant la quantité en stock de l'article.
     * @return La quantité en stock de l'article.
     */
    public int getQuantiteStock() {
        return this.quantiteStock;
    }

    /**
     * Méthode retournant si le produit est disponible
     * (i.e. si sa quantité en stock est strictement supérieure à 0).
     * @return true si et seulement si sa quantité en stock est strictement supérieure à 0.
     */
    public boolean estDisponible() {
        return this.quantiteStock < 0;
    }

    /**
     * Méthode permettant de modifier la quantité en stock de l'article.
     * Dans le cas où la quantité en stock donnée en paramètre est
     * strictement inférieure à 0 alors 0 est mis à la place.
     * @param quantiteStock La nouvelle quantité en stock de l'article.
     */
    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    /**
     * Méthode permettant d'ajouter une quantité à la quantité en stock
     * de l'article. Dans le cas où la quantité à ajouter est strictement
     * inférieure à 0 alors la quantité en stock n'est pas modifiée.
     * @param quantite La quantité à ajouter à la quantité en stock de l'article.
     */
    public void ajouterQuantiteStock(int quantite) {
        if (quantite > 0) {
            this.quantiteStock += quantite;
        }
    }

    /**
     * Méthode permettant de supprimer une quantité à la quantité en stock de l'article.
     * Dans le cas où la quantité à enlever est strictement inférieure à 0 alors la
     * quantité en stock n'est pas modifiée. Dans le cas où la quantité à enlever est supérieure
     * à la quantité en stock alors la quantité en stock devient 0.
     * @param quantite La quantité à enlever.
     */
    public void enleverQuantiteStock(int quantite) {
        if (quantite > 0) {
            if (quantite >= this.quantiteStock) {
                this.quantiteStock = 0;
            }
            else {
                this.quantiteStock -= quantite;
            }
        }
    }

    /**
     * Méthode retournant le numéro de référence de l'article.
     * @return La référence de l'article.
     */
    public int getReference() {
        return this.reference;
    }

    /**
     * Méthode retournant la catégorie de l'article.
     * @return La catégorie de l'article.
     */
    public String getCategorie() {
        return this.categorie;
    }

    /**
     * Méthode retournant la désignation de l'article.
     * @return La désignation de l'article.
     */
    public String getDesignation() {
        return this.designation;
    }

    /**
     * Méthode (redéfinition de toString()) retournant une représentation
     * textuelle. Cette représentation contient la référence, la désignation,
     * la catégorie, le prix unitaire et la quantité en stock de l'article.
     * @return Représentation textuelle de l'article.
     */
    public String toString() {
        return "->Désignation : "+this.designation+"\n->Catégorie : "+this.categorie+"\n->Prix : "+this.prix+"\n->Quantité : "+this.quantiteStock+"\n->Référence : "+this.reference;
    }

    /**
     * Méthode permettant de tester si deux articles sont les mêmes :
     * deux articles sont les mêmes si et seulement si ils ont le même numéro de référence.
     * @param article Un objet supposé être instance de la classe Article et non null.
     * @return equals in class Object
     */
    public boolean equals(Object article) {
    	if (article == null) {
    		return false;
    	} else if (!(article instanceof Article)) {
    		return false;
    	} else {
    		return ((Article)article).reference == reference;
    	}
    }

    /**
     * Méthode permettant d'afficher les articles d'un tableau d'articles.
     * @param articles Le tableau contenant les articles à afficher, chaque élément du tableau contient une référence non null.
     */
    public static void afficherTabArticles(ObservableList<Article> articles) {
        for (int i=0; i<=articles.size(); i++) {
            System.out.println(articles.get(i).toString());
            System.out.println("###################");
        }
    }

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
