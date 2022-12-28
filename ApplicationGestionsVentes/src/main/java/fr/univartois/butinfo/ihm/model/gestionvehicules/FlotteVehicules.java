package fr.univartois.butinfo.ihm.model.gestionvehicules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Une instance de la classe FlotteVehicules correspond à une flotte de véhicules.
 * Elle contient une liste de véhicules (ObservableList<Vehicule>) et une liste de conducteurs (Conducteurs)
 * @author Jonatha,
 *
 */
public class FlotteVehicules{
	/**
	 * Une flotte de véhicules
	 */
    private ObservableList<Vehicule> flotte;
    
    /**
     * Une liste de conducteurs
     */
    private Conducteurs conducteurs;
    
    /**
     * Constructeur créant une flotte de véhicules.
     * On initialise la flotte de véhicules
     */
    public FlotteVehicules() {
    	this.flotte = FXCollections.observableList(new ArrayList<>());
    }

    /**
     * Méthode retournant la flotte de véhicules.
     * @return ObservableList<Vehicule> - La flotte de véhicules.
     */
    public ObservableList<Vehicule> getFlotte() {
        return this.flotte;
    }
    
    /**
     * Méthode mettant à jour la liste de conducteurs
     * @param conducteurs - La nouvelle liste de conducteurs.
     */
    public void setConducteurs(Conducteurs conducteurs) {
    	this.conducteurs = conducteurs;
    }

    /**
     * Méthode permettant d'ajouter un véhicule à la flotte de véhicules
     * Si le véhicule est null, rien ne se passe.
     * Si le véhicule est déjà dans la liste, une exception est levée.
     * @param vehicule - Le véhicule à ajouter.
     */
    public void ajouteVehicule(Vehicule vehicule) {
    	if (vehicule != null) {
    		try {
	    		existeDeja(vehicule);
	    	} catch (ElementAlreadyExistsException e) {
	    		System.out.println("Le véhicule n'a pas pu être ajouté.");
	    	}
	    	flotte.add(vehicule);
    	}
    	
    }
    
    /**
     * Méthode permettant de savoir si un véhicule est dans la flotte de véhicules.
     * @param vehicule - Le véhicule qu'on cherche
     * @return true si le véhicule est dans la flotte, false sinon
     * @throws ElementNotInListException - si le véhicule n'est pas dans la flotte
     */
    public boolean existe(Vehicule vehicule) throws ElementNotInListException {
    	if (flotte.contains(vehicule)) {
    		return true;
    	} else {
    		throw new ElementNotInListException("Le véhicule n'est pas dans la liste !");
    	}
    }
    
    /**
     * Méthode permettant de savoir si un véhicule est déjà dans la flotte de véhicules
     * @param vehicule - Le véhicule qu'on cherche
     * @return true si le véhicule existe déjà dans la flotte, false sinon
     * @throws ElementAlreadyExistsException - si le véhicule est déjà dans la liste
     */
    public boolean existeDeja(Vehicule vehicule) throws ElementAlreadyExistsException {
    	if (flotte.contains(vehicule)) {
    		throw new ElementAlreadyExistsException("Le véhicule est déjà dans la liste !");
    	} else {
    		return false;
    	}
    }

    /**
     * Méthode permettant de supprimer un véhicule de la flotte de véhicules.
     * @param vehicule - Le véhicule qu'on souhaite supprimer
     */
    public void supprimeVehicule(Vehicule vehicule) {
    	try {
    		existe(vehicule);
    	} catch (ElementNotInListException e) {
    		System.out.println("Le véhicule n'a pas pu être supprimé");
    	}
    	flotte.remove(vehicule);
    }
    
    /**
     * Méthode affichant les voitures de la flotte de véhicules
     */
    public void afficheVoitures() {
    	Iterator<Vehicule> it = flotte.iterator();
    	System.out.println("Voitures : ");
    	while (it.hasNext()) {
    		Object obj = it.next();
    		if (obj instanceof Voiture) {
    			System.out.println("\t * " + obj.toString());
    		}
    	}
    }

    /**
     * Méthode affichant les fourgons de la flotte de véhicules
     */
    public void afficheFourgons() {
    	System.out.println("Fourgons : ");
    	for (int i = 0; i < flotte.size(); i++) {
    		Object obj = flotte.get(i);
    		if (obj instanceof Fourgon) {
    			System.out.println("\t * " + obj.toString());
    		}
    	}
    }
    
    /**
     * Méthode affichant les véhicules triés par leur année de mise en circulation
     * On utilise un ComparateurVehicules pour comparer les véhicules
     */
    public void afficheVehiculesTries() {
    	Collections.sort(flotte, new ComparateurVehicules());
    	Iterator<Vehicule> it = flotte.iterator();
    	System.out.println("Véhicules : ");
    	while (it.hasNext()) {
    		System.out.println("\t * " + it.next().toString());
    	}
    }
    
    /**
     * Méthode permettant de trouver un voiture via son numéro d'immatriculation
     * @param numImma - le numéro d'immatriculation de la voiture recherchée.
     * @return Voiture - La voiture si elle a été trouvée.
     */
    public Voiture trouveVoiture(String numImma) {
    	Iterator<Vehicule> it = flotte.iterator();
    	boolean notFound = false;
    	while ((it.hasNext()) && (notFound)) {
    		Object obj = it.next();
    		if (obj instanceof Voiture) {
    			if (((Voiture) obj).getNumImma().equals(numImma)){
    				return (Voiture) obj;
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Méthode permettant de trouver un fourgon via son numéro d'immatriculation
     * @param numImma - Le numéro d'immatriculation du fourgon recherché.
     * @return Fourgon - Le fourgon s'il a été trouvé.
     */
    public Fourgon trouveFourgon(String numImma) {
    	Iterator<Vehicule> it = flotte.iterator();
    	boolean notFound = false;
    	while ((it.hasNext()) && (notFound)) {
    		Object obj = it.next();
    		if (obj instanceof Fourgon) {
    			if (((Fourgon) obj).getNumImma().equals(numImma)){
    				return (Fourgon) obj;
    			}
    		}
    	}
    	return null;
    }
    
    /**
     * Crée une liste de véhicules contenant les véhicules par défaut.
     * Cette liste de véhicules sert de démonstration.
     *
     * @return La liste de véhicules par défaut.
     */
    public static FlotteVehicules defaultFlotte() {
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
		v1.assigneCommercial(c1);
		Voiture v2 = new Voiture("DZ-213-DZ","Polo","Volkswagen",130203,2005);
		v2.assigneCommercial(c2);
		Voiture v3 = new Voiture("ER-645-AZ","Fiesta","Ford",143032,2007);
		Voiture v4 = new Voiture("BZ-055-GH","Jazz","Honda",177340,2010);
		Voiture v5 = new Voiture("JE-304-BZ","Zonda","Pagani",52503,2019);
	
		Fourgon f1 = new Fourgon("OR-342-DE","Zippy","Peugeot",205930,2007,3000,10);
		f1.assigneLivreur(l1);
		Fourgon f2 = new Fourgon("TR-243-GE","Multipla","Fiat",95640,2008,2500,6);
		f2.assigneLivreur(l2);
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
        return flotte;
    }

}