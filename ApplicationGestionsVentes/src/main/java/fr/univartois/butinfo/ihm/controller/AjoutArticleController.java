package fr.univartois.butinfo.ihm.controller;

import java.util.ArrayList;

import fr.univartois.butinfo.ihm.model.article.Article;
import fr.univartois.butinfo.ihm.model.article.ArticleCat1;
import fr.univartois.butinfo.ihm.model.article.ArticleCat2;
import fr.univartois.butinfo.ihm.model.article.Gout;
import fr.univartois.butinfo.ihm.model.article.Stock;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.stage.Stage;

public class AjoutArticleController {
	
	private ListView<Article> listView;
	
	private Stage stage;
	
	private Scene mainScene;
	
	private Stock stock;
	
	private ObservableList<Article> articles;
	
	private Article article;
	
	private int reference;

	 @FXML
	    private Label aciditeDetailsLabel;

	    @FXML
	    private TextArea aciditeField;

	    @FXML
	    private RadioButton aciduleBox;

	    @FXML
	    private TextArea designationField;

	    @FXML
	    private Label genreContactLabel;

	    @FXML
	    private ComboBox<Gout> goutBox;

	    @FXML
	    private ColumnConstraints gridLivrable;

	    @FXML
	    private TextField hauteurField;

	    @FXML
	    private TextField largeurField;

	    @FXML
	    private RadioButton nonAciduleBox;

	    @FXML
	    private TextField poidsField;

	    @FXML
	    private TextArea prixField;

	    @FXML
	    private TextField profondeurField;

	    @FXML
	    private TextArea quantiteField;
	    
	    @FXML
	    private TextArea teneurField;

	    @FXML
	    private ToggleGroup typeArticle;
    
    @FXML
    void changeLabel() {
    	if (nonAciduleBox.isSelected()) {
    		aciditeDetailsLabel.setText("Détails du colis");
    	} else {
    		aciditeDetailsLabel.setText("Acidité");
    	}
    }
    
    public void setStage(Stage stage) {
    	this.stage=stage;
    }
    
    public void setMainScene(Scene mainScene) {
    	this.mainScene = mainScene;
    }
    
    public void bind(Stock stock) {
    	this.stock = stock;
    }
    
    @FXML
    void initialize() {
    	goutBox.setItems(FXCollections.observableArrayList(Gout.values()));
    	
    	hauteurField.disableProperty().bind(aciduleBox.selectedProperty());
    	largeurField.disableProperty().bind(aciduleBox.selectedProperty());
    	profondeurField.disableProperty().bind(aciduleBox.selectedProperty());
    	poidsField.disableProperty().bind(aciduleBox.selectedProperty());
    	aciditeField.disableProperty().bind(nonAciduleBox.selectedProperty());

    	
    }

    @FXML
    void annuler() {
    	stage.setScene(mainScene);
    }
    
    void modifieArticle() {
    	designationField.setText(article.getDesignation());
    	prixField.setText(Double.toString(article.getPrix()));
    	quantiteField.setText(Integer.toString(article.getQuantiteStock()));
    	aciduleBox.setDisable(true);
    	nonAciduleBox.setDisable(true);
    	if (article instanceof ArticleCat1) {
    		aciduleBox.setSelected(true);
    		aciditeField.setText(Double.toString(((ArticleCat1) article).getAcidite()));
    		goutBox.getSelectionModel().select(((ArticleCat1)article).getGout());
        	teneurField.setText(Double.toString(((ArticleCat1)article).getTeneurEnSucre()));

    		} else {
    		nonAciduleBox.setSelected(true);
    		profondeurField.setText(Integer.toString(((ArticleCat2)article).getProfondeurColis()));
    		largeurField.setText(Integer.toString(((ArticleCat2)article).getLargeurColis()));
    		hauteurField.setText(Integer.toString(((ArticleCat2)article).getHauteurColis()));
    		poidsField.setText(Double.toString(((ArticleCat2)article).getPoidsKgColis()));
    		goutBox.getSelectionModel().select(((ArticleCat2)article).getGout());
        	teneurField.setText(Double.toString(((ArticleCat2)article).getTeneurEnSucre()));
    		changeLabel();
    	}
    	listView.refresh();
    }

    @FXML
    void valider() {
    	articles = stock.getArticles();
    	if ((article != null) && (designationField.getText() != "") && (prixField.getText() != "") && (quantiteField.getText() != "") && (teneurField.getText() != "")) {
    		String designation = designationField.getText();
	    	Double prix = Double.parseDouble(prixField.getText());
	    	int quantite = Integer.parseInt(quantiteField.getText());
	    	double teneur = Double.parseDouble(teneurField.getText());
	    	if ((designation != "")  && (!(prix == 0)) && (!(quantite == 0))){
    			article.setDesignation(designation);
    			article.setPrix(prix);
    			article.setQuantiteStock(quantite);
	    		if (aciditeField.getText() != "") {
			    	int acidite = Integer.parseInt(aciditeField.getText());

	    			((ArticleCat1)article).setGout(goutBox.getValue());
	    			((ArticleCat1)article).setAcidite(acidite);
	            	((ArticleCat1)article).setTeneurEnSucre(teneur);

	    		} else if ((largeurField.getText() != "") && (hauteurField.getText() != "") && (profondeurField.getText() != "") && (poidsField.getText() != "")){
	    			((ArticleCat2)article).setProfondeurColis(Integer.parseInt(profondeurField.getText()));
	    			((ArticleCat2)article).setLargeurColis(Integer.parseInt(largeurField.getText()));
	    			((ArticleCat2)article).setHauteurColis(Integer.parseInt(hauteurField.getText()));
	    			((ArticleCat2)article).setPoidsColis(Double.parseDouble(poidsField.getText()));
	            	((ArticleCat2)article).setTeneurEnSucre(teneur);
	        	}
	    	}
    	} else {
    		String designation = designationField.getText();
	    	Double prix = Double.parseDouble(prixField.getText());
	    	if ((quantiteField.getText() != "") && (teneurField.getText() != "")) {
	    		int quantite = Integer.parseInt(quantiteField.getText());
	    		double teneur = Double.parseDouble(teneurField.getText());
	    		if (!((largeurField.getText() == "") || (profondeurField.getText() == "") || (poidsField.getText() == "") || (hauteurField.getText() == ""))){
		    		int profondeur = Integer.parseInt(profondeurField.getText());
					int largeur = Integer.parseInt(largeurField.getText());
					int hauteur = Integer.parseInt(hauteurField.getText());
					Double poids = Double.parseDouble(poidsField.getText());
		    		articles.add(new ArticleCat2(designation,prix,quantite,teneur,hauteur,largeur,profondeur,poids,goutBox.getValue()));
	    		} else if (!(aciditeField.getText() == "")){
	    			int acidite = Integer.parseInt(aciditeField.getText());
	    			articles.add(new ArticleCat1(designation,prix,quantite,teneur,acidite,goutBox.getValue()));
	    		}
	    	}	
    	}
    	listView.refresh();
    	stage.setScene(mainScene);
    }

	public void setListView(ListView<Article> listView) {
		this.listView = listView;
		
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}

}
