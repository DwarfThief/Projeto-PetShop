package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Veterinario extends Funcionario {
	
	public Veterinario(String nome, String cpf, String login, String senha) {
		super.nome = nome;
		super.cpf = cpf;
		super.login = login;
		super.senha = senha;
	}
	@Override
	public String toString() {
		return "Cargo: Veterinario"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
