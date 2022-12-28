package fr.univartois.butinfo.ihm.model.gestionvehicules;

/**
 * Cette classe crée des exceptions indiquant qu'un élément existe déjà dans la liste.
 * @author Moi
 *
 */
public class ElementAlreadyExistsException extends Exception {
	
	/**
	 * Constructeur créant une exception ElementAlreadyInListException
	 * @param message - Le message d'erreur à afficher.
	 */
	public ElementAlreadyExistsException(String message) {
		super(message);
	}
}
