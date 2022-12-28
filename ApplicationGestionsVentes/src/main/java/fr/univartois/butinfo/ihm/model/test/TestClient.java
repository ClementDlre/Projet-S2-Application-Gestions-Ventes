package fr.univartois.butinfo.ihm.model.test;

import java.util.ArrayList;

import fr.univartois.butinfo.ihm.model.client.Client;
import fr.univartois.butinfo.ihm.model.client.ClientEntreprise;
import fr.univartois.butinfo.ihm.model.client.ClientParticulier;
import fr.univartois.butinfo.ihm.model.client.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Une classe contenant une méthode main permettant de tester la classe Client et ses sous-classes.
 * @author Jean-François Condotta
 * @version 13/03/22
 */
public class TestClient {
	/**
	 * Méthode permettant de tester la classe Client et ses sous-classes. Cette méthode permet :
	 * 
	 * (1) Créer un tableau de 4 clients :
	 * 
	 * Le premier client du tableau est un client particulier créé sans aucune saisie.
	 * Le deuxième client du tableau est un client entreprise créé sans aucune saisie.
	 * Le troisième client du tableau est un client particulier créé avec une saisie au clavier.
	 * Le quatrième client du tableau est un client entreprise créé avec une saisie au clavier.
	 * 
	 * (2) Une fois le tableau de 4 clients créé, les clients du tableau sont affichés.
	 * 
	 * (3) Les informations des clients correspondant au premier et deuxième élément du tableau sont resaisis.
	 * 
	 * (4) les clients du tableau sont de nouveau affichés.
	 * 
	 * @param args Auncun argument.
	 */
	public static void main(String[] args) {
		ObservableList<Client> clients= FXCollections.observableList(new ArrayList<>());
		clients.add(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",600,"Hector",Genre.Homme));
		clients.add(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62000 Lens, France",200,"Francis Chêne"));
		System.out.println("Saisie d'un client de type particulier >>>");
		clients.add(new ClientParticulier());
		System.out.println("Saisie d'un client de type entreprise >>>");
		clients.add(new ClientEntreprise());
		System.out.println("**** Liste des clients ****");
		Client.afficherTabClients(clients);
		System.out.println("Nouvelle saisie des informations du premier client >>>");
		clients.get(0).saisirInfos();
		System.out.println("Nouvelle saisie des informations du deuxième client >>>");
		clients.get(1).saisirInfos();
		System.out.println("**** Liste des clients ****");
		Client.afficherTabClients(clients);
	}

}
