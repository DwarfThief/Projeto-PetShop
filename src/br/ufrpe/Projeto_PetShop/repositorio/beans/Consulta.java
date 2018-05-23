package br.ufrpe.Projeto_PetShop.repositorio.beans;

import java.time.LocalDate;

public class Consulta {
	private Animal animal;
	private Veterinario medico;
	private LocalDate time;
	
	public Animal getAnimal() {
		return animal;
	}
	
	public Veterinario getMedico() {
		return medico;
	}
	
	public LocalDate getTime() {
		return time;
	}
	
	public void consulta(Animal nome, Veterinario medico) {
		this.animal=nome;
		this.medico=medico;
		this.time = LocalDate.now();
	}
	
	public String toString() {
		return animal.getNome() + " foi consultado por " + medico.getNome() + " as " + time;
	}
}
