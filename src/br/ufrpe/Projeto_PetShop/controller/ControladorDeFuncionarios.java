package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public class ControladorDeFuncionarios {
	private IRepositorioFuncionario instanceRepFuncionario;
	
	public ControladorDeFuncionarios(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	
	public void addFuncionario(Funcionario funcionario) throws CadastroInvalidoException {
		if(funcionario!=null && funcionario.getCpf() != null && funcionario.getLogin() != null 
				&& funcionario.getNome() != null && funcionario.getSenha() != null) {
			instanceRepFuncionario.addFuncionario(funcionario);
		}
		//TODO implementar Exception
	}
	public Funcionario getFuncionario(String cpf) throws CadastroInvalidoException {
		if(cpf != null) {
			return instanceRepFuncionario.getFuncionario(cpf);
		} else{ 
			return null;
		}
		//TODO implementar Exception
	}
	public void remover(String cpf) {
		if(cpf != null) {
			instanceRepFuncionario.remover(cpf);
		}
		//TODO
	}
	public Funcionario getFuncionario(int pos) {
		return instanceRepFuncionario.getFuncionario(pos);
		//TODO
	}
}
