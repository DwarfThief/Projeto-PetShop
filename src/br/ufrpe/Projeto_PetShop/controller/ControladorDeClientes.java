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

	/**
	 * Retorna a posição do cliente no Array.
	 * @param cpf, String com o cpf do cliente para buscar no banco de dados.
	 * @return	pos, int referente a posição do cliente no Array.
	 * @throws NaoEncontradoException, enviada quando o cliente não é encontrado no banco de dados.
	 * @throws CadastroInvalidoException, enviado quando o cadastro não foi efetivado corretamente.
	 */
	public int getClientePos(String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		if(cpf != null && cpf != ""){
			return instanceRepCliente.getClientePos(cpf);
		}else{
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Altera os valores do cliente da posição que é passada como parametro para as do novo cliente que foi passada no
	 * parametro
	 * @param pos, int referente a posição do cliente que será modificado.
	 * @param cliente, envia uma instância do cliente que carregara toda a mudança.
	 */
	public void setCliente(int pos, Cliente cliente){
		if(pos>=0 && cliente!=null && cliente.getCpf() != null && cliente.getEndereco() != null && cliente.getNome() !=null
			&& (cliente.getSexo() == 'F'||cliente.getSexo() == 'M' || cliente.getSexo() == 'O') &&
				cliente.getTelefone() != null){
			instanceRepCliente.setCliente(pos, cliente);
		}
	}
}
