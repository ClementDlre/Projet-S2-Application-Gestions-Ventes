package fr.univartois.butinfo.ihm.model.client;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Un objet de la classe CarnetClients correspond à un carnet de clients.
 * Chaque carnet de clients a un nom ("Carnet Clients 2022" par exemple) et permet de gérer un ensemble de clients.
 * Un carnet de clients ne peut pas contenir plus de CarnetClients.MAX_CLIENTS clients.
 * @author Jean-François Condotta
 * @version 13/03/22
 */
public class CarnetClients {
	/**
	 * Le nombre maximal de clients pouvant être dans un carnet (valué à 10).
	 */
	final public int MAX_CLIENTS=10;
	
	/**
	 * Les clients se trouvant dans le carnet. Il sera initialisé avec un tableau pouvant contenir MAX_CLIENTS clients.
	 */
	private ObservableList<Client> clients;
	
	/**
	 * Le nombre de clients dans le carnet. Les clients sont toujours placés en début du tableau clients.
	 */
	private int nbClients;

	/**
	 * Le nom du carnet de clients.
	 */
	private String nom;
	
	/**
	 * Constructeur permettant de construire un nouveau carnet de clients.
	 * 
	 * @param nom Le nom du carnet de clients.
	 */
	public CarnetClients(String nom) {
		this.nom=nom;
		clients=FXCollections.observableList(new ArrayList<Client>(MAX_CLIENTS));
		nbClients=0;
	}
	
	/**
	 * Méthode testant si le carnet est plein.
	 * @return true si et seulement si le carnet de clients est plein.
	 */
	public boolean estPlein() {
		return nbClients==MAX_CLIENTS;
	}
	/**
	 * Méthode testant si le carnet est vide.
	 * @return true si et seulement si le carnet de clients est vide.
	 */
	public boolean estVide() {
		return nbClients==0;
	}
	
	/**
	 * Méthode cherchant un client dans le tableau clients correspondant (ayant même référence) au client passé en parmaètre. 
	 * @param client Un client (supposé non null).
	 * @return L'indice où se trouve ce client dans le tableau clients. Dans le cas où le client n'est pas présent -1 est retourné.
	 */
	private int chercherIndiceClient(Client client) {
		for (int i=0;i<nbClients;i++)
			if (client.equals(clients.get(i)))
				return i;
		return -1;
	}
	
	/**
	 * Méthode permettant d'ajouter un client dans le carnet.
	 * Dans le cas où le carnet est plein ou bien le client est déjà présent dans le carnet, rien est fait.
	 * Dans le cas contraire le client est inséré dans le carnet.
	 * @param client Un client (supposé non null).
	 */
	public void ajouterClient(Client client) {
		if ((estPlein())||(chercherIndiceClient(client)!=-1))
			return;
		clients.add(client);
		nbClients++;
	}
	
	/**
	 * Méthode permettant de supprimer un client du carnet.
	 * Rien est fait dans le cas où le client n'est pas présent dans le carnet.
	 * @param client Un client (supposé non null).
	 */
	public void supprimerClient(Client client) {
		int indice=chercherIndiceClient(client);
		if (indice==-1)
			return;
		clients.remove(indice);
		nbClients--;
	}
	
	/**
	 * Méthode permettant de chercher un client dans le carnet avec son numéro de référence.
	 * @param refClient La référence du client recherché.
	 * @return Le client dans le carnet ayant refClient comme référence ou null si un tel client n'existe pas.
	 */
	public Client rechercherClientParReference(int refClient) {
		for (int i=0;i<nbClients;i++)
			if (clients.get(i).getReference()==refClient)
				return clients.get(i);
		return null;
	}

