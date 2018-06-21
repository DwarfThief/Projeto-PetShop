package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.*;

public class ControllerVendendor {
	private IRepositorioCliente instanceRepCliente;
	private IRepositorioAnimal instanceRepAnimal;
	private IRepositorioConsulta instanceRepConsulta;
	public ControllerVendendor(IRepositorioCliente instanceRepCliente, IRepositorioConsulta instanceRepConsulta
			, IRepositorioAnimal instanceRepAnimal) {
		this.instanceRepCliente = instanceRepCliente;
		this.instanceRepAnimal = instanceRepAnimal;
		this.instanceRepConsulta = instanceRepConsulta;
	}
	public void cadastrarCliente(Cliente cliente) {
		if(cliente != null) {
			instanceRepCliente.addCliente(cliente);
		}
	}
	public void cadastrarCliente(String nome, String endereco, String telefone,
			String cpf, char sexo) {
		if(nome != null && endereco != null && telefone != null &&
			cpf !=null && sexo != "".charAt(0)) {
			Cliente cliente = new Cliente(nome, endereco, telefone, cpf, sexo);
			instanceRepCliente.addCliente(cliente);
		}		
	}
	public Cliente getCliente(String cpf) {
		if(cpf != null) {
			Cliente cliente = instanceRepCliente.getCliente(cpf);
			if(cliente != null) {
				return cliente;
			}
		}
		return null;
	}
	public void cadastrarAnimal(String nome, String raca, char sexo, Cliente dono) {
		if(nome != null && raca != null && sexo!="".charAt(0) && dono != null) {
			instanceRepAnimal.addAnimal(new Animal(nome, raca, sexo, dono));
		}
	}
	public void cadastrarAnimal(Animal animal) {
		if(animal != null) {
			instanceRepAnimal.addAnimal(animal);
		}
	}
	public Animal getAnimal(String cpf, String nome) {
		if(cpf != null && nome != null) {
			Animal animal = instanceRepAnimal.getAnimal(cpf, nome);
			if(animal!= null) {
				return animal;
			}
		}
		return null;
	}
	public Animal getAnimal(Cliente cliente, String nome) {
		if(cliente !=null && nome !=null) {
			Animal animal = instanceRepAnimal.getAnimal(cliente.getCpf(), nome);
			if(animal != null) {
				return animal;
			}
		}
		return instanceRepAnimal.getAnimal(cliente.getCpf(), nome);
	}
	public Animal[] getAnimaisDono(String cpf) {
		if(cpf != null) {
			Animal[] animais = instanceRepAnimal.getAnimaisCliente(cpf);
			if(animais != null) {
				return animais;
			}
		}
		return null;
	}
	public Animal[] getAnimaisDono(Cliente cliente) {
		return this.getAnimaisDono(cliente.getCpf());
	}
	public void removerCliente(String cpf, String nome) {
		instanceRepAnimal.remover(cpf, nome);
	}
	public void removerCliente(Cliente cliente, String nome) {
		instanceRepAnimal.remover(cliente.getCpf(), nome);
	}
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) {
		if(veterinario != null && nomeAnimal!=null) {
			return this.instanceRepConsulta.getConsulta(veterinario, dia, mes, ano, nomeAnimal);
		}
		return null;
	}
}
