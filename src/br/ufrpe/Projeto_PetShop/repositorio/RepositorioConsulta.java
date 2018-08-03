package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class RepositorioConsulta implements IRepositorioConsulta{
	private static RepositorioConsulta instance;
	
	private Consulta consultas[]=new Consulta[5];
	private int consultasTam=0;

	/**
	 * Retorna uma única instancia, limitando criação
	 * @return instance
	 */
	public static RepositorioConsulta getInstance() {
	    if (instance == null) {
	      instance = new RepositorioConsulta();
	    }
	    return instance;
	}
	private RepositorioConsulta() {}
	/**
	 * Procura a msm consulta.
	 * @param veterinario
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param nomeAnimal
	 * @return consulta
	 */
	private Consulta procurarConsulta (String veterinario, int dia, int mes, int ano, String nomeAnimal) {
		for(int i=0;i<consultasTam;i++) {
			if(consultas[i].getTime().getYear() == ano && consultas[i].getTime().getDayOfMonth() == dia 
				&& consultas[i].getTime().getMonthValue() == mes && consultas[i].getVeterinario().getNome().equals(veterinario) 
					&& consultas[i].getAnimal().getNome().equals(nomeAnimal)) {
				return consultas[i];
			}			
		}
		return null;
	}
	/**
	 * Procura posição da consulta enviada por atributo e retorna int.
	 * @param consulta
	 * @return int posição
	 */
	private int procurarPos(Consulta consulta) {
		int i = 0;
        for(; i<this.consultasTam; i++) {
        	if(consultas[i].equals(consulta)) {
        		return i;
        	}
        }
        return -1;
	}
	@Override
	/**
	 * Adiciona consulta ao repositório.
	 * @throws CadastroInvalidoException
	 */
	public void addConsulta(Consulta consulta) throws CadastroInvalidoException{
		if(consulta != null && procurarConsulta(consulta.getVeterinario().getNome(), consulta.getTime().getDayOfMonth(), 
				consulta.getTime().getMonthValue(), consulta.getTime().getYear(), consulta.getAnimal().getNome()) == null) {
			if(this.consultasTam == this.consultas.length) {
				this.duplicaArray();
			}
			this.consultas[consultasTam]=consulta;
			this.consultasTam++;
		}else {
			throw new CadastroInvalidoException();
		}
	}
	@Override
	/**
	 * Pega uma consulta no repositório
	 * @return consulta
	 * @throws NaoEncontradoException("Consulta")
	 */
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) throws NaoEncontradoException {
		if(this.procurarConsulta(veterinario, dia, mes, ano, nomeAnimal) !=null){
			return this.procurarConsulta(veterinario, dia, mes, ano, nomeAnimal);
		}else {
			throw new NaoEncontradoException("Consulta");
		}
		
	}	
	@Override
	/**
	 * Remove consulta do array
	 * @throw NaoEncontradoException
	 */
	public void removerConsulta(Consulta consulta)throws NaoEncontradoException {
		int i = this.procurarPos(consulta);
		if(i!= -1) {
			if (i != this.consultasTam) {
	            this.consultas[i] = this.consultas[this.consultasTam - 1];
	            this.consultas[this.consultasTam - 1] = null;
	            this.consultasTam = this.consultasTam - 1;
	        }
		}else {
            throw new NaoEncontradoException("Consulta");
        }
	}
	/**
	 * Duplica o Array para aumentar a capacidade.
	 */
	private void duplicaArray() {
        if (this.consultas != null && this.consultas.length > 0) {
            Consulta[] arrayDuplicado = new Consulta[this.consultas.length * 2];
            for (int i = 0; i < this.consultas.length; i++) {
                arrayDuplicado[i] = this.consultas[i];
            }
            this.consultas = arrayDuplicado;
        }
    }
	/**
	 * Retorna todo o array de consulta;
	 * @return Consulta[] consultas
	 */
	@Override
	public Consulta[] getConsultasArray() {
		return consultas;
	}
}
