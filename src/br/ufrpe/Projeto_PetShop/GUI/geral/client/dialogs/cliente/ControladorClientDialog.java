package br.ufrpe.Projeto_PetShop.GUI.geral.client.dialogs.cliente;

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
import javafx.stage.Stage;

public class ControladorClientDialog {
	@FXML
	private TextField nomeTextField;
	@FXML
	private TextField cpfTextField;
	@FXML
	private TextField enderecoTextField;
	@FXML
	private TextField telefoneTextField;
	@FXML
	private RadioButton masculinoRadioButton;
	@FXML
	private RadioButton femininoRadioButton;
	@FXML
	private RadioButton outroRadioButton;
	private Cliente cliente;
	private Stage dialogStage;


	public void setCliente(Cliente c){
		this.cliente = c;
	}
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
	 * Evento chamado ao clicar no botão "Ok" do dialog. Caso o dialog tenha sido chamado atraves do "Criar novo" ele
	 * vai cadastrar um novo cliente, caso o dialog tenha sido chamado atraves do "Editar cliente" ele edita o cliente
	 * de acordo com sua posição no Array.
	 * @param event
	 */
	@FXML
	private void handleOk(ActionEvent event) {
		if(nomeTextField.getText() == "" && cpfTextField.getText() == "" && enderecoTextField.getText() == ""
				&& telefoneTextField.getText()==""&& (masculinoRadioButton.isSelected() || femininoRadioButton.isSelected()
				|| outroRadioButton.isSelected())){
			Cliente novoCliente;
			if(femininoRadioButton.isSelected()){
				novoCliente = new Cliente(nomeTextField.getText(), cpfTextField.getText(), telefoneTextField.getText()
						, enderecoTextField.getText(), 'F');
			}else if(masculinoRadioButton.isSelected()){
				novoCliente = new Cliente(nomeTextField.getText(), cpfTextField.getText(), telefoneTextField.getText()
						, enderecoTextField.getText(), 'M');
			}else{
				novoCliente = new Cliente(nomeTextField.getText(), cpfTextField.getText(), telefoneTextField.getText()
						, enderecoTextField.getText(), 'O');
			}
			try{
				if(this.cliente!=null){
					//Caso o dialog tenha sido chamado atraves do "Editar cliente"
					Fachada.getInstance().removerCliente(cliente.getCpf());
					Fachada.getInstance().cadastrarCliente(novoCliente);
					this.dialogStage.close();
				}else{
					//Caso o dialog tenha sido chamado atraves do "Cadastrar cliente"
					Fachada.getInstance().cadastrarCliente(novoCliente);
					this.dialogStage.close();
				}

			} catch (NaoEncontradoException nee) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle(":O");
				alert.setHeaderText(null);
				alert.setContentText(nee.getMessage());

				alert.showAndWait();
			} catch (CadastroInvalidoException cie) {
				this.alertCadastroInvalido();
			} catch (ClienteJaExisteException cjee) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle(":'(");
				alert.setHeaderText(null);
				alert.setContentText(cjee.getMessage());

				alert.showAndWait();
			}
		}else{
			this.alertCadastroInvalido();
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
	private void alertCadastroInvalido(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(">:(");
		alert.setHeaderText(null);
		alert.setContentText("Preencha corretamente o formulário!");

		alert.showAndWait();
	}
}
