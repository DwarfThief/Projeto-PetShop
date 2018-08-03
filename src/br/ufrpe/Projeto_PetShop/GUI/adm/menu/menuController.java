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
		ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/geral/client/ClienteScene.fxml");
	}
	@FXML
	private void handleFuncionariosButton(ActionEvent event) {
//		ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/adm/funcionarios/tabelaFuncionarios.fxml");
		ScreenManager.getInstance().funcionarioCena();
	}
	@FXML
	private void handleConsultasButton(ActionEvent event) {
		ScreenManager.getInstance().setCenterScene("/br/ufrpe/Projeto_PetShop/GUI/geral/consulta/ConsultaScene.fxml");
	}
}
