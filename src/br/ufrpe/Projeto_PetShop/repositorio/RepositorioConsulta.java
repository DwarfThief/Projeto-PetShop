package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class RepositorioConsulta implements IRepositorioConsulta{
	private static RepositorioConsulta instance;
	
	private Consulta consultas[]=new Consulta[5];
	private int consultasTam=0;

	
	public static RepositorioConsulta getInstance() {
	    if (instance == null) {
	      instance = new RepositorioConsulta();
	    }
	    return instance;
	}
	private RepositorioConsulta() {}	
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
	private int procurarPos(Consulta consulta) {
		int i = 0;
        for(; i<this.consultasTam; i++) {
        	if(consultas[i].equals(consulta)) {
        		return i;
        	}
        }
        return -1;
	}
	public void addConsulta(Consulta consulta) {
		if(consulta != null && procurarConsulta(consulta.getVeterinario().getNome(), consulta.getTime().getDayOfMonth(), 
				consulta.getTime().getMonthValue(), consulta.getTime().getYear(), consulta.getAnimal().getNome()) == null) {
			if(this.consultasTam == this.consultas.length) {
				this.duplicaArray();
			}
			this.consultas[consultasTam]=consulta;
			this.consultasTam++;
		}
		//TODO exception
	}	
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) {
		return this.procurarConsulta(veterinario, dia, mes, ano, nomeAnimal);
	}	
	public void removerConsulta(Consulta consulta) {
		int i = this.procurarPos(consulta);
		if (i != this.consultasTam) {
            this.consultas[i] = this.consultas[this.consultasTam - 1];
            this.consultas[this.consultasTam - 1] = null;
            this.consultasTam = this.consultasTam - 1;
        } else {
            //TODO exceptions
        }
	}
	private void duplicaArray() {
        if (this.consultas != null && this.consultas.length > 0) {
            Consulta[] arrayDuplicado = new Consulta[this.consultas.length * 2];
            for (int i = 0; i < this.consultas.length; i++) {
                arrayDuplicado[i] = this.consultas[i];
            }
            this.consultas = arrayDuplicado;
        }
    }
}
