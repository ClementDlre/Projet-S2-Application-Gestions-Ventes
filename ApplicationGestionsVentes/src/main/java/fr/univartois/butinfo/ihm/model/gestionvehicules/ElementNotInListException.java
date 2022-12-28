package fr.univartois.butinfo.ihm.model.gestionvehicules;

/**
 * Cette classe crée de exceptions indiquant qu'un élément n'est pas dans la liste.
 * @author Moi
 *
 */
public class ElementNotInListException extends Exception {
	
	/**
	 * Constructeur créant une exception ElementNotInListException
	 * @param message - Le message d'erreur à afficher.
	 */
	public ElementNotInListException(String message) {
		super(message);
	}
}
