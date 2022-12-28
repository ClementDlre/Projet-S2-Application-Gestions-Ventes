package fr.univartois.butinfo.ihm.controller;

import java.io.IOException;

import fr.univartois.butinfo.ihm.model.article.Stock;
import fr.univartois.butinfo.ihm.model.client.CarnetClients;
import fr.univartois.butinfo.ihm.model.gestionvehicules.Conducteurs;
import fr.univartois.butinfo.ihm.model.gestionvehicules.FlotteVehicules;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChoixSceneController {
	
	/**
     * La fenêtre de l'application.
     */
    private Stage stage;
    
    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;
	
	public void setStage(Stage stage) {
    	this.stage=stage;
    }
	
	public void setScene(Scene scene) {
		this.scene=scene;
	}
    
    private CarnetClients carnetClients;
    
    public void setCarnetClients(CarnetClients carnetClients) {
    	this.carnetClients=carnetClients;
    }
    
    public void setStock(Stock stock) {
    	this.stock=stock;
    }
    
    public void setFlotte(FlotteVehicules flotte) {
    	this.flotte = flotte;
    }
    
    public void setConducteurs(Conducteurs conducteurs) {
    	this.conducteurs=conducteurs;
    }
    
    private Stock stock;
    
    private FlotteVehicules flotte;
    
    private Conducteurs conducteurs;

    @FXML
    void choixArticle() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/stock-article-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        StockArticlesController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(stock);
    }

    @FXML
    void choixClient() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/carnet-clients-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        CarnetClientsController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(carnetClients);
    }

    @FXML
    void choixConducteur() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/liste-conducteurs-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        ListeConducteursController controller = fxmlLoader.getController();
        Conducteurs conducteurs = Conducteurs.defaultConducteurs();
        FlotteVehicules flotte = FlotteVehicules.defaultFlotte();
        flotte.setConducteurs(conducteurs);
        controller.setFlotte(flotte);
        controller.bind(conducteurs);
        controller.setStage(stage);
        controller.setMainScene(scene);
        
        stage.show();
    }

    @FXML
    void choixFlotte() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/flotte-vehicule-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        FlotteVehiculeController controller = fxmlLoader.getController();
        Conducteurs conducteurs = Conducteurs.defaultConducteurs();
        FlotteVehicules flotte = FlotteVehicules.defaultFlotte();
        conducteurs.setFlotte(flotte);
        controller.setConducteurs(conducteurs);
        controller.bind(flotte);
        controller.setStage(stage);
        controller.setMainScene(scene);
        
        stage.show();
    }
    
    @FXML
    void bastienButton() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/memoire-bastien-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 1000, 700);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        MemoireBastienController controller = fxmlLoader.getController();

        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.initialize();
        
        stage.show();
    }

}
