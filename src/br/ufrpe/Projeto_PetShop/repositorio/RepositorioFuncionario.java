package br.ufrpe.Projeto_PetShop.repositorio;

import br.ufrpe.Projeto_PetShop.exceptions.FuncionarioJaExisteException;
import br.ufrpe.Projeto_PetShop.exceptions.NaoEncontradoException;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

import java.io.Serializable;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable {
	private static RepositorioFuncionario instance;
	
	private Funcionario funcionarios[] = new Funcionario[5];
	private int funcionariosTam = 0;
	
	
	public static RepositorioFuncionario getInstance() {
	    if (instance == null) {
	      instance = new RepositorioFuncionario();
	    }
	    return instance;
	}
	private RepositorioFuncionario() {}
	private Funcionario procurarFuncionario(String cpf){
		for(int i = 0; i < funcionariosTam; i++) {
			if(funcionarios[i].getCpf().equals(cpf)) {
				return funcionarios[i];
			}
		}
		return null;
	}
	/**
	 * Retorna posicionamento no array do repositório.
	 * @param cpf
	 * @return int i com o posicionamento do Funcionário no Array.
	 * @throws NaoEncontradoException é lançado quando o Funcionario não foi encontrado no Array.
	 */
	private int procurarPos(String cpf) throws NaoEncontradoException{
		int i = 0;
        for(; i<this.funcionariosTam; i++) {
        	if(cpf.equals(this.funcionarios[i].getCpf())) {
        		return i;
        	}
        }
        throw new NaoEncontradoException("Funcionario");
	}
	/**
	 * Add o Funcionario no banco de Dados.
	 * @throws FuncionarioJaExisteException;
	 */
	@Override
	public void addFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{
		if(funcionario != null && procurarFuncionario(funcionario.getCpf()) == null) {
			if(this.funcionariosTam == this.funcionarios.length) {
				this.duplicaArray();
			}
			this.funcionarios[funcionariosTam] = funcionario;
			this.funcionariosTam++;
		}else {
			throw new FuncionarioJaExisteException(funcionario.getCpf());
		}
	}
	@Override
	public Funcionario getFuncionario(String cpf){
		return this.procurarFuncionario(cpf);
	}
	/**
	 * Retorna funcionario por posicao no Array 
	 * @return Funcionario pela posicao
	 * @return null caso nao encontre
	 */
	@Override
	public Funcionario getFuncionario(int pos) {
		if(pos < this.funcionariosTam) {
			return this.funcionarios[pos];
		}
		return null;
	}
	@Override
	public void remover(String cpf) throws NaoEncontradoException {
		int i = this.procurarPos(cpf);
		if (i != this.funcionariosTam) {
            this.funcionarios[i] = this.funcionarios[this.funcionariosTam - 1];
            this.funcionarios[this.funcionariosTam - 1] = null;
            this.funcionariosTam = this.funcionariosTam - 1;
        } else {
        	throw new NaoEncontradoException("Funcionario");
        }
	}
	private void duplicaArray() {
        if (this.funcionarios != null && this.funcionarios.length > 0) {
            Funcionario[] arrayDuplicado = new Funcionario[this.funcionarios.length * 2];
            for (int i = 0; i < this.funcionarios.length; i++) {
                arrayDuplicado[i] = this.funcionarios[i];
            }
            this.funcionarios = arrayDuplicado;
        }
    }
	@Override
	public Funcionario[] getFuncionarioArray() {
		return funcionarios;
	}
	@Override
	public int getFuncionarioPos(String cpf) throws NaoEncontradoException {
		return this.procurarPos(cpf);
	}
	@Override
	public void setFuncionario(int i, Funcionario f) {
		funcionarios[i] = f;
	}
}
