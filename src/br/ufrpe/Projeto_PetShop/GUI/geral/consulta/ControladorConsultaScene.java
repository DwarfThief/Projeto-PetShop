package br.ufrpe.Projeto_PetShop.GUI.geral.consulta;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorConsultaScene {
	@FXML
	private TableView personTable;
	@FXML
	private TableColumn nomeTableColumn;
	@FXML
	private TableColumn dataTableColumn;
	
	@FXML
	private Label nomeGrid;
	@FXML
	private Label cpfGrid;
}
