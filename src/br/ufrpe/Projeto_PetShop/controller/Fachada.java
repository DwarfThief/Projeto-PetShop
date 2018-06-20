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
	
	public ControllerAdm controllerAdm = new ControllerAdm(instanceRepCliente, instanceRepConsulta
			, instanceRepAnimal, instanceRepFuncionario);
	
	
	public static Fachada getInstance() {
	    if (instance == null) {
	      instance = new Fachada();
	    }
	    return instance;
	}
	private Fachada () {}
}
