package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public interface IRepositorioAnimal{
	public void addAnimal(Animal animal);
	public void remover(String cpf,String nome);
	public Animal getAnimal(String cpf, String nome);
	public Animal[] getAnimaisCliente(String cpf);//usado apenas no repositorio de Animal
}
