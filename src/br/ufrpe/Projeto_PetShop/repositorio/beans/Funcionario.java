package br.ufrpe.Projeto_PetShop.repositorio.beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Funcionario {
	protected StringProperty nome;
	protected StringProperty cpf;
	protected StringProperty login;
	protected StringProperty senha;
	
	public Funcionario() {};
	public Funcionario(String nome, String cpf, String login, String senha) {}
	public void setNome(String nome) {
		this.nome = new SimpleStringProperty((String) nome);
	}
	public String getNome() {
		return this.nome.getValue();
	}
	public void setCpf(String cpf) {
		this.cpf = new SimpleStringProperty((String) cpf);
	}
	public String getCpf() {
		return this.cpf.getValue();
	}
	public void setLogin(String login) {
		this.login = new SimpleStringProperty((String) login);
	}
	public String getLogin() {
		return this.login.getValue();
	}
	public void setSenha(String senha) {
		this.senha = new SimpleStringProperty((String) senha);
	}
	public String getSenha() {
		return this.senha.getValue();
	}
	public boolean equals(Object funcionario) {
		return funcionario != null && ((Funcionario)funcionario).getNome().equals(this.nome.getValue())
		&& ((Funcionario)funcionario).getCpf().equals(this.cpf.getValue());
	}
	public String toString() {
		return "Nome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
