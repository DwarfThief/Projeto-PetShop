package br.ufrpe.Projeto_PetShop.GUI.adm.funcionarios.dialogs.edit;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    /*
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        cityField.setText(person.getCity());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }
    */
    
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
/*    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }
*/
    /**
     * Chamado quando o usuário clica Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}