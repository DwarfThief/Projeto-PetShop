package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs;

import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
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
public class FuncionarioDialogController {

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

    private Funcionario funcionario;
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
     * @param funcionario
	*/
    public void setPerson(Funcionario funcionario) {
    	this.funcionario = funcionario;
        nomeTextField.setText(funcionario.getNome());
        cpfTextField.setText(funcionario.getCpf());
        loginTextField.setText(funcionario.getLogin());
        senhaTextField.setText(funcionario.getSenha());
        if(funcionario instanceof Gerente) {
        	gerenteRadioButton.setSelected(true);
        }else if(funcionario instanceof Vendedor) {
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
     * Ao clicar "Ok" chama este evento. Cria um Funcionario caso este Dialog for chamado pelo botão "Criar..." e edita
	 * um Funcionario caso este Dialog for chamado pelo botão "Editar...".
     */
    @FXML
    private void handleOk() {
    	if(nomeTextField.getText()!="" && cpfTextField.getText()!="" && loginTextField.getText()!="" && 
    			senhaTextField.getText()!="" && (gerenteRadioButton.isSelected() == true || veterinarioRadioButton.isSelected() == true || vendedorRadioButton.isSelected() == true)) {
    		//Cria um Funcionario que sera usado para armazenar o novoFuncionario temporariamente.
    		Funcionario novoFuncionario;
    		if(this.gerenteRadioButton.isSelected()==true){
    			novoFuncionario = new Gerente(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
			}else if(this.vendedorRadioButton.isSelected() == true){
				novoFuncionario = new Vendedor(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
			}else{
				novoFuncionario = new Veterinario(nomeTextField.getText(), cpfTextField.getText(), loginTextField.getText(), senhaTextField.getText());
			}
			try{
				if(this.funcionario !=null){
					//Para editar um Funcionário já criado.
					Fachada.getInstance().contFuncionarios().setFuncionario(
							Fachada.getInstance().contFuncionarios().getFuncionarioPos(funcionario.getCpf()), novoFuncionario);
				}else {
					//Para criar um Funcionário novo.
					Fachada.getInstance().contFuncionarios().addFuncionario(novoFuncionario);
				}
				dialogStage.close();
			} catch (CadastroInvalidoException e) {
				e.printStackTrace();
			} catch (FuncionarioJaExisteException e) {
				e.printStackTrace();
			} catch (NaoEncontradoException e) {
				e.printStackTrace();
			}
		}else {
    		this.alertCadastroInvalido();
    	}
    }

	/**
	 * Cria um alert avisando que o usuário não preencheu os campos corretamente.
	 */
	private void alertCadastroInvalido(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(">:(");
		alert.setHeaderText(null);
		alert.setContentText("Preencha corretamente!");

		alert.showAndWait();
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