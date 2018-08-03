package br.ufrpe.Projeto_PetShop.controller;
import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.ClienteJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public class ControladorDeClientes {
	private IRepositorioCliente instanceRepCliente;

	public ControladorDeClientes(IRepositorioCliente instanceRepCliente){
		this.instanceRepCliente = instanceRepCliente;
	}
	/**
	 * Adiciona o cliente no repositório.
	 * @param cliente
	 * @throws NaoEncontradoException
	 * @throws ClienteJaExisteException
	 * @throws CadastroInvalidoException
	 */
	public void cadastrarCliente(Cliente cliente) throws NaoEncontradoException, ClienteJaExisteException, CadastroInvalidoException {
		if(cliente != null && cliente.getCpf() != null && cliente.getEndereco() != null && cliente.getNome() != null 
				&&  cliente.getTelefone() != null) {
			instanceRepCliente.addCliente(cliente);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Remove o cliente.
	 * @param cpf
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public void removerCliente(String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		if(cpf!=null) {
			instanceRepCliente.removerCliente(cpf);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Retorna cliente.
	 * @param cpf
	 * @return
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public Cliente getCliente(String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		if(cpf!=null) {
			return instanceRepCliente.getCliente(cpf);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Retorna array de clientes.
	 * @return
	 */
	public Cliente[] getClientesArray() {
		return instanceRepCliente.getClienteArray();
	}
}
