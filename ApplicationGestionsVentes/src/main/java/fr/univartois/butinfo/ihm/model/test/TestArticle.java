package fr.univartois.butinfo.ihm.model.test;

import java.util.ArrayList;

import fr.univartois.butinfo.ihm.model.article.Article;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Une classe contenant une méthode main permettant de tester la classe Article.
 * @author Jean-François Condotta
 * @version 16/03/22
 */
public class TestArticle {
	/**
	 * Méthode permettant de tester la classe Article. Cette méthode permet :
	 * 
	 * (1) Créer un tableau de 4 articles avec le quatrième article du tableau qui est saisi au clavier.
	 * 
	 * (2) Une fois le tableau de 4 articles créé, les articles du tableau sont affichés.
	 * 
	 * (3) Les informations des articles correspondant au premier et deuxième élément du tableau sont resaisis.
	 * 
	 * (4) les articles du tableau sont de nouveau affichés.
	 * 
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		ObservableList<Article> articles=FXCollections.observableList(new ArrayList<>());
		articles.add(new Article("Super Article",15.0,5));
		articles.add(new Article("Article Sympa",10.0,123));
		articles.add(new Article("Article Super Cool",4.0,1));
		System.out.println("Saisie d'un produit >>>");
		articles.add(new Article());
		System.out.println("**** Liste des articles ****");
		Article.afficherTabArticles(articles);
		System.out.println("Nouvelle saisie des informations du premier article >>>");
		articles.get(0).saisirInfos();
		System.out.println("Nouvelle saisie des informations du deuxième article >>>");
		articles.get(1).saisirInfos();
		System.out.println("**** Liste des articles ****");
		Article.afficherTabArticles(articles);
	}

}
