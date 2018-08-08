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
	/**
	 * Retorna a localização do cliente de acordo com o array que ele esta localizado.
	 * @param cpf, String com o cpf que sera usado para a busca.
	 * @return pos, retorna um int referente a posição do cliente no array.
	 * @throws NaoEncontradoException, envia uma Exception quando o cliente não é encontrado no array.
	 */
	public int getClientePos(String cpf) throws NaoEncontradoException;
	/**
	 * Edita o cliente no array do repositório.
	 * @param pos, posição para trocar o cliente.
	 * @param cliente, recebe o cliente que ira substituir no array
	 */
	public void setCliente(int pos, Cliente cliente);
}