	/**
	 * Méthode retournant un nouveau tableau contenant les clients du carnet.
	 * Le tableau retourné a pour taille getNbClients().
	 * @return Un nouveau tableau non null contenant les clients du carnet.
	 */
	public ObservableList<Client> clientsDansCarnet() {
		ObservableList<Client> tab = FXCollections.observableList(new ArrayList<>(nbClients));
		for  (int i=0;i<nbClients;i++)
			tab.add(clients.get(i));
		return tab;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type particulier du carnet.
	 * @return Un nouveau tableau non null contenant les clients de type particulier du carnet.
	 */
	public ObservableList<Client> clientsParticulierDansCarnet() {
		int nb=0;
		ObservableList<Client> selection = FXCollections.observableList(new ArrayList<>());
		for (int i=0;i<nbClients;i++)
			if (clients.get(i) instanceof ClientParticulier)
				nb++;
		selection.add(clients.get(nb));
		nb=0;
		for (int i=0;i<nbClients;i++)
			if (clients.get(i) instanceof ClientParticulier)
				selection.add(clients.get(i));
		return selection;
	}
	
	/**
	 * Méthode retournant un nouveau tableau contenant les clients de type entreprise du carnet.
	 * @return Un nouveau tableau non null contenant les clients de type entreprise du carnet.
	 */
	public ObservableList<Client> clientsEntrepriseDansCarnet() {
		int nb=0;
		ObservableList<Client> selection= FXCollections.observableList(new ArrayList<>());
		for (int i=0;i<nbClients;i++)
			if (clients.get(i) instanceof ClientEntreprise)
				nb++;
		selection.add(clients.get(nb));
		nb=0;
		for (int i=0;i<nbClients;i++)
			if (clients.get(i) instanceof ClientEntreprise)
				selection.add(clients.get(i));
		return selection;
	}
	
	/**
	 * Méthode permettant de chercher des clients se trouvant dans le carnet à l'aide d'un mot clé.
	 * Les clients sélectionnés sont ceux dont le nom ou l'adresse contient le mot clé spécifié.
	 * La sélection tient compte de la casse.
	 * La méthode retourne un tableau de clients (toujours non null et pouvant contenir aucun élément si aucun client a été sélectionné).
	 * 
	 * @param motCle Le mot clé cherché dans les noms et les adresses.
	 * @return Un tableau contenant les clients trouvés dans le carnet dont l'adresse ou le nom contient le motCle.
	 */
	public ObservableList<Client> rechercherClientsParMotCle(String motCle) {
		int nb=0;
		ObservableList<Client> selection = FXCollections.observableList(new ArrayList<>());
		for (int i=0;i<nbClients;i++)
			if ((clients.get(i).getAdresse().contains(motCle))||(clients.get(i).getNom().contains(motCle)))
				nb++;
		selection.add(clients.get(nb));
		nb=0;
		for (int i=0;i<nbClients;i++)
			if ((clients.get(i).getAdresse().contains(motCle))||(clients.get(i).getNom().contains(motCle)))
				selection.add(clients.get(i));
		return selection;
	}
	

	/**
	 * Méthode retournant le nom du carnet de clients.
	 * @return Le nom du carnet de clients.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode permettant de modifier le nom du carnet de clients.
	 * @param nom Le nouveau nom du carnet.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode retournant le nombre de clients du carnet.
	 * @return Le nombre de clients dans le carnet.
	 */
	public int getNbClients() {
		return nbClients;
	}
	
	/**
	 * Méthode retournant la liste des clients.
	 * @return La liste des clients.
	 */
	public ObservableList<Client> getClients(){
		return clients;
	}
	
	/**
     * Crée un carnet de clients contenant les clients par défaut.
     * Ce carnet de clients sert de démonstration.
     *
     * @return Le carnet de clients par défaut.
     */
    public static CarnetClients defaultCarnetClients() {
        CarnetClients carnetClients=new CarnetClients("Carnet Clients 2022");
		carnetClients.ajouterClient(new ClientParticulier("Cure","30 rue des Tulipes, 62000 Lens, France",0,"Hector",Genre.Homme));
		carnetClients.ajouterClient(new ClientEntreprise("Peuplier and Co.","42 boulevard des Marguerites, 62000 Lens, France",10,"Francis Chêne"));
		carnetClients.ajouterClient(new ClientEntreprise("Charme and Co.","22 impasse des Lilas, 62000 Lille, France",500,"René Tilleul"));
		carnetClients.ajouterClient(new ClientParticulier("Tournesol","123 rue des narcisses, 62000 Lens, France",2000,"Jonquille",Genre.Femme));
        return carnetClients;
    }
}
