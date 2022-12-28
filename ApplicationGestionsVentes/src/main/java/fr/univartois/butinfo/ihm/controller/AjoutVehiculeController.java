package fr.univartois.butinfo.ihm.controller;


import fr.univartois.butinfo.ihm.model.gestionvehicules.Commercial;
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

public class AjoutVehiculeController {
	
	private ListView<Vehicule> listView;
	
	private Stage stage;
	
	private Scene mainScene;
	
	private FlotteVehicules flotte;
	
	private ObservableList<Vehicule> vehicules;
	
	private Vehicule vehicule;
	
	private Conducteurs conducteurs;
	

	@FXML
    private TextArea anCircuField;

    @FXML
    private RadioButton fourgonBox;

    @FXML
    private ColumnConstraints gridLivrable;

    @FXML
    private ColumnConstraints gridLivrable1;

    @FXML
    private TextArea immaField;

    @FXML
    private TextArea kilometrageField;

    @FXML
    private Label livreurCommercialLabel;

    @FXML
    private TextArea marqueField;

    @FXML
    private TextArea modeleField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField poidsField;

    @FXML
    private TextField prenomField;

    @FXML
    private ToggleGroup typeVehicule;

    @FXML
    private RadioButton voitureBox;

    @FXML
    private TextField volumeField;
    
    @FXML
    void changeLabel() {
    	if (fourgonBox.isSelected()) {
    		livreurCommercialLabel.setText("Livreur");
    	} else {
    		livreurCommercialLabel.setText("Commercial");
    	}
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
    
    public void bind(FlotteVehicules flotte) {
    	this.flotte = flotte;
    }
    
    
    
    @FXML
    void initialize() {
    	poidsField.disableProperty().bind(voitureBox.selectedProperty());
    	volumeField.disableProperty().bind(voitureBox.selectedProperty());
    }

    @FXML
    void annuler() {
    	stage.setScene(mainScene);
    }
    
    void modifieVehicule() {
    	immaField.setText(vehicule.getNumImma());
    	kilometrageField.setText(Double.toString(vehicule.getKilometrage()));
    	marqueField.setText(vehicule.getMarque());
    	modeleField.setText(vehicule.getModele());
    	anCircuField.setText(Integer.toString(vehicule.getAnCircu()));
    	voitureBox.setDisable(true);
    	fourgonBox.setDisable(true);
    	if (vehicule instanceof Voiture) {
    		voitureBox.setSelected(true);
    		if (((Voiture) vehicule).getCommercial() != null) {
    			prenomField.setText(((Voiture) vehicule).getCommercial().getPrenom());
    			nomField.setText(((Voiture) vehicule).getCommercial().getNom());
    		}
    	} else {
    		fourgonBox.setSelected(true);
    		if (((Fourgon) vehicule).getLivreur() != null) {
    			prenomField.setText(((Fourgon) vehicule).getLivreur().getPrenom());
    			nomField.setText(((Fourgon) vehicule).getLivreur().getNom());
    		}
    		changeLabel();
    	}
    	listView.refresh();
    }

    @FXML
    void valider() {
    	this.vehicules = flotte.getFlotte();
    	if (vehicule != null) {
    		String numImma = immaField.getText();
	    	String marque = marqueField.getText();
	    	String modele = modeleField.getText();
	    	String prenom = prenomField.getText();
	    	String nom = nomField.getText();
	    	if ((anCircuField.getText() != "") && (kilometrageField.getText() != "")) {
	    		int anCircu = Integer.parseInt(anCircuField.getText());
		    	double kilometrage = Double.parseDouble(kilometrageField.getText());
		    	if ((numImma != "")  && (marque != "") && (modele != "")){
	    			vehicule.setNumImma(numImma);
	    			vehicule.setMarque(marque);
	    			vehicule.setModel(modele);
	    			vehicule.setAnCircu(anCircu);
	    			vehicule.setKilometrage(kilometrage);
		    		if ((voitureBox.isSelected())) {
		    			Commercial commercialChoisi = conducteurs.trouveCommercial(prenom,nom);
		    			if (commercialChoisi != null) {
		    				((Voiture) vehicule).assigneCommercial(commercialChoisi);
		    			}
		    		} else if ((poidsField.getText() != "") && (volumeField.getText() != "")){
		    			double poids = Double.parseDouble(poidsField.getText());
		    			double volume = Double.parseDouble(volumeField.getText());
		    			((Fourgon) vehicule).setPoids(poids);
		    			((Fourgon) vehicule).setVolume(volume);
		    			Livreur livreurChoisi = conducteurs.trouveLivreur(prenom,nom);
		    			if (livreurChoisi != null) {
		    				((Fourgon) vehicule).assigneLivreur(livreurChoisi);
		    			}
		        	}
		    	}
	    	}
	    	
    	} else {
    		String numImma = immaField.getText();
	    	String marque = marqueField.getText();
	    	String modele = modeleField.getText();
	    	String prenom = prenomField.getText();
	    	String nom = nomField.getText();
	    	if ((anCircuField.getText() != "") && (kilometrageField.getText() != "")) {
	    		int anCircu = Integer.parseInt(anCircuField.getText());
		    	double kilometrage = Double.parseDouble(kilometrageField.getText());
		    	if ((numImma != "")  && (marque != "") && (modele != "")){
		    		if ((voitureBox.isSelected())) {
		    			Voiture voiture = new Voiture(numImma, modele, marque, kilometrage, anCircu);
		    			Commercial commercialChoisi = conducteurs.trouveCommercial(prenom,nom);
		    			if (commercialChoisi != null) {
		    				voiture.assigneCommercial(commercialChoisi);
		    			}
		    			vehicules.add(voiture);
		    		} else if ((poidsField.getText() != "") && (volumeField.getText() != "")){
		    			double poids = Double.parseDouble(poidsField.getText());
		    			double volume = Double.parseDouble(volumeField.getText());
		    			Fourgon fourgon = new Fourgon(numImma, modele, marque, kilometrage, anCircu, poids, volume);
		    			Livreur livreurChoisi = conducteurs.trouveLivreur(prenom,nom);
		    			if (livreurChoisi != null) {
		    				((Fourgon) vehicule).assigneLivreur(livreurChoisi);
		    			}
		    			vehicules.add(fourgon);
		        	}
		    	}
	    	}
    	}
    	stage.setScene(mainScene);
    }

	public void setListView(ListView<Vehicule> listView) {
		this.listView = listView;
		
	}
	
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	public void setConducteurs(Conducteurs conducteurs) {
		this.conducteurs = conducteurs;
	}

}
