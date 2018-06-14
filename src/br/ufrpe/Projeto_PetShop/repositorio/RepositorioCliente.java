package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public class RepositorioCliente {
	private Cliente clientes[]=new Cliente[5];
	private int clientesTam=0;
	
	public RepositorioCliente () {}
	
	private Cliente procurarCliente (String cpf) {
		for(int i=0;i<clientesTam;i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				return clientes[i];
			}
		}
		return null;
	}
	
	public void adicionarCliente(Cliente cliente) {
		this.clientes[clientesTam]=cliente;
		clientesTam++;
	}
	
	public Cliente getCliente(String cpf) {
		return this.procurarCliente(cpf);
	}
	
	public void removeFuncionario(String cpf) {
		for(int i=0;i<clientesTam;i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				this.clientes[i]=this.clientes[clientesTam-1];
				this.clientes[clientesTam-1]=null;
				clientesTam--;
			}
		}
	}
}
