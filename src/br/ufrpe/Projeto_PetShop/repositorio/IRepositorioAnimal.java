package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public interface IRepositorioAnimal {
	public void addAnimal(Animal animals);
	public Animal getAnimal(String cpf, String nome);
	public void removerAnimal(String cpf, String nome);
}
