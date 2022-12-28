package fr.univartois.butinfo.ihm.model.gestionvehicules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *  Cette classe permet de tester les constrcuteurs, les méthodes, les getteurs et les setteurs de la classe ComprateurVehicules
 * 
 * @author DELERUE Clement
 * @version 16/06/2022
 */
class ComparateurVehiculesTest {
	/**
	 * Ce test permet de tester la méthode ComparateurVehicule
	 */
	@Test
	@DisplayName("Test Méthode ComparateurVehicules qui compare deux véhicules entre eux")
	void testComparateurVehicule() {
		//GIVEN
		String numImma1 = "56BD58";
		String modele1 = "Supra";
		String marque1 = "Toyota";
		double kilometrage1 = 15360.2;
		int anCircu1 = 1982;
		
		String numImma2 = "23ER85";
		String modele2 = "LAN-EV05";
		String marque2 = "Mitsubishi";
		double kilometrage2 = 10245.2;
		int anCircu2 = 1998;
		
		String numImma3 = "25DF62";
		String modele3 = "Partner";
		String marque3 = "Peugeot";
		double kilometrage3 = 152360.2;
		int anCircu3 = 2012;
		double poidsMax3 = 300;
		double volumeMax3 = 2;
		
		//WHEN
		ComparateurVehicules comparateur = new ComparateurVehicules();
		Voiture voiture1 = new Voiture(numImma1,modele1,marque1,kilometrage1,anCircu1); 
		Voiture voiture2 = new Voiture(numImma2,modele2,marque2,kilometrage2,anCircu2); 
		Fourgon fourgon1 = new Fourgon(numImma3,modele3,marque3,kilometrage3,anCircu3,poidsMax3,volumeMax3);

		//THEN
		assertThat(comparateur.compare(voiture1, voiture2)).isEqualTo(-1);
		assertThat(comparateur.compare(voiture2, voiture1)).isEqualTo(1);
		assertThat(comparateur.compare(voiture1, voiture1)).isEqualTo(0);
		assertThat(comparateur.compare(voiture1, voiture1)).isNotEqualTo(1);
		assertThat(comparateur.compare(voiture1, voiture1)).isNotEqualTo(-1);
		assertThat(comparateur.compare(voiture2, voiture1)).isNotEqualTo(0);
		assertThat(comparateur.compare(voiture2, voiture1)).isNotEqualTo(-1);
		assertThat(comparateur.compare(voiture1, voiture2)).isNotEqualTo(1);
		assertThat(comparateur.compare(voiture1, voiture2)).isNotEqualTo(0);
		assertThat(comparateur.compare(voiture1, fourgon1)).isEqualTo(-1);
	}

}
