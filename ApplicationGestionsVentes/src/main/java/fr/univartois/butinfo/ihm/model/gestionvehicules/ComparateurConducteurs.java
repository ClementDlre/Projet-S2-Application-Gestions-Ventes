package fr.univartois.butinfo.ihm.model.gestionvehicules;

import java.util.Comparator;

/**
 * Cette classe permet de créer un comparateur spécial pour les conducteurs
 * @author Jonathan
 *
 */
public class ComparateurConducteurs implements Comparator<Conducteur>{
	
	/**
	 * Cette méthode compare les deux conducteurs.
	 * Si les deux conducteurs ont le même nom, on compare leurs prénoms.
	 * Cette méthode renvoie -1 si le conducteur c1 est avant c2 dans l'ordre alphabétique.
	 * 0 s'ils ont les mêmes noms/prénoms.
	 * 1 si le conducteur c1 est après c2 dans l'ordre alphabétique.
	 */
	public int compare(Conducteur c1, Conducteur c2) {
		int comparaison = c1.getNom().compareTo(c2.getNom());
		if (comparaison == 0) {
			return c1.getPrenom().compareTo(c2.getPrenom());
		} else {
			return comparaison;
		}
		
    }
   
	
}
