package fr.univartois.butinfo.ihm.model.gestionvehicules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe Fourgon
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class FourgonTest {

	@Mock
	Livreur livreur1;
	@Mock
	Livreur livreur2;
	
	private Fourgon fourgonTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau fourgon avant chaque test
	 */
	@BeforeEach
	public void initFlotteVehicules() {
		//GIVEN
		String numImma = "25DF62";
		String modele = "Partner";
		String marque = "Peugeot";
		double kilometrage = 152360.2;
		int anCircu = 2012;
		double poidsMax = 300;
		double volumeMax = 2;
				
		//WHEN
		fourgonTest = new Fourgon(numImma,modele,marque,kilometrage,anCircu,poidsMax,volumeMax); 
	}
	
	/**
	 * Cette méthode permet de rendre invalide le fourgon utilisé pour le test
	 */
	@AfterEach
	public void invalideFlotteVehicules() {
		fourgonTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Fourgon et les getteurs qui lui sont rattachés
	 */
	@Test
	@DisplayName("Test Constructeur Fourgon, Getteurs")
	void testFourgon() {
		//THEN
		assertThat(fourgonTest.getNumImma()).isEqualTo("25DF62");
		assertThat(fourgonTest.getModele()).isEqualTo("Partner");
		assertThat(fourgonTest.getMarque()).isEqualTo("Peugeot");
		assertThat(fourgonTest.getKilometrage()).isEqualTo(152360.2);
		assertThat(fourgonTest.getAnCircu()).isEqualTo(2012);
		assertThat(fourgonTest.getPoidsMax()).isEqualTo(300);
		assertThat(fourgonTest.getVolumeMax()).isEqualTo(2);
	}
	
	/**
	 * Ce test permet de tester la méthode assigneLivreur
	 */
	@Test
	@DisplayName("Test Méthode assigneLivreur qui permet d'assigner un livreur à un fourgon")
	void testAssigneLivreur() {
		//WHEN
		fourgonTest.assigneLivreur(livreur1);
	}
}
