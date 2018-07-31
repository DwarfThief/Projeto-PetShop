package Teste;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;

public class Teste {

	public static void main(String[] args) {
		Funcionario gerente =new Gerente("NOME", "cpf", "LOGIN", "SENHA");
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.contFuncionarios().addFuncionario(gerente);
		}catch(CadastroInvalidoException cadastroInvalidoException) {
			System.out.println(cadastroInvalidoException.getMessage());
		}catch(FuncionarioJaExisteException fjee) {
			System.out.println(fjee.getMessage());
		}
		MainApp.main(args);
	}

}
