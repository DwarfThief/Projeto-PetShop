package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.edit;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAnimalEditDialog {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField racaTextField;
	private Stage dialogStage;
	/**
	 * Recebe o stage, serve para o botão "Ok" e "Cancel" fecharem o Dialog ao clicar.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void handleOk(ActionEvent event) {
		this.dialogStage.close();
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
}
