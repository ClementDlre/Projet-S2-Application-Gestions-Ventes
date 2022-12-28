package fr.univartois.butinfo.ihm.controller;

import java.util.ArrayList;

import fr.univartois.butinfo.ihm.model.client.CarnetClients;
import fr.univartois.butinfo.ihm.model.client.Client;
import fr.univartois.butinfo.ihm.model.client.ClientEntreprise;
import fr.univartois.butinfo.ihm.model.client.ClientParticulier;
import fr.univartois.butinfo.ihm.model.client.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutClientController {
	
	private ListView<Client> listView;
	
	private Stage stage;
	
	private Scene mainScene;
	
	private CarnetClients carnetClients;
	
	private ObservableList<Client> clients;
	
	private Client client;
	
	private int reference;

    @FXML
    private TextArea adresseField;
    
    @FXML
    private TextField contactField;
    
    @FXML
    private RadioButton entrepriseBox;
    
    @FXML
    private Label genreContactLabel;

    @FXML
    private ComboBox<Genre> genreBox;

    @FXML
    private TextArea nomField;

    @FXML
    private TextArea prenomField;


    @FXML
    private TextArea fideliteField;
    
    @FXML
    private RadioButton particulierBox;
    
    @FXML
    void changeLabel() {
    	if (entrepriseBox.isSelected()) {
    		genreContactLabel.setText("Contact");
    	} else {
    		genreContactLabel.setText("Genre");
    	}
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
    
    public void bind(CarnetClients carnetClients) {
    	this.carnetClients = carnetClients;
    }
    
    @FXML
    void initialize() {
    	genreBox.setItems(FXCollections.observableArrayList(Genre.values()));
    	
    	contactField.disableProperty().bind(particulierBox.selectedProperty());
    	genreBox.disableProperty().bind(entrepriseBox.selectedProperty());
    	prenomField.disableProperty().bind(entrepriseBox.selectedProperty());

    	
    }

    @FXML
    void annuler() {
    	stage.setScene(mainScene);
    }
    
    void modifieClient() {
    	nomField.setText(client.getNom());
    	adresseField.setText(client.getAdresse());
    	fideliteField.setText(Integer.toString(client.getPointsFidelite()));
    	particulierBox.setDisable(true);
    	entrepriseBox.setDisable(true);
    	if (client instanceof ClientParticulier) {
    		particulierBox.setSelected(true);
    		prenomField.setText(((ClientParticulier) client).getPrenom());
    		genreBox.getSelectionModel().select(((ClientParticulier) client).getGenre());
    	} else {
    		entrepriseBox.setSelected(true);
    		contactField.setText(((ClientEntreprise)client).getContact());
    		changeLabel();
    	}
    	listView.refresh();
    }

    @FXML
    void valider() {
    	clients = carnetClients.getClients();
    	if (client != null) {
    		String nom = nomField.getText();
	    	String prenom = prenomField.getText();
	    	String adresse = adresseField.getText();
	    	int pointsFidelite = Integer.parseInt(fideliteField.getText());
	    	if ((nom != "")  && (adresse != "") && (fideliteField.getText() != "")){
    			client.setNom(nom);
    			client.setAdresse(adresse);
    			client.setPointsFidelite(pointsFidelite);
	    		if ((genreBox.getValue() != null) && (prenom == "")) {
	    			((ClientParticulier)client).setPrenom(prenom);
	    			((ClientParticulier)client).setGenre(genreBox.getValue());
	    		} else if (contactField.getText() != "") {
	    			String contact = contactField.getText();
	    			((ClientEntreprise)client).setContact(contact);
	        	}
	    	}
    	} else {
	    	String nom = nomField.getText();
	    	String prenom = prenomField.getText();
	    	String adresse = adresseField.getText();
	    	int pointsFidelite = Integer.parseInt(fideliteField.getText());
	    	if ((nom != "") && (prenom != "") && (adresse != "") && (fideliteField.getText() != "")){
	    		if (particulierBox.isSelected() && (genreBox.getValue() != null)) {
	    			clients.add(new ClientParticulier(nom,adresse,pointsFidelite,prenom,genreBox.getValue()));
	    		} else if (contactField.getText() != "") {
	        		String contact = contactField.getText();
	            	clients.add(new ClientEntreprise(nom,adresse,pointsFidelite,contact));
	        	}
	    	}
    	}
    	stage.setScene(mainScene);
    }

	public void setListView(ListView<Client> listView) {
		this.listView = listView;
		
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

}
