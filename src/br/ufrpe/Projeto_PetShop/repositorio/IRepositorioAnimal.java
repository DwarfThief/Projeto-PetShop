package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public interface IRepositorioAnimal{
	/**
	 * Adicionar o animal no repositório
	 * @param animal
	 */
	public void addAnimal(Animal animal);
	/**
	 * Remove animal do repositório
	 * @param cpf
	 * @param nome
	 * @throws NaoEncontradoException
	 */
	public void remover(String cpf,String nome) throws NaoEncontradoException;
	/**
	 * Retorna animal
	 * @param cpf
	 * @param nome
	 * @return animal
	 * @throws NaoEncontradoException
	 */
	public Animal getAnimal(String cpf, String nome) throws NaoEncontradoException;
	/**
	 * Retorna um array contendo todos os animais de um mesmo dono.
	 * @param cpf
	 * @return animais[]
	 */
	public Animal[] getAnimaisCliente(String cpf);
}
