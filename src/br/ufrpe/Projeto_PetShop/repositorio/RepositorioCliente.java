package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.ClienteJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

import java.io.Serializable;

public class RepositorioCliente implements IRepositorioCliente, Serializable {
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
	/**
	 * Procura se o cpf usado como parametro esta cadastrado em algum cliente.
	 * @param cpf
	 * @return cliente, caso encontre um cliente com esse cpf.
	 * @return null, caso não exista cliente com esse cpf.
	 */
	private Cliente procurarCliente (String cpf) {
		for(int i=0;i<clientesTam;i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				return clientes[i];
			}
		}
		return null;
	}
	/**
	 * Procura a posicao de determinado cliente a partir do seu cpf.
	 * @param cpf
	 * @return i
	 */
	private int procurarPos(String cpf)throws NaoEncontradoException {
        for(int i = 0; i<this.clientesTam; i++) {
        	if(cpf.equals(this.clientes[i].getCpf())) {
        		return i;
        	}
        }
        throw new NaoEncontradoException("Cliente");
	}
	@Override
	public void addCliente(Cliente cliente) throws ClienteJaExisteException {
		if(cliente != null && procurarCliente(cliente.getCpf()) == null) {
			if(procurarCliente(cliente.getCpf()) == null) {
				if(this.clientesTam == this.clientes.length) {
					this.duplicaArray();
				}
				this.clientes[clientesTam]=cliente;
				this.clientesTam++;
			}else {
				throw new ClienteJaExisteException(cliente.getCpf());
			}
		}
	}
	@Override
	public Cliente getCliente(String cpf) throws NaoEncontradoException {
		Cliente c = this.procurarCliente(cpf);
		if(c!=null) {
			return c;
		}else {
			throw new NaoEncontradoException("Cliente");
		}
	}
	@Override
	public void removerCliente(String cpf) throws NaoEncontradoException {
		int i = this.procurarPos(cpf);
		if (i != this.clientesTam) {
            this.clientes[i] = this.clientes[this.clientesTam - 1];
            this.clientes[this.clientesTam - 1] = null;
            this.clientesTam = this.clientesTam - 1;
        }else {
        	throw new NaoEncontradoException("Cliente");
        }
	}
	/**
	 * Serve para duplicar o tamanho do arry do repositório
	 */
	private void duplicaArray() {
        if (this.clientes != null && this.clientes.length > 0) {
            Cliente[] arrayDuplicado = new Cliente[this.clientes.length * 2];
            for (int i = 0; i < this.clientes.length; i++) {
                arrayDuplicado[i] = this.clientes[i];
            }
            this.clientes = arrayDuplicado;
        }
    }
	public Cliente[] getClienteArray() {
		return clientes;
	}

	@Override
	public int getClientePos(String cpf) throws NaoEncontradoException{
		return this.procurarPos(cpf);
	}

	@Override
	public void setCliente(int pos, Cliente cliente) {
		this.clientes[pos] = cliente;
	}
}
