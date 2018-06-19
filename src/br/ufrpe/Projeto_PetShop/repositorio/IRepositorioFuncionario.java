package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public interface IRepositorioFuncionario {
	public void addFuncionario(Funcionario funcionario);
	public Funcionario getFuncionario(String cpf);
	public void removeFuncionario(String cpf);
}