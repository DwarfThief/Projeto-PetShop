package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public interface IRepositorioConsulta {
	public void addConsulta(Consulta consulta) throws CadastroInvalidoException;
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) throws NaoEncontradoException;
	public void removerConsulta(Consulta consulta) throws NaoEncontradoException;
}
