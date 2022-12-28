package fr.univartois.butinfo.ihm.model.test;

import java.util.ArrayList;

import fr.univartois.butinfo.ihm.model.article.Article;
import fr.univartois.butinfo.ihm.model.article.ArticleCat1;
import fr.univartois.butinfo.ihm.model.article.ArticleCat2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Une classe contenant une méthode main permettant de tester la classe Article et ses deux sous-classes ArticleCat1 et ArticleCat2.
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class TestArticle2 {
	/**
	 * Méthode permettant de tester la classe Article et ses deux sous-classes ArticleCat1 et ArticleCat2. 
	 * Cette méthode permet :
	 * 
	 * (1) Créer un tableau de 4 articles avec le troisième qui est de type ArticleCat1 et saisi au clavier
	 * et le quatrième qui est de type ArticleCat2 et saisi au clavier.
	 * 
	 * (2) Une fois le tableau de 4 articles créé, les articles du tableau sont affichés.
	 * 
	 * (3) Les informations des articles correspondant au troisième et quatrième élément du tableau sont resaisis.
	 * 
	 * (4) les articles du tableau sont de nouveau affichés.
	 * 
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		ObservableList<Article> articles= FXCollections.observableList(new ArrayList<>());
		articles.add(new Article("Super Article",15.0,5));
		articles.add(new Article("Article Sympa",10.0,123));
		System.out.println("Saisie d'un produit de type ArticleCat1 >>>");
		articles.add(new ArticleCat1());
		System.out.println("Saisie d'un produit de type ArticleCat2 >>>");
		articles.add(new ArticleCat2());
		System.out.println("**** Liste des articles ****");
		Article.afficherTabArticles(articles);
		System.out.println("Nouvelle saisie des informations du troisième article >>>");
		articles.get(2).saisirInfos();
		System.out.println("Nouvelle saisie des informations du quatrième article >>>");
		articles.get(3).saisirInfos();
		System.out.println("**** Liste des articles ****");
		Article.afficherTabArticles(articles);
	}

}
