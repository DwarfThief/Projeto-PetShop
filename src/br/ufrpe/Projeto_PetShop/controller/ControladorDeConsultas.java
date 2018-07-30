package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class ControladorDeConsultas {
	private IRepositorioConsulta instanceRepConsulta;
	
	public ControladorDeConsultas(IRepositorioConsulta instanceRepConsulta) {
		this.instanceRepConsulta = instanceRepConsulta;
	}
	/**
	 * Adiciona consulta no repositório.
	 * @param consulta
	 * @throws CadastroInvalidoException
	 */
	public void addConsulta(Consulta consulta) throws CadastroInvalidoException {
		if(consulta != null && consulta.getAnimal() != null && consulta.getTime() != null 
				&& consulta.getVeterinario() != null) {
			instanceRepConsulta.addConsulta(consulta);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Retorna consulta.
	 * @param veterinario
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param nomeAnimal
	 * @return Consulta
	 * @throws CadastroInvalidoException
	 * @throws NaoEncontradoException
	 */
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) throws CadastroInvalidoException, NaoEncontradoException {
		if(veterinario != null && dia!= 0 && dia <=31 && mes <= 12 && mes > 0 && ano > 0 
				&& nomeAnimal != null ) {
			return instanceRepConsulta.getConsulta(veterinario, dia, mes, ano, nomeAnimal);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Remove consulta do array.
	 * @param consulta
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public void removerConsulta(Consulta consulta) throws NaoEncontradoException, CadastroInvalidoException{
		if(consulta != null && consulta.getAnimal() != null && consulta.getVeterinario() != null && consulta.getTime() != null) {
			instanceRepConsulta.removerConsulta(consulta);
		}else {
			throw new CadastroInvalidoException();
		}
	}
}
