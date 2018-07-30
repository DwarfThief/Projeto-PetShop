package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public class ControladorDeAnimais {
	private IRepositorioAnimal instanceRepAnimal;
	
	public ControladorDeAnimais(IRepositorioAnimal instanceRepAnimal) {
		this.instanceRepAnimal = instanceRepAnimal;
	}
	/**
	 * Checa e adiciona um animal
	 * @param animal
	 * @throws CadastroInvalidoExceptions
	 */
	public void addAnimal(Animal animal) throws CadastroInvalidoException {
		if(animal != null && animal.getDono() != null 
				&& Fachada.getInstance().contClientes().getCliente(animal.getDono().getCpf()) != null
				&& animal.getNome() != null && animal.getRaca() != null) {
			instanceRepAnimal.addAnimal(animal);
		}
		else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Remove animal
	 * @param cpf
	 * @param nome
	 * @throws NaoEncontradoException 
	 */
	public void remover(String cpf,String nome) throws CadastroInvalidoException, NaoEncontradoException{
		if(cpf != null && nome != null) {
			instanceRepAnimal.remover(cpf, nome);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Retorna animal
	 * @param cpf
	 * @param nome
	 * @return animal
	 * @throws NaoEncontradoException
	 */
	public Animal getAnimal(String cpf, String nome) throws NaoEncontradoException {
		if(cpf != null && nome != null) {
			return instanceRepAnimal.getAnimal(cpf, nome);
		}return null;
	}
	/**
	 * Retorna um array contendo todos os animais do mesmo cliente.
	 * @param cpf
	 * @return
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public Animal[] getAnimaisCliente(String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		if(cpf != null) {
			Animal[] a =instanceRepAnimal.getAnimaisCliente(cpf);
			if(a!=null) {
				return a;
			}
			else{
				throw new NaoEncontradoException("Lista de animais");
			}
		}else {
			throw new CadastroInvalidoException();
		}
	}
}
