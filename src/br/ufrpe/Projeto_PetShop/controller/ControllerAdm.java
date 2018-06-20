package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.IRepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.*;


//TODO precisa implementar exceptions
public class ControllerAdm {
	private IRepositorioCliente instanceRepCliente;
	private IRepositorioAnimal instanceRepAnimal;
	private IRepositorioFuncionario instanceRepFuncionario;
	private IRepositorioConsulta instanceRepConsulta;
	
	public ControllerAdm(IRepositorioCliente instanceRepCliente, IRepositorioConsulta instanceRepConsulta
			, IRepositorioAnimal instanceRepAnimal, IRepositorioFuncionario instanceRepFuncionario) {
		this.instanceRepCliente = instanceRepCliente;
		this.instanceRepAnimal = instanceRepAnimal;
		this.instanceRepConsulta = instanceRepConsulta;
		this.instanceRepFuncionario = instanceRepFuncionario;
	}	
	public void cadastrarCliente(Cliente cliente) {
		if(cliente != null) {
			instanceRepCliente.addCliente(cliente);
		}
	}
	public void cadastrarCliente(String nome, String endereco, String telefone,
			String cpf, char sexo) {
		if(nome != null && endereco != null && telefone != null &&
			cpf !=null && sexo != "".charAt(0)) {
			Cliente cliente = new Cliente(nome, endereco, telefone, cpf, sexo);
			instanceRepCliente.addCliente(cliente);
		}		
	}
	public Cliente getCliente(String cpf) {
		if(cpf != null) {
			Cliente cliente = instanceRepCliente.getCliente(cpf);
			if(cliente != null) {
				return cliente;
			}
		}
		return null;
	}
	public void removerCliente(String cpf) {
		instanceRepCliente.removerCliente(cpf);
	}
	public void cadastrarAnimal(String nome, String raca, char sexo, Cliente dono) {
		if(nome != null && raca != null && sexo!="".charAt(0) && dono != null) {
			instanceRepAnimal.addAnimal(new Animal(nome, raca, sexo, dono));
		}
	}
	public void cadastrarAnimal(Animal animal) {
		if(animal != null) {
			instanceRepAnimal.addAnimal(animal);
		}
	}
	public Animal getAnimal(String cpf, String nome) {
		if(cpf != null && nome != null) {
			Animal animal = instanceRepAnimal.getAnimal(cpf, nome);
			if(animal!= null) {
				return animal;
			}
		}
		return null;
	}
	public Animal getAnimal(Cliente cliente, String nome) {
		if(cliente !=null && nome !=null) {
			Animal animal = instanceRepAnimal.getAnimal(cliente.getCpf(), nome);
			if(animal != null) {
				return animal;
			}
		}
		return instanceRepAnimal.getAnimal(cliente.getCpf(), nome);
	}
	public Animal[] getAnimaisDono(String cpf) {
		if(cpf != null) {
			Animal[] animais = instanceRepAnimal.getAnimaisCliente(cpf);
			if(animais != null) {
				return animais;
			}
		}
		return null;
	}
	public Animal[] getAnimaisDono(Cliente cliente) {
		return this.getAnimaisDono(cliente.getCpf());
	}
	public void removerCliente(String cpf, String nome) {
		instanceRepAnimal.remover(cpf, nome);
	}
	public void removerCliente(Cliente cliente, String nome) {
		instanceRepAnimal.remover(cliente.getCpf(), nome);
	}
	public void addVendendor(Funcionario funcionario) {
		if(funcionario != null) {
			instanceRepFuncionario.addFuncionario((Vendendor)funcionario);
		}
	}
	public void addVendendor(String nome, String cpf, String login, String senha) {
		if(nome != null && cpf != null && login != null && senha != null) {
			Funcionario funcionario = new Vendendor(nome, cpf, login, senha);
			instanceRepFuncionario.addFuncionario(funcionario);
		}
	}
	public void addGerente(Funcionario funcionario) {
		if(funcionario != null) {
			instanceRepFuncionario.addFuncionario((Gerente)funcionario);
		}
	}
	public void addGerente(String nome, String cpf, String login, String senha) {
		if(nome != null && cpf != null && login != null && senha != null) {
			Funcionario funcionario = new Gerente(nome, cpf, login, senha);
			instanceRepFuncionario.addFuncionario(funcionario);
		}
	}
	public void addVeterinario(String nome, String cpf, String login, String senha) {
		if(nome != null && cpf != null && login != null && senha != null) {
			Funcionario funcionario = new Veterinario(nome, cpf, login, senha);
			instanceRepFuncionario.addFuncionario(funcionario);
		}
	}
	public void addVeterinario(Funcionario funcionario) {
		if(funcionario != null) {
			instanceRepFuncionario.addFuncionario((Veterinario)funcionario);
		}
	}
	public Funcionario getFuncionario(Funcionario funcionario) {
		if(funcionario != null) {
			funcionario = instanceRepFuncionario.getFuncionario(funcionario.getCpf());
			if(funcionario != null) {
				return funcionario;
			}
		}
		return null;
	}
	public Funcionario getFuncionario(String cpf) {
		if(cpf!=null) {
			return instanceRepFuncionario.getFuncionario(cpf);
		}
		return null;
	}
	public void removerFuncionario(String cpf) {
		this.instanceRepFuncionario.remover(cpf);
	}
	public void removerFuncionario(Funcionario funcionario) {
		this.instanceRepFuncionario.remover(funcionario.getCpf());
	}
	public Consulta getConsulta(Consulta consulta) {
		if(consulta!=null) {
			return this.instanceRepConsulta.getConsulta(consulta);
		}
		return null;
	}
	public void removerConsulta(Consulta consulta) {
		if(consulta!=null) {
			this.instanceRepConsulta.removerConsulta(consulta);
		}
	}
}
