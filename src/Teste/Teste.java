package Teste;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;

public class Teste {

	public static void main(String[] args) {
		Funcionario gerente = new Gerente("NOME", "gerente", "G", "s");
		Funcionario vendedor = new Vendedor("NOME", "vendedor", "V", "s");
		Funcionario veterinario = new Veterinario("NOME", "Veterinario", "vet", "s");
		try {
			Fachada.getInstance().contFuncionarios().addFuncionario(gerente);
			Fachada.getInstance().contFuncionarios().addFuncionario(vendedor);
			Fachada.getInstance().contFuncionarios().addFuncionario(veterinario);
		}catch(CadastroInvalidoException cadastroInvalidoException) {
			System.out.println(cadastroInvalidoException.getMessage());
		}catch(FuncionarioJaExisteException fjee) {
			System.out.println(fjee.getMessage());
		}
		MainApp.main(args);
	}

}
