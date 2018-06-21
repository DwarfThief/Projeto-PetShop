package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;

public class CheckLogin {
	private IRepositorioFuncionario instanceRepFuncionario;

	public CheckLogin(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	public void checagemLogin(String login, String senha) {
		boolean validando = true;
		if(login != null && senha != null) {
			int pos = 0;
			do {
				if(instanceRepFuncionario.getFuncionario(pos) != null) {
					if(instanceRepFuncionario.getFuncionario(pos).getLogin().equals(login)
							&& instanceRepFuncionario.getFuncionario(pos).getSenha().equals(senha)) {
						checkType(instanceRepFuncionario.getFuncionario(pos));
					}
				}else {
					validando = false;
				}
				pos++;
			}while(validando == true);
		}
	}
	public void checkType(Funcionario funcionario) {
		if(funcionario != null) {
			if(funcionario instanceof Gerente) {
				//TODO chamar o GUI para Gerente
			}else if(funcionario instanceof Veterinario) {
				//TODO chamar o GUI para Veterinario
			}else if(funcionario instanceof Vendedor) {
				//TODO chamar o GUI para Vendendor
			}
		}
	}
}
