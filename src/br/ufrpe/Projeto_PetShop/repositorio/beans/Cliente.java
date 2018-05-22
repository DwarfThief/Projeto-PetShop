package br.ufrpe.Projeto_PetShop.repositorio.beans;

import java.util.ArrayList;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private char sexo;
	private ArrayList<Animal> animais;
	
	public Cliente(String nome, String endereco, String telefone,
			String cpf, char sexo, Animal animal) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.sexo = sexo;
		this.animais.add(animal);
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getSexo() {
		return this.sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
