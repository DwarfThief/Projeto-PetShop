package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public interface IRepositorioFuncionario {
	public void addFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException;
	public Funcionario getFuncionario(String cpf);
	public void remover(String cpf) throws NaoEncontradoException;
	public Funcionario getFuncionario(int pos);
	public Funcionario[] getFuncionarioArray();
	public int getFuncionarioPos(String cpf) throws NaoEncontradoException;
	public void setFuncionario(int i, Funcionario f);
}
