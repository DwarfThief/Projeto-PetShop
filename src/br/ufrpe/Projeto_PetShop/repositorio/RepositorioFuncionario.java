package br.ufrpe.Projeto_PetShop.repositorio;

import java.time.LocalDate;

import br.ufrpe.Projeto_PetShop.repositorio.beans.*;

public class RepositorioFuncionario{
	private Funcionario funcionarios[] = new Funcionario[5];
	private int funcionariosTam = 0;
	
	public RepositorioFuncionario() {}
	private Funcionario procurarFuncionario(String cpf) {
		for(int i = 0; i < funcionariosTam; i++) {
			if(funcionarios[i].getCPF().equals(cpf)) {
				return funcionarios[i];
			}
		}
		return null;
	}
	public void addFuncionario(Funcionario funcionario) {
		this.funcionarios[funcionariosTam] = funcionario;
		this.funcionariosTam++;
	}
	public Funcionario getFuncionario(String cpf) {
		return this.procurarFuncionario(cpf);
	}
	public void removeFuncionario(String cpf) {
		
	}
}
