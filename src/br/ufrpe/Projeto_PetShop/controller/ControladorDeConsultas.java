package br.ufrpe.Projeto_PetShop.controller;

import javax.management.InstanceNotFoundException;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class ControladorDeConsultas {
	private IRepositorioConsulta instanceRepConsulta;
	
	public ControladorDeConsultas(IRepositorioConsulta instanceRepConsulta) {
		this.instanceRepConsulta = instanceRepConsulta;
	}
	
	public void addConsulta(Consulta consulta) {
		if(consulta != null && consulta.getAnimal() != null && consulta.getTime() != null 
				&& consulta.getVeterinario() != null) {
			instanceRepConsulta.addConsulta(consulta);
		}
	}
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) {
		if(veterinario != null && dia!= 0 && dia <=31 && mes <= 12 && mes > 0 && ano > 0 
				&& nomeAnimal != null ) {
			return instanceRepConsulta.getConsulta(veterinario, dia, mes, ano, nomeAnimal);
		}return null;
	}
	public void removerConsulta(Consulta consulta) {
		if(consulta != null) {
			instanceRepConsulta.removerConsulta(consulta);
		}
	}
}
