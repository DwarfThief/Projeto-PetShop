package br.ufrpe.Projeto_PetShop.GUI.geral.consulta;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorConsultaScene {
	@FXML
    private TableView<Consulta> personTable;
 	private final ObservableList<Consulta> data = FXCollections.observableArrayList(Fachada.getInstance().contConsultas().getConsultasArray());
    @FXML
    private TableColumn<Consulta, String> nomeTableColumn;
    @FXML
    private TableColumn<Consulta, String> dataTableColumn;

	@FXML
	private Label clienteLabelGrid;
	@FXML
	private Label animalLabelGrid;
	@FXML
	private Label diaLabelGrid;
	
	@FXML
	private void handleNewConsulta() {
		
	}
	@FXML
	private void handleEditConsulta() {
		
	}
	@FXML
	private void handleDelConsulta() {
		
	}
	public void carregarLista() {
		nomeTableColumn.setCellValueFactory(new PropertyValueFactory<Consulta,String>("donoNome"));
    	dataTableColumn.setCellValueFactory(new PropertyValueFactory<Consulta,String>("animalNome"));
    	personTable.setItems(data);
		
	}
	public void showPersonDetails(Consulta consulta) {
		if (consulta != null) {
            // Preenche as labels com informações do objeto person.
        	clienteLabelGrid.setText(consulta.getDonoNome());
        	animalLabelGrid.setText(consulta.getAnimalNome());
        	diaLabelGrid.setText("");
//        	TODO adicionar data.
        } else {
            // Person é null, remove todo o texto.
            clienteLabelGrid.setText("");
        	animalLabelGrid.setText("");
        	diaLabelGrid.setText("");
        }
	}
}
