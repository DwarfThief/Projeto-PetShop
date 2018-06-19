package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class RepositorioConsulta implements IRepositorioConsulta{
	private Consulta consultas[]=new Consulta[5];
	private int consultasTam=0;
	//mudar o remover
	public RepositorioConsulta() {}	
	private Consulta procurarConsulta (Consulta consulta) {
		for(int i=0;i<consultasTam;i++) {
			if(consultas[i].equals(consulta)) {
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
		if(this.consultasTam == this.consultas.length) {
			this.duplicaArray();
		}
		this.consultas[consultasTam]=consulta;
		this.consultasTam++;
	}	
	public Consulta getConsulta(Consulta consulta) {
		return this.procurarConsulta(consulta);
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
