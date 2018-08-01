package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
	    	
	    }
	    @FXML
		private void handleEdit(ActionEvent event) {
	    	
	    }
	    @FXML
		private void handleDel(ActionEvent event) {
	    	
	    }
}
