package br.ufrpe.Projeto_PetShop.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControladorCenaPrincipal {
	@FXML
	private void handleClientesButton(ActionEvent event) {
		ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/geral/client/ClienteScene.fxml");
	}
	@FXML
	private void handleConsultasButton(ActionEvent event) {
		//TODO
	}
}
