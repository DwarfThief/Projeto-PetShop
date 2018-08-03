package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.animal.create;

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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControladorAnimalCreateDialog {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField racaTextField;
	@FXML
	private RadioButton machoRadioButton;
	@FXML
	private RadioButton femeaRadioButton;
	
	private Stage dialogStage;
	private Cliente dono;
	/**
	 * Recebe o stage, serve para o botão "Ok" e "Cancel" fecharem o Dialog ao clicar.
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	/**
	 * Recebe o dono para poder cadastrar o animal ao cliente.
	 * @param dono
	 */
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	@FXML
	private void handleOk(ActionEvent event) {
		if(nomeTextField.getText() != "" && racaTextField.getText()!="" && (machoRadioButton.isSelected()==true || femeaRadioButton.isSelected()==true)) {
			Animal a; 
			if(this.machoRadioButton.isSelected()==true) {
				a = new Animal(nomeTextField.getText(), racaTextField.getText(),'M', this.dono);
			}else{
				a = new Animal(nomeTextField.getText(), racaTextField.getText(),'F', this.dono);
			}
			try {
				Fachada.getInstance().contAnimais().addAnimal(a);
				this.dialogStage.close();
			} catch (CadastroInvalidoException | NaoEncontradoException e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Cadastro Invalido");
				alert.setHeaderText(null);
				alert.setContentText("O cadastro é inválido, preencha todos os campos.");

				alert.showAndWait();
			}
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cadastro Invalido");
			alert.setHeaderText(null);
			alert.setContentText("O cadastro é inválido, preencha todos os campos.");

			alert.showAndWait();
		}
		
	}
	@FXML
	private void handleCancel(ActionEvent event) {
		this.dialogStage.close();
	}
	@FXML
    private void handleFemea(ActionEvent event) {
    	machoRadioButton.setSelected(false);
    	femeaRadioButton.setSelected(true);
    	femeaRadioButton.requestFocus();
    }
	@FXML
    private void handleMacho(ActionEvent event) {
    	machoRadioButton.setSelected(true);
    	femeaRadioButton.setSelected(false);
    	femeaRadioButton.requestFocus();
    }
}
