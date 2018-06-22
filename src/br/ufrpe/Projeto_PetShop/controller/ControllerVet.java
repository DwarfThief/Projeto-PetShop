package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class ControllerVet {
	private IRepositorioAnimal instanceRepAnimal;
	private IRepositorioConsulta instanceRepConsulta;
	public ControllerVet(IRepositorioConsulta instanceRepConsulta, IRepositorioAnimal instanceRepAnimal) {
		this.instanceRepAnimal = instanceRepAnimal;
		this.instanceRepConsulta = instanceRepConsulta;
	}
	public void addConsulta(Consulta consulta) {
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
