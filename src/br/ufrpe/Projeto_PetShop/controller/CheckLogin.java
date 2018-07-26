package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.exceptions.LoginInvalidoException;

public class CheckLogin {
	private IRepositorioFuncionario instanceRepFuncionario;

	public CheckLogin(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	/**
	 * Checa o login e senha de acordo com o repositorio de funcionarios.
	 * 
	 * @return instance do Funcionario correspondente.
	 * @exception LoginInvalidoException();
	 */
	public Funcionario checagemLogin (String login, String senha) throws LoginInvalidoException{
		boolean validando = false;
		
		if(login != null && senha != null) {
			int pos = 0;
			do {
				if(instanceRepFuncionario.getFuncionario(pos) != null) {
					if(instanceRepFuncionario.getFuncionario(pos).getLogin().equals(login)
							&& instanceRepFuncionario.getFuncionario(pos).getSenha().equals(senha)) {
						return instanceRepFuncionario.getFuncionario(pos);
						
					}
				}else {
					break;
				}
				pos++;
			}while(validando == false);
			throw new LoginInvalidoException();
		}
		return null;
	}
}
