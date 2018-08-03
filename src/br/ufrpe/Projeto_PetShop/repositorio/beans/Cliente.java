package br.ufrpe.Projeto_PetShop.repositorio.beans;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String cpf;
	private char sexo;
	
	public Cliente(String nome,String cpf , String telefone,
			String endereco, char sexo) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.sexo = sexo;
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
	public boolean equals(Object o) {
		Cliente outro = (Cliente) o;
		return this.nome.equals(outro.getNome()) && this.cpf.equals(outro.getCpf())
				&& this.endereco.equals(outro.getEndereco()) && this.sexo == outro.getSexo()
				&& this.telefone.equals(outro.getTelefone());
	}
	public String toString() {
		String text = "Nome: " + this.nome + "\nCPF: " + this.cpf +"\n Sexo: "+ this.cpf 
			+ "\nTelefone: "+ this.telefone + "\nEndereco: " + this.endereco;
		return text;
	}
	
}