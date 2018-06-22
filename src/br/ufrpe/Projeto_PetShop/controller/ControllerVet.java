package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;

public class ControllerVet {
	private IRepositorioAnimal instanceRepAnimal;
	private IRepositorioConsulta instanceRepConsulta;
	public ControllerVet(IRepositorioConsulta instanceRepConsulta, IRepositorioAnimal instanceRepAnimal) {
		this.instanceRepAnimal = instanceRepAnimal;
		this.instanceRepConsulta = instanceRepConsulta;
	}
	public void addConsulta(Animal animal, Veterinario medico) {
		Consulta consulta = new Consulta(animal, medico);
		if(consulta!=null) {
			this.instanceRepConsulta.addConsulta(consulta);
		}
	}
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) {
		if(veterinario != null && nomeAnimal!=null) {
			return this.instanceRepConsulta.getConsulta(veterinario, dia, mes, ano, nomeAnimal);
		}
		return null;
	}
	public void removerConsulta(Consulta consulta) {
		if(consulta!=null) {
			this.instanceRepConsulta.removerConsulta(consulta);
		}
	}
}
