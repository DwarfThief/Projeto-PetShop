package br.ufrpe.Projeto_PetShop.GUI.telaLogin;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	
	private String loginTxt;
	private String senhaTxt;
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
		return okClicked;
	}
	
	@FXML
	private void handleOk(ActionEvent event) {
		this.loginTxt = login.getText();
		this.senhaTxt = senha.getText();
		Fachada.getInstance().checkLogin().checagemLogin(loginTxt, senhaTxt);
	}
}
