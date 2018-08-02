package br.ufrpe.Projeto_PetShop.GUI.geral.client;

import java.io.IOException;

import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.create.FuncionarioCreateDialog;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit.FuncionarioEditDialogController;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorClienteScene {
	 	@FXML
	    private TableView<Funcionario> personTable;
	    @FXML
	    private TableColumn<Funcionario, String> nomeTableView;
	    @FXML
	    private TableColumn<Funcionario, String> cpfTableView;

	    @FXML
	    private Label nomeGrid;
	    @FXML
	    private Label cpfGrid;
	    @FXML
	    private ComboBox animaisComboBox;
	    
	    @FXML
	    private void iniatilize() {
	    	//TODO implementar a lista no TableView
	    	nomeTableView.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
	    	cpfTableView.setCellValueFactory(new PropertyValueFactory<Cliente,String>("cpf"));
	    }
	    @FXML
		private void handleNewClient(ActionEvent event) {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
		        //TODO loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/create/funcionarioCreateDialog.fxml"));
		        AnchorPane page = (AnchorPane)loader.load();
		    	// Cria o palco dialogStage.
		        Stage dialogStage = new Stage();
		        FuncionarioCreateDialog fooController = (FuncionarioCreateDialog) loader.getController();
		        fooController.setDialogStage(dialogStage);
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
	     * Evento do botão "Editar Cliente". Ao apertar cria uma dialog para editar os dados do cliente.
	     * @param event
	     */
	    @FXML
		private void handleEditClient(ActionEvent event) {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
		        //TODO loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/edit/funcionarioEditDialog.fxml"));
		        AnchorPane page = (AnchorPane)loader.load();
		    	// Cria o palco dialogStage.
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Edit Person");
		        dialogStage.initModality(Modality.WINDOW_MODAL);
		        dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);

		        // Define a pessoa no controller.
		        FuncionarioEditDialogController controller = loader.getController();
		        controller.setDialogStage(dialogStage);

		        // Mostra a janela e espera até o usuário fechar.
		        dialogStage.showAndWait();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	    @FXML
	    private void handleDelClient(ActionEvent event) {
	    	
	    }
	    @FXML
	    private void handleNewAnimal(ActionEvent event) {
	    	
	    }
	    @FXML
	    private void handleEditAnimal(ActionEvent event) {
	    	
	    }
	    @FXML
	    private void handleDelAnimal(ActionEvent event) {
	    	
	    }
}
