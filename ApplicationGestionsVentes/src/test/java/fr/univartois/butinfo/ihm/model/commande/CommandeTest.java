package fr.univartois.butinfo.ihm.model.commande;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univartois.butinfo.ihm.model.article.*;
import fr.univartois.butinfo.ihm.model.client.*;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe Commande
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
@ExtendWith(MockitoExtension.class)
class CommandeTest {
	@Mock
	Client client1;
	@Mock
	Article article1;
	@Mock
	Article article2;
	@Mock
	Article article3;
	@Mock
	Article article4;
	@Mock
	Article article5;
	@Mock
	Article article6;
	@Mock
	Article article7;
	@Mock
	Article article8;
	@Mock
	Article article9;
	@Mock
	Article article10;
	@Mock
	Article article11;

	/**
	 * Ce test permet de tester le constructeur de Commande et les getteurs qui lui sont rattachés
	 */
	@Test
	@DisplayName("Test Constructeur Commande, Méthode estCloturee, Getteur getReference, getNbLignesCommandes")
	void testCommandeConstructeur() {
		//GIVEN
		//WHEN
		Commande commande = new Commande(client1);
	
		//THEN
		assertThat(commande.estCloturee()).isEqualTo(false);
		assertThat(commande.getReference()).isEqualTo(commande.getReference());
		assertThat(commande.getNbLignesCommande()).isEqualTo(0);

	}
	
	/**
	 * Ce test permet de tester la méthode estVide
	 */
	@Test
	@DisplayName("Test Méthode estVide")
	void testEstVide() {
		//GIVEN
		//WHEN
		Commande commande = new Commande(client1);
	
		//THEN
		assertThat(commande.estPleine()).isEqualTo(false);
		assertThat(commande.estVide()).isEqualTo(true);
	}
	
