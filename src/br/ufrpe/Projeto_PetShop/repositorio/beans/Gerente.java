package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Gerente extends Funcionario {
	
	public Gerente(String nome, String cpf, String login, String senha) {
		super.nome = nome;
		super.cpf = cpf;
		super.login = login;
		super.senha = senha;
	}
	@Override
	public void setNome(String nome) {
		super.nome = nome;
	}
	@Override
	public String getNome() {
		return super.nome;
	}
	@Override
	public void setCPF(String cpf) {
		super.cpf = cpf;
	}
	@Override
	public String getCPF() {
		return super.cpf;
	}
	@Override
	public void setLogin(String login) {
		super.login = login;
	}
	@Override
	public String getLogin() {
		return super.login;
	}
	@Override
	public void setSenha(String senha) {
		super.senha = senha;
	}
	@Override
	public String getSenha() {
		return super.senha;
	}
	@Override
	public String toString() {
		return "Cargo: Gerente"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
