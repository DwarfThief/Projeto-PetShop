package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario{
	private static RepositorioFuncionario instance;
	
	private Funcionario funcionarios[] = new Funcionario[5];
	private int funcionariosTam = 0;
	
	
	public static RepositorioFuncionario getInstance() {
	    if (instance == null) {
	      instance = new RepositorioFuncionario();
	    }
	    return instance;
	}
	private RepositorioFuncionario() {}
	private Funcionario procurarFuncionario(String cpf) {
		for(int i = 0; i < funcionariosTam; i++) {
			if(funcionarios[i].getCpf().equals(cpf)) {
				return funcionarios[i];
			}
		}
		return null;
	}
	private int procurarPos(String cpf) {
		int i = 0;
        for(; i<this.funcionariosTam; i++) {
        	if(cpf.equals(this.funcionarios[i].getCpf())) {
        		return i;
        	}
        }
        return funcionariosTam;
	}
	public void addFuncionario(Funcionario funcionario) {
		if(funcionario != null && procurarFuncionario(funcionario.getCpf()) == null) {
			if(this.funcionariosTam == this.funcionarios.length) {
				this.duplicaArray();
			}
			this.funcionarios[funcionariosTam] = funcionario;
			this.funcionariosTam++;
		}
		//TODO exception
	}
	public Funcionario getFuncionario(String cpf) {
		return this.procurarFuncionario(cpf);
	}
	public void remover(String cpf) {
		int i = this.procurarPos(cpf);
		if (i != this.funcionariosTam) {
            this.funcionarios[i] = this.funcionarios[this.funcionariosTam - 1];
            this.funcionarios[this.funcionariosTam - 1] = null;
            this.funcionariosTam = this.funcionariosTam - 1;
        } else {
        	//TODO exception
        }
	}
	private void duplicaArray() {
        if (this.funcionarios != null && this.funcionarios.length > 0) {
            Funcionario[] arrayDuplicado = new Funcionario[this.funcionarios.length * 2];
            for (int i = 0; i < this.funcionarios.length; i++) {
                arrayDuplicado[i] = this.funcionarios[i];
            }
            this.funcionarios = arrayDuplicado;
        }
    }
}
