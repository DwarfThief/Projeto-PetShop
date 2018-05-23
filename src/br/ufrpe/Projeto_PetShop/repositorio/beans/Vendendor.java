package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Vendendor extends Funcionario {
	
	public Vendendor(String nome, String cpf, String login, String senha) {
		super.nome = nome;
		super.cpf = cpf;
		super.login = login;
		super.senha = senha;
	}
	@Override
	public String toString() {
		return "Cargo: Vendendor"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
