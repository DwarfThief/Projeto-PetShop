package br.ufrpe.Projeto_PetShop.repositorio.beans;

import javafx.beans.property.SimpleStringProperty;

public class Veterinario extends Funcionario {
	
	public Veterinario(String nome, String cpf, String login, String senha) {
		super.nome = new SimpleStringProperty((String) nome);
		super.cpf = new SimpleStringProperty((String) cpf);
		super.login = new SimpleStringProperty((String) login);
		super.senha = new SimpleStringProperty((String) senha);
	}
	@Override
	public String toString() {
		return "Cargo: Veterinario"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
