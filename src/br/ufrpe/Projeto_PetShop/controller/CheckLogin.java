package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;
import br.ufrpe.Projeto_PetShop.exceptions.LoginInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;

public class CheckLogin {

	/**
	 * Checa o login e senha de acordo com o repositorio de funcionarios.
	 * 
	 * @return instance do Funcionario correspondente.
	 * @exception LoginInvalidoException();
	 */
	public Funcionario checagemLogin (String login, String senha) throws LoginInvalidoException{	
		if(login != null && senha != null) {
			int pos = 0;
			try {
				for(;pos>=0;pos++) {
						if(Fachada.getInstance().contFuncionarios().getFuncionario(pos).getLogin().equals(login)
								&& Fachada.getInstance().contFuncionarios().getFuncionario(pos).getSenha().equals(senha) ) {
							return Fachada.getInstance().contFuncionarios().getFuncionario(pos);
						}
					} 
			}catch (NaoEncontradoException e) {
				throw new LoginInvalidoException();
			}
		}
		throw new LoginInvalidoException();
	}
}
