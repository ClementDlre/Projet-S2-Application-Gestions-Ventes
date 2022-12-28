package fr.univartois.butinfo.ihm.controller;

import java.io.IOException;

import fr.univartois.butinfo.ihm.model.gestionvehicules.Commercial;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteur;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteurs;
import fr.univartois.butinfo.ihm.model.gestionvehicules.FlotteVehicules;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Fourgon;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Livreur;
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

public class ListeConducteursController {
	
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
    private TextArea categorieField;

    @FXML
    private ListView<Conducteur> conducteurList;

    @FXML
    private TextArea nomField;

    @FXML
    private TextArea numeroPermisField;

    @FXML
    private TextArea prenomField;

    @FXML
    private TextArea typePermisField;

    @FXML
    private TextArea visiteHeuresField;

    @FXML
    private Label visiteHeuresLabel;

    @FXML
    private TextArea voitureFourgonField;

    @FXML
    private Label voitureFourgonLabel;
    
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
    
    public ListView<Conducteur> getListView(){
    	return conducteurList;
    }
    
    public void setFlotte(FlotteVehicules flotte) {
    	this.flotte = flotte;
    }
    
    
    
    /**
     * Associe la liste de conducteurs affiché par l'application à ce contrôleur.
     *
     * @param conducteurs La liste de conducteurs affichés par l'application.
     */
    public void bind(Conducteurs conducteurs) {
        this.conducteurs = conducteurs;

        // On lie la ListView à la liste des conducteurs.
        // On ajoute pas simplement les conducteurs ici.
        // En fait, tout changement dans la liste est répercuté sur la vue.
        conducteurList.setItems(conducteurs.getConducteurs());
        conducteurList.setCellFactory(list -> {
        	return new ListCell<>() {
        		@Override
        		public void updateItem(Conducteur conducteur, boolean empty) {
        			super.updateItem(conducteur, empty);
        			if (empty || (conducteur == null)) {
        				setText(null);
        			} else {
        				setText(conducteur.getPrenom() + " " + conducteur.getNom());
        			}
        		}
        	 };
        });

        // On associe ensuite à la sélection d'un article son affichage détaillé.
        conducteurList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
        	nomField.setText(n.getNom());
            prenomField.setText(n.getPrenom());
            numeroPermisField.setText(n.getNumeroPermis());
            typePermisField.setText(n.getTypePermis());
            if (n instanceof Commercial commercial) {
            	categorieField.setText(((Commercial)n).getCategorie());
            	visiteHeuresField.setText(Integer.toString(((Commercial)n).getNbVisitEffect()));
            	visiteHeuresLabel.setText("Nombres de visites effectuées");
            	if (((Commercial)n).getVoiture() != null) {
            		Voiture voiture = ((Commercial)n).getVoiture();
            		voitureFourgonField.setText(voiture.getNumImma() + " " + voiture.getMarque() + " " + voiture.getModele());
            	} else {
            		voitureFourgonField.setText("Aucune voiture assignée");
            	}
        		voitureFourgonLabel.setText("Voiture assignée");
            } else {
            	categorieField.setText(((Livreur)n).getCategorie());
            	visiteHeuresField.setText(Integer.toString(((Livreur)n).getNbHeurCond()));
            	visiteHeuresLabel.setText("Nombres d'heures de conduite");
            	if (((Livreur)n).getFourgon() != null) {
            		Fourgon fourgon = ((Livreur)n).getFourgon();
            		voitureFourgonField.setText(fourgon.getNumImma() + " " + fourgon.getMarque() + " " + fourgon.getModele());
            	} else {
            		voitureFourgonField.setText("Aucune voiture assignée");
            	}
        		voitureFourgonLabel.setText("Fourgon assigné");

            	
            }
        });
    }
    
    /**
     * Ouvre une nouvelle vue permettant d'ajouter un véhicule à la liste.
     */
    @FXML
    void ajouteConducteur() throws IOException {
        // Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-conducteur-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutConducteurController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.setFlotte(flotte);
        controller.bind(conducteurs);
        controller.setListView(getListView());
    }

    @FXML
    void modifieConducteur() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-conducteur-view.fxml"));
        Parent viewContent = fxmlLoader.load();
        Conducteur conducteurAModifier = conducteurList.getSelectionModel().getSelectedItem();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutConducteurController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.setFlotte(flotte);
        controller.bind(conducteurs);
        controller.setConducteur(conducteurAModifier);
        controller.setListView(getListView());
        controller.modifieConducteur();
        conducteurList.refresh();
    }

    @FXML
    void supprimeConducteur() {
    	conducteurs.supprimeConducteur(conducteurList.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    void retourButton() {
    	stage.setScene(mainScene);
    }

}
