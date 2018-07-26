package br.ufrpe.Projeto_PetShop.exceptions;

public class LoginInvalidoException extends Exception{
	public LoginInvalidoException(){
		super("Login ou senha invalido.");
	}
}