	/**
	 * Ce test permet de tester la méthode estPleine
	 */
	@Test
	@DisplayName("Test Méthode estPlein")
	void testEstPleine() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(15);
		when(article2.getQuantiteStock()).thenReturn(15);
		when(article3.getQuantiteStock()).thenReturn(15);
		when(article4.getQuantiteStock()).thenReturn(15);
		when(article5.getQuantiteStock()).thenReturn(15);
		when(article6.getQuantiteStock()).thenReturn(15);
		when(article7.getQuantiteStock()).thenReturn(15);
		when(article8.getQuantiteStock()).thenReturn(15);
		when(article9.getQuantiteStock()).thenReturn(15);
		when(article10.getQuantiteStock()).thenReturn(15);
		when(article2.getReference()).thenReturn(2);
		when(article3.getReference()).thenReturn(3);
		when(article4.getReference()).thenReturn(4);
		when(article5.getReference()).thenReturn(5);
		when(article6.getReference()).thenReturn(6);
		when(article7.getReference()).thenReturn(7);
		when(article8.getReference()).thenReturn(8);
		when(article9.getReference()).thenReturn(9);
		when(article10.getReference()).thenReturn(10);
		
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,10);
		commande.commander(article2,9);
		commande.commander(article3,8);
		commande.commander(article4,7);
		commande.commander(article5,6);
		commande.commander(article6,5);
		commande.commander(article7,4);
		commande.commander(article8,3);
		commande.commander(article9,2);
		commande.commander(article10,1);
	
		//THEN
		assertThat(commande.getNbLignesCommande()).isEqualTo(10);
		assertThat(commande.estVide()).isEqualTo(false);
		assertThat(commande.estPleine()).isEqualTo(true);
	}
	
	/**
	 * Ce test permet de tester la méthode supprimerLigneCommande
	 */
	@Test
	@DisplayName("Test Méthode supprimerLigneCommande")
	void testSupprimerLigneCommande() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(15);
		when(article2.getQuantiteStock()).thenReturn(15);
		when(article1.getReference()).thenReturn(1);
		when(article2.getReference()).thenReturn(2);
		
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,10);
		commande.commander(article2,9);		
	
		//THEN
		assertThat(commande.supprimerLigneCommande(article2.getReference())).isEqualTo(true);
		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
	}
	
	/**
	 * Ce test permet de tester la méthode supprimerLigneCommande
	 */
	@Test
	@DisplayName("Test2 Méthode supprimerLigneCommande")
	void testSupprimerLigneCommande2() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(15);
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,10);
		commande.supprimerLigneCommande(2);
		
		//THEN
		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
	}
	
	/**
	 * Ce test permet de tester la méthode commander
	 */
	@Test
	@DisplayName("Test Méthode commander")
	void testCommander() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(15);
		when(article2.getQuantiteStock()).thenReturn(15);
		when(article3.getQuantiteStock()).thenReturn(15);
		when(article4.getQuantiteStock()).thenReturn(15);
		when(article5.getQuantiteStock()).thenReturn(15);
		when(article6.getQuantiteStock()).thenReturn(15);
		when(article7.getQuantiteStock()).thenReturn(15);
		when(article8.getQuantiteStock()).thenReturn(15);
		when(article9.getQuantiteStock()).thenReturn(15);
		when(article10.getQuantiteStock()).thenReturn(15);
		when(article11.getQuantiteStock()).thenReturn(15);
		when(article1.getReference()).thenReturn(1);
		when(article2.getReference()).thenReturn(2);
		when(article3.getReference()).thenReturn(3);
		when(article4.getReference()).thenReturn(4);
		when(article5.getReference()).thenReturn(5);
		when(article6.getReference()).thenReturn(6);
		when(article7.getReference()).thenReturn(7);
		when(article8.getReference()).thenReturn(8);
		when(article9.getReference()).thenReturn(9);
		when(article10.getReference()).thenReturn(10);
		when(article11.getReference()).thenReturn(11);
		
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,10);
		commande.commander(article2,9);
		commande.commander(article3,8);
		commande.commander(article4,7);
		commande.commander(article5,6);
		commande.commander(article6,5);
		commande.commander(article7,4);
		commande.commander(article8,3);
		commande.commander(article9,2);
		commande.commander(article10,1);
		commande.commander(article11,11);
	
		//THEN
		assertThat(commande.getNbLignesCommande()).isEqualTo(10);
	}
	
	/**
	 * Ce test permet de tester le getteur GetQuantite
	 */
	@Test
	@DisplayName("Test Getteur getQuantite")
	void testGetQuantite() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(15);
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,10);
		
		//THEN
		assertThat(commande.getQuantite(-1)).isEqualTo(0);
		assertThat(commande.getQuantite(3)).isEqualTo(0);
		assertThat(commande.getQuantite(0)).isEqualTo(10);
	}
	
	/**
	 * Ce test permet de tester le getteur getArticle
	 */
	@Test
	@DisplayName("Test Getteur getArticle")
	void testGetArticle() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(10);
		//WHEN
		Commande commande = new Commande(client1);
		commande.commander(article1,5);
		
		//THEN
		assertThat(commande.getArticle(-1)).isEqualTo(null);
		assertThat(commande.getArticle(3)).isEqualTo(null);
		assertThat(commande.getArticle(0)).isEqualTo(article1);
	}
	
	/**
	 * Ce test permet de tester la methode cloture
	 */
	@Test
	@DisplayName("Test Méthode cloture")
	void testSupprErreurCloture() {
		//GIVEN
		when(article1.getQuantiteStock()).thenReturn(2);
		//WHEN
		Commande commande =new Commande(client1);
		commande.commander(article1, 1);
		commande.cloturer(false);
		commande.supprimerLigneCommande(article1.getReference());
		//THEN
		assertThat(commande.getNbLignesCommande()).isEqualTo(1);
	}
	
	/**
	 * Ce test permet de tester la methode cloture
	 */
	@Test
	@DisplayName("Test2 Méthode cloture")
	void testCommanderErreurCloture() {
		//GIVEN
		//WHEN
		Commande commande =new Commande(client1);
		commande.commander(article1, 0);
		commande.cloturer(false);
		//THEN
		assertThat(commande.getNbLignesCommande()).isEqualTo(0);
	}
}
