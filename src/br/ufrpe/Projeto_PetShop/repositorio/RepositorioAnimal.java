package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;

public class RepositorioAnimal implements IRepositorioAnimal {
	Animal animais[] = new Animal[5];
	int animaisTam = 0;
	@Override
	public void addAnimal(Animal animal) {
		if(animal != null) {
			if(this.animaisTam == this.animais.length) {
				this.duplicarArray();
			}
			this.animais[animaisTam] = animal;
			this.animaisTam++;
		}
		// TODO exceptions
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
	@Override
	public Animal getAnimal(String cpf, String nome) {
		return this.procurarAnimal(cpf, nome);
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
	public void removerAnimal(String cpf, String nome) {
		int i = this.procurarPos(cpf, nome);
		if (i != this.animaisTam) {
            this.animais[i] = this.animais[this.animaisTam - 1];
            this.animais[this.animaisTam - 1] = null;
            this.animaisTam = this.animaisTam - 1;
        } else {
            //TODO exception
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
