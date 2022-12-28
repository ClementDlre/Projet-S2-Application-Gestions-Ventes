package fr.univartois.butinfo.ihm.model.commande;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import fr.univartois.butinfo.ihm.model.article.Article;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe LigneCommande
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class LigneCommandeTest {

	private LigneCommande ligneCommandeTest;
	private Article articleTest;
	
	/**
	 * Cette méthode permet d'initialiser une nouvelle ligneCommande carnetClients avant chaque test
	 */
	@BeforeEach
	public void initCarnetClients() {
		//GIVEN
		int quantite = 20;
		String designation = "Bon'Bec" ;
		double prix = 2.50;
		int quantiteStock = 60;
		
		//WHEN
		articleTest = new Article(designation,prix,quantiteStock);
		ligneCommandeTest = new LigneCommande(articleTest, quantite);
	}
	
	/**
	 * Cette méthode permet de rendre invalide la ligneCommande utilisé pour le test
	 */
	@AfterEach
	public void invalideCarnetClients() {
		ligneCommandeTest = null;
		articleTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de LigneCommande et la méthode ajouterConducteur
	 */
	@Test
	@DisplayName("Test Constructeur LigneCommande,Getteurs getQuantite et getArticle")
	void testLigneCommande() {		
		//THEN
		assertThat(ligneCommandeTest.getQuantite()).isEqualTo(20);
		assertThat(ligneCommandeTest.getArticle()).isEqualTo(articleTest);
	}
	
	/**
	 * Ce test permet de tester la méthode AjouterQuantite
	 */
	@Test
	@DisplayName("Test Méthode AjouterQuantite")
	void testAjouterQuantite() {
		//WHEN
		ligneCommandeTest.ajouterQuantite(60);
		
		//THEN
		assertThat(ligneCommandeTest.getQuantite()).isEqualTo(60);
	}
	
	/**
	 * Ce test permet de tester le getteur getMontant
	 */
	@Test
	@DisplayName("Test Getteur getMontant")
	void testGetMontant() {
		//THEN
		assertThat(ligneCommandeTest.getMontant()).isEqualTo(2.50);
	}
}
