package fr.univartois.butinfo.ihm.model.article;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe ArticleCat1
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ArticleCat1Test {
	private ArticleCat1 articleCat1Test;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau articleCat1 avant chaque test
	 */
	@BeforeEach
	public void initArticleCat1() {
		//GIVEN
		String designation = "Bon'Boum" ;
		double prix = 2.30;
		int quantiteStock = 50;
		double acidite = 5;
		double teneurEnSucre = 20;
		Gout gout = Gout.Fraise;
		
		//WHEN
		articleCat1Test = new ArticleCat1(designation,prix,quantiteStock,teneurEnSucre,acidite,gout);
	}
	
	/**
	 * Cette méthode permet de rendre invalide l'articleCat1 utilisé pour le test
	 */
	@AfterEach
	public void invalideArticle1() {
		articleCat1Test = null;
	}
	
	
	/**
	 * Ce test permet de tester le constructeur de ArticleCat1 et les getteurs qui lui sont rattachés
	 */
	@Test
	@DisplayName("Test Constructeur ArticleCat1, Getteurs")
	void testarticleCat1TestConstructeur1() {
		//THEN
		assertThat(articleCat1Test.getDesignation()).isEqualTo("Bon'Boum");
		assertThat(articleCat1Test.getPrix()).isEqualTo(2.30);
		assertThat(articleCat1Test.getQuantiteStock()).isEqualTo(50);
		assertThat(articleCat1Test.getGout()).isEqualTo(Gout.Fraise);
		assertThat(articleCat1Test.getAcidite()).isEqualTo(5);
		assertThat(articleCat1Test.getTeneurEnSucre()).isEqualTo(20);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification du gout
	 */
	@Test
	@DisplayName("Test Setteur Gout qui permet de changer le gout")
	void testSetGout() {
		//WHEN
		articleCat1Test.setGout(Gout.Citron);
		
		//THEN
		assertThat(articleCat1Test.getGout()).isEqualTo(Gout.Citron);
		assertThat(articleCat1Test.getGout()).isNotEqualTo(Gout.Fraise);
	}

	/**
	 * Ce test permet de tester le setteur permettant la modification de l'acidite
	 */
	@Test
	@DisplayName("Test Setteur Acidite qui permet de changer l'acidite")
	void testSetAcidite() {
		//WHEN
		articleCat1Test.setAcidite(20);
		
		//THEN
		assertThat(articleCat1Test.getAcidite()).isEqualTo(20);
		assertThat(articleCat1Test.getAcidite()).isNotEqualTo(10);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de la teneur en sucre
	 */
	@Test
	@DisplayName("Test Setteur Teneur en sucre qui permet de changer la teneur en sucre")
	void testSetTeneurEnSucre() {
		//WHEN
		articleCat1Test.setTeneurEnSucre(50);
		
		//THEN
		assertThat(articleCat1Test.getTeneurEnSucre()).isEqualTo(50);
		assertThat(articleCat1Test.getTeneurEnSucre()).isNotEqualTo(30);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de l'acidite
	 * Si on rentre une valeur négative, l'acidité est mis à 0
	 */
	@Test
	@DisplayName("Test Setteur Acidite Négative")
	void testSetAciditeNegatif() {
		//WHEN
		articleCat1Test.setAcidite(-4);
		
		//THEN
		assertThat(articleCat1Test.getAcidite()).isEqualTo(0);
	}
	
	/**
	 * Ce test permet de tester le setteur permettant la modification de la teneur en sucre
	 * Si on rentre une valeur négative, la teneur en sucre est mis à 0
	 */
	@Test
	@DisplayName("Test Setteur TeneurEnSucre Négative")
	void testSetTeneurEnSucreNegatif() {
		//WHEN
		articleCat1Test.setTeneurEnSucre(-6);
		
		//THEN
		assertThat(articleCat1Test.getTeneurEnSucre()).isEqualTo(0);
	}

}
