package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

import java.io.Serializable;

public class RepositorioAnimal implements IRepositorioAnimal, Serializable {
	private static RepositorioAnimal instance;
	
	private Animal animais[] = new Animal[5];
	private int animaisTam = 0;
	
	
	public static RepositorioAnimal getInstance() {
	    if (instance == null) {
	      instance = new RepositorioAnimal();
	    }
	    return instance;
	}
	private RepositorioAnimal() {}
	@Override
	public void addAnimal(Animal animal) {
		if(animal == null) {
			if(this.animaisTam == this.animais.length) {
				this.duplicarArray();
			}
			this.animais[animaisTam] = animal;
			this.animaisTam++;
		}
	}
	private void duplicarArray() {
		if (this.animais != null && this.animais.length > 0) {
            Animal[] arrayDuplicado = new Animal[this.animais.length * 2];
            for (int i = 0; i < this.animais.length; i++) {
                arrayDuplicado[i] = this.animais[i];
            }
            this.animais = arrayDuplicado;
        }		
	}
	public Animal getAnimal(String cpf, String nome) throws NaoEncontradoException{
		Animal i = procurarAnimal(cpf, nome);
		if(i!= null) {
			return i;
		}else {
			throw new NaoEncontradoException("Animal");
		}
	}
	@Override
	public Animal[] getAnimaisCliente(String cpf) {
		Animal[] donos = new Animal[1];
		int donosTam = 0;
		for(int i = 0 ; i<animaisTam ; i++ ) {
			if(animais[i].getDono().getCpf().equals(cpf)) {
				donos[donosTam] = animais[i];
				donosTam++;
				if(donosTam>donos.length) {
					Animal[] arrayDuplicado = new Animal[donos.length * 2];
		            for (int x = 0; x < donos.length ; x++) {
		                arrayDuplicado[i] = donos[i];
		            }
		            donos = arrayDuplicado;
				}
				
			}
		}
		return donos;
	}
	private Animal procurarAnimal(String cpf, String nome) {
		for(int i=0;i<animaisTam;i++) {
			if(animais[i].getNome().equals(nome) && animais[i].getDono().getCpf().equals(cpf)) {
				return animais[i];
			}
		}
		return null;
	}
	@Override
	public void remover(String cpf, String nome) throws NaoEncontradoException {
		int i = this.procurarPos(cpf, nome);
		if (i != this.animaisTam) {
            this.animais[i] = this.animais[this.animaisTam - 1];
            this.animais[this.animaisTam - 1] = null;
            this.animaisTam = this.animaisTam - 1;
        } else {
            throw new NaoEncontradoException("Animal");
        }
	}
	private int procurarPos(String cpf, String nome) {
		int i = 0;
        for(; i<this.animaisTam; i++) {
        	if(nome.equals(animais[i].getNome()) && cpf.equals(this.animais[i].getDono().getCpf())) {
        		return i;
        	}
        }
        return animaisTam;
	}
}
