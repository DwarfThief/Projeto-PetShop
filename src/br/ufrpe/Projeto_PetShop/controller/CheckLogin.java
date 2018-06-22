package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Gerente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Vendedor;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Veterinario;
import br.ufrpe.Projeto_PetShop.userInterface.Menu;

public class CheckLogin {
	private IRepositorioFuncionario instanceRepFuncionario;

	public CheckLogin(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	public void checagemLogin(String login, String senha) {
		boolean validando = false;
		Funcionario funcionario=null;
		if(login != null && senha != null) {
			int pos = 0;
			do {
				if(instanceRepFuncionario.getFuncionario(pos) != null) {
					if(instanceRepFuncionario.getFuncionario(pos).getLogin().equals(login)
							&& instanceRepFuncionario.getFuncionario(pos).getSenha().equals(senha)) {
						funcionario = instanceRepFuncionario.getFuncionario(pos);
						validando = true;
						
					}
				}else {
					break;
				}
				pos++;
			}while(validando == false);
			if(true) {
				this.checkType(funcionario);
			}
		}
	}
	public void checkType(Funcionario funcionario) {
		Menu menu = new Menu();
		if(funcionario != null) {
			if(funcionario instanceof Gerente) {
				menu.gerente();
			}else if(funcionario instanceof Veterinario) {
				menu.veterinario();
			}else if(funcionario instanceof Vendedor) {
				menu.vendedor();
			}
		}
	}
}
