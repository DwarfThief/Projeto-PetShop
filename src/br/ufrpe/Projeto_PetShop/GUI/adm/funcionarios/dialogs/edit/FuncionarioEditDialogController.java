package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.CpfInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;


/**
 * Dialog para editar detalhes de uma pessoa.
 * 
 * @author Marco Jakob
 */
public class FuncionarioEditDialogController {

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
    private Funcionario person;
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
    /**
     * Define a pessoa a ser editada no dialog.
     * 
     * @param person
	*/
    public void setPerson(Funcionario person) {
    	this.person = person;
        nomeTextField.setText(person.getNome());
        cpfTextField.setText(person.getCpf());
        loginTextField.setText(person.getLogin());
        senhaTextField.setText(person.getSenha());
        if(person instanceof Gerente) {
        	gerenteRadioButton.setSelected(true);
        }else if(person instanceof Vendedor) {
        	vendedorRadioButton.setSelected(true);
        }else {
        	veterinarioRadioButton.setSelected(true);
        }
    }
    
    
    /**
     * Retorna true se o usuário clicar OK,caso contrário false.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Chamado quando o usuário clica OK.
     */
    @FXML
    private void handleOk() {
    	
    	if(nomeTextField.getText()!="" && cpfTextField.getText()!="" && loginTextField.getText()!="" && 
    			senhaTextField.getText()!="" && (gerenteRadioButton.isSelected() == true || veterinarioRadioButton.isSelected() == true || vendedorRadioButton.isSelected() == true)) {
    		try {
    			if(Fachada.getInstance().contFuncionarios().getFuncionario(cpfTextField.getText()) != null) {
    				Funcionario novoPerson;
    				if(gerenteRadioButton.isSelected() == true) {
            			novoPerson = new Gerente(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
            		}else if(vendedorRadioButton.isSelected() == true) {
            			novoPerson = new Vendedor(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
            		}else{
            			novoPerson = new Veterinario(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
            		}
    				try {
						Fachada.getInstance().contFuncionarios().setFuncionario(Fachada.getInstance().contFuncionarios().getFuncionarioPos(person.getCpf()), novoPerson);
					} catch (NaoEncontradoException e) {
						Alert alert = new Alert(AlertType.INFORMATION);
		    			alert.setTitle("Er...");
		    			alert.setHeaderText(null);
		    			alert.setContentText("Aconteceu algum imprevisto.");

		    			alert.showAndWait();
					}finally {
						dialogStage.close();
					}
    			}
    		} catch (CadastroInvalidoException | CpfInvalidoException e) {
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Opa...");
    			alert.setHeaderText(null);
    			alert.setContentText("Funcionario ja existe.");

    			alert.showAndWait();
    		}
    		
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(">:(");
			alert.setHeaderText(null);
			alert.setContentText("Preencha corretamente!");

			alert.showAndWait();
    	}
    }
 
	@FXML
	private void handleGerente(ActionEvent event) {
		gerenteRadioButton.setSelected(true);
		vendedorRadioButton.setSelected(false);
		veterinarioRadioButton.setSelected(false);
		gerenteRadioButton.requestFocus();
	}
	@FXML
	private void handleVendedor(ActionEvent event) {
		gerenteRadioButton.setSelected(false);
		vendedorRadioButton.setSelected(true);
		veterinarioRadioButton.setSelected(false);
		vendedorRadioButton.requestFocus();
	}
	@FXML
	private void handleVeterinario(ActionEvent event) {
		gerenteRadioButton.setSelected(false);
		vendedorRadioButton.setSelected(false);
		veterinarioRadioButton.setSelected(true);
		veterinarioRadioButton.requestFocus();
	}
	@FXML
	private void handleCancel(ActionEvent event) {
	    dialogStage.close();
	}
}