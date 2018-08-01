package br.ufrpe.Projeto_PetShop.repositorio.beans;

import javafx.beans.property.SimpleStringProperty;

public class Gerente extends Funcionario {
	
	public Gerente(String nome, String cpf, String login, String senha) {
		super.nome = new SimpleStringProperty((String) nome);
		super.cpf = new SimpleStringProperty((String) cpf);
		super.login = new SimpleStringProperty((String) login);
		super.senha = new SimpleStringProperty((String) senha);
	}
	@Override
	public String toString() {
		return "Cargo: Gerente"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
