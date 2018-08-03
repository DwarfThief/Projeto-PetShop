package br.ufrpe.Projeto_PetShop.GUI.geral.consulta.dialogs.create;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorCreateConsulta {
	@FXML
	private TextField cpfTextField;
	@FXML
	private Label vetLabel;
//	TODO ObservableList<String> options = Fachada.getInstance().contAnimais().getAnimaisCliente(cliente.getCpf());
	@FXML
	private ComboBox animaisComboBox;
	
	@FXML
	private DatePicker datePicker;
	private Stage dialogStage;
	private String cliente;
//	Callback<ListView<String>, ListCell<String>> cellFactory = Arrays.asList(Fachada.getInstance().contConsultas().getConsultasArray());;
//	 comboBox.setItems(items);
//	 comboBox.setButtonCell(cellFactory.call(null));
//	 comboBox.setCellFactory(cellFactory);
	
	private void setAnimaisComboBox(Cliente c) {
		try {
			this.animaisComboBox.getItems().add(Fachada.getInstance().contAnimais().getAnimaisCliente(c.getCpf()));
		} catch (NaoEncontradoException | CadastroInvalidoException e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleOk(ActionEvent event) {
		if(this.cpfTextField.getText() != "" && datePicker.getAccessibleText()!= null) {
			
		}else {
			
		}
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void setCliente(Consulta c) {
		this.cliente = c.getDonoNome();
	}
	public void setCliente(ReadOnlyObjectProperty<Consulta> selectedItemProperty) {
		Object c = selectedItemProperty.getClass();
		this.cliente = ((Consulta) c).getDonoNome();
	}
}
