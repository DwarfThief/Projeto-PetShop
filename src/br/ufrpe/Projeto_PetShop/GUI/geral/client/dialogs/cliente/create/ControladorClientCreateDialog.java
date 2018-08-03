package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente.create;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.ClienteJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorClientCreateDialog {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField cpfTextField;
	@FXML
	private TextField enderecoTextField;
	@FXML
	private TextField emailTextField;
	
	@FXML
	private RadioButton masculinoRadioButton;
	@FXML
	private RadioButton femininoRadioButton;
	@FXML
	private RadioButton outroRadioButton;
	
	private Stage dialogStage;
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	/**
	 * Evento do RadioButton "Masculino"
	 * @param event
	 */
	@FXML
    private void handleMasculinoRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(true);
    	femininoRadioButton.setSelected(false);
    	outroRadioButton.setSelected(false);
    	masculinoRadioButton.requestFocus();
    }
	/**
	 * Evento do RadioButton "Feminino"
	 * @param event
	 */
	@FXML
    private void handleFemininoRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(false);
    	femininoRadioButton.setSelected(true);
    	outroRadioButton.setSelected(false);
    	femininoRadioButton.requestFocus();
    }
	/**
	 * Evento do RadioButton "Outro"
	 * @param event
	 */
	@FXML
    private void handleOutroRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(false);
    	femininoRadioButton.setSelected(false);
    	outroRadioButton.setSelected(true);
    	outroRadioButton.requestFocus();
    }
	/**
	 * Cadastra o cliente novo no banco de dados.
	 * @param event
	 */
	@FXML
	private void handleOk(ActionEvent event) {
		if(nomeTextField.getText() != "" && cpfTextField.getText() != "" && enderecoTextField.getText() != "" && emailTextField.getText()!="" &&
				(masculinoRadioButton.isSelected() == true || femininoRadioButton.isSelected() == true || outroRadioButton.isSelected() == true)) {
			Cliente c;
			if(masculinoRadioButton.isSelected() == true) {
				c = new Cliente(nomeTextField.getText(), cpfTextField.getText(), enderecoTextField.getText(), emailTextField.getText(), 'M');
				//Cadastra com o sexo "Masculino"
			}else if(femininoRadioButton.isSelected() == true) {
				c = new Cliente(nomeTextField.getText(), cpfTextField.getText(), enderecoTextField.getText(), emailTextField.getText(), 'F');
				//Cadastra com o sexo "Feminino"
			}else{
				c = new Cliente(nomeTextField.getText(), cpfTextField.getText(), enderecoTextField.getText(), emailTextField.getText(), 'O');
				//Cadastra com o sexo "outro"
			}
			
			try {
				Fachada.getInstance().contClientes().cadastrarCliente(c);
			} catch (NaoEncontradoException | CadastroInvalidoException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops...");
				alert.setHeaderText(null);
				alert.setContentText(e.getMessage());

				alert.showAndWait();
			}catch (ClienteJaExisteException cje) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Ops...");
				alert.setHeaderText(null);
				alert.setContentText(cje.getMessage());

				alert.showAndWait();
			}
		}
	}
	/**
	 * Evento do botão "Cancel"
	 * @param event
	 */
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
}
