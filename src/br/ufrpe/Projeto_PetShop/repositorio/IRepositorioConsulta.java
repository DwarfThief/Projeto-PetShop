package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public interface IRepositorioConsulta {
	public void addConsulta(Consulta consulta);
	public Consulta getConsulta(Consulta consulta);
	public void removerConsulta(Consulta consulta);
}
