package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.beans.*;

public class CheckType {
	public void checkType(Funcionario funcionario) {
		if(funcionario != null) {
			if(funcionario instanceof Gerente) {
				//TODO chamar o GUI para Gerente
			}else if(funcionario instanceof Veterinario) {
				//TODO chamar o GUI para
			}else if(funcionario instanceof Vendedor) {
				//TODO chamar o GUI para
			}
		}
	}
}
