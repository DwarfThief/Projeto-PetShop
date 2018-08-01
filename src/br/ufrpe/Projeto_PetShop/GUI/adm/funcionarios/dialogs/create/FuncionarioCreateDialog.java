package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.create;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FuncionarioCreateDialog {
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField cpfTextField;
    @FXML
    private TextField loginTextField;
    @FXML
    private TextField senhaTextField;
    
    @FXML
    private RadioButton gerenteRadioButton;
    @FXML
    private RadioButton vendedorRadioButton;
    @FXML
    private RadioButton veterinarioRadioButton;
    
    private Stage dialogStage;
    private boolean okClicked = false;
        
    /**
     * Inicializa a classe controlle. Este método é chamado automaticamente
     * após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Define o palco deste dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public boolean isOkClicked() {
        return okClicked;
    }
    /**
     * Evento para o botão "OK"
     * Recebe String tas caixas de texto e a seleção do cargo do Funcionário.
     * Caso mais de um cargo seja selecionado ele emite um alert.
     * @param event
     */
    @FXML
    private void handleOk(ActionEvent event) {
    	if(nomeTextField.getText()!="" && cpfTextField.getText()!="" && loginTextField.getText()!="" && 
    			senhaTextField.getText()!="" && (gerenteRadioButton.isSelected() == true || veterinarioRadioButton.isSelected() == true || vendedorRadioButton.isSelected() == true)) {
    		if(veterinarioRadioButton.isSelected() == true) {
	    		//Cadastra veterinario
    			Veterinario funcionario = new Veterinario(nomeTextField.getText(), cpfTextField.getText(), 
	    				loginTextField.getText(), senhaTextField.getText());
	    		try {
					Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					dialogStage.close();
				} catch (CadastroInvalidoException e) {
					this.alertaDeCadastro();
				} catch (FuncionarioJaExisteException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Funcionario ja existe.");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
				}
	    	}else if(gerenteRadioButton.isSelected() == true) {
	    		//Cadastra gerente
	    		Gerente funcionario = new Gerente(nomeTextField.getText(), cpfTextField.getText(), 
	    				loginTextField.getText(), senhaTextField.getText());
	    		try {
					Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					dialogStage.close();
				} catch (CadastroInvalidoException e) {
					this.alertaDeCadastro();
				} catch (FuncionarioJaExisteException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Funcionario ja existe.");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
				}
	    	}else if(vendedorRadioButton.isSelected() == true) {
	    		//Cadastra vendedor
	    		Vendedor funcionario = new Vendedor(nomeTextField.getText(), cpfTextField.getText(), 
	    				loginTextField.getText(), senhaTextField.getText());
	    		try {
					Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					dialogStage.close();
				} catch (CadastroInvalidoException e) {
					this.alertaDeCadastro();
				} catch (FuncionarioJaExisteException e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Funcionario ja existe.");
					alert.setHeaderText(null);
					alert.setContentText(e.getMessage());

					alert.showAndWait();
				}
	    	}
    	}else {
    		this.alertaDeCadastro();
    	}
    }
    @FXML
    private void handleGerente(ActionEvent event) {
    	gerenteRadioButton.setSelected(true);
    	vendedorRadioButton.setSelected(false);
    	veterinarioRadioButton.setSelected(false);
    	gerenteRadioButton.requestFocus();
    }
    @FXML
    private void handleVendedor(ActionEvent event) {
    	gerenteRadioButton.setSelected(false);
    	vendedorRadioButton.setSelected(true);
    	veterinarioRadioButton.setSelected(false);
    	vendedorRadioButton.requestFocus();
    }
    @FXML
    private void handleVeterinario(ActionEvent event) {
    	gerenteRadioButton.setSelected(false);
    	vendedorRadioButton.setSelected(false);
    	veterinarioRadioButton.setSelected(true);
    	veterinarioRadioButton.requestFocus();
    }
    @FXML
    private void handleCancel(ActionEvent event) {
        dialogStage.close();
    }
    /**
     * Emite um alert com "Cadastro invalido", serve apenas para nao repetir codigo.
     */
    private void alertaDeCadastro() {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cadastro invalido");
		alert.setHeaderText(null);
		alert.setContentText("Cadastro invalido");

		alert.showAndWait();
    }
}
