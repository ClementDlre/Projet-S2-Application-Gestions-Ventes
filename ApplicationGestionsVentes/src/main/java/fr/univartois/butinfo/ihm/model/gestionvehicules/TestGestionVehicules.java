package fr.univartois.butinfo.ihm.model.gestionvehicules;

/**
 * Cette classe permet de vérifier le bon fonctionnement du paquetage gestionVehicules.
 * @author Moi
 *
 */
public class TestGestionVehicules {
	public static void main(String[] args) {
		
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
		
		cond.afficheCommerciaux();
		cond.afficheLivreurs();
		cond.afficheConducteursTries();
		
		flotte.afficheVoitures();
		flotte.afficheFourgons();
		flotte.afficheVehiculesTries();
		
		
	}
}
;
