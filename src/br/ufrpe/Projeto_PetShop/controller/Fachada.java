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
	
	public ControllerAdm controllerAdm;
	public CheckLogin checkLogin;
	public ControllerVet controllerVet;
	public ControllerVendendor controllerVendendor;
	
	public static Fachada getInstance() {
	    if (instance == null) {
	      instance = new Fachada();
	    }
	    return instance;
	}
	private Fachada () {
		this.controllerAdm = new ControllerAdm(this.instanceRepCliente, this.instanceRepConsulta
				, this.instanceRepAnimal, this.instanceRepFuncionario);
		this.checkControl = new CheckLogin(this.instanceRepFuncionario);
		this.controllerVet = new ControllerVet(this.instanceRepConsulta, this.instanceRepAnimal);
		this.controllerVendendor = new ControllerVendendor(this.instanceRepCliente, this.instanceRepConsulta, instanceRepAnimal);
			
	}
}
