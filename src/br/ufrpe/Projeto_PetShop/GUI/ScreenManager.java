package br.ufrpe.Projeto_PetShop.GUI;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScreenManager {
	
	private static ScreenManager instance;
    private Stage mainStage;
    private Scene centerScene;
    
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        } 
        
        return instance; 
    }
    private ScreenManager() {
        // Construtor privado para evitar instanciação
        
        try {
            AnchorPane center = FXMLLoader.load(getClass().getResource(
              "/br/ufrpe/Projeto_PetShop/GUI/telaLogin/LoginScene.fxml"));
            // inicializando cena
            this.centerScene = new Scene(center);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
        // configurando título da app
        mainStage.setTitle("Transições entre telas");
    }
    public void setCenterScene(String localizacao) {
    	AnchorPane cena;
		try {
			cena = FXMLLoader.load(getClass().getResource(localizacao));
			this.centerScene = new Scene(cena);
	    	this.showCenterScreen();
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }
    public void showCenterScreen() {
        this.mainStage.setScene(this.centerScene);
        this.mainStage.show();
    }
}
