package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.ClienteJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public interface IRepositorioCliente {
	/**
	 * Remove cliente do repositório.
	 * @param cpf
	 * @throws NaoEncontradoException
	 */
	public void removerCliente(String cpf) throws NaoEncontradoException;
	/**
	 * Retorna cliente do banco de dados
	 * @param cpf
	 * @return cliente
	 * @throws NaoEncontradoException
	 */
	public Cliente getCliente(String cpf) throws NaoEncontradoException;
	/**
	 * Adiciona clientes no banco de dados.
	 * @param cliente
	 * @throws ClienteJaExisteException
	 */
	public void addCliente(Cliente cliente) throws ClienteJaExisteException;
	/**
	 * Retorna o array com todos os clientes do repositório.
	 * @return Clientes[] cliente
	 */
	public Cliente[] getClienteArray();
}
