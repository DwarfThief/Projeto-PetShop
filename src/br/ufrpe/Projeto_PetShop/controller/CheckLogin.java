package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;

public class CheckLogin {
	private IRepositorioFuncionario instanceRepFuncionario;

	public CheckLogin(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	public boolean checagemLogin(String login) {
		if(login!=null) {
			int pos = 0;
			do {
				if(instanceRepFuncionario.getFuncionario(pos) != null) {
					if(instanceRepFuncionario.getFuncionario(pos).getLogin().equals(login)) {
						return true;
					}
				}else {
					return false;
				}
				pos++;
			}while(1==1);
		}
		return false;
	}
	public boolean checagemSenha(String senha) {
		if(senha!=null) {
			int pos = 0;
			do {
				if(instanceRepFuncionario.getFuncionario(pos) != null) {
					if(instanceRepFuncionario.getFuncionario(pos).getSenha().equals(senha)) {
						return true;
					}
				}else {
					return false;
				}
				pos++;
			}while(1==1);
		}
		return false;
	}
}
