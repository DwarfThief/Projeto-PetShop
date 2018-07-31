package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioFuncionario;

public class Fachada {
	private static Fachada instance;
	private IRepositorioCliente instanceRepCliente = RepositorioCliente.getInstance();
	private IRepositorioAnimal instanceRepAnimal = RepositorioAnimal.getInstance();
	private IRepositorioConsulta instanceRepConsulta = RepositorioConsulta.getInstance();
	private IRepositorioFuncionario instanceRepFuncionario = RepositorioFuncionario.getInstance();
	
	private ControladorDeAnimais controladorDeAnimais;
	private	ControladorDeConsultas controladorDeConsultas;
	private ControladorDeFuncionarios controladorDeFuncionarios;
	private ControladorDeClientes controladorDeClientes;
	private CheckLogin checkLogin;
	/**
	 * Retorna instance da fachada, assim limitando sua criação para uma única
	 * @return instance
	 */
	public static Fachada getInstance() {
	    if (instance == null) {
	      instance = new Fachada();
	    }
	    return instance;
	}
	private Fachada () {
		this.controladorDeAnimais = new ControladorDeAnimais(this.instanceRepAnimal);
		this.controladorDeConsultas = new ControladorDeConsultas(this.instanceRepConsulta);
		this.controladorDeFuncionarios = new ControladorDeFuncionarios(this.instanceRepFuncionario);
		this.controladorDeClientes = new ControladorDeClientes(this.instanceRepCliente);
		this.checkLogin = new CheckLogin();
	}
	/**
	 * Acesso ao controladorDeAnimais
	 * @return controladorDeAnimais
	 */
	public ControladorDeAnimais contAnimais() {
		return this.controladorDeAnimais;
	}
	/**
	 * Acesso ao controladorDeConsultas
	 * @return controladorDeConsultas
	 */
	public ControladorDeConsultas contConsultas() {
		return this.controladorDeConsultas;
	}
	/**
	 * Acesso ao controladorDeFuncionarios
	 * @return controladorDeFuncionarios
	 */
	public ControladorDeFuncionarios contFuncionarios() {
		return this.controladorDeFuncionarios;
	}
	/**
	 * Acesso ao controladorDeClientes
	 * @return controladorDeClientes
	 */
	public ControladorDeClientes contClientes() {
		return this.controladorDeClientes;
	}
	/**
	 * Acesso ao checkLogin
	 * @return checkLogin
	 */
	public CheckLogin checkLogin() {
		return this.checkLogin;
	}
}
