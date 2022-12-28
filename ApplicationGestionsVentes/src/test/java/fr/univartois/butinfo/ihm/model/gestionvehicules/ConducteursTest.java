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
 *  Cette classe permet de tester les constrcuteurs, les m�thodes, les getteurs et les setteurs de la classe Conducteurs
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */

@ExtendWith(MockitoExtension.class)
class ConducteursTest {
	@Mock
	Commercial commercial1;
	@Mock
	Commercial commercial2;
	@Mock
	Livreur livreur1;
	@Mock
	Livreur livreur2;
	
	private Conducteurs conducteursTest;
	
	/**
	 * Cette m�thode permet d'initialiser un nouveau conducteurs avant chaque test
	 */
	@BeforeEach
	public void initConducteurs() {
		//WHEN
		conducteursTest = new Conducteurs();
	}
	
	/**
	 * Cette m�thode permet de rendre invalide le conducteurs utilis� pour le test
	 */
	@AfterEach
	public void invalideConducteurs() {
		conducteursTest = null;
	}
	
	/**
	 * Ce test permet de tester le constructeur de Conducteurs et la m�thode ajouterConducteur
	 */
	@Test
	@DisplayName("Test Constructeur conducteurs, M�thode ajouteConducteur qui ajoute un conducteur � conducteurs, getteur getConducteurs")
	void testConducteurs() {
		conducteursTest.ajouteConducteur(commercial1);
		conducteursTest.ajouteConducteur(livreur1);
		conducteursTest.ajouteConducteur(commercial1);
		
		//THEN
		assertThat(conducteursTest.getConducteurs()).isEqualTo(conducteursTest);
	}
	
	/**
	 * Ce test permet de tester la m�thode supprimerConducteur
	 */
	@Test
	@DisplayName("Test supprimeConducteur qui supprime le conducteur choisit de conducteurs")
	void testSupprime() {
		//WHEN
		conducteursTest.ajouteConducteur(commercial1);
		conducteursTest.ajouteConducteur(livreur1);
		conducteursTest.supprimeConducteur(commercial1);
		conducteursTest.supprimeConducteur(commercial1);
		
		//THEN
		assertThat(conducteursTest.getConducteurs()).isEqualTo(conducteursTest);
	}
}
