package fr.univartois.butinfo.ihm.model.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe ClientEntreprise
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ClientEntrepriseTest {

	private ClientEntreprise clientEntrepriseTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau clientEntprise avant chaque test
	 */
	@BeforeEach
	public void initClientEntreprise() {
		//GIVEN
		String nom = "Delerue" ;
		String adresse = "1 rue Test, Lens, 62300" ;
		int pointsFidelite = 50;
		String contact = "test.test@gmail.com";
		
		//WHEN
		clientEntrepriseTest = new ClientEntreprise(nom, adresse,pointsFidelite,contact);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le clientEntprise utilisé pour le test
	 */
	@AfterEach
	public void invalideClientEntreprise() {
		clientEntrepriseTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de ClientEntreprise et les getteurs qui lui sont rattachés
	 */
	@Test
	@DisplayName("Test Constructeur ClientEntreprise, Getteurs")
	void testClientEntrepriseConstructeur1() {	
		//THEN
		assertThat(clientEntrepriseTest.getNom()).isEqualTo("Delerue");
		assertThat(clientEntrepriseTest.getAdresse()).isEqualTo("1 rue Test, Lens, 62300");
		assertThat(clientEntrepriseTest.getPointsFidelite()).isEqualTo(50);
		assertThat(clientEntrepriseTest.getContact()).isEqualTo("test.test@gmail.com");
	}
	
	/**
	* Ce test permet de tester le setteur setContact
	*/
	@Test
	@DisplayName("Test Setteur setContact qui permet de changer le contact du clientEntreprise")
	void testSetContact() {
		//WHEN
		clientEntrepriseTest.setContact("TEST.TEST@gmail.com");
		
		//THEN
		
		assertThat(clientEntrepriseTest.getContact()).isEqualTo("TEST.TEST@gmail.com");
	}

}
