package br.ufrpe.Projeto_PetShop.exceptions;

public class ClienteJaExisteException extends Exception {
	private String cpf;
	public ClienteJaExisteException(String cpf) {
		super("Esse cpf ja foi cadastrado./nCPF: " + cpf);
		this.cpf = cpf;
	}
}
