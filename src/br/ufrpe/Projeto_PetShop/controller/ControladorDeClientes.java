package br.ufrpe.Projeto_PetShop.controller;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;

public class ControladorDeClientes {
	private IRepositorioCliente instanceRepCliente;
	public ControladorDeClientes(IRepositorioCliente instanceRepCliente){
		this.instanceRepCliente = instanceRepCliente;
	}
	public void cadastrarCliente(Cliente cliente) {
		if(cliente != null) {
			this.checarExistÍncia(cliente.getCpf());
			instanceRepCliente.addCliente(cliente);
		}
	}
	private void checarExistÍncia(String cpf){
		if(instanceRepCliente.getCliente(cpf)!=null) {
			//TODO por exceptions avisando se existe um cliente com o msm CPF
		}
	}
	public void removerCliente(String cpf) {
		this.checarExistÍncia(cpf);
		instanceRepCliente.removerCliente(cpf);
	}
	public Cliente getCliente(String cpf) {
		this.checarExistÍncia(cpf);
		return instanceRepCliente.getCliente(cpf);
	}
	
}
