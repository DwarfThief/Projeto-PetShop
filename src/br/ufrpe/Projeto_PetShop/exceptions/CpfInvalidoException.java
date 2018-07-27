package br.ufrpe.Projeto_PetShop.exceptions;

public class CpfInvalidoException extends Exception{

	public CpfInvalidoException(){
		super("O CPF é inválido");
	}
}
