package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.create.FuncionarioCreateDialog;
import br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit.FuncionarioEditDialogController;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CpfInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorTabelaFuncionarios implements Initializable {
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showPersonDetails(null);
		nomeTableView.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("nome"));
		cpfTableView.setCellValueFactory(new PropertyValueFactory<Funcionario,String>("cpf"));
		personTable.setItems(data);
		this.personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(this.personTable.getSelectionModel().getSelectedItem()));
	}
	@FXML
	private void handleNew(ActionEvent event) {
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
	@FXML
	private void handleEdit(ActionEvent event) {
		if(personTable.getSelectionModel().getSelectedItem() != null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/dialogs/edit/funcionarioEditDialog.fxml"));
				AnchorPane page = loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Edit Person");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Define a pessoa no controller, assim sera possível o carregamento no dialog.
				FuncionarioEditDialogController controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setPerson(personTable.getSelectionModel().getSelectedItem());

				// Mostra a janela e espera até o usuário fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops...");
			alert.setHeaderText(null);
			alert.setContentText("É necessário selecionar um funcionário.");

			alert.showAndWait();
		}

	}
	@FXML
	private void handleDel(ActionEvent event) {
		if(this.personTable.getSelectionModel().getSelectedItem()!=null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação de delete");
			alert.setHeaderText("Deletar funcionario");
			alert.setContentText("Você realmente quer deletar esse funcionário?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				try {
					Fachada.getInstance().contFuncionarios().remover(this.personTable.getSelectionModel().getSelectedItem().getCpf());
				} catch (CpfInvalidoException e) {
					Alert alertE = new Alert(AlertType.INFORMATION);
					alertE.setTitle("Er...");
					alertE.setHeaderText(null);
					alertE.setContentText(e.getMessage());

					alertE.showAndWait();
				} catch (NaoEncontradoException e) {
					Alert alertE = new Alert(AlertType.INFORMATION);
					alertE.setTitle("Estranho...");
					alertE.setHeaderText(null);
					alertE.setContentText(e.getMessage());

					alertE.showAndWait();
				}finally {
					alert.close();
				}
			} else {
				alert.close();
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops...");
			alert.setHeaderText(null);
			alert.setContentText("É necessário selecionar um funcionário.");

			alert.showAndWait();
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
