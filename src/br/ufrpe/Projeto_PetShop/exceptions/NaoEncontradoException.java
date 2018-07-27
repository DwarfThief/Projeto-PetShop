package br.ufrpe.Projeto_PetShop.exceptions;

public class NaoEncontradoException extends Exception{
	public NaoEncontradoException(String tipo) {
		super(tipo + " nao encontrado."); //especificar o tipo, como: "Funcionario, cliente, veterinario, animal, ..."
	}
}
