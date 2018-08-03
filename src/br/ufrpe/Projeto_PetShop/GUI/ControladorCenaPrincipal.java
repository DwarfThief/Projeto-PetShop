package br.ufrpe.Projeto_PetShop.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControladorCenaPrincipal {
	/**
	 * Evento para o botão "Cliente" no menu principal.
	 * @param event
	 */
	@FXML
	private void handleClientesButton(ActionEvent event) {
		ScreenManager.getInstance().clienteCena();
	}
	@FXML
	private void handleConsultasButton(ActionEvent event) {
		ScreenManager.getInstance().consultaCena();
	}
}
