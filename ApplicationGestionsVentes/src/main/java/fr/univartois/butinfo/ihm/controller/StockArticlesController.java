package fr.univartois.butinfo.ihm.controller;

import java.io.IOException;

import fr.univartois.butinfo.ihm.model.article.Article;
import fr.univartois.butinfo.ihm.model.article.ArticleCat1;
import fr.univartois.butinfo.ihm.model.article.ArticleCat2;
import fr.univartois.butinfo.ihm.model.article.Stock;
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

public class StockArticlesController {
	
	/**
     * La fenêtre de l'application.
     */
    private Stage stage;
    
    private Scene mainScene;
    
    /**
     * La scène où la vue gérée par ce contrôleur est affichée.
     */
    private Scene scene;
    
    @FXML
    private Label aciditeColisLabel;
    
    @FXML
    private TextArea aciditeColisField;

    @FXML
    private ListView<Article> articleList;

    @FXML
    private TextArea categorieField;

    @FXML
    private TextArea designationField;


    @FXML
    private TextArea goutField;


    @FXML
    private TextArea prixField;

    @FXML
    private TextArea quantiteField;

    @FXML
    private TextArea referenceField;

    @FXML
    private TextArea sucreField;
    
    /**
     * Le stock affiché par l'application.
     */
    private Stock stock;
    
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
    
    public ListView<Article> getListView(){
    	return articleList;
    }
    
    /**
     * Associe le stock affiché par l'application à ce contrôleur.
     *
     * @param stock Le stock affiché par l'application.
     */
    public void bind(Stock stock) {
        this.stock = stock;

        // On lie la ListView au stock d'articles.
        // On ajoute pas simplement les articles ici.
        // En fait, tout changement dans la liste est répercuté sur la vue.
        articleList.setItems(stock.getArticles());
        articleList.setCellFactory(list -> {
        	return new ListCell<>() {
        		@Override
        		public void updateItem(Article article, boolean empty) {
        			super.updateItem(article, empty);
        			if (empty || (article == null)) {
        				setText(null);
        			} else {
        				setText(article.getDesignation());
        			}
        		}
        	 };
        });

        // On associe ensuite à la sélection d'un article son affichage détaillé.
        articleList.getSelectionModel().selectedItemProperty().addListener((o, p, n) -> {
            referenceField.setText(Integer.toString(n.getReference()));
        	categorieField.setText(n.getCategorie());
            designationField.setText(n.getDesignation());
            prixField.setText(Double.toString(n.getPrix()));
            quantiteField.setText(Integer.toString(n.getQuantiteStock()));
            if (n instanceof ArticleCat1 articleCat1) {
            	goutField.setText(((ArticleCat1)n).getGout().toString());
            	sucreField.setText(Double.toString(((ArticleCat1)n).getTeneurEnSucre()));
            	aciditeColisField.setText(Double.toString(((ArticleCat1)n).getAcidite()));
            	aciditeColisLabel.setText("Acidité");
            } else {
            	goutField.setText(((ArticleCat2)n).getGout().toString());
            	sucreField.setText(Double.toString(((ArticleCat2)n).getTeneurEnSucre()));
            	aciditeColisField.setText("Hauteur colis : "+(((ArticleCat2)n).getHauteurColis()) + "\nLargeur colis : "+(((ArticleCat2)n).getLargeurColis()) + "\nProfondeur colis : "+(((ArticleCat2)n).getProfondeurColis())+"\nPoids colis : "+(((ArticleCat2)n).getPoidsKgColis()));
            	aciditeColisLabel.setText("Détails colis");
            }
        });
    }
    
    /**
     * Ouvre une nouvelle vue permettant d'ajouter un article à la liste.
     */
    @FXML
    void ajouteArticle() throws IOException {
        // Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-article-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addGestionScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addGestionScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutArticleController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(stock);
        controller.setListView(getListView());
    }

    @FXML
    void modifieArticle() throws IOException{
    	// Il faut d'abord récupérer la description de la nouvelle vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ajout-article-view.fxml"));
        Parent viewContent = fxmlLoader.load();
        Article articleAModifier = articleList.getSelectionModel().getSelectedItem();

        // Ensuite, on la place dans une nouvelle Scene...
        Scene addArticleScene = new Scene(viewContent, 800, 600);
        // que l'on place elle-même dans la fenêtre pour remplacer la scène courante.
        stage.setScene(addArticleScene);

        // On lie le modèle au nouveau contrôleur.
        AjoutArticleController controller = fxmlLoader.getController();
        controller.setStage(stage);
        controller.setMainScene(scene);
        controller.bind(stock);
        controller.setArticle(articleAModifier);
        controller.setListView(getListView());
        controller.modifieArticle();
        articleList.refresh();
    }

    @FXML
    void supprimeArticle() {
    	stock.supprimerArticle(articleList.getSelectionModel().getSelectedItem());
    }

	public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
	
	@FXML
    void retourButton() {
    	stage.setScene(mainScene);
    }

}
