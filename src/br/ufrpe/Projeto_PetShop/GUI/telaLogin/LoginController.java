package br.ufrpe.Projeto_PetShop.GUI.telaLogin;

import java.io.IOException;

import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.LoginInvalidoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	
	private boolean okClicked = false;
	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}
	
	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return this.okClicked;
	}
	/**
	 * Evento de button. Pega o que esta escrito no TextField e PasswordField e envia para
	 * Fachada.getInstance().checkLogin().checagemLogin();
	 * 
	 */
	@FXML
	private void handleOk(ActionEvent event) {
		this.okClicked = true;
		String loginTxt = login.getText();
		String senhaTxt = senha.getText();
		try {
			Funcionario f = Fachada.getInstance().checkLogin().checagemLogin(loginTxt, senhaTxt);
			if(f instanceof Gerente) {
			ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/adm/menu/menuScene.fxml");
			}
		}catch(LoginInvalidoException lie) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login invalido.");
			alert.setHeaderText(null);
			alert.setContentText(lie.getMessage());

			alert.showAndWait();
		}
	}
}
