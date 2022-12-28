package fr.univartois.butinfo.ihm.model.article;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les m�thodes, les getteurs et les setteurs de la classe Article
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ArticleTest {
	private Article articleTest;
	
	/**
	 * Cette m�thode permet d'initialiser un nouvel article avant chaque test
	 */
	@BeforeEach
	public void initArticleTest() {
		//GIVEN
		String categorie = "Bonbon acidul�" ;
		String designation = "Bon'Boum" ;
		double prix = 2.50;
		int quantiteStock = 60;
		
		//WHEN
		articleTest = new Article(categorie, designation,prix,quantiteStock);
	}
	
	/**
	 * Cette m�thode permet de rendre invalide l'article utilis� pour le test
	 */
	@AfterEach
	public void invalideArticleTest() {
		articleTest = null;
	}
	
	/**
	 * Ce test permet de tester le 1er constructeur de Article et les getteurs qui lui sont rattach�s
	 */
	@Test
	@DisplayName("Test Constructeur1 Article, Getteurs")
	void testarticleTestConstructeur1() {
	
		//THEN
		assertThat(articleTest.getCategorie()).isEqualTo("Bonbon acidul�");
		assertThat(articleTest.getDesignation()).isEqualTo("Bon'Boum");
		assertThat(articleTest.getPrix()).isEqualTo(2.50);
		assertThat(articleTest.getQuantiteStock()).isEqualTo(60);
	}

	/**
	 * Ce test permet de tester le 2e constructeur de Article et les getteurs qui lui sont rattach�s
	 */
	@Test
	@DisplayName("Test Constructeur2 Article, Getteurs")
	void testarticleTestConstructeur2() {
		//GIVEN
		String designation = "Bon'Boum" ;
		double prix = 2.30;
		int quantiteStock = 50;
		
		//WHEN
		Article articleTest2 = new Article(designation,prix,quantiteStock);
	
		//THEN
		assertThat(articleTest2.getDesignation()).isEqualTo(designation);
		assertThat(articleTest2.getPrix()).isEqualTo(prix);
		assertThat(articleTest2.getQuantiteStock()).isEqualTo(quantiteStock);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du prix de l'article
	 */
	@Test
	@DisplayName("Test Setteur Prix qui permet de changer le prix")
	void testSetPrix(){		
		//WHEN
		articleTest.setPrix(3);
		
		//Then
		assertThat(articleTest.getPrix()).isEqualTo(3);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du prix de l'article
	 * Si on rentre une valeur n�gative, le prix est mis � 0
	 */
	@Test
	@DisplayName("Test Setteur Prix N�gatif")
	void testSetPrixInfZero(){	
		//WHEN
		articleTest.setPrix(-3);
		
		//Then
		assertThat(articleTest.getPrix()).isEqualTo(0.0);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de la quantite dans le stock
	 */
	@Test
	@DisplayName("Test Setteur Quantite qui permet de changer la quantite dans le stock")
	void testSetQuantiteStock(){	
		//WHEN
		articleTest.setQuantiteStock(70);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(70);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de la quantite dans le stock
	 * Si on rentre une valeur n�gative, la quantite dans le stock est mis � 0
	 */
	@Test
	@DisplayName("Test Setteur Quantite N�gatif")
	void testQuantiteStockInfZero(){
		//WHEN
		articleTest.setQuantiteStock(-5);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(0);
	}
	
	/**
	 * Ce test permet de tester la m�thode permettant d'ajouter du stock
	 **/
	@Test
	@DisplayName("Test Methode ajouterQuantite qui permet d'ajouter une quantite � la quantite dans le stock existante")
	void testAjouterQuantiteStock(){
		//WHEN
		articleTest.ajouterQuantiteStock(5);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(65);
	}
	
	/**
	 * Ce test permet de tester la m�thode permettant d'ajouter du stock
	 * Si on rentre une valeur n�gative, la quantite ajoutée au stock est de 0
	 */
	@Test
	@DisplayName("Test Methode ajouterQuantite Negative qui n'ajoute rien � la quantite dans le stock")
	void testAjouterQuantiteStockInfZero(){
		//WHEN
		articleTest.ajouterQuantiteStock(-5);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(60);
	}
	
	/**
	 * Ce test permet de tester la m�thode permettant d'enlever du stock
	 **/
	@Test
	@DisplayName("Test Methode enleverQuantite qui permet d'enlever une quantite � la quantite dans le stock existante")
	void testEnleverQuantiteStock(){
		//WHEN
		articleTest.enleverQuantiteStock(10);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(50);
	}
	
	/**
	 * Ce test permet de tester la m�thode permettant d'enlever du stock
	 * Si on rentre une valeur n�gative, la quantite enlev� au stock est de 0
	 */
	@Test
	@DisplayName("Test Methode enleverQuanite Negative qui n'enleve rien � la quantite dans le stock")
	void testEnleverQuantiteStockInfZero(){
		//WHEN
		articleTest.enleverQuantiteStock(-5);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(60);
	}
	
	/**
	 * Ce test permet de tester la m�thode permettant d'enlever du stock
	 * Si on rentre une valeur sup�rieure au stock actuelle, la quantit� du stock est mise � 0
	 */
	@Test
	@DisplayName("Test Methode enleverQuanite Supp qui met le stock � 0")
	void testEnleverQuantiteStockSupp(){
		//WHEN
		articleTest.enleverQuantiteStock(70);
		
		//Then
		assertThat(articleTest.getQuantiteStock()).isEqualTo(0);
	}
	
	@Test
	@DisplayName("Test Methode Equals")
	void testEquals(){		
		//Then
		assertThat(articleTest.equals(articleTest)).isEqualTo(true);
	}
	
	/**
	 * Ce test permet de tester la m�thode est reference
	 */
	@Test
	@DisplayName("Test Methode Reference")
	void testReference(){
		//GIVEN
		String designation2 = "Bon'Bec";
		double prix2 = 3;
		int quantiteStock2 = 80;
			
		//WHEN
		Article articleTest2 = new Article(designation2, prix2, quantiteStock2);
		
		//Then
		assertThat(articleTest.getReference()).isNotEqualTo(articleTest2.getReference());
	}
	
	/**
	 * Ce test permet de tester la m�thode est disponible
	 */
	@Test
	@DisplayName("Test Methode estDisponible qui regarde si un article est disponible")
	void testEstDisponible(){		
		//Then
		assertThat(articleTest.estDisponible()).isNotEqualTo(true);
		assertThat(articleTest.estDisponible()).isEqualTo(false);
	}
}

