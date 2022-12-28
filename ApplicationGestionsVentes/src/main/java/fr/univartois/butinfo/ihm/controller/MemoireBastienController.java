package fr.univartois.butinfo.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MemoireBastienController {
	
	private Scene scene;
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	private Scene mainScene;
	
	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}
	
	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void retourButton() {
    	stage.setScene(mainScene);
    }

    @FXML
    private ImageView bastienBo;

    @FXML
    private ImageView bastienMalade;

    @FXML
    private ImageView bastienCharmeur;
    
    @FXML
    private ImageView bastienWTF;
    
    public void initialize() {
    	bastienMalade.setImage(new Image(getClass()
	    	     .getResource("../view/images/BASITENMALADE.jpg")
	    	     .toExternalForm(), 500, 500, true, false));
    	bastienBo.setImage(new Image(getClass()
	    	     .getResource("../view/images/bastienbo-min.PNG")
	    	     .toExternalForm(), 800, 500, true, false));
    	bastienCharmeur.setImage(new Image(getClass()
	    	     .getResource("../view/images/bastienCharmeur.jpg")
	    	     .toExternalForm(), 800, 500, true, false));
    	bastienWTF.setImage(new Image(getClass()
	    	     .getResource("../view/images/bastienWTF.jpg")
	    	     .toExternalForm(), 800, 500, true, false));
    }

}