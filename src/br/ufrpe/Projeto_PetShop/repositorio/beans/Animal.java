package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Animal {
	private	String nome;
	private String raca;
	private char sexo;
	private Cliente dono;
	
	public Animal(String nome, String raca, char sexo, Cliente dono) {
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.dono = dono;
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
	public Cliente getDono() {
		return this.dono;
	}
	public void setCliente(Cliente dono) {
		this.dono = dono;
	}
	public boolean equals(Object o) {
		Animal outro = (Animal) o;
		return this.nome.equals(outro.getNome()) && this.raca.equals(outro.getRaca()) && this.sexo == outro.getSexo();
	}
	public String toString() {
		return "Nome: " + this.nome 
				+ " Sexo: " + this.sexo 
				+ "\nRaca: " + this.raca;
	}
}
