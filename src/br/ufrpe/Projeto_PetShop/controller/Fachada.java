package br.ufrpe.Projeto_PetShop.controller;

import br.ufrpe.Projeto_PetShop.exceptions.*;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioAnimal;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioCliente;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioConsulta;
import br.ufrpe.Projeto_PetShop.repositorio.RepositorioFuncionario;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Animal;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Cliente;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Consulta;
import br.ufrpe.Projeto_PetShop.repositorio.beans.Funcionario;

public class Fachada {
	private static Fachada instance;
	private ControladorDeAnimais controladorDeAnimais;
	private	ControladorDeConsultas controladorDeConsultas;
	private ControladorDeFuncionarios controladorDeFuncionarios;
	private ControladorDeClientes controladorDeClientes;
	private CheckLogin checkLogin;
	/**
	 * Retorna instance da fachada, assim limitando sua criação para uma única
	 * @return instance, retorna a instância da Fachada, assim tornando impossível duas fachadas
	 */
	public static Fachada getInstance() {
	    if (instance == null) {
	      instance = new Fachada();
	    }
	    return instance;
	}
	private Fachada () {
		this.controladorDeAnimais = new ControladorDeAnimais(RepositorioAnimal.getInstance());
		this.controladorDeConsultas = new ControladorDeConsultas(RepositorioConsulta.getInstance());
		this.controladorDeFuncionarios = new ControladorDeFuncionarios(RepositorioFuncionario.getInstance());
		this.controladorDeClientes = new ControladorDeClientes(RepositorioCliente.getInstance());
		this.checkLogin = new CheckLogin();
	}
	/**
	 * TODO comentar método
	 * @param nome
	 * @param cpf
	 * @return
	 * @throws NaoEncontradoException
	 */
	public Animal getAnimal(String nome, String cpf) throws NaoEncontradoException {
		return this.controladorDeAnimais.getAnimal(cpf, nome);
	}
	/**
	 * TODO comentar método
	 * @param cpf
	 * @return
	 * @throws CadastroInvalidoException
	 * @throws NaoEncontradoException
	 */
	public Animal[] getAnimaisCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeAnimais.getAnimaisCliente(cpf);
	}
	/**
	 * TODO comentar método
	 * @param nome
	 * @param cpf
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public void removerAnimal(String nome, String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		this.controladorDeAnimais.remover(cpf, nome);
	}
	/**
	 * TODO comentar o método
	 * @param animal
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public void cadastrarAnimal(Animal animal) throws NaoEncontradoException, CadastroInvalidoException {
		this.controladorDeAnimais.addAnimal(animal);
	}
	/**
	 * TODO comentar método
	 * @return
	 */
	public Consulta[] getConsultasArray(){
		return this.controladorDeConsultas.getConsultasArray();
	}
	/**
	 * TODO comentar método
	 * @param veterinario
	 * @param dia
	 * @param mes
	 * @param ano
	 * @param nomeAnimal
	 * @return
	 * @throws NaoEncontradoException
	 * @throws CadastroInvalidoException
	 */
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) throws NaoEncontradoException, CadastroInvalidoException {
		return this.controladorDeConsultas.getConsulta(veterinario,dia,mes,ano,nomeAnimal);
	}
	/**
	 * TODO comentar o método
	 * @param consulta
	 * @throws CadastroInvalidoException
	 * @throws NaoEncontradoException
	 */
	public void removerConsulta(Consulta consulta) throws CadastroInvalidoException, NaoEncontradoException {
		this.controladorDeConsultas.removerConsulta(consulta);
	}

	/**
	 * TODO comentar o método
	 * @param consulta
	 * @throws CadastroInvalidoException
	 */
	public void cadastrarConsulta(Consulta consulta) throws CadastroInvalidoException {
		this.controladorDeConsultas.addConsulta(consulta);
	}
	/**
	 * TODO comentar o método
	 * @return
	 */
	public Funcionario[] getFuncionariosArray(){
		return this.controladorDeFuncionarios.getFuncionarioArray();
	}
	/**
	 * TODO comentar o método
	 * @param pos
	 * @return
	 * @throws NaoEncontradoException
	 */
	public Funcionario getFuncionario(int pos) throws NaoEncontradoException {
		return this.controladorDeFuncionarios.getFuncionario(pos);
	}
	/**
	 * TODO comentar o método
	 * @param cpf
	 * @return
	 * @throws CpfInvalidoException
	 * @throws CadastroInvalidoException
	 */
	public Funcionario getFuncionario(String cpf) throws CpfInvalidoException, CadastroInvalidoException {
		return this.controladorDeFuncionarios.getFuncionario(cpf);
	}
	/**
	 * TODO comentar o método
	 * @param funcionario
	 * @throws FuncionarioJaExisteException
	 * @throws CadastroInvalidoException
	 */
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException, CadastroInvalidoException {
		this.controladorDeFuncionarios.addFuncionario(funcionario);
	}
	/**
	 * TODO comentar o método.
	 * @param cpf
	 */
	public void removerFuncionario(String cpf) throws NaoEncontradoException, CpfInvalidoException {
		this.controladorDeFuncionarios.remover(cpf);
	}
	/**
	 * Acesso ao controladorDeClientes
	 * @return controladorDeClientes
	 */
	public ControladorDeClientes contClientes() {
		return this.controladorDeClientes;
	}
	public Cliente[] getClientesArray(){
		return this.controladorDeClientes.getClientesArray();
	}
	/**
	 * TODO comentar o método
	 * @param cpf
	 * @return
	 * @throws CadastroInvalidoException
	 * @throws NaoEncontradoException
	 */
	public int getClientePos(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeClientes.getClientePos(cpf);
	}
	/**
	 * TODO comentar o método
	 * @param cpf
	 * @throws CadastroInvalidoException
	 * @throws NaoEncontradoException
	 */
	public Cliente getCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeClientes.getCliente(cpf);
	}
	/**
	 * Adiciona um cliente no repositório de clientes usando o objeto do parametro.
	 * @param cliente, objeto do tipo cliente;
	 * @throws NaoEncontradoException, retorna essa exception mas ela nunca irá acontecer com esse método.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro é invalido devido a ausência de
	 * alguma informação. Serve para não deixar acontecer um {@link NullPointerException}
	 * @throws ClienteJaExisteException, retorna essa exception quando o cpf ja foi cadastrado em algum cliente.
	 */
	public void cadastrarCliente(Cliente cliente) throws NaoEncontradoException, CadastroInvalidoException, ClienteJaExisteException {
		this.controladorDeClientes.cadastrarCliente(cliente);
	}
	/**
	 * Procura um cliente no repositório e o deleta.
	 * @param cpf, uma String contendo o cpf do cliente que sera removido.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro é inválido devido a ausência de algum
	 * dado importante. Serve para não deixar acontecer um {@link NullPointerException}
	 * @throws NaoEncontradoException, essa exception nunca acontecerá.
	 */
	public void removerCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		this.controladorDeClientes.removerCliente(cpf);
	}

	/**
	 *
	 * @param login
	 * @param senha
	 * @return
	 * @throws LoginInvalidoException
	 */
	public Funcionario checarLogin(String login, String senha) throws LoginInvalidoException {
		return this.checkLogin.checagemLogin(login,senha);
	}
}
