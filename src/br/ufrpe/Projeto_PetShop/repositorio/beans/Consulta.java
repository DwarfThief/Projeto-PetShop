package br.ufrpe.Projeto_PetShop.repositorio.beans;

import java.time.LocalDateTime;

public class Consulta {
	private Animal animal;
	private Veterinario veterinario;
	private LocalDateTime data;
	
	public Consulta(Animal nome, Veterinario medico) {
		this.animal=nome;
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
	
	
	public String toString() {
		return this.animal.getNome() + " foi consultado por " + this.veterinario.getNome() + " as " + data;
	}
}
