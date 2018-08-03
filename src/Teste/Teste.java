package Teste;
import br.ufrpe.Projeto_PetShop.MainApp;
import br.ufrpe.Projeto_PetShop.controller.Fachada;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.ClienteJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;

public class Teste {

	public static void main(String[] args) {
		Funcionario gerente = new Gerente("NOME", "gerente", "G", "s");
		Funcionario vendedor = new Vendedor("NOME", "vendedor", "V", "s");
		Funcionario veterinario = new Veterinario("NOME", "Veterinario", "vet", "s");
		Cliente Brenno = new Cliente("Brenno", "555.555.555-55", "Endereco", "email", 'M');
		Cliente cliente2 = new Cliente("Nome2", "cpf2", "Endereco", "email", 'F');
		Cliente cliente3 = new Cliente("Nome3", "cpf3", "Endereco", "email", 'O');
		Animal a = new Animal("Meg", "Vira-lata", 'F', Brenno);
		Animal b = new Animal("Frida", "Vira-lata", 'F', Brenno);
		Consulta consulta1 = new Consulta(a,(Veterinario)veterinario);
		Consulta consulta2 = new Consulta(b,(Veterinario)veterinario);
		try {
			Fachada.getInstance().contFuncionarios().addFuncionario(gerente);
			Fachada.getInstance().contFuncionarios().addFuncionario(vendedor);
			Fachada.getInstance().contFuncionarios().addFuncionario(veterinario);
			Fachada.getInstance().contClientes().cadastrarCliente(Brenno);
			Fachada.getInstance().contClientes().cadastrarCliente(cliente2);
			Fachada.getInstance().contClientes().cadastrarCliente(cliente3);
			Fachada.getInstance().contAnimais().addAnimal(a);
			Fachada.getInstance().contAnimais().addAnimal(b);
			Fachada.getInstance().contConsultas().addConsulta(consulta1);
			Fachada.getInstance().contConsultas().addConsulta(consulta2);
		}catch(CadastroInvalidoException cadastroInvalidoException) {
			System.out.println(cadastroInvalidoException.getMessage());
		}catch(FuncionarioJaExisteException fjee) {
			System.out.println(fjee.getMessage());
		}catch(ClienteJaExisteException cjee) {
			System.out.println(cjee.getMessage());
		}catch (NaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		MainApp.main(args);
	}

}
