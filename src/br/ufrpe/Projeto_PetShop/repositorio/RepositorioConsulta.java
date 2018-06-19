package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;

public class RepositorioConsulta implements IRepositorioConsulta{
	private Consulta consultas[]=new Consulta[5];
	private int consultasTam=0;
	//mudar o remover
	public RepositorioConsulta() {}	
	private Consulta procurarConsulta (Consulta consulta) {
		for(int i=0;i<consultasTam;i++) {
			consultas[i].equals(consulta);
		}
		return null;
	}	
	public void adicionarConsulta(Consulta consulta) {
		if(this.consultasTam == this.consultas.length) {
			this.duplicaArray();
		}
		this.consultas[consultasTam]=consulta;
		consultasTam++;
	}	
	public Consulta getConsulta(Consulta consulta) {
		return this.procurarConsulta(consulta);
	}	
	public void removeConsulta(Consulta consulta) {
		for(int i=0;i<consultasTam;i++) {
			if(consultas[i].equals(consulta)) {
				this.consultas[i]=this.consultas[consultasTam-1];
				this.consultas[consultasTam-1]=null;
				this.consultasTam--;
			}
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
