package fr.univartois.butinfo.ihm.model.gestionvehicules;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import fr.univartois.butinfo.ihm.model.client.CarnetClients;
import fr.univartois.butinfo.ihm.model.client.ClientEntreprise;
import fr.univartois.butinfo.ihm.model.client.ClientParticulier;
import fr.univartois.butinfo.ihm.model.client.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Une instance de la classe Conducteurs correspond à une liste de conducteurs.
 * Elle contient une liste de conducteurs (ObservableList<Conducteur>) et une flotte de véhicules (FlotteVehicules)
 * @author Jonathan
 *
 */
public class Conducteurs{
	/**
	 * La liste de conducteurs
	 */
    private ObservableList<Conducteur> conducteurs;
    
    /**
     * La flotte de véhicules
     */
    private FlotteVehicules flotte;
    
    /**
     * Constructeur créant une instance de la classe Conducteurs.
     * On y initialise la liste de conducteurs.
     */
    public Conducteurs() {
    	this.conducteurs = FXCollections.observableList(new LinkedList<>());
    }

    /**
     * Méthode retournant la liste de conducteurs.
     * @return La liste de conducteurs.
     */
    public ObservableList<Conducteur> getConducteurs() {
        return this.conducteurs;
    }
    
    /**
     * Méthode permettant de mettre à jour la flotte de véhicules
     * @param flotte - La nouvelle flotte de véhicules
     */
    public void setFlotte(FlotteVehicules flotte) {
    	this.flotte = flotte;
    }
    
    /**
     * Méthode permettant d'ajouter un conducteur à la liste de conducteurs.
     * Si le conducteur est null, rien ne se passe.
     * Si le conducteur est déjà dans la liste, une exception est levée.
     * @param conducteur
     */
    public void ajouteConducteur(Conducteur conducteur) {
    	if (conducteur != null) {
    		try {
    			existeDeja(conducteur);
    		} catch (ElementAlreadyExistsException e) {
    			System.out.println("Le conducteur n'a pas pu être ajouté.");
    		}
    		conducteurs.add(conducteur);
    	}
    	
    }
    
    /**
     * Méthode permettant de savoir si un conducteur est dans la liste.
     * Cette méthode lève une ElementNotInListException si le conducteur n'est pas dans la liste de conducteurs.
     * @param conducteur - Le conducteur qu'on cherche
     * @return true si le conducteur est dans la liste, false sinon
     * @throws ElementNotInListException
     */
    public boolean existe(Conducteur conducteur) throws ElementNotInListException {
    	if (conducteurs.contains(conducteur)) {
    		return true;
    	} else {
    		throw new ElementNotInListException("Le conducteur n'est pas dans la liste !");
    	}
    }
    
    /**
     * Méthode permettant de savoir si un conducteur existe déjà dans la liste de conducteurs.
     * Cette méthode lève une ElementAlreadyInListException si le conducteur est déjà dans la liste.
     * @param conducteur - Le conducteur qu'on cherche
     * @return true si le conducteur existe déjà dans la liste de conducteurs, false sinon
     * @throws ElementAlreadyExistsException
     */
    public boolean existeDeja(Conducteur conducteur) throws ElementAlreadyExistsException {
    	if (conducteurs.contains(conducteur)) {
    		throw new ElementAlreadyExistsException("Le conducteur est déjà dans la liste !");
    	} else {
    		return false;
    	}
    }

    /**
     * Cette méthode permet de supprimer un conducteur de la liste.
     * Si le conducteur n'est pas dans la liste, rien ne se passe
     * @param conducteur - Le conducteur qu'on veut supprimer de la liste.
     */
    public void supprimeConducteur(Conducteur conducteur) {
    	try {
        	existe(conducteur);
    	} catch (ElementNotInListException e) {
    		System.out.println("Le conducteur n'a pas pu être supprimé");
    	}
    	conducteurs.remove(conducteur);
    }

    /**
     * Méthode affichant les commerciaux de la liste de conducteurs.
     */
    public void afficheCommerciaux() {
    	Iterator<Conducteur> it = conducteurs.iterator();
    	System.out.println("Commerciaux : ");
    	while (it.hasNext()) {
    		Object obj = it.next();
    		if (obj instanceof Commercial) {
    			System.out.println("\t * " + obj.toString());
    		}
    	}
    }
    
