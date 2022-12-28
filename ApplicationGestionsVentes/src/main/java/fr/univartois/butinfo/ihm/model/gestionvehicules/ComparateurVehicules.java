package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.Comparator;


/**
 * Cette classe permet de comparer des véhicules.
 * @author Moi
 *
 */
public class ComparateurVehicules implements Comparator<Vehicule>{
	
	/**
	 * Cette méthode compare les deux véhicules.
	 * Cette méthode renvoie -1 si le véhicule v1 a été mis en circulation avant le véhicule v2
	 * 0 s'ils ont les mêmes années de mise en circulation.
	 * 1 si le véhicule v1 a été mis en circulation après le véhicule v2.
	 */
	public int compare(Vehicule v1, Vehicule v2) {
		if (v1.getAnCircu() < v2.getAnCircu()) {
			return -1;
		} else if (v1.getAnCircu() < v2.getAnCircu()) {
			return 0;
		}
		return 1;
	}
}
