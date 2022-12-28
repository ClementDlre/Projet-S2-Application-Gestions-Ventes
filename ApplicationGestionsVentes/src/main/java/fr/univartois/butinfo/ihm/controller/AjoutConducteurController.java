package fr.univartois.butinfo.ihm.controller;


import fr.univartois.butinfo.ihm.model.gestionvehicules.Commercial;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteur;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteurs;
import fr.univartois.butinfo.ihm.model.gestionvehicules.FlotteVehicules;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Fourgon;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Livreur;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Vehicule;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Voiture;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.stage.Stage;

public class AjoutConducteurController {
	
	private ListView<Conducteur> listView;
	
	private Stage stage;
	
	private Scene mainScene;
	
	private FlotteVehicules flotte;
	
	private ObservableList<Conducteur> conducteursList;
	
	private Conducteur conducteur;
	
	private Conducteurs conducteurs;
	

	@FXML
    private RadioButton commercialBox;

    @FXML
    private ColumnConstraints gridLivrable1;

    @FXML
    private RadioButton livreurBox;

    @FXML
    private TextArea nomField;

    @FXML
    private TextField numImmaField;

    @FXML
    private TextArea numPermisField;

    @FXML
    private TextArea prenomField;

    @FXML
    private ToggleGroup typeConducteur;

    @FXML
    private TextArea typePermisField;

    @FXML
    private TextArea visiteHeuresField;

    @FXML
    private Label voitureFourgonLabel;
    
    @FXML
    void changeLabel() {
    	if (commercialBox.isSelected()) {
    		voitureFourgonLabel.setText("Voiture à assigner");
    	} else {
    		voitureFourgonLabel.setText("Fourgon à assigner");
    	}
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
    
    public void bind(Conducteurs conducteurs) {
    	this.conducteurs = conducteurs;
    }
    
    
    
    @FXML
    void initialize() {
    	
    }

    @FXML
    void annuler() {
    	stage.setScene(mainScene);
    }
    
    void modifieConducteur() {
    	nomField.setText(conducteur.getNom());
        prenomField.setText(conducteur.getPrenom());
        numPermisField.setText(conducteur.getNumeroPermis());
        typePermisField.setText(conducteur.getTypePermis());
    	commercialBox.setDisable(true);
    	livreurBox.setDisable(true);
    	if (conducteur instanceof Commercial) {
    		commercialBox.setSelected(true);
    		if (((Commercial) conducteur).getVoiture() != null) {
    			numImmaField.setText(((Commercial) conducteur).getVoiture().getNumImma());
    		}
    	} else {
    		livreurBox.setSelected(true);
    		if (((Livreur) conducteur).getFourgon() != null) {
    			numImmaField.setText(((Livreur) conducteur).getFourgon().getNumImma());
    		}
    		changeLabel();
    	}
    	listView.refresh();
    }

    @FXML
    void valider() {
    	this.conducteursList = conducteurs.getConducteurs();
    	if (conducteur != null) {
    		String nom = nomField.getText();
	    	String prenom = prenomField.getText();
	    	String typePermis = typePermisField.getText();
	    	String numPermis = numPermisField.getText();
	    	if ((visiteHeuresField.getText() != "")) {
	    		int visiteHeures = Integer.parseInt(visiteHeuresField.getText());
		    	if ((nom != "")  && (prenom != "") && (typePermis != "") && (numPermis != "")){
	    			conducteur.setNom(nom);
	    			conducteur.setPrenom(prenom);
	    			conducteur.setTypePermis(typePermis);
	    			conducteur.setNumeroPermis(numPermis);
	    			String numImma = numImmaField.getText();
		    		if (commercialBox.isSelected()) {
		    			((Commercial) conducteur).setNbVisitEffect(visiteHeures);
		    			Voiture voitureChoisie = flotte.trouveVoiture(numImma);
		    			if (voitureChoisie != null) {
		    				((Commercial) conducteur).assigneVoiture(voitureChoisie);
		    			}
		    		} else {
		    			((Livreur) conducteur).setNbHeurCond(visiteHeures);
		    			Fourgon fourgonChoisi = flotte.trouveFourgon(numImma);
		    			if (fourgonChoisi != null) {
		    				((Livreur) conducteur).assigneFourgon(fourgonChoisi);
		    			}
		        	}
		    	}
	    	}
	    	
    	} else {
    		String nom = nomField.getText();
	    	String prenom = prenomField.getText();
	    	String typePermis = typePermisField.getText();
	    	String numPermis = numPermisField.getText();
			String numImma = numImmaField.getText();
	    	if (visiteHeuresField.getText() != "") {
	    		int visiteHeures = Integer.parseInt(visiteHeuresField.getText());
		    	if ((nom != "")  && (prenom != "") && (typePermis != "") && (numPermis != "")){
		    		if ((commercialBox.isSelected())) {
		    			Commercial commercial = new Commercial(nom, prenom, numPermis, typePermis);
		    			commercial.setNbVisitEffect(visiteHeures);
		    			Voiture voitureChoisie = flotte.trouveVoiture(numImma);
		    			if (voitureChoisie != null) {
		    				commercial.assigneVoiture(voitureChoisie);
		    			}
		    			conducteursList.add(commercial);
		    		} else {
		    			Livreur livreur = new Livreur(nom, prenom, numPermis, typePermis);
		    			livreur.setNbHeurCond(visiteHeures);
		    			Fourgon fourgonChoisi = flotte.trouveFourgon(numImma);
		    			if (fourgonChoisi != null) {
		    				livreur.assigneFourgon(fourgonChoisi);
		    			}
		    			conducteursList.add(livreur);
		        	}
		    	}
	    	}
    	}
    	stage.setScene(mainScene);
    }

	public void setListView(ListView<Conducteur> listView) {
		this.listView = listView;
		
	}
	
	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}
	
	public void setFlotte(FlotteVehicules flotte) {
		this.flotte = flotte;
	}

}
