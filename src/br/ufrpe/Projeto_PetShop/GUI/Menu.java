package br.ufrpe.Projeto_PetShop.userInterface;

import java.util.Scanner;
import br.ufrpe.Projeto_PetShop.controller.*;
import br.ufrpe.Projeto_PetShop.repositorio.beans.*;

public class Menu {
	private Fachada fachada = Fachada.getInstance();
	private Scanner sc = new Scanner (System.in);
	private  int escolha;
	
	public void login() {
		System.out.println("Login: ");
		String login = sc.nextLine();
		System.out.println("Senha: ");
		String senha = sc.nextLine();
		fachada.checkLogin.checagemLogin(login, senha);
	}
	public void menu() {
		login();
		System.out.print("--------- MENU ---------\n");
		System.out.print("----- FUNCIONARIO -----\n\n");
		System.out.print("1) Gerente\n2) Vendedor\n3) Veterinario");
		escolha = sc.nextInt();
		sc.nextLine();
		if(escolha==1) {
			gerente();
		}
		else if(escolha==2){
			vendedor();
		}
		else if(escolha==3) {
			veterinario();
		}
		else {				
			while(escolha!=1 && escolha!=2 && escolha!=3) {
				System.out.println("Opcao invalida\nTente novamente");
				int escolha = sc.nextInt();
				sc.nextLine();
				if(escolha==1) {
					gerente();
				}
				else if(escolha==2){
					vendedor();
				}
				else if(escolha==3) {
					veterinario();
				}
			}
		}
	}
	
	public void gerente() {
		System.out.print("--------- Gerente ---------\n");
		System.out.print("1) Cadastrar Cliente\n2) Cadastrar Funcionario\n3) Cadastrar Animal");
		escolha = sc.nextInt();
		sc.nextLine();
		if(escolha==1) {
			cadastroCliente();
		}
		else if(escolha==2){
			cadastroFuncionario();
		}
		else if(escolha==3){
			cadastroAnimal();
		}
		else {				
			while(escolha!=1 && escolha!=2 && escolha!=3) {
				System.out.println("Opcao invalida\nTente novamente");
				gerente();
			}
		}
		gerente();
	}
	
	public void vendedor() {
		System.out.print("--------- Vendedor ---------\n\n");
		System.out.print("1)Cadastrar Cliente\n2)Cadastrar Animal");
		escolha = sc.nextInt();
		sc.nextLine();
		if(escolha == 1) {
			cadastroCliente();
		}else if(escolha == 2) {
			cadastroAnimal();
		}
		else {				
			while(escolha!=1) {
				System.out.println("Opcao invalida\nTente novamente");
			}
		}
		vendedor();
	}

	public void veterinario() {
		System.out.print("--------- Veterinario ---------\n\n");
		System.out.print("Veterinario que ira atender(CPF): ");
		String veterinario = sc.nextLine();
		Funcionario medico = fachada.controllerAdm.getFuncionario(veterinario);
		System.out.println("1)Cadastrar Animal\n2)Criar consulta");
		int escolha = sc.nextInt();
		sc.nextLine();
		if(escolha == 1) {
			cadastroAnimal();
		}else if(escolha == 2) {
			consulta(medico);
		}
		veterinario();
	}
	public void consulta(Funcionario medico) {
		System.out.print("--------- Consulta ---------\n\n");
		System.out.print("Cpf do dono: ");
		String cpf = sc.nextLine();
		System.out.print("Nome do animal: ");
		String nome = sc.nextLine();
		Animal animal = fachada.controllerAdm.getAnimal(cpf, nome);
		fachada.controllerVet.addConsulta(animal, (Veterinario)medico);
	}
	
	public void cadastroCliente() {
		System.out.print("------ Cadastro Cliente ------\n\n");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Endereco: ");
		String endereco = sc.nextLine();
		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Sexo: ");
		String sexo = sc.nextLine();
		fachada.controllerAdm.cadastrarCliente(nome, endereco, telefone, cpf, sexo.charAt(0));
	}
	
	public void cadastroAnimal() {
		System.out.print("------ Cadastro Animal ------\n\n");
		System.out.print("Cpf do dono: ");
		String cpf = sc.nextLine();
		Cliente dono = fachada.controllerAdm.getCliente(cpf);
		System.out.print("\nInformacoes sobre o animal\n");
		System.out.print("Nome: ");
		String nomeA = sc.nextLine();
		System.out.print("Raca: ");
		String raca = sc.nextLine();
		System.out.print("Sexo: ");
		char sexo = sc.nextLine().charAt(0);
		fachada.controllerAdm.cadastrarAnimal(nomeA, raca, sexo, dono);
	}
	
	public void cadastroFuncionario() {
		System.out.print("----- Cadastro Funcionario -----\n\n");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		System.out.print("Login: ");
		String login = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		System.out.println("Tipo de funcionario:\n1)Gerente\n2)Vendedor\n3)Veterinario");
		int tipo = sc.nextInt();
		if(tipo == 1) {
			fachada.controllerAdm.addGerente(nome,cpf,login,senha);
		}if(tipo == 2) {
			fachada.controllerAdm.addVendendor(nome,cpf,login,senha);
		}else {
			fachada.controllerAdm.addVeterinario(nome,cpf,login,senha);
		}
	}
}
	
