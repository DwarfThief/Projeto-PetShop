package br.ufrpe.Projeto_PetShop.repositorio.beans;

public abstract class Funcionario {
	protected String nome;
	protected String cpf;
	protected String login;
	protected String senha;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	public String getCPF() {
		return this.cpf;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return this.login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return this.senha;
	}
	public boolean equals(Object funcionario) {
		return funcionario != null && ((Funcionario)funcionario).getNome().equals(this.nome)
		&& ((Funcionario)funcionario).getCPF() == this.cpf;
	}
	public String toString() {
		return "Nome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
