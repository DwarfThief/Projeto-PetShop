package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios;

import java.io.IOException;

import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.create.FuncionarioCreateDialog;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit.FuncionarioEditDialogController;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorTabelaFuncionarios {
	 	@FXML
	    private TableView<Funcionario> personTable;
	 	private final ObservableList<Funcionario> data = FXCollections.observableArrayList(Fachada.getInstance().contFuncionarios().getFuncionarioArray());
	    @FXML
	    private TableColumn<Funcionario, String> nomeTableView;
	    @FXML
	    private TableColumn<Funcionario, String> cpfTableView;
	    
	    @FXML
	    private Label funcaoGrid;
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
	    	showPersonDetails(null);
	    	personTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showPersonDetails(newValue));
	    }
	    public void carregarLista() {
	    	nomeTableView.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("nome"));
	    	cpfTableView.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("cpf"));
	    	personTable.setItems(data);
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
	    /**
	     * Abre o dialog para cadastrar um novo cliente
	     */
	    private void abrirNewDialog() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/create/funcionarioCreateDialog.fxml"));
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
	    public void showPersonDetails(Funcionario func) {
	        if (func != null) {
	            // Preenche as labels com informações do objeto person.
	        	if(func instanceof Gerente) {
	        		funcaoGrid.setText("Gerente");
	        	}else if(func instanceof Vendedor) {
	        		funcaoGrid.setText("Vendedor");
	        	}else {
		        	funcaoGrid.setText("Veterinario");
	        	}
	        	nomeGrid.setText(func.getNome());
	        	cpfGrid.setText(func.getCpf());
	        	loginGrid.setText(func.getLogin());
	        	senhaGrid.setText(func.getSenha());
	        } else {
	            // Person é null, remove todo o texto.
	        	funcaoGrid.setText("");
	            nomeGrid.setText("");
	        	cpfGrid.setText("");
	        	loginGrid.setText("");
	        	senhaGrid.setText("");
	        }
	    }
}
