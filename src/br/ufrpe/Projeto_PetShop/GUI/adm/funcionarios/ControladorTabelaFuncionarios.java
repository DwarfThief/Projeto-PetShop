package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios;

import java.io.IOException;

import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit.FuncionarioEditDialogController;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorTabelaFuncionarios {
	 	@FXML
	    private TableView<Funcionario> personTable;
	    @FXML
	    private TableColumn<Funcionario, String> nomeTableView;
	    @FXML
	    private TableColumn<Funcionario, String> cpfTableView;

	    @FXML
	    private Label funcaoGriid;
	    @FXML
	    private Label nomeGrid;
	    @FXML
	    private Label cpfGrid;
	    @FXML
	    private Label loginGrid;
	    @FXML
	    private Label senhaGrid;
	    
	    @FXML
	    private void iniatilize() {
	    	//TODO implementar a lista no TableView
	    	/*nomeTableView.setCellValueFactory(cellData -> cellData.getValue().getNome());
	    	nomeTableView.setCellValueFactory(cellData -> cellData.getValue().getCpf());*/
	    }
	    @FXML
		private void handleNew(ActionEvent event) {
	    	abrirNewDialog();
	    }
	    @FXML
		private void handleEdit(ActionEvent event) {
	    	abrirEditDialog();
	    }
	    @FXML
		private void handleDel(ActionEvent event) {
	    	
	    }
	    private void abrirNewDialog() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/create/funcionarioCreateDialog.fxml"));
		        AnchorPane page = (AnchorPane)loader.load();
		    	// Cria o palco dialogStage.
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Edit Person");
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
	    private void abrirEditDialog() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/edit/funcionarioEditDialog.fxml"));
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
}
