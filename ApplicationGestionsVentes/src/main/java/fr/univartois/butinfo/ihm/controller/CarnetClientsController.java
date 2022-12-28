package fr.univartois.butinfo.ihm.controller;

import java.io.IOException;

import fr.univartois.butinfo.ihm.model.client.CarnetClients;
import fr.univartois.butinfo.ihm.model.client.Client;
import fr.univartois.butinfo.ihm.model.client.ClientEntreprise;
import fr.univartois.butinfo.ihm.model.client.ClientParticulier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CarnetClientsController {
	
	/**
     * La fenêtre de l'application.
     */
    private Stage stage;
    
    private Scene mainScene;
    
    @FXML
    private Label nomLabel;
    
    @FXML
    private TextArea genreContactField;

    @FXML
    private Label genreContactLabel;

    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;

    @FXML
    private TextArea adresseField;

    @FXML
    private TextArea fideliteField;

    @FXML
    private ListView<Client> clientList;

    @FXML
    private TextArea nomField;

    @FXML
    private TextArea referenceField;

    @FXML
    private TextArea typeField;
    
    /**
     * Le carnet de clients affiché par l'application.
     */
    private CarnetClients carnetClients;
    
    /**
     * Stocke la fenêtre de l'application.
     *
     * @param stage La fenêtre de l'application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }

    /**
     * Stocke la scène de l'application.
     *
     * @param scene La scène de l'application.
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public ListView<Client> getListView(){
    	return clientList;
    }
    
    /**
     * Associe le carnet de clients affiché par l'application à ce contrôleur.
     *
     * @param carnetClients Le carnet de clients affiché par l'application.
     */
    public void bind(CarnetClients carnetClients) {
        this.carnetClients = carnetClients;

        // On lie la ListView à la liste des clients.
        // On ajoute pas simplement les clients ici.
        // En fait, tout changement dans la liste est répercuté sur la vue.
        clientList.setItems(carnetClients.getClients());
        clientList.setCellFactory(list -> {
        	return new ListCell<>() {
        		@Override
        		public void updateItem(Client client, boolean empty) {
        			super.updateItem(client, empty);
        			if (empty || (client == null)) {
        				setText(null);
        			} else {
        				setText(client.getNom());
        			}
        		}
        	 };
        });

        // On associe ensuite à la sélection d'un client son affichage détaillé.
        clientList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
            referenceField.setText(Integer.toString(n.getReference()));
        	nomField.setText(n.getNom());
            adresseField.setText(n.getAdresse());
            fideliteField.setText(Integer.toString(n.getPointsFidelite()));
            if (n instanceof ClientParticulier clientParticulier) {
            	typeField.setText("Particulier");
            	nomLabel.setText("Nom complet");
            	nomField.setText(((ClientParticulier)n).getPrenom() + " " + nomField.getText());
            	genreContactField.setText(((ClientParticulier)n).getGenre().toString());
            	genreContactLabel.setText("Genre");
            } else {
            	nomLabel.setText("Nom");
            	typeField.setText("Entreprise");
            	genreContactLabel.setText("Contact");
            	genreContactField.setText(((ClientEntreprise)n).getContact());
            }
        });
    }
    
    /**
     * Ouvre une nouvelle vue permettant d'ajouter un client à la liste.
     */
    @FXML
    void ajouteClient() throws IOException {
        // Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-client-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutClientController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(carnetClients);
        controller.setListView(getListView());
    }

    @FXML
    void modifieClient() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-client-view.fxml"));
        Parent viewContent = fxmlLoader.load();
        Client clientAModifier = clientList.getSelectionModel().getSelectedItem();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addClientScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addClientScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutClientController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(carnetClients);
        controller.setClient(clientAModifier);
        controller.setListView(getListView());
        controller.modifieClient();
        
    }

    @FXML
    void supprimeClient() {
    	carnetClients.supprimerClient(clientList.getSelectionModel().getSelectedItem());
    }
    
    @FXML
    void retourButton() {
    	stage.setScene(mainScene);
    }


}
