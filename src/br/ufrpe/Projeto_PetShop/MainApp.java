package br.ufrpe.Projeto_PetShop;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application{

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PetShop");

        initRootLayout();

        LoginScene();
	}
	/**
     * Inicializa o layout base
     */
	public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("GUI/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
     * Mostra a tela de Login dentro do root layout.
     */
	public void LoginScene() {
		try {
            // Carrega a tela de Login.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("GUI/telaLogin/LoginScene.fxml"));
            AnchorPane loginScene = (AnchorPane) loader.load();

            // Define a tela de Login dentro do root layout.
            rootLayout.setCenter(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Retorna a tela de Login.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