    /**
     * Méthode permettant de trouver un commercial à partir de son prénom et de son nom
     * @param prenom - Le prénom du commercial recherché
     * @param nom - Le nom du commercial recherché.
     * @return Commercial - Le commercial s'il a été trouvé.
     */
    public Commercial trouveCommercial(String prenom, String nom) {
    	Iterator<Conducteur> it = conducteurs.iterator();
    	boolean notFound = false;
    	while ((it.hasNext()) && (notFound)) {
    		Object obj = it.next();
    		if (obj instanceof Commercial) {
    			if ((((Commercial) obj).getNom().equals(nom)) && (((Commercial) obj).getPrenom().equals(prenom))){
    				return (Commercial) obj;
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Méthode permettant de trouver un livreur à partir de son prénom et de son nom.
     * @param prenom - Le prénom du livreur recherché
     * @param nom - Le nom du livreur recherché
     * @return Livreur - Le livreur s'il a été trouvé.
     */
    public Livreur trouveLivreur(String prenom, String nom) {
    	Iterator<Conducteur> it = conducteurs.iterator();
    	boolean notFound = false;
    	while ((it.hasNext()) && (notFound)) {
    		Object obj = it.next();
    		if (obj instanceof Livreur) {
    			if ((((Livreur) obj).getNom().equals(nom)) && (((Livreur) obj).getPrenom().equals(prenom))){
    				return (Livreur) obj;
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Méthode affichant les livreurs de la liste de conducteurs.
     */
    public void afficheLivreurs() {
    	System.out.println("Livreurs : ");
    	for (int i = 0; i < conducteurs.size(); i++) {
    		Object obj = conducteurs.get(i);
    		if (obj instanceof Livreur) {
    			System.out.println("\t * " + obj.toString());
    		}
    	}
    }

    /**
     * Cette méthode affiche les conducteurs dans l'ordre alphabétique.
     * On utilise un ComparateurConducteurs pour faire la comparaison.
     */
    public void afficheConducteursTries() {
    	Collections.sort(conducteurs, new ComparateurConducteurs());
    	Iterator<Conducteur> it = conducteurs.iterator();
    	System.out.println("Conducteurs : ");
    	while (it.hasNext()) {
    		System.out.println("\t * " + it.next().toString());
    	}
    }
    
    /**
     * Crée une liste de conducteurs contenant les conducteurs par défaut.
     * Cette liste de conducteurs sert de démonstration.
     *
     * @return La liste de conducteurs par défaut.
     */
    public static Conducteurs defaultConducteurs() {
    	Livreur l1 = new Livreur("Delerue","Clement","202002","C");
		Livreur l2 = new Livreur("Poteau","Alex","404040","C");
		Livreur l3 = new Livreur("Nizart","Bastien","234023","B");
		Livreur l4 = new Livreur("Lamps","Guillaume","546533","C");
		Livreur l5 = new Livreur("Fontaine","Nathan","123923","C");
		
		Commercial c1 = new Commercial("Sagot","Paul","500550","A");
		Commercial c2 = new Commercial("Bonsigne","Amaury","505980","A");
		Commercial c3 = new Commercial("Broda","Lucas","193204","A");
		Commercial c4 = new Commercial("Sebastien","Patrick","654034","A");
		Commercial c5 = new Commercial("Daï","Ayoub","543023","A");
		
		Conducteurs cond = new Conducteurs();
		cond.ajouteConducteur(l1);
		cond.ajouteConducteur(l2);
		cond.ajouteConducteur(l3);
		cond.ajouteConducteur(l4);
		cond.ajouteConducteur(l5);
		cond.ajouteConducteur(c1);
		cond.ajouteConducteur(c2);
		cond.ajouteConducteur(c3);
		cond.ajouteConducteur(c4);
		cond.ajouteConducteur(c5);
		
		
		Voiture v1 = new Voiture("AA-453-DE","Clio","Renault",49384,2009);
		Voiture v2 = new Voiture("DZ-213-DZ","Polo","Volkswagen",130203,2005);
		Voiture v3 = new Voiture("ER-645-AZ","Fiesta","Ford",143032,2007);
		Voiture v4 = new Voiture("BZ-055-GH","Jazz","Honda",177340,2010);
		Voiture v5 = new Voiture("JE-304-BZ","Zonda","Pagani",52503,2019);
	
		Fourgon f1 = new Fourgon("OR-342-DE","Zippy","Peugeot",205930,2007,3000,10);
		Fourgon f2 = new Fourgon("TR-243-GE","Multipla","Fiat",95640,2008,2500,6);
		Fourgon f3 = new Fourgon("RE-345-AZ","Partner","Citroën",54033,2016,4000,12);
		Fourgon f4 = new Fourgon("GR-102-KE","Iveco","Peugeot",192034,2010,2000,5);
		Fourgon f5 = new Fourgon("LO-504-ER","Kangoo","Renault",45530,2021,3000,9);
		
		FlotteVehicules flotte = new FlotteVehicules();
		flotte.ajouteVehicule(v1);
		flotte.ajouteVehicule(v2);
		flotte.ajouteVehicule(v3);
		flotte.ajouteVehicule(v4);
		flotte.ajouteVehicule(v5);
		flotte.ajouteVehicule(f1);
		flotte.ajouteVehicule(f2);
		flotte.ajouteVehicule(f3);
		flotte.ajouteVehicule(f4);
		flotte.ajouteVehicule(f5);
        return cond;
    }

}
