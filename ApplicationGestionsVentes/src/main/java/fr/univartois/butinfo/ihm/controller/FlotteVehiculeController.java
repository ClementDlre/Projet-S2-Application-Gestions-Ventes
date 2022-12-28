package fr.univartois.butinfo.ihm.controller;

import java.io.IOException;


import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteurs;
import fr.univartois.butinfo.ihm.model.gestionvehicules.FlotteVehicules;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Fourgon;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Vehicule;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Voiture;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FlotteVehiculeController {
	
	/**
     * La fenêtre de l'application.
     */
    private Stage stage;
    
    private Scene mainScene;
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
    
    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;
    
    @FXML
    private TextArea anCircuField;

    @FXML
    private TextField categorieField;

    @FXML
    private TextArea immaField;

    @FXML
    private TextArea kilometrageField;

    @FXML
    private TextArea livreurCommercialField;

    @FXML
    private Label livreurCommercialLabel;

    @FXML
    private TextArea marqueField;

    @FXML
    private TextArea modeleField;

    @FXML
    private Label nomLabel;

    @FXML
    private TextField poidsField;

    @FXML
    private ListView<Vehicule> vehiculeList;

    @FXML
    private TextField volumeField;
    
    /**
     * La flotte de véhicules affiché par l'application.
     */
    private FlotteVehicules flotte;
    
    private Conducteurs conducteurs;
    
    /**
     * Stocke la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Stocke la scène de l'application.
     *
     * @param scene La scène de l'application.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public ListView<Vehicule> getListView(){
    	return vehiculeList;
    }
    
    public void setConducteurs(Conducteurs conducteurs) {
    	this.conducteurs = conducteurs;
    }
    
    
    
    /**
     * Associe la flotte de véhicules affiché par l'application à ce contrôleur.
     *
     * @param flotte La flotte de véhicules affiché par l'application.
     */
    public void bind(FlotteVehicules flotte) {
        this.flotte = flotte;

        // On lie la ListView à la liste des véhicules.
        // On ajoute pas simplement les véhicules ici.
        // En fait, tout changement dans la liste est répercuté sur la vue.
        vehiculeList.setItems(flotte.getFlotte());
        vehiculeList.setCellFactory(list -> {
        	return new ListCell<>() {
        		@Override
        		public void updateItem(Vehicule vehicule, boolean empty) {
        			super.updateItem(vehicule, empty);
        			if (empty || (vehicule == null)) {
        				setText(null);
        			} else {
        				setText(vehicule.getNumImma());
        			}
        		}
        	 };
        });

        // On associe ensuite à la sélection d'un article son affichage détaillé.
        vehiculeList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
        	immaField.setText(n.getNumImma());
            marqueField.setText(n.getMarque());
            modeleField.setText(n.getModele());
            anCircuField.setText(Integer.toString(n.getAnCircu()));
            kilometrageField.setText(Double.toString(n.getKilometrage()));
            if (n instanceof Fourgon fourgon) {
            	categorieField.setText(((Fourgon)n).getCategorie());
            	poidsField.setText(Double.toString(((Fourgon)n).getPoidsMax()));
            	volumeField.setText(Double.toString(((Fourgon)n).getVolumeMax()));
            	if (((Fourgon)n).getLivreur() != null) {
            		livreurCommercialField.setText(((Fourgon)n).getLivreur().getPrenom() + " " + ((Fourgon)n).getLivreur().getNom());
            	} else {
            		livreurCommercialField.setText("Aucun livreur assigné");
            	}
            	livreurCommercialLabel.setText("Livreur assigné");
            } else {
            	categorieField.setText(((Voiture)n).getCategorie());
            	poidsField.setText("");
            	volumeField.setText("");
            	poidsField.setDisable(true);
            	volumeField.setDisable(true);
            	if (((Voiture)n).getCommercial() != null) {
            		livreurCommercialField.setText((((Voiture)n).getCommercial().getPrenom()) + " " + (((Voiture)n).getCommercial().getNom()));
            	} else {
            		livreurCommercialField.setText("Aucun commercial assigné");
            	}
            	livreurCommercialLabel.setText("Commercial assigné");
            	
            }
        });
    }
    
    /**
     * Ouvre une nouvelle vue permettant d'ajouter un véhicule à la liste.
     */
    @FXML
    void ajouteVehicule() throws IOException {
        // Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-vehicule-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addVehiculeScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addVehiculeScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutVehiculeController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.setConducteurs(conducteurs);
        controller.bind(flotte);
        controller.setListView(getListView());
    }

    @FXML
    void modifieVehicule() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-vehicule-view.fxml"));
        Parent viewContent = fxmlLoader.load();
        Vehicule vehiculeAModifier = vehiculeList.getSelectionModel().getSelectedItem();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addVehiculeScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addVehiculeScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutVehiculeController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.setConducteurs(conducteurs);
        controller.bind(flotte);
        controller.setVehicule(vehiculeAModifier);
        controller.setListView(getListView());
        controller.modifieVehicule();
        vehiculeList.refresh();
    }

    @FXML
    void supprimeVehicule() {
    	flotte.supprimeVehicule(vehiculeList.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    void retourButton() {
    	stage.setScene(mainScene);
    }

}
