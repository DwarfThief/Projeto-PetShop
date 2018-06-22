package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public interface IRepositorioConsulta {
	public void addConsulta(Consulta consulta);
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal);
	public void removerConsulta(Consulta consulta);
}
