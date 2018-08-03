package br.ufrpe.Projeto_PetShop.GUI.adm.menu;

import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {
	/**
	 * Inicializa o controlador quando o FXML é carregado.
	 */
	@FXML
	private void initialize() {
	}
	
	@FXML
	private void handleClientesButton(ActionEvent event) {
		ScreenManager.getInstance().clienteCena();
	}
	@FXML
	private void handleFuncionariosButton(ActionEvent event) {
		ScreenManager.getInstance().funcionarioCena();
	}
	@FXML
	private void handleConsultasButton(ActionEvent event) {
		ScreenManager.getInstance().consultaCena();
	}
}
