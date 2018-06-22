package Teste;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.userInterface.Menu;

public class Teste {

	public static void main(String[] args) {
		Gerente gerente =new Gerente("NOME", "cpf", "LOGIN", "SENHA");
		Fachada fachada = Fachada.getInstance();
		fachada.controllerAdm.addGerente(gerente);
		Menu menu = new Menu();
		menu.menu();
	}

}
