package br.ufrpe.Projeto_PetShop;

import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
    	ScreenManager.getInstance().setMainStage(primaryStage);
    	ScreenManager.getInstance().showCenterScreen();
    }

    public static void main(String[] args) {
       launch(args);
    }

}