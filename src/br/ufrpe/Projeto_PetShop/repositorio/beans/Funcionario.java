package br.ufrpe.Projeto_PetShop.repositorio.beans;

import javafx.beans.property.StringProperty;

public abstract class Funcionario {
	protected StringProperty nome;
	protected StringProperty cpf;
	protected StringProperty login;
	protected StringProperty senha;
	
	public Funcionario() {};
	public Funcionario(String nome, String cpf, String login, String senha) {}
	public void setNome(String nome) {
		this.nome.set(nome);;
	}
	public String getNome() {
		return this.nome.get();
	}
	public void setCpf(String cpf) {
		this.cpf.set(cpf);
	}
	public String getCpf() {
		return this.cpf.get();
	}
	public void setLogin(String login) {
		this.login.set(login);;
	}
	public String getLogin() {
		return this.login.get();
	}
	public void setSenha(String senha) {
		this.senha.set(senha);;
	}
	public String getSenha() {
		return this.senha.get();
	}
	public boolean equals(Object funcionario) {
		return funcionario != null && ((Funcionario)funcionario).getNome().equals(this.nome)
		&& ((Funcionario)funcionario).getCpf().equals(this.cpf);
	}
	public String toString() {
		return "Nome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
