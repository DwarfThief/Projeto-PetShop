package br.ufrpe.Projeto_PetShop.GUI.adm.menu;

import br.ufrpe.Projeto_PetShop.GUI.ScreenManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class menuController {
	/**
	 * Inicializa o controlador quando o FXML é carregado.
	 */
	@FXML
	private void initialize() {
	}
	
	@FXML
	private void handleClientesButton(ActionEvent event) {
		
	}
	@FXML
	private void handleFuncionariosButton(ActionEvent event) {
		ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/tabelaFuncionarios.fxml");
	}
	@FXML
	private void handleConsultasButton(ActionEvent event) {
		
	}
}
