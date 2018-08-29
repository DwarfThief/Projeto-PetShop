package br.ufrpe.Projeto_PetShop.GUI.geral.consulta;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.GUI.geral.consulta.dialogs.ControladorConsultaDialog;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorConsultaScene implements Initializable {
	@FXML
	private TableView<Consulta> personTable;
	private final ObservableList<Consulta> data = FXCollections.observableArrayList(Fachada.getInstance().getConsultasArray());
	@FXML
	private TableColumn<Consulta, String> nomeTableColumn;
	@FXML
	private TableColumn<Consulta, String> dataTableColumn;

	@FXML
	private Label clienteLabelGrid;
	@FXML
	private Label animalLabelGrid;
	@FXML
	private Label diaLabelGrid;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.showPersonDetails(null);
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(this.personTable.getSelectionModel().getSelectedItem()));
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Consulta,String>("donoNome"));
		dataTableColumn.setCellValueFactory(new PropertyValueFactory<Consulta,String>("animalNome"));
		personTable.setItems(data);
	}
	@FXML
	private void handleNewConsulta() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/consulta/dialogs/ConsultaCreateDialog.fxml"));
			AnchorPane page = loader.load();
			// Cria o palco dialogStage.
			Stage dialogStage = new Stage();
			ControladorConsultaDialog fooController = loader.getController();
			fooController.setDialogStage(dialogStage);
			fooController.setCliente(personTable.getSelectionModel().selectedItemProperty());
			dialogStage.setTitle("Cadastrar cliente");
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
	private void handleEditConsulta() {
		if(this.personTable.getSelectionModel().getSelectedItem() != null){
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainApp.class.getResource("/br/ufrpe/Projeto_PetShop/GUI/geral/consulta/dialogs/edit/ConsultaEditDialog.fxml"));
				AnchorPane page = (AnchorPane)loader.load();
				// Cria o palco dialogStage.
				Stage dialogStage = new Stage();
				ControladorConsultaDialog fooController = loader.getController();
				fooController.setDialogStage(dialogStage);
				dialogStage.setTitle("Cadastrar cliente");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				dialogStage.initOwner(ScreenManager.getInstance().getMainStage());
				Scene scene = new Scene(page);
				dialogStage.setScene(scene);
				// Mostra a janela e espera até o usuário fechar.
				dialogStage.showAndWait();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else{
			this.AlertaConsultaNaoSelecionada();
		}
	}
	@FXML
	private void handleDelConsulta() {
		if(this.personTable.getSelectionModel().getSelectedItem()!=null) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmação de delete");
			alert.setHeaderText("Deletar consulta");
			alert.setContentText("Você realmente quer deletar essa consulta?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				try {
					Fachada.getInstance().removerConsulta(this.personTable.getSelectionModel().getSelectedItem());
				} catch (CadastroInvalidoException e) {
					Alert alertE = new Alert(Alert.AlertType.INFORMATION);
					alertE.setTitle("Er...");
					alertE.setHeaderText(null);
					alertE.setContentText(e.getMessage());

					alertE.showAndWait();
				} catch (NaoEncontradoException e) {
					Alert alertE = new Alert(Alert.AlertType.INFORMATION);
					alertE.setTitle("Estranho...");
					alertE.setHeaderText(null);
					alertE.setContentText(e.getMessage());

					alertE.showAndWait();
				} finally {
					alert.close();
				}
			} else {
				alert.close();
			}
		}else{
			this.AlertaConsultaNaoSelecionada();
		}
	}
	private void AlertaConsultaNaoSelecionada(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Consulta não selecionada");
		alert.setHeaderText(null);
		alert.setContentText("É necessário selecionar uma consulta.");

		alert.showAndWait();
	}
	public void showPersonDetails(Consulta consulta) {
		if (consulta != null) {
			// Preenche as labels com informações do objeto person.
			clienteLabelGrid.setText(consulta.getDonoNome());
			animalLabelGrid.setText(consulta.getAnimalNome());
			diaLabelGrid.setText("");
	//        	TODO adicionar data.
		} else {
			// Person é null, remove todo o texto.
			clienteLabelGrid.setText("");
			animalLabelGrid.setText("");
			diaLabelGrid.setText("");
		}
	}
	}
