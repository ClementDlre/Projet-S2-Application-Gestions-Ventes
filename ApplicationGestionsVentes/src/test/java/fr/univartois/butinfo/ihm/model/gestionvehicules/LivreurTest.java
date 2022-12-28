package fr.univartois.butinfo.ihm.model.gestionvehicules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe Livreur
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class LivreurTest {

	private Livreur livreurTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau livreur avant chaque test
	 */
	@BeforeEach
	public void initLivreur() {
		//GIVEN
		String nom = "ISAMBOURG";
		String prenom = "Jonathan";
		String numeroPermis = "46516165f1sd65f1";
		String typePermis = "C";
				
		//WHEN
		livreurTest = new Livreur(nom,prenom,numeroPermis,typePermis);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le livreur utilisé pour le test
	 */
	@AfterEach
	public void invalideLivreur() {
		livreurTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Livreur et les getteurs qui lui sont rattachés 
	 */
	@Test
	@DisplayName("Test Constructeur Livreur, Getteurs")
	void testLivreur() {
		//THEN
		assertThat(livreurTest.getNom()).isEqualTo("ISAMBOURG");
		assertThat(livreurTest.getPrenom()).isEqualTo("Jonathan");
		assertThat(livreurTest.getNumeroPermis()).isEqualTo("46516165f1sd65f1");
		assertThat(livreurTest.getTypePermis()).isEqualTo("C");
		assertThat(livreurTest.getNbHeurCond()).isEqualTo(0);
		assertThat(livreurTest.getNbHeurCond()).isNotEqualTo(1);
	}

}
