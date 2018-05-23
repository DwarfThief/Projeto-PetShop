package br.ufrpe.Projeto_PetShop.repositorio.beans;

import java.time.LocalDate;

public class Consulta {
	private Animal animal;
	private Veterinario veterinario;
	private LocalDate time;
	
	public Animal getAnimal() {
		return animal;
	}
	
	public Veterinario getVeterinario() {
		return veterinario;
	}
	
	public LocalDate getTime() {
		return time;
	}
	
	public void consulta(Animal nome, Veterinario medico) {
		this.animal=nome;
		this.veterinario = medico;
		this.time = LocalDate.now();
	}
	
	public String toString() {
		return this.animal.getNome() + " foi consultado por " + this.veterinario.getNome() + " as " + time;
	}
}
