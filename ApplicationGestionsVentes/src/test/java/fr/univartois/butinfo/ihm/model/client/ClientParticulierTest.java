package fr.univartois.butinfo.ihm.model.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe ClientParticulier
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ClientParticulierTest {
	
	private ClientParticulier clientParticulierTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau clientParticulier avant chaque test
	 */
	@BeforeEach
	public void initClientParticulier() {
		//GIVEN
		String nom = "Delerue" ;
		String adresse = "1 rue Test, Lens, 62300" ;
		int pointsFidelite = 50;
		String prenom = "Clement";
		Genre genre = Genre.Homme;
		
		//WHEN
		clientParticulierTest = new ClientParticulier(nom, adresse,pointsFidelite,prenom,genre);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le clientParticulier utilisé pour le test
	 */
	@AfterEach
	public void invalideClientParticulier() {
		clientParticulierTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de ClientParticulier et les getteurs qui lui sont rattachés
	 */
	@Test
	@DisplayName("Test Constructeur ClientParticulier, Getteurs")
	void testClientEntrepriseConstructeur1() {	
		//THEN
		assertThat(clientParticulierTest.getNom()).isEqualTo("Delerue");
		assertThat(clientParticulierTest.getAdresse()).isEqualTo("1 rue Test, Lens, 62300");
		assertThat(clientParticulierTest.getPointsFidelite()).isEqualTo(50);
		assertThat(clientParticulierTest.getPrenom()).isEqualTo("Clement");
		assertThat(clientParticulierTest.getGenre()).isEqualTo(Genre.Homme);
	}
	
	/**
	 * Ce test permet de tester le setteur setGenre
	 */
	@Test
	@DisplayName("Test Setteur setGenre qui permet de changer le genre du clientParticulier")
	void testSetGenre() {
		//WHEN
		clientParticulierTest.setGenre(Genre.Femme);
		//THEN
		
		assertThat(clientParticulierTest.getGenre()).isEqualTo(Genre.Femme);
	}
	
	/**
	 * Ce test permet de tester le setteur setGenre
	 */
	@Test
	@DisplayName("Test2 Setteur setGenre qui permet de changer le genre du clientParticulier")
	void testSetGenreFalse() {
		//WHEN
		clientParticulierTest.setGenre(Genre.Femme);
		//THEN
		
		assertThat(clientParticulierTest.getGenre()).isNotEqualTo(Genre.Homme);
	}
	
	/**
	 * Ce test permet de tester le setteur setPrenom
	 */
	@Test
	@DisplayName("Test Setteur setPrenom qui permet de changer le prenom du clientParticulier")
	void testSetPrenom() {
		//WHEN
		clientParticulierTest.setPrenom("Jon");
		//THEN
		
		assertThat(clientParticulierTest.getPrenom()).isEqualTo("Jon");
	}
	
	/**
	 * Ce test permet de tester le setteur setPrenom
	 */
	@Test
	@DisplayName("Test2 Setteur setPrenom qui permet de changer le prenom du clientParticulier")
	void testSetPrenomFalse() {
		//WHEN
		clientParticulierTest.setPrenom("Jon");
		//THEN
		
		assertThat(clientParticulierTest.getPrenom()).isNotEqualTo("Guillaume");
	}
}
