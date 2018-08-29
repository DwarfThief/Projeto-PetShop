package br.ufrpe.Projeto_PetShop.GUI.geral.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.Dialog.AnimalDialogCrontroller;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente.ControladorClientDialog;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorClienteScene implements Initializable{
	@FXML
	private TableView<Cliente> personTable;
	private final ObservableList<Cliente> data = FXCollections.observableArrayList(Fachada.getInstance().contClientes().getClientesArray());
	@FXML
	private TableColumn<Cliente, String> nomeTableView;
	@FXML
	private TableColumn<Cliente, String> cpfTableView;

	@FXML
	private Label nomeGrid;
	@FXML
	private Label cpfGrid;
	@FXML
	private ComboBox animaisComboBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showPersonDetails(null);
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(this.personTable.getSelectionModel().getSelectedItem()));
		nomeTableView.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nome"));
		cpfTableView.setCellValueFactory(new PropertyValueFactory<Cliente,String>("cpf"));
		personTable.setItems(data);
		ScreenManager.getInstance();

	}
	/**
	 * Evento para o botão "Cadastrar cliente"
	 * @param event
	 */
	@FXML
	private void handleNewClient(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/cliente/ClientCreateDialog.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Cadastrar cliente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			//Envia o cliente selecionado para o dialog.
			ControladorClientDialog fooController = loader.getController();
			fooController.setDialogStage(dialogStage);
			fooController.setCliente(null);

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
		if(personTable.getSelectionModel().selectedItemProperty()!=null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/cliente/ClientEditDialog.fxml"));
				AnchorPane page = loader.load();

				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Editar cliente");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Define a pessoa no controller.
				ControladorClientDialog controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setCliente(this.personTable.getSelectionModel().getSelectedItem());

				// Mostra a janela e espera até o usuário fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			this.alertaClienteNaoSelecionado();
		}
	}
	/**
	 * Evento para o botão "Deletar cliente"
	 * @param event
	 */
	@FXML
	private void handleDelClient(ActionEvent event) {
		this.alertaClienteNaoSelecionado();
	}
	/**
	 * Chama o dialog para cadastrar animal.
	 * @param event
	 */
	@FXML
	private void handleNewAnimal(ActionEvent event) {
		if(personTable.getSelectionModel().selectedItemProperty() != null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/animal/create/AnimalCreateDialog.fxml"));
				AnchorPane page = loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				AnimalDialogCrontroller fooController = loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Cadastrar animal");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);
				// Mostra a janela e espera até o usuário fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			this.alertaClienteNaoSelecionado();
		}
	}
	/**
	 * Chama o dialog para editar o animal selecionado.
	 * @param event
	 */
	@FXML
	private void handleEditAnimal(ActionEvent event) {
		if(personTable.getSelectionModel().selectedItemProperty() != null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/animal/edit/AnimalEditDialog.fxml"));
				AnchorPane page = loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				AnimalDialogCrontroller fooController = loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Cadastrar animal");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Define a pessoa no controller, assim sera possível o carregamento no dialog.
				AnimalDialogCrontroller controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setAnimal(Fachada.getInstance().getAnimal(personTable.getSelectionModel().getSelectedItem().getCpf(), "X"));
				//TODO por o nome do animal selecionado do ComboBox no setAnimal
				// Mostra a janela e espera até o usuário fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			} catch (NaoEncontradoException e) {
				e.printStackTrace();
			}
		}else {
			this.alertAnimalNaoSelecionado();
		}
	}
	/**
	 * Evento para o botão "Deletar animal"
	 * @param event
	 */
	@FXML
	private void handleDelAnimal(ActionEvent event) {
		this.alertAnimalNaoSelecionado();
	}
	/**
	 * Cria um alerta para indicar que não existe animal selecionado.
	 */
	private void alertAnimalNaoSelecionado(){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Animal não selecionado");
			alert.setHeaderText(null);
			alert.setContentText("É necessário selecionar um animal.");

			alert.showAndWait();
	}
	/**
	 * Emite um alert quando o cliente n foi selecionado.
	 */
	private void alertaClienteNaoSelecionado() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cliente não selecionado");
		alert.setHeaderText(null);
		alert.setContentText("É necessário selecionar um cliente.");

		alert.showAndWait();
	}
	public void showPersonDetails(Cliente cliente) {
		if (cliente != null) {
			// Preenche as labels com informações do objeto person.
			nomeGrid.setText(cliente.getNome());
			cpfGrid.setText(cliente.getCpf());
//			try {
//				Animal a[] = Fachada.getInstance().contAnimais().getAnimaisCliente(cliente.getCpf());
//				String nameS[] = new String[a.length];
//				for(int i =0; i<= a.length; i++){
//					nameS[i] = a[i].getNome();
//				}
//				this.animaisComboBox.getItems().addAll(nameS);
//			} catch (NaoEncontradoException | CadastroInvalidoException e) {
//				e.printStackTrace();
//			}
		} else {
			// Person é null, remove todo o texto.
			nomeGrid.setText("");
			cpfGrid.setText("");
		}

	}
}
