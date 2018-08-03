package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorClientEditDialog {
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
//		TODO implementar substituição no repositório
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
