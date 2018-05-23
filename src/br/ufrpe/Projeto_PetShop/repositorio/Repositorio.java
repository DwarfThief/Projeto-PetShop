package br.ufrpe.Projeto_PetShop.repositorio;

import java.time.LocalDate;

import br.ufrpe.Projeto_PetShop.repositorio.beans.*;

public class Repositorio{
	private Funcionario funcionarios[] = new Funcionario[5];
	private Cliente clientes[] = new Cliente[5];
	private Consulta consultas[];
	private int consultasTam = 0;
	private int clientesTam = 0;
	private int funcionariosTam = 0;
	
	
	public Repositorio() {}

	private Consulta procurarConsulta(Animal animal, LocalDate data, Veterinario veterinario) {
		for(int i = 0 ; i < consultasTam ; i++) {
			if(animal.equals(consultas[i].getAnimal()) 
					&& data.equals(consultas[i]) && veterinario.equals(consultas[i].getVeterinario())) {
				return consultas[i];
			}
		}
		return null;
	}
	private Funcionario procurarFuncionario(String cpf) {
		for(int i = 0; i < funcionariosTam; i++) {
			if(funcionarios[i].getCPF().equals(cpf)) {
				return funcionarios[i];
			}
		}
		return null;
	}
	private Cliente procurarCliente(String cpf) {
		for(int i = 0; i < clientesTam; i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				return clientes[i];
			}
		}
		return null;
	}
	public void addFuncionario(String nome, String cpf, String senha, String login, String tipo) {
		if(tipo.equals("Gerente")) {
			this.funcionarios[this.funcionariosTam] = new Gerente(nome, cpf, login, senha);
		}else if(tipo.equals("Veterinario")) {
			this.funcionarios[this.funcionariosTam] = new Veterinario(nome, cpf, login, senha);
		}else if(tipo.equals("Vendendor")) {
			this.funcionarios[this.funcionariosTam] = new Vendendor(nome, cpf, login, senha);
		}
		this.funcionariosTam++;
	}
	public Funcionario getFuncionario(String cpf) {
		return this.procurarFuncionario(cpf);
	}
	public void addCliente(String nome, String cpf, String endereco, String telefone,
			Animal animal ,char sexo) {
		this.clientes[this.clientesTam] = new Cliente(nome, endereco, telefone,
				cpf, sexo, animal);
		this.clientesTam++;
	}
	public Cliente getCliente(String cpf) {
		return procurarCliente(cpf);
	}
	public Consulta getConsultas(Animal animal, LocalDate data, Veterinario veterinario) {
		return procurarConsulta(animal, data, veterinario);
	}
}
