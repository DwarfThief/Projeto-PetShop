package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.Dialog;


import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnimalDialogCrontroller {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField racaTextField;
    @FXML
    private RadioButton machoRadioButton;
    @FXML
    private RadioButton femeaRadioButton;

    private Stage dialogStage;
	private Animal animal;

	/**
	 * Recebe o stage, serve para o botão "Ok" e "Cancel" fecharem o Dialog ao clicar.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void handleOk(ActionEvent event) {
		if(validacaoDeCampos()) {
			if (animal != null) {
				char sexo = ' ';
				if (machoRadioButton.isSelected()) {
					sexo = 'M';
				} else {
					sexo = 'F';
				}
				this.animal = new Animal(nomeTextField.getText(), racaTextField.getText(), sexo, this.animal.getDono());
				try {
					Fachada.getInstance().removerAnimal(this.animal.getNome(), this.animal.getDono().getCpf());
					Fachada.getInstance().cadastrarAnimal(animal);
				} catch (NaoEncontradoException nee) {
					nee.printStackTrace();
				} catch (CadastroInvalidoException cie) {
					this.alertCadastroInvalido();
				}
			}else {
				this.alertCadastroInvalido();
			}
		}else{
			this.alertCadastroInvalido();
		}
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
	private boolean validacaoDeCampos(){
		return !nomeTextField.getText().isEmpty()  && !racaTextField.getText().isEmpty() &&
				(machoRadioButton.isSelected() || femeaRadioButton.isSelected());
	}
	/**
	 * Define a pessoa a ser editada no dialog.
	 *
	 * @param animal
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
		if(this.animal != null){
			nomeTextField.setText(animal.getNome());
			racaTextField.setText(animal.getRaca());
			if(animal.getSexo() == 'M') {
				machoRadioButton.setSelected(true);
			}else {
				femeaRadioButton.setSelected(true);
			}
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
	private void alert(String title, String message){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();
	}
	private void alertCadastroInvalido(){
		this.alert("Something gone wrong...","Dados invalidos, por favor certifique-se que tudo esta corretamente preenchido");
	}
}
