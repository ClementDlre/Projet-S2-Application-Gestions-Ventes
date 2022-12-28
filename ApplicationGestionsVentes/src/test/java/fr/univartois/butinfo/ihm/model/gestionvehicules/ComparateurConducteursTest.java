package fr.univartois.butinfo.ihm.model.gestionvehicules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe ComparateurConducteur
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ComparateurConducteursTest {

	/**
	 * Ce test permet de tester la méthode ComparateurConducteur
	 */
	@Test
	@DisplayName("Test Méthode ComparateurConducteurs qui compare deux conducteurs entre eux")
	void testComparateurConducteur() {
		//GIVEN
		String nom1 = "ISAMBOURG";
		String prenom1 = "Jonathan";
		String numeroPermis1 = "46516165f1sd65f1";
		String typePermis1 = "C";
		
		String nom2 = "ISAMBOURG";
		String prenom2 = "Bastien";
		String numeroPermis2 = "46516165f1sd65f1";
		String typePermis2 = "C";
		
		String nom3 = "NIZART";
		String prenom3 = "Bastien";
		String numeroPermis3 = "46516165f1sd65f1";
		String typePermis3 = "C";
				
		//WHEN
		Livreur livreur1 = new Livreur(nom1,prenom1,numeroPermis1,typePermis1);
		Livreur livreur2 = new Livreur(nom2,prenom2,numeroPermis2,typePermis2);
		Commercial commercial3 = new Commercial(nom3,prenom3,numeroPermis3,typePermis3);
		ComparateurConducteurs comparateur = new ComparateurConducteurs();
		
		//THEN
		assertThat(comparateur.compare(livreur1, commercial3)).isEqualTo(-1);
		assertThat(comparateur.compare(commercial3, livreur1)).isEqualTo(1);
		assertThat(comparateur.compare(livreur1, livreur2)).isEqualTo(0);
		assertThat(comparateur.compare(livreur1, commercial3)).isNotEqualTo(1);
		assertThat(comparateur.compare(livreur1, commercial3)).isNotEqualTo(0);
		assertThat(comparateur.compare(commercial3, livreur1)).isNotEqualTo(0);
		assertThat(comparateur.compare(commercial3, livreur1)).isNotEqualTo(-1);
		assertThat(comparateur.compare(livreur1, livreur2)).isNotEqualTo(1);
		assertThat(comparateur.compare(livreur1, livreur2)).isNotEqualTo(-1);
		assertThat(comparateur.compare(livreur1, livreur1)).isEqualTo(0);
	}

}
