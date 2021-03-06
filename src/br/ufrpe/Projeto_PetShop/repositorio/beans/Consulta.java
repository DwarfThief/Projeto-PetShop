package br.ufrpe.Projeto_PetShop.repositorio.beans;

import java.time.LocalDateTime;

public class Consulta {
	private Animal animal;
	private Veterinario veterinario;
	private LocalDateTime data;
	
	public Consulta(Animal animal, Veterinario medico) {
		this.animal= animal;
		this.veterinario = medico;
		this.data = LocalDateTime.now();
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	public Veterinario getVeterinario() {
		return veterinario;
	}
	public LocalDateTime getTime() {
		return data;
	}	
	public boolean equals(Object consulta) {
		if(consulta != null){
			return (((Consulta)consulta).getAnimal().equals(this.animal) && ((Consulta)consulta).getVeterinario().equals(this.veterinario));
		}else{
			return false;
		}
	}
	public String toString() {
		return this.animal.getNome() + " foi consultado por " + this.veterinario.getNome() + " as " + this.data;
	}
	public String getDonoNome() {
		return this.animal.getDono().getNome();
	}
	public String getAnimalNome() {
		return this.animal.getNome();
	}
}
