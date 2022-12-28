package fr.univartois.butinfo.ihm.model.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe CarnetClients
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class CarnetClientsTest {
	@Mock
	Client client1;
	@Mock
	Client client2;
	@Mock
	Client client3;
	@Mock
	Client client4;
	@Mock
	Client client5;
	@Mock
	Client client6;
	@Mock
	Client client7;
	@Mock
	Client client8;
	@Mock
	Client client9;
	@Mock
	Client client10;
	@Mock
	Client client11;

	private CarnetClients carnetClientsTest;
	
	/**
	 * Cette méthode permet d'initialiser un nouveau carnetClients avant chaque test
	 */
	@BeforeEach
	public void initCarnetClients() {
		//GIVEN
		String nom = "Professionnel" ;
				
		//WHEN
		carnetClientsTest = new CarnetClients(nom);
	}
	
	/**
	 * Cette méthode permet de rendre invalide le carnetClients utilisé pour le test
	 */
	@AfterEach
	public void invalideCarnetClients() {
		carnetClientsTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de CarnetClient et le getteur getNom
	 */
	@Test
	@DisplayName("Test Constructeur carnetClient, Getteurs")
	void testCarnetCleintConstructeur() {
		//THEN
		assertThat(carnetClientsTest.getNom()).isEqualTo("Professionnel");
	}
	
	/**
	 * Ce test permet de tester la méthode est vide et de vérifier que le carnetClient créé est bien vide
	 */
	@Test
	@DisplayName("Test Methode estVide qui permet de savoir si le carnetCLient est vide")
	void testEstVide() {
		//THEN
		assertThat(carnetClientsTest.estVide()).isEqualTo(true);
	}
	
	/**
	 * Ce test permet de tester la méthode est vide et de vérifier que le carnetClient n'est pas vide
	 */
	@Test
	@DisplayName("Test Methode estVide qui permet de savoir si le carnetCLient n'est vide")
	void testEstVideFalse() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		
		//THEN
		assertThat(carnetClientsTest.estVide()).isEqualTo(false);
	}
	
	/**
	 * Ce test permet de tester le setteur setNom
	 */
	@Test
	@DisplayName("Test Setteur setNom qui permet de modifier le nom du carnetClients")
	void testSetNom() {
		//WHEN
		carnetClientsTest.setNom("Particulier");
		
		//THEN
		assertThat(carnetClientsTest.getNom()).isEqualTo("Particulier");
	}
	
	/**
	 * Ce test permet de tester si le carnet client est plein et la méthode ajouterClient
	 */
	@Test
	@DisplayName("Test methode estPlein qui permet de savoir si le carnetClients est plein et la méthode ajouterClient qui permet d'ajouter des clients au carnetClient")
	void testEstPleinEtAjouterClient() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client2);
		carnetClientsTest.ajouterClient(client3);
		carnetClientsTest.ajouterClient(client4);
		carnetClientsTest.ajouterClient(client5);
		carnetClientsTest.ajouterClient(client6);
		carnetClientsTest.ajouterClient(client7);
		carnetClientsTest.ajouterClient(client8);
		carnetClientsTest.ajouterClient(client9);
		carnetClientsTest.ajouterClient(client10);
		carnetClientsTest.ajouterClient(client11);
		
		//THEN
		assertThat(carnetClientsTest.estPlein()).isEqualTo(true);
	}
	
	/**
	* Ce test permet de tester la méthode chercherIndiceClient
	*/
	@Test
	@DisplayName("Test Méthode chercherIndiceClient")
	void testChercherIndiceClient() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client1);
		
		//THEN
		assertThat(carnetClientsTest.getNbClients()).isNotEqualTo(2);
	}
	
	/**
	* Ce test permet de tester la méthode supprimerClient
	*/
	@Test
	@DisplayName("Test Méthode supprimerClient qui permet de supprimer un client")
	void testSupprimerClient() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client2);
		carnetClientsTest.supprimerClient(client2);

		//THEN
		assertThat(carnetClientsTest.getNbClients()).isEqualTo(1);
	}
	
	/**
	* Ce test permet de tester la méthode supprimerClient en supprimant un client qui n'existe pas
	*/
	@Test
	@DisplayName("Test2 Méthode supprimerClient qui permet de tester la suppression d'un client qui n'existe pas")
	void testSupprimerClient2() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client2);
		carnetClientsTest.supprimerClient(client3);

		//THEN
		assertThat(carnetClientsTest.getNbClients()).isEqualTo(2);
	}
	
	/**
	* Ce test permet de tester la méthode rechercherClientParReference
	*/
	@Test
	@DisplayName("Test Méthode rechercherClientParReference")
	void testRechercherClientParReference() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client2);

		//THEN
		assertThat(carnetClientsTest.rechercherClientParReference(5)).isEqualTo(null);
		assertThat(carnetClientsTest.rechercherClientParReference(client1.getReference())).isEqualTo(client1);
	}
	
	/**
	* Ce test permet de tester la méthode ClientDansCarnet
	*/
	@Test
	@DisplayName("Test Méthode clientsDansCarnet")
	void testClientsDansCarnet() {
		//WHEN
		carnetClientsTest.ajouterClient(client1);
		carnetClientsTest.ajouterClient(client2);
		carnetClientsTest.ajouterClient(client3);
		carnetClientsTest.ajouterClient(client4);

		//THEN
		assertThat(carnetClientsTest.clientsDansCarnet()).isNotEqualTo(null);
		assertThat(carnetClientsTest.clientsDansCarnet()).isNotEmpty();
	}
	
	/**
	* Ce test permet de tester la méthode rechercherClientParticulier
	*/
	@Test
	@DisplayName("Test Méthode rechercheClientParticulier")

	void testRechercheClientParticulier() {
		//WHEN
		ClientEntreprise client12 = new ClientEntreprise("Carrefour","1 rue Béthune, 62300, Lens,",2000,"carrefour.lens@gmail.com");
		ClientParticulier client13 = new ClientParticulier("Delerue","12 rue Test, Lens, 62300",50,"Delerue",Genre.Homme);
		carnetClientsTest.ajouterClient(client12);
		carnetClientsTest.ajouterClient(client13);

		//THEN
		assertThat(carnetClientsTest.clientsParticulierDansCarnet()).isNotEqualTo(null);
		assertThat(carnetClientsTest.clientsParticulierDansCarnet()).isNotEmpty();
	}
	
	/**
	* Ce test permet de tester la méthode rechercherClientEntreprise
	*/
	@Test
	@DisplayName("Test Méthode rechercheClientEntreprise")

	void testRechercheClientEntreprise() {
		//WHEN
		ClientEntreprise client12 = new ClientEntreprise("Carrefour","1 rue Béthune, 62300, Lens,",2000,"carrefour.lens@gmail.com");
		ClientParticulier client13 = new ClientParticulier("Delerue","12 rue Test, Lens, 62300",50,"Delerue",Genre.Homme);
		carnetClientsTest.ajouterClient(client12);
		carnetClientsTest.ajouterClient(client13);

		//THEN
		assertThat(carnetClientsTest.clientsEntrepriseDansCarnet()).isNotEqualTo(null);
		assertThat(carnetClientsTest.clientsEntrepriseDansCarnet()).isNotEmpty();
	}
	
	/**
	* Ce test permet de tester la méthode rechercherClientParMotCle
	*/
	@Test
	@DisplayName("Test Méthode recherhceClientParMotCle")

	void testRechercheClientParMotCle() {
		//WHEN
		ClientEntreprise client12 = new ClientEntreprise("Carrefour","1 rue Béthune, 62300, Lens,",2000,"carrefour.lens@gmail.com");
		ClientParticulier client13 = new ClientParticulier("Delerue","12 rue Test, Lens, 62300",50,"Clement",Genre.Homme);
		carnetClientsTest.ajouterClient(client12);
		carnetClientsTest.ajouterClient(client13);

		//THEN
		assertThat(carnetClientsTest.rechercherClientsParMotCle("Carrefour")).isEqualTo(client12);
		assertThat(carnetClientsTest.rechercherClientsParMotCle("12 rue Test, Lens, 62300")).isEqualTo(client13);
		assertThat(carnetClientsTest.rechercherClientsParMotCle("Delerue")).isEqualTo(client13);
	}
	
	/**
	* Ce test permet de tester le getteur getCarnets
	*/
	@Test
	@DisplayName("Test Getteur getCarnets")
	void testGetCarnets() {
		//WHEN
		ClientEntreprise client12 = new ClientEntreprise("Carrefour","1 rue Béthune, 62300, Lens,",2000,"carrefour.lens@gmail.com");
		ClientParticulier client13 = new ClientParticulier("Delerue","12 rue Test, Lens, 62300",50,"Clement",Genre.Homme);
		carnetClientsTest.ajouterClient(client12);
		carnetClientsTest.ajouterClient(client13);

		//THEN
		assertThat(carnetClientsTest.getClients()).isNotEqualTo(null);
		assertThat(carnetClientsTest.getClients()).isNotEmpty();
	}
}
