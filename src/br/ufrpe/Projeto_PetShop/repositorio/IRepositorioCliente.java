package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public interface IRepositorioCliente {
	public void removeCliente(String cpf);
	public Cliente getCliente(String cpf);
	public void addCliente(Cliente cliente);
}
