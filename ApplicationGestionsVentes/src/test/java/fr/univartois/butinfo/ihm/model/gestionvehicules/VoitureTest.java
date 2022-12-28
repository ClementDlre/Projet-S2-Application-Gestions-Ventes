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
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe Voiture
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class VoitureTest {
	@Mock
	Commercial commercial1;
	@Mock
	Commercial commercial2;
	
	private Voiture voitureTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau voiture avant chaque test
	 */
	@BeforeEach
	public void initVoiture() {
		//GIVEN
		String numImma = "56BD58";
		String modele = "Supra";
		String marque = "Toyota";
		double kilometrage = 15360.2;
		int anCircu = 1982;
				
		//WHEN
		voitureTest = new Voiture(numImma,modele,marque,kilometrage,anCircu);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le voiture utilisé pour le test
	 */
	@AfterEach
	public void invalideVoiture() {
		voitureTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Voiture et les getteurs qui lui sont rattachés 
	 */
	@Test
	@DisplayName("Test Constructeur Voiture, Getteurs")
	void testVoiture() {
		//THEN
		assertThat(voitureTest.getNumImma()).isEqualTo("56BD58");
		assertThat(voitureTest.getModele()).isEqualTo("Supra");
		assertThat(voitureTest.getMarque()).isEqualTo("Toyota");
		assertThat(voitureTest.getKilometrage()).isEqualTo(15360.2);
		assertThat(voitureTest.getAnCircu()).isEqualTo(1982);
	}
	
	/**
	 * Ce test permet de tester la méthode assigneCommercial
	 */
	@Test
	@DisplayName("Test Méthode assigneCommercial qui permet d'assigner un commercial à une voiture")
	void testAssigneCommercial() {
		voitureTest.assigneCommercial(commercial1);
	}
	
}
