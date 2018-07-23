package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public class ControladorDeAnimais {
	private IRepositorioAnimal instanceRepAnimal;
	
	public ControladorDeAnimais(IRepositorioAnimal instanceRepAnimal) {
		this.instanceRepAnimal = instanceRepAnimal;
	}
	public void addAnimal(Animal animal) {
		if(animal != null && animal.getDono() != null
				&& animal.getNome() != null && animal.getRaca() != null) {
			instanceRepAnimal.addAnimal(animal);
		}
	}
	public void remover(String cpf,String nome) {
		if(cpf != null && nome != null) {
			instanceRepAnimal.remover(cpf, nome);
		}
	}
	public Animal getAnimal(String cpf, String nome) {
		if(cpf != null && nome != null) {
			return instanceRepAnimal.getAnimal(cpf, nome);
		}return null;
	}
	public Animal[] getAnimaisCliente(String cpf) {
		if(cpf != null) {
			return instanceRepAnimal.getAnimaisCliente(cpf);
		}return null;
	}
}
