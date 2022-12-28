package fr.univartois.butinfo.ihm.model.gestionvehicules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe Commercial
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class CommercialTest {

	private Commercial commercialTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau commercial avant chaque test
	 */
	@BeforeEach
	public void initCommercial() {
		//GIVEN
		String nom = "Delerue";
		String prenom = "Clement";
		String numeroPermis = "12BC52CD";
		String typePermis = "B";
				
		//WHEN
		commercialTest = new Commercial(nom,prenom,numeroPermis,typePermis);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le commercial utilisé pour le test
	 */
	@AfterEach
	public void invalideCommercial() {
		commercialTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Commercial et les getteurs qui lui sont rattachés 
	 */
	@Test
	@DisplayName("Test Constructeur et Getteur de Commercial")
	void testCommercial() {
		//THEN
		assertThat(commercialTest.getNom()).isEqualTo("Delerue");
		assertThat(commercialTest.getPrenom()).isEqualTo("Clement");
		assertThat(commercialTest.getNumeroPermis()).isEqualTo("12BC52CD");
		assertThat(commercialTest.getTypePermis()).isEqualTo("B");
		assertThat(commercialTest.getNbVisitEffect()).isEqualTo(0);
		assertThat(commercialTest.getNbVisitEffect()).isNotEqualTo(1);
	}

}
