package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public class RepositorioCliente implements IRepositorioCliente  {
	private static RepositorioCliente instance;
	
	private Cliente clientes[] = new Cliente[5];
	private int clientesTam = 0;
	
	public static RepositorioCliente getInstance() {
	    if (instance == null) {
	      instance = new RepositorioCliente();
	    }
	    return instance;
	}
	private RepositorioCliente () {}
	
	private Cliente procurarCliente (String cpf) {
		for(int i=0;i<clientesTam;i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				return clientes[i];
			}
		}
		return null;
	}	
	private int procurarPos(String cpf) {
		int i = 0;
        for(; i<this.clientesTam; i++) {
        	if(cpf.equals(this.clientes[i].getCpf())) {
        		return i;
        	}
        }
        return clientesTam;
	}	
	public void addCliente(Cliente cliente) {
		if(cliente != null && procurarCliente(cliente.getCpf()) == null) {
			if(this.clientesTam == this.clientes.length) {
				this.duplicaArray();
			}
			this.clientes[clientesTam]=cliente;
			this.clientesTam++;
		}
		//TODO exception
	}	
	public Cliente getCliente(String cpf) {
		return this.procurarCliente(cpf);
	}	
	public void removerCliente(String cpf) {
		int i = this.procurarPos(cpf);
		if (i != this.clientesTam) {
            this.clientes[i] = this.clientes[this.clientesTam - 1];
            this.clientes[this.clientesTam - 1] = null;
            this.clientesTam = this.clientesTam - 1;
        } else {
        	//TODO exception
        }
	}	
	private void duplicaArray() {
        if (this.clientes != null && this.clientes.length > 0) {
            Cliente[] arrayDuplicado = new Cliente[this.clientes.length * 2];
            for (int i = 0; i < this.clientes.length; i++) {
                arrayDuplicado[i] = this.clientes[i];
            }
            this.clientes = arrayDuplicado;
        }
    }
}
