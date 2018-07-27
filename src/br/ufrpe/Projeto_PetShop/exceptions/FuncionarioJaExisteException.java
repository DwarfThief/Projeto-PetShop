package br.ufrpe.Projeto_PetShop.exceptions;

public class FuncionarioJaExisteException extends Exception{
	private String cpf;
	
	public FuncionarioJaExisteException(String cpf) {
		super("O funcionario " + cpf + " ja esta cadastrado.");
		this.cpf = cpf;
	}
}
