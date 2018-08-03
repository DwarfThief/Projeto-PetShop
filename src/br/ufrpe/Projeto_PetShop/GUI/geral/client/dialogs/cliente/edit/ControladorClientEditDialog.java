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
	/**
	 * 
	 * @param event
	 */
	@FXML
    private void handleMasculinoRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(true);
    	femininoRadioButton.setSelected(false);
    	outroRadioButton.setSelected(false);
    	masculinoRadioButton.requestFocus();
    }
	@FXML
    private void handleFemininoRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(false);
    	femininoRadioButton.setSelected(true);
    	outroRadioButton.setSelected(false);
    	femininoRadioButton.requestFocus();
    }
	@FXML
    private void handleOutroRadioButton(ActionEvent event) {
    	masculinoRadioButton.setSelected(false);
    	femininoRadioButton.setSelected(false);
    	outroRadioButton.setSelected(true);
    	outroRadioButton.requestFocus();
    }
	@FXML
	private void handleOk(ActionEvent event) {
		this.dialogStage.close();
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
