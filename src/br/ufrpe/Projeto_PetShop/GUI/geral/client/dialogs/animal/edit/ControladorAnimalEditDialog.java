package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.edit;


import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorAnimalEditDialog {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField racaTextField;
    @FXML
    private RadioButton machoRadioButton;
    @FXML
    private RadioButton femeaRadioButton;

    private Stage dialogStage;
	private Animal person;

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

	/**
	 * Define a pessoa a ser editada no dialog.
	 *
	 * @param person
	 */
	public void setPerson(Animal person) {
		this.person = person;
		nomeTextField.setText(person.getNome());
		racaTextField.setText(person.getRaca());
		if(person.getSexo() == 'M') {
			machoRadioButton.setSelected(true);
		}else {
			femeaRadioButton.setSelected(true);
		}
	}
	@FXML
	private void handleMachoRadioButton (ActionEvent event){
		machoRadioButton.setSelected(true);
		femeaRadioButton.setSelected(false);
		machoRadioButton.requestFocus();
	}
	@FXML
	private void handleFemeaRadioButton (ActionEvent event){
		machoRadioButton.setSelected(false);
		femeaRadioButton.setSelected(true);
		femeaRadioButton.requestFocus();
	}
}
