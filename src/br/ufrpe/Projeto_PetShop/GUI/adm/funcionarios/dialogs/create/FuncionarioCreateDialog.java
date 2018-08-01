package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.create;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.CpfInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
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
	    
	    
	    private boolean gerenteRadio = false;
	    private boolean vendedorRadio = false;
	    private boolean veterinarioRadio = false;
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
	    @FXML
	    private void handleOk(ActionEvent event) {
	    	if(nomeTextField.getText()!="" && cpfTextField.getText()!="" && loginTextField.getText()!="" && senhaTextField.getText()!="") {
	    		if(veterinarioRadio == true && gerenteRadio == false && vendedorRadio == false) {
		    		//Cadastra veterinario
	    			Veterinario funcionario = new Veterinario(nomeTextField.getText(), cpfTextField.getText(), 
		    				loginTextField.getText(), senhaTextField.getText());
		    		try {
						Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					} catch (CadastroInvalidoException e) {
						this.alertaDeCadastro();
					} catch (FuncionarioJaExisteException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Funcionario ja existe.");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
					}
		    	}else if(veterinarioRadio == false && gerenteRadio == true && vendedorRadio == false) {
		    		//Cadastra gerente
		    		Gerente funcionario = new Gerente(nomeTextField.getText(), cpfTextField.getText(), 
		    				loginTextField.getText(), senhaTextField.getText());
		    		try {
						Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					} catch (CadastroInvalidoException e) {
						this.alertaDeCadastro();
					} catch (FuncionarioJaExisteException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Funcionario ja existe.");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
					}
		    	}else if(veterinarioRadio == false && gerenteRadio == false && vendedorRadio == true) {
		    		//Cadastra vendedor
		    		Vendedor funcionario = new Vendedor(nomeTextField.getText(), cpfTextField.getText(), 
		    				loginTextField.getText(), senhaTextField.getText());
		    		try {
						Fachada.getInstance().contFuncionarios().addFuncionario(funcionario);
					} catch (CadastroInvalidoException e) {
						this.alertaDeCadastro();
					} catch (FuncionarioJaExisteException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Funcionario ja existe.");
						alert.setHeaderText(null);
						alert.setContentText(e.getMessage());

						alert.showAndWait();
					}
		    	}else {
		    		this.alertaDeCadastro();
		    	}
	    	}else {
	    		this.alertaDeCadastro();
	    	}
	    }
	    @FXML
	    private void handleGerente(ActionEvent event) {
	    	if(this.gerenteRadio == false) {
	    		this.gerenteRadio=true;
	    	}else {
	    		this.gerenteRadio = false;
	    	}
	    }
	    @FXML
	    private void handleVendedor(ActionEvent event) {
	    	if(this.vendedorRadio == false) {
	    		this.vendedorRadio=true;
	    	}else {
	    		this.vendedorRadio = false;
	    	}
	    }
	    @FXML
	    private void handleVeterinario(ActionEvent event) {
	    	if(this.veterinarioRadio == false) {
	    		this.veterinarioRadio=true;
	    	}else {
	    		this.veterinarioRadio = false;
	    	}
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
