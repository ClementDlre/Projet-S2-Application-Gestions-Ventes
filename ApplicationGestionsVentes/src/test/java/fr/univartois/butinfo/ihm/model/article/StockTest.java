package fr.univartois.butinfo.ihm.model.article;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
/**
 *  Cette classe permet de tester les constrcuteurs, les m�thodes, les getteurs et les setteurs de la classe Stock
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class StockTest {
	@Mock
	Article article1;
	@Mock
	Article article2;
	@Mock
	Article article3;
	@Mock
	Article article4;
	@Mock
	Article article5;
	@Mock
	Article article6;
	@Mock
	Article article7;
	@Mock
	Article article8;
	@Mock
	Article article9;
	@Mock
	Article article10;
	@Mock
	Article article11;

private Stock stockTest;
	
	/**
	 * Cette m�thode permet d'initialiser un nouveau stock avant chaque test
	 */
	@BeforeEach
	public void initCalculatrice() {
	//GIVEN
	String nom = "Bon'stockTest";
				
	//WHEN
	stockTest = new Stock(nom);
	}
	
	/**
	 * Cette m�thode permet de rendre invalide le stock utilis� pour le test
	 */
	@AfterEach
	public void invalideCalculatrice() {
	stockTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Stock et les getteurs qui lui sont rattach�s
	 */
	@Test
	@DisplayName("Test Constructeur Stock, Getteurs")
	void teststockTestConstructeur() {
		//THEN
		assertThat(stockTest.getNom()).isEqualTo("Bon'stockTest");
		assertThat(stockTest.getNbArticles()).isEqualTo(0);
	}

	/**
	 * Ce test permet de tester les m�thodes permettant de savoir si le stock est vide et si le stock n'est pas plein
	 */
	@Test
	@DisplayName("Test Methode estVide qui test si le stock est vide")
	void testEstVide() {
		//THEN
		assertThat(stockTest.estVide()).isEqualTo(true);
		assertThat(stockTest.estPlein()).isEqualTo(false);
	}
	
	/**
	 * Ce test permet de tester permettant de savoir si le stock n'est pas vide
	 */
	@Test
	@DisplayName("Test Methode estVide qui test si le stock n'est vide")
	void testEstVideFalse() {
		//WHEN
		stockTest.ajouterArticle(article1);
		
		//THEN
		assertThat(stockTest.estVide()).isEqualTo(false);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du nom du stock
	 */
	@Test
	@DisplayName("Test setNom qui permet de changer le nom du stock")
	void testSetNom() {
		//WHEN
		stockTest.setNom("Bon'Amaury");
		
		//THEN
		assertThat(stockTest.getNom()).isEqualTo("Bon'Amaury");
	}
	
	/**
	 * Ce test permet de tester la m�thode estPlein et la m�thode ajouterArticle
	 */
	@Test
	@DisplayName("Test methode ajouterArticle qui permet d'ajouter un article, et la m�thode estPlein qui permet de savoir si le stock est plein")
	void testEstPleinEtAjouterArticle() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);
		stockTest.ajouterArticle(article3);
		stockTest.ajouterArticle(article4);
		stockTest.ajouterArticle(article5);
		stockTest.ajouterArticle(article6);
		stockTest.ajouterArticle(article7);
		stockTest.ajouterArticle(article8);
		stockTest.ajouterArticle(article9);
		stockTest.ajouterArticle(article10);
		stockTest.ajouterArticle(article11);
		
		//THEN
		assertThat(stockTest.estPlein()).isEqualTo(true);
	}
	
	/**
	 * Ce test permet de tester la m�thode chercherIndiceArticle 
	 */
	@Test
	@DisplayName("Test Methode chercherIndiceArticle")
	void testChercherIndiceArticle() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article1);
		
		//THEN
		assertThat(stockTest.getNbArticles()).isNotEqualTo(2);
	}
	
	/**
	 * Ce test permet de tester la m�thode supprimerArticle qui supprime un article du stock
	 */
	@Test
	@DisplayName("Test Methode supprimerArticle qui permet de supprimer un article du stock")
	void testSupprimerArticle() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);
		stockTest.supprimerArticle(article1);

		//THEN
		assertThat(stockTest.getNbArticles()).isEqualTo(1);
	}
	
	/**
	 * Ce test permet de tester la m�thode supprimerArticle qui supprime un article du stock
	 * Ici on essaie de supprimer un article qui n'existe pas
	 */
	@Test
	@DisplayName("Test Methode supprimerArticle qui teste la suppression d'un article qui n'existe pas")
	void testSupprimerArticle2() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);
		stockTest.supprimerArticle(article3);

		//THEN
		assertThat(stockTest.getNbArticles()).isEqualTo(2);
	}
	
	/**
	 * Ce test permet de tester la m�thode recherhceArticlesCategories qui permet de chercher un article gr�ce � sa cat�gorie
	 */
	@Test
	@DisplayName("Test Methode rechercheArticlesCategories")
	void testRechercheArticlesCategories() {
		//WHEN
		ArticleCat1 article12 = new ArticleCat1("Bon'Boum",2.70,150,30,30,Gout.Fraise);
		ArticleCat2 article13 = new ArticleCat2("Bon'Gout",1.5,200,10,10,10,10,30.,Gout.Citron);
		stockTest.ajouterArticle(article12);
		stockTest.ajouterArticle(article13);

		//THEN
		assertThat(stockTest.rechercherArticlesCategorie("Bonbon non-acidul�")).isNotEmpty();
		assertThat(stockTest.rechercherArticlesCategorie("Bonbon non-acidul�")).isNotEqualTo(null);
		assertThat(stockTest.rechercherArticlesCategorie("Bonbon non-acidul�")).isNotEmpty();
	}
	
	/**
	 * Ce test permet de tester la m�thode articleDansStock
	 */
	@Test
	@DisplayName("Test Methode articleDansStock")
	void testArticleDansStockTestNotNull() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);
		stockTest.ajouterArticle(article3);
		stockTest.ajouterArticle(article4);

		//THEN
		assertThat(stockTest.articlesDansStock()).isNotEqualTo(null);
		assertThat(stockTest.articlesDansStock()).isNotEmpty();
	}
	
	/**
	 * Ce test permet de tester la m�thode rechercherArticleParReference
	 */
	@Test
	@DisplayName("Test Methode rechercheArticleParReference")
	void testRechercherArticleParReference() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);

		//THEN
		assertThat(stockTest.rechercherArticleParReference(5)).isEqualTo(null);
		assertThat(stockTest.rechercherArticleParReference(article1.getReference())).isEqualTo(article1);
	}
	
	/**
	 * Ce test permet de tester le getteur getArticle
	 */
	@Test
	@DisplayName("Test Getteur getArticles")
	void testGetArticles() {
		//WHEN
		stockTest.ajouterArticle(article1);
		stockTest.ajouterArticle(article2);
		stockTest.ajouterArticle(article3);
		stockTest.ajouterArticle(article4);

		//THEN
		assertThat(stockTest.getArticles()).isNotEqualTo(null);
		assertThat(stockTest.getArticles()).isNotEmpty();
	}
}
