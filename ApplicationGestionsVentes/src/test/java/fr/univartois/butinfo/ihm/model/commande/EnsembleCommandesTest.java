package fr.univartois.butinfo.ihm.model.commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *  Cette classe permet de tester les constrcuteurs, les m�thodes, les getteurs et les setteurs de la classe EnsembleCommandes
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class EnsembleCommandesTest {
	@Mock
	Commande commande1;
	@Mock
	Commande commande2;
	@Mock
	Commande commande3;
	@Mock
	Commande commande4;
	
	private EnsembleCommandes ensembleCommandeTest;
	
	/**
	 * Cette m�thode permet d'initialiser un nouvel ensemble de commande de vehicule avant chaque test
	 */
	@BeforeEach
	public void initEnsembleCommandes() {
		//WHEN
		ensembleCommandeTest = new EnsembleCommandes();
	}
	
	/**
	 * Cette m�thode permet de rendre invalide l'ensemble de commande utilis� pour le test
	 */
	@AfterEach
	public void invalideEnsembleCommandes() {
		ensembleCommandeTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de EnsembleCommande et la m�thode ajouterCommande, et les m�thodes estPlein et estVide
	 */
	@Test
	@DisplayName("Test Constructeur EnsembleCommandes, M�thode ajouterCommande qui ajoute une commande � l'ensemble des commandes, les m�thodes estVide et estPlein")
	void testEnsemblesCommandesETAjouterCommandeETestPleinETestVide() {
		ensembleCommandeTest.ajouterCommande(commande1);
		ensembleCommandeTest.ajouterCommande(commande2);
		ensembleCommandeTest.ajouterCommande(commande3);
		ensembleCommandeTest.ajouterCommande(commande4);
		
		//THEN
		assertThat(ensembleCommandeTest.estPlein()).isEqualTo(false);
		assertThat(ensembleCommandeTest.estVide()).isEqualTo(false);
	}
	
	/**
	* Ce test permet de tester la m�thode estVide
	 */
	@Test
	@DisplayName("Test M�thode estVide")
	void testEstVide() {		
		//THEN
		assertThat(ensembleCommandeTest.estVide()).isEqualTo(true);
	}
	
	/**
	* Ce test permet de tester la m�thode supprimerCommande
	 */
	@Test
	@DisplayName("Test M�thode supprimerCommande")
	void testSupprimerCommande() {
		when(commande4.getReference()).thenReturn(4);
		ensembleCommandeTest.ajouterCommande(commande1);
		ensembleCommandeTest.ajouterCommande(commande2);
		ensembleCommandeTest.ajouterCommande(commande3);
		ensembleCommandeTest.ajouterCommande(commande4);
		ensembleCommandeTest.supprimerCommande(4);
		ensembleCommandeTest.supprimerCommande(-9);

		
		//THEN
		assertThat(ensembleCommandeTest.getCommandes().size()).isEqualTo(4);
	}
}

