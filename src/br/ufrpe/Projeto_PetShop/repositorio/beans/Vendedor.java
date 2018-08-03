package br.ufrpe.Projeto_PetShop.repositorio.beans;

import javafx.beans.property.SimpleStringProperty;

public class Vendedor extends Funcionario {
	
	public Vendedor(String nome, String cpf, String login, String senha) {
		super.nome = new SimpleStringProperty(nome);
		super.cpf = new SimpleStringProperty(cpf);
		super.login = new SimpleStringProperty(login);
		super.senha = new SimpleStringProperty(senha);
	}
	@Override
	public String toString() {
		return "Cargo: Vendendor"+"\nNome: " + this.nome + "\nCPF: " + this.cpf;
	}
}
