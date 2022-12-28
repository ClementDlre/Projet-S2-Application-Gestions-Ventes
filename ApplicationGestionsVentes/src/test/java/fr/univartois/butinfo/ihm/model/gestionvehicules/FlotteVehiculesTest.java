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
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe FlotteVehicules
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class FlotteVehiculesTest {
	@Mock
	Voiture voiture1;
	@Mock
	Fourgon fourgon1;
	@Mock
	Voiture voiture2;
	@Mock
	Fourgon fourgon2;
	
	private FlotteVehicules flotteVehiculesTest;
	
	/**
	 * Cette méthode permet d'initialiser une nouvelle flotte de vehicule avant chaque test
	 */
	@BeforeEach
	public void initFlotteVehicules() {
		//WHEN
		flotteVehiculesTest = new FlotteVehicules();
	}
	
	/**
	 * Cette méthode permet de rendre invalide la flotte de véhicule utilisé pour le test
	 */
	@AfterEach
	public void invalideFlotteVehicules() {
		flotteVehiculesTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de FlottesVehicules et la méthode ajouteVehicule
	 */
	@Test
	@DisplayName("Test Constructeur FlotteVehicules, Méthode ajouteVehicule qui permet d'ajouter un vehicule à la flotte de vehicule, getteur getFlotte")
	void testFlotteVehicules() {
		//WHEN
		flotteVehiculesTest.ajouteVehicule(voiture1);
		flotteVehiculesTest.ajouteVehicule(fourgon1);
		flotteVehiculesTest.ajouteVehicule(voiture1);
		
		//THEN
		assertThat(flotteVehiculesTest.getFlotte()).isEqualTo(flotteVehiculesTest);
	}
	
	/**
	 * Ce test permet de tester la méthode Supprime
	 */
	@Test
	@DisplayName("Test Methode supprimeVehicule qui permet de supprimer un vehicule de la flotte")
	void testSupprime() {
		//WHEN
		flotteVehiculesTest.ajouteVehicule(voiture1);
		flotteVehiculesTest.ajouteVehicule(fourgon1);
		flotteVehiculesTest.supprimeVehicule(voiture1);
		flotteVehiculesTest.supprimeVehicule(voiture2);
		
		//THEN
		assertThat(flotteVehiculesTest.getFlotte()).isEqualTo(flotteVehiculesTest);
	}
	
}
