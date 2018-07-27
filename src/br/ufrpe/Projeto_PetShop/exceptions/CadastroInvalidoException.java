package br.ufrpe.Projeto_PetShop.exceptions;

public class CadastroInvalidoException extends Exception{
	public CadastroInvalidoException() {
		super("O cadastro esta invalido.");
	}
}
