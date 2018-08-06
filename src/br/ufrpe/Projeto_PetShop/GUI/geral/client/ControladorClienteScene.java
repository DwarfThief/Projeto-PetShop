package br.ufrpe.Projeto_PetShop.GUI.geral.client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.edit.ControladorAnimalEditDialog;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.create.ControladorAnimalCreateDialog;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente.create.ControladorClientCreateDialog;
import br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente.edit.ControladorClientEditDialog;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
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

	}
	/**
	 * Evento para o bot�o "Cadastrar cliente"
	 * @param event
	 */
	@FXML
	private void handleNewClient(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/cliente/create/ClientCreateDialog.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			ControladorClientCreateDialog fooController = (ControladorClientCreateDialog) loader.getController();
			fooController.setDialogStage(dialogStage);
			dialogStage.setTitle("Cadastrar cliente");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			// Mostra a janela e espera at� o usu�rio fechar.
			dialogStage.showAndWait();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Evento do bot�o "Editar Cliente". Ao apertar cria uma dialog para editar os dados do cliente.
	 * @param event
	 */
	@FXML
	private void handleEditClient(ActionEvent event) {
		if(personTable.getSelectionModel().selectedItemProperty()!=null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/client/dialogs/cliente/edit/ClientEditDialog.fxml"));
				AnchorPane page = (AnchorPane)loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				ControladorClientEditDialog fooController = (ControladorClientEditDialog) loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Editar cliente");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Define a pessoa no controller.
				ControladorClientEditDialog controller = loader.getController();
				controller.setDialogStage(dialogStage);

				// Mostra a janela e espera at� o usu�rio fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			this.alertaClienteNaoSelecionado();
		}
	}
	/**
	 * Evento para o bot�o "Deletar cliente"
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
				AnchorPane page = (AnchorPane)loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				ControladorAnimalCreateDialog fooController = (ControladorAnimalCreateDialog) loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Cadastrar animal");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);
				// Mostra a janela e espera at� o usu�rio fechar.
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
				ControladorAnimalCreateDialog fooController = loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Cadastrar animal");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);

				// Define a pessoa no controller, assim sera poss�vel o carregamento no dialog.
				ControladorAnimalEditDialog controller = loader.getController();
				controller.setDialogStage(dialogStage);
				controller.setPerson(personTable.getSelectionModel().getSelectedItem());

				// Mostra a janela e espera at� o usu�rio fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			/*
			 * Alerta para indicar que n�o existe animal selecionado
			 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Animal n�o selecionado");
			alert.setHeaderText(null);
			alert.setContentText("� necess�rio selecionar um animal.");

			alert.showAndWait();
		}
	}
	/**
	 * Evento para o bot�o "Deletar animal"
	 * @param event
	 */
	@FXML
	private void handleDelAnimal(ActionEvent event) {
		/*
		 * Alerta para indicar que n�o existe animal selecionado
		 */
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Animal n�o selecionado");
		alert.setHeaderText(null);
		alert.setContentText("� necess�rio selecionar um animal.");

		alert.showAndWait();
	}
	/**
	 * Emite um alert quando o cliente n foi selecionado.
	 */
	private void alertaClienteNaoSelecionado() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cliente n�o selecionado");
		alert.setHeaderText(null);
		alert.setContentText("� necess�rio selecionar um cliente.");

		alert.showAndWait();
	}
	public void showPersonDetails(Cliente cliente) {
		if (cliente != null) {
			// Preenche as labels com informa��es do objeto person.
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
			// Person � null, remove todo o texto.
			nomeGrid.setText("");
			cpfGrid.setText("");
		}

	}
}
