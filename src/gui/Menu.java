package gui;

import java.util.Scanner;
import br.ufrpe.Projeto_PetShop.controller.*;

public class Menu {
	
	private Scanner sc = new Scanner (System.in);
	private  int escolha,opcao;
	
	public void menu() {
		System.out.print("--------- MENU ---------\n\n");
		System.out.print("1) Funcionário\n2) Cliente");
		opcao = sc.nextInt();
		switch(opcao) {
		case 1:
			System.out.print("--------- MENU ---------\n");
			System.out.print("----- FUNCIONARIO -----\n\n");
			System.out.print("1) Gerente\n2) Vendedor\n3) Veterinario");
			escolha = sc.nextInt();
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
		case 2:
			System.out.print("--------- MENU ---------\n");
			System.out.print("-------- CLIENTE --------\n\n");
			System.out.print("1) Marcar Consulta");
			escolha = sc.nextInt();
			if(escolha==1) {
				consulta();
			}
			else {				
				while(escolha!=1) {
					System.out.println("Opcao invalida\nTente novamente");
					int escolha = sc.nextInt();
					if(escolha==1) {
						consulta();
					}
				}
			}

		}
	}
	
	public void gerente() {
		System.out.print("--------- Gerente ---------\n");
		System.out.print("1) Cadastrar Cliente\n2) Cadastrar Funcionario\n3) Cadastrar Animal");
		escolha = sc.nextInt();
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
				int escolha = sc.nextInt();
				if(escolha==1) {
					cadastroCliente();
				}
				else if(escolha==2){
					cadastroFuncionario();
				}
				else if(escolha==3){
					cadastroAnimal();
				}
			}
		}
	}
	
	public void vendedor() {
		System.out.print("--------- Vendedor ---------\n\n");
		System.out.print("1) Marcar consulta");
		escolha = sc.nextInt();
		if(escolha==1) {
			consulta();
		}
		else {				
			while(escolha!=1) {
				System.out.println("Opcao invalida\nTente novamente");
				int escolha = sc.nextInt();
				if(escolha==1) {
					consulta();
				}
			}
		}
	}

	public void veterinario() {
		System.out.print("--------- Veterinario ---------\n\n");
		/*//Funcoes do Veterinario
		System.out.println("Informe seu cpf");
		String cpf = sc.nextLine();
		//Pesquisar quais consultas ele ta pra poder mostrar
		System.out.println("1) Consultas marcadas");*/
	}
	
	public void consulta() {
		System.out.print("--------- Consulta ---------\n\n");
		System.out.print("Nome do animal: ");
		String nomeA = sc.nextLine();
		System.out.print("Veterinario que ira atender: ");
		String veterinario = sc.nextLine();
		System.out.print("Data da consulta: ");
		String data = sc.nextLine();
		//Como passar essas informações pra serem verificadas pela fachada??
		//Tem que tranformar nomeA em Animal, veterinario em Veterinario e data em LocalDateTime
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
		sc.nextLine();
		System.out.print("Sexo: ");
		char sexo = sc.nextLine().charAt(0);
		//Como passar essas informações pra serem verificadas pela fachada??
	}
	
	public void cadastroAnimal() {
		System.out.print("------ Cadastro Animal ------\n\n");
		System.out.print("Nome do dono do animal: ");
		String nome = sc.nextLine();		
		System.out.print("\nInformacoes sobre o animal\n");
		System.out.print("Nome: ");
		String nomeA = sc.nextLine();
		System.out.print("Raca: ");
		String raca = sc.nextLine();
		sc.nextLine();
		System.out.print("Sexo: ");
		char sexoA = sc.nextLine().charAt(0);
		//Como passar essas informações pra serem verificadas pela fachada??
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
		//Como passar essas informações pra serem verificadas pela fachada??
	}
}
	
