package br.ufrpe.Projeto_PetShop.repositorio;

import java.time.LocalDateTime;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;

public class RepositorioConsulta {
	private Consulta consultas[]=new Consulta[5];
	private int consultasTam=0;
	
	public RepositorioConsulta() {}
	
	private Consulta procurarConsulta (Consulta consulta) {
		for(int i=0;i<consultasTam;i++) {
			consultas[i].equals(consulta);
		}
		return null;
	}
	
	public void adicionarConsulta(Consulta consulta) {
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
				consultasTam--;
			}
		}
	}
}
