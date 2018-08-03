package br.ufrpe.Projeto_PetShop.GUI;

import java.io.IOException;

import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.ControladorTabelaFuncionarios;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.ControladorClienteScene;
import br.ufrpe.Projeto_PetShop.GUI.geral.consulta.ControladorConsultaScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
    /**
     * Construtor privado, sempre abre com a tela de login
     */
    private ScreenManager() {
        // Construtor privado para evitar multiplas instancias
        
        try {
            AnchorPane center = FXMLLoader.load(getClass().getResource(
              "/br/ufrpe/Projeto_PetShop/GUI/telaLogin/LoginScene.fxml"));
            // inicializando cena
            this.centerScene = new Scene(center);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    /**
     * Retorna o stage principal
     * @return mainStage
     */
    public Stage getMainStage() {
        return mainStage;
    }
    /**
     * Muda o Stage
     * @param mainStage
     */
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
        // configurando título da app
        mainStage.setTitle("Petshop");
    }
    /**
     * Muda a cena central que sera exibida, precisa apenas passar como parametro uma String com a localizacao do arquivo .fxml
     * @param localizacao
     */
    public void setCenterScene(String localizacao) {
    	AnchorPane cena;
		try {
			cena = FXMLLoader.load(getClass().getResource(localizacao));
			this.centerScene = new Scene(cena);
	    	this.showCenterScreen();
	    	// Dá ao controlador acesso à the main app.
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }
    /**
     * Mostra a cena
     */
    public void showCenterScreen() {
        this.mainStage.setScene(this.centerScene);
        this.mainStage.show();
    }
    public void funcionarioCena() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/tabelaFuncionarios.fxml"));
	        AnchorPane page = (AnchorPane)loader.load();
	    	// Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        ControladorTabelaFuncionarios fooController = (ControladorTabelaFuncionarios) loader.getController();
	        fooController.carregarLista();
	        fooController.showPersonDetails(null);
	        dialogStage.setTitle("Cadastrar funcionário");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        // Mostra a janela e espera até o usuário fechar.
	        dialogStage.showAndWait();
    	}catch(IOException e) {
    		e.printStackTrace();
    	} 
    }
    /**
     * Cria um dialog com as opções do cliente.
     */
    public void clienteCena() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/ClienteScene.fxml"));
	        AnchorPane page = (AnchorPane)loader.load();
	    	// Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        ControladorClienteScene fooController = (ControladorClienteScene) loader.getController();
	        fooController.carregarLista();
	        fooController.showPersonDetails(null);
	        dialogStage.setTitle("Cadastrar funcionário");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        // Mostra a janela e espera até o usuário fechar.
	        dialogStage.showAndWait();
    	}catch(IOException e) {
    		e.printStackTrace();
    	} 
    }
    public void consultaCena() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/consulta/ConsultaScene.fxml"));
	        AnchorPane page = (AnchorPane)loader.load();
	    	// Cria o palco dialogStage.
	        Stage dialogStage = new Stage();
	        ControladorConsultaScene fooController = (ControladorConsultaScene) loader.getController();
	        fooController.carregarLista();
	        fooController.showPersonDetails(null);
	        dialogStage.setTitle("Cadastrar funcionário");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        // Mostra a janela e espera até o usuário fechar.
	        dialogStage.showAndWait();
    	}catch(IOException e) {
    		e.printStackTrace();
    	} 
    }
}
