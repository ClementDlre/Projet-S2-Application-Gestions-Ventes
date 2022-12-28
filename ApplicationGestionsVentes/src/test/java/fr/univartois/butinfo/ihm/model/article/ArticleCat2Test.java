package fr.univartois.butinfo.ihm.model.article;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les m�thodes, les getteurs et les setteurs de la classe ArticleCat2
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ArticleCat2Test {
	
	private ArticleCat2 articleCat2Test;
	
	/**
	 * Cette m�thode permet d'initialiser un nouveau articleCat2 avant chaque test
	 */
	@BeforeEach
	public void initArticleCat2() {
		//GIVEN
		String designation = "Bon'Boum" ;
		double prix = 2.30;
		int quantiteStock = 50;
		double teneurEnSucre = 20;
		Gout gout = Gout.Fraise;
		int hauteur = 10;
		int largeur = 10;
		int profondeur = 10;
		double poidsColis = 5;
		
		//WHEN
		articleCat2Test = new ArticleCat2(designation,prix,quantiteStock,teneurEnSucre,hauteur,largeur,profondeur,poidsColis,gout);
	}
	
	/**
	 * Cette m�thode permet de rendre invalide l'articleCat2 utilis� pour le test
	 */
	@AfterEach
	public void invalideArticleCat2() {
		articleCat2Test = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de ArticleCat2 et les getteurs qui lui sont rattach�s
	 */
	@Test
	@DisplayName("Test Constructeur ArticleCat2, Getteurs")
	void testarticleCat2TestConstructeur() {
		
		//THEN
		assertThat(articleCat2Test.getDesignation()).isEqualTo("Bon'Boum");
		assertThat(articleCat2Test.getPrix()).isEqualTo(2.30);
		assertThat(articleCat2Test.getQuantiteStock()).isEqualTo(50);
		assertThat(articleCat2Test.getGout()).isEqualTo(Gout.Fraise);
		assertThat(articleCat2Test.getTeneurEnSucre()).isEqualTo(20);
		assertThat(articleCat2Test.getHauteurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getLargeurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getProfondeurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getPoidsKgColis()).isEqualTo(5);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du gout
	 */
	@Test
	@DisplayName("Test Setteur Gout qui permet de changer le gout")
	void testSetGout() {
		//WHEN
		articleCat2Test.setGout(Gout.Citron);
		
		//THEN
		assertThat(articleCat2Test.getGout()).isEqualTo(Gout.Citron);
		assertThat(articleCat2Test.getGout()).isNotEqualTo(Gout.Fraise);
	}

	/**
	 * Ce test permet de tester le setteur permettant la modification de la teneur en sucre
	 */
	@Test
	@DisplayName("Test Setteur Teneur en sucre qui permet de changer la teneur en sucre")
	void testSetTeneurEnSucre() {
		//WHEN
		articleCat2Test.setTeneurEnSucre(50);
		
		//THEN
		assertThat(articleCat2Test.getTeneurEnSucre()).isEqualTo(50);
		assertThat(articleCat2Test.getTeneurEnSucre()).isNotEqualTo(30);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de la teneur en sucre
	 * Si on rentre une valeur n�gative, la teneur en sucre est mis � 0
	 */
	@Test
	@DisplayName("Test Setteur TeneurEnSucre N�gative")
	void testSetTeneurEnSucreNegatif() {
		//WHEN
		articleCat2Test.setTeneurEnSucre(-6);
		
		//THEN
		assertThat(articleCat2Test.getTeneurEnSucre()).isEqualTo(0);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du poids du colis
	 * Il permet aussi de tester les getteurs des dimensions du colis
	 */
	@Test
	@DisplayName("Test Setteur Poids du colis et les getteurs li�s au colis")
	void testGetColisSetColis() {
		//WHEN
		articleCat2Test.setPoidsColis(10.0);
		
		//THEN
		assertThat(articleCat2Test.getHauteurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getLargeurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getProfondeurColis()).isEqualTo(10);
		assertThat(articleCat2Test.getPoidsKgColis()).isEqualTo(10.0);
		assertThat(articleCat2Test.getHauteurColis()).isNotEqualTo(100);
		assertThat(articleCat2Test.getLargeurColis()).isNotEqualTo(100);
		assertThat(articleCat2Test.getProfondeurColis()).isNotEqualTo(100);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du poids du colis
	 * Si on rentre une valeur n�gative, le poids est mis � 1.5kg
	 */
	@Test
	@DisplayName("Test Setteur Poids du colis N�gatif")
	void testPoidNegatif() {
		//WHEN
		articleCat2Test.setPoidsColis(-5.0);
		
		//THEN
		assertThat(articleCat2Test.getPoidsKgColis()).isEqualTo(1.5);
		
	}
}
