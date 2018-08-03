package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.exceptions.CadastroInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.CpfInvalidoException;
import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public class ControladorDeFuncionarios {
	private IRepositorioFuncionario instanceRepFuncionario;
	
	public ControladorDeFuncionarios(IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepFuncionario = instanceRepFuncionario;
	}
	/**
	 * Adiciona funcionario
	 * @exception
	 * CadastroInvalidoException(); Quando algum atributo foi enviado com null
	 * @exception
	 * FuncionarioJaExisteException(); Quando o cpf ja foi cadastro no banco de dados em algum funcionario.
	 */
	public void addFuncionario(Funcionario funcionario) throws CadastroInvalidoException, FuncionarioJaExisteException {
		if(funcionario!=null && funcionario.getCpf() != null && funcionario.getLogin() != null 
				&& funcionario.getNome() != null && funcionario.getSenha() != null) {
			instanceRepFuncionario.addFuncionario(funcionario);
		}else {
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * @param String cpf
	 * @return Funcionario
	 * @throws CadastroInvalidoException
	 * @throws CpfInvalidoException
	 */
	public Funcionario getFuncionario(String cpf) throws CadastroInvalidoException, CpfInvalidoException {
		if(cpf != null) {
			if(instanceRepFuncionario.getFuncionario(cpf)!=null) {
				return instanceRepFuncionario.getFuncionario(cpf);
			}
			else {
				throw new CpfInvalidoException();
			}
		} else{ 
			throw new CadastroInvalidoException();
		}
	}
	/**
	 * Remove um funcionario do banco de dados de acordo com o seu CPF.
	 * @param cpf
	 * @throws CpfInvalidoException
	 * @throws NaoEncontradoException 
	 */
	public void remover(String cpf) throws CpfInvalidoException, NaoEncontradoException{
		if(cpf != null) {
			instanceRepFuncionario.remover(cpf);
		}else {
			throw new CpfInvalidoException();
		}
	}
	/**
	 * Retorna Funcionario de acordo com a posicao enviada como parametro
	 * @param pos
	 * @return Funcionario
	 * @throws NaoEncontradoException
	 */
	public Funcionario getFuncionario(int pos) throws NaoEncontradoException{
		if(instanceRepFuncionario.getFuncionario(pos)!=null) {
			return instanceRepFuncionario.getFuncionario(pos);
		}else {
			throw new NaoEncontradoException("Funcionario");
		}
	}
	/**
	 * retorna todo o array de funcionarios do repositório.
	 * @return Funcinario[]
	 */
	public Funcionario[] getFuncionarioArray() {
		return instanceRepFuncionario.getFuncionarioArray();
	}
	public int getFuncionarioPos(String cpf) throws NaoEncontradoException {
		return instanceRepFuncionario.getFuncionarioPos(cpf);
	}
	public void setFuncionario(int funcionarioPos, Funcionario f) {
		if(funcionarioPos >= 0 && f!=null && f.getCpf() != null && f.getLogin() != null && f.getLogin() != null && f.getNome()!=null && f.getSenha() != null) {
			instanceRepFuncionario.setFuncionario(funcionarioPos, f);
		}
	}
}
