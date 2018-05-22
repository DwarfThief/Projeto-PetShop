package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Animal {
	private	String nome;
	private String raca;
	private char sexo;
	
	public Animal(String nome, String raca, char sexo) {
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
	}
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return this.raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String toString() {
		return "Nome: " + this.nome 
				+ " Sexo: " + this.sexo 
				+ "\nRaca: " + this.raca;
	}
}
