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
	 * Retorna instance da fachada, assim limitando sua criacao para uma unica
	 * @return instance, retorna a instancia da Fachada, assim tornando impossivel duas fachadas.
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
	 * Retorna o animal usando como parametro o nome do animal e o cpf do seu dono.
	 * @param nome, String que tera o nome do Animal.
	 * @param cpf, String que tera o CPF do dono.
	 * @return Animal, retorna Animal do repositorio que possua o mesmo nome que foi passado como parametro e um dono
	 * igual ao CPF recebido como atributo.
	 * @throws NaoEncontradoException, retorna uma Exception alegando que o animal nao foi encontrado.
	 */
	public Animal getAnimal(String nome, String cpf) throws NaoEncontradoException {
		return this.controladorDeAnimais.getAnimal(cpf, nome);
	}
	/**
	 * Retorna um Array do tipo Animal contendo todos os animais que o cliente possui cadastrado em seu nome.
	 * @param cpf, uma String possuindo o CPF do cliente.
	 * @return	Animal[], array tipo Animal[].
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro eh invalido devido a ausencia de
	 * alguma informacaoo. Serve para nao deixar acontecer um {@link NullPointerException}.
	 * @throws NaoEncontradoException, lancado quando o cliente nao foi encontrado.
	 */
	public Animal[] getAnimaisCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeAnimais.getAnimaisCliente(cpf);
	}
	/**
	 * Remove o animal de acordo com o nome do animal e o cpf de seu dono. Ambos passados por parametro.
	 * @param nome, String representando o nome do animal.
	 * @param cpf, String representando o cpf do dono do animal.
	 * @throws NaoEncontradoException, retorna essa exception quando o Animal nao foi encontrado no banco de dados.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 */
	public void removerAnimal(String nome, String cpf) throws NaoEncontradoException, CadastroInvalidoException {
		this.controladorDeAnimais.remover(cpf, nome);
	}
	/**
	 * Recebe como parametro um objeto tipo Animal contendo os dados do animal para cadastra-lo no repositorio.
	 * @param animal, objeto tipo Animal contendo a informacao.
	 * @throws NaoEncontradoException //TODO ver pq disso existir.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 */
	public void cadastrarAnimal(Animal animal) throws NaoEncontradoException, CadastroInvalidoException {
		this.controladorDeAnimais.addAnimal(animal);
	}
	/**
	 * Retorna um array do tipo Consulta contendo o repositorio.
	 * @return Retorna um array do tipo Consulta contendo o repositorio.
	 */
	public Consulta[] getConsultasArray(){
		return this.controladorDeConsultas.getConsultasArray();
	}
	/**
	 * Procura uma consulta usando as informacoes dadas como parametro para pesquisar e retornar a consulta.
	 * @param veterinario, String representando o nome do Veterinario que cadastrou a consulta.
	 * @param dia, int representando o dia.
	 * @param mes, int representando o mes.
	 * @param ano, int representando o ano.
	 * @param nomeAnimal, String representando o nome do animal.
	 * @return Retorna um objeto tipo Consulta contendo os dados da consulta.
	 * @throws NaoEncontradoException, retorna essa exception quando nao encontra.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro eh invalido devido a ausencia de
	 * alguma informacao. Serve para nao deixar acontecer um {@link NullPointerException}.
	 */
	public Consulta getConsulta(String veterinario, int dia, int mes, int ano, String nomeAnimal) throws NaoEncontradoException, CadastroInvalidoException {
		return this.controladorDeConsultas.getConsulta(veterinario,dia,mes,ano,nomeAnimal);
	}
	/**
	 * Procura se a consulta existe no repositorio, caso sim, o metodo a exclui.
	 * @param consulta, recebe um Objeto tipo Consulta contendo as informacoes da consulta que deve ser excluida.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 * @throws NaoEncontradoException, retorna essa exception quando a consulta nao foi encontrada
	 */
	public void removerConsulta(Consulta consulta) throws CadastroInvalidoException, NaoEncontradoException {
		this.controladorDeConsultas.removerConsulta(consulta);
	}

	/**
	 * Verifica se a Consulta cumpre os requisitos e caso cumpra, a consulta eh cadastrada, caso nao, um {@link CadastroInvalidoException} eh emitido.
	 * @param consulta, Consulta que sera enviada para o cadastro do repositorio.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro eh invalido devido a ausencia de
	 * alguma informacao. Serve para nao deixar acontecer um {@link NullPointerException}.
	 */
	public void cadastrarConsulta(Consulta consulta) throws CadastroInvalidoException {
		this.controladorDeConsultas.addConsulta(consulta);
	}
	/**
	 * Retorna um Array tipo Funcionario que possui o msm endereço que o repositório.
	 * @return Funcionario[], retorna um array do tipo Funcionario que possui o mesmo endereço que
	 */
	public Funcionario[] getFuncionariosArray(){
		return this.controladorDeFuncionarios.getFuncionarioArray();
	}
	/**
	 * Retorna o Funcionario da posicao {@code pos} passada por parametro que
	 * @param pos, int representando a posi��o do Funcionario no Array do repositorio.
	 * @return Funcionario, retorna o funcionario de acordo com a pos no Array.
	 * @throws NaoEncontradoException, retorna essa exception quando o Funcionario n�o foi encontrado no reposit�rio.
	 */
	public Funcionario getFuncionario(int pos) throws NaoEncontradoException {
		return this.controladorDeFuncionarios.getFuncionario(pos);
	}
	/**
	 * Recebe uma String como parametro e usa essa String para buscar um Funcionario, caso encontrado ele retorna esse
	 * Funcionario.
	 * @param cpf, String representando o cpf do Funcionario que sera pesquisado no repositorio.
	 * @return Funcionario, retorna o funcionario que possui o cpf igual ao cpf enviado por parametro.
	 * @throws CpfInvalidoException, retorna essa exception quando o CPF � inv�lido alegando que n�o existe Funcionario
	 * cadastrado com esse cpf.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 */
	public Funcionario getFuncionario(String cpf) throws CpfInvalidoException, CadastroInvalidoException {
		return this.controladorDeFuncionarios.getFuncionario(cpf);
	}
	/**
	 * O metodo verificar se o Funcionario enviado como parametro possui os campos de cadastro preenchidos e se n�o
	 * existe algum Funcionario usando o mesmo cpf. Caso tudo esteja de acordo o Funcionario � cadastrado no reposit�rio.
	 * @param funcionario, recebe uma inst�ncia de um object tipo Funcionario.
	 * @throws FuncionarioJaExisteException, retrona essa exception quando o CPF ja esta cadastrado em algum outro
	 * Funcion�rio, por tanto, o funcion�rio j� existe.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 */
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException, CadastroInvalidoException {
		this.controladorDeFuncionarios.addFuncionario(funcionario);
	}
	/**
	 * Recebe como par�metro uma String remetendo ao CPF do Funcion�rio e deleta do reposit�rio.
	 * @param cpf, uma String que representa o CPF do Funcion�rio
	 * @throws NaoEncontradoException, retorna essa Exception quando o Funcion�rio n�o foi encontrado no Array
	 * @throws CpfInvalidoException, retorna essa Exception quando o cpf n�o � v�lido.
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

	/**
	 * Retorna o array do banco de dados.
	 * @return Cliente[], retorna o array do reposit�rio inteiro.
	 */
	public Cliente[] getClientesArray(){
		return this.controladorDeClientes.getClientesArray();
	}
	/**
	 * Recebe uma String com o cpf e retornar� a pos do Cliente no Array do reposit�rio.
	 * @param cpf, uma String contendo o CPF do cliente.
	 * @return int representando a posi��o do Cliente no Array.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}
	 * @throws NaoEncontradoException, retorna essa exception quando o cliente n�o foi encontrado no banco de dados.
	 */
	public int getClientePos(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeClientes.getClientePos(cpf);
	}
	/**
	 * O m�todo recebe uma String representando o cpf, busca no reposit�rio e retorna o Cliente correspondente.
	 * @param cpf, String como paramentro representando o cpf para buscar o cliente.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 * @throws NaoEncontradoException, exception enviada quando o Cliente n�o � encontrado no banco de dados.
	 */
	public Cliente getCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		return this.controladorDeClientes.getCliente(cpf);
	}
	/**
	 * Adiciona um cliente no reposit�rio de clientes usando o objeto do parametro.
	 * @param cliente, objeto do tipo cliente.
	 * @throws NaoEncontradoException, retorna essa exception mas ela nunca ir� acontecer com esse m�todo.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � invalido devido a aus�ncia de
	 * alguma informa��o. Serve para n�o deixar acontecer um {@link NullPointerException}.
	 * @throws ClienteJaExisteException, retorna essa exception quando o cpf ja foi cadastrado em algum cliente.
	 */
	public void cadastrarCliente(Cliente cliente) throws NaoEncontradoException, CadastroInvalidoException, ClienteJaExisteException {
		this.controladorDeClientes.cadastrarCliente(cliente);
	}
	/**
	 * Procura um cliente no reposit�rio e o deleta.
	 * @param cpf, uma String contendo o cpf do cliente que sera removido.
	 * @throws CadastroInvalidoException, retorna essa exception quando o cadastro � inv�lido devido a aus�ncia de algum
	 * dado importante. Serve para n�o deixar acontecer um {@link NullPointerException}
	 * @throws NaoEncontradoException, essa exception nunca acontecer�.
	 */
	public void removerCliente(String cpf) throws CadastroInvalidoException, NaoEncontradoException {
		this.controladorDeClientes.removerCliente(cpf);
	}

	/**
	 * M�todo que checa se as String mandadas atrav�s do parametros est�o cadastras em algum Funcionario como Login ou
	 * Senha
	 * @param login, String representando o Login do usu�rio.
	 * @param senha, String representando a senha do usu�rio.
	 * @return Funcionario, retorna o funcion�rio que foi feito o Login
	 * @throws LoginInvalidoException, envia essa exception quando o Login ou Senha n�o est�o cadastrados em nenhum
	 * cliente
	 */
	public Funcionario checarLogin(String login, String senha) throws LoginInvalidoException {
		return this.checkLogin.checagemLogin(login,senha);
	}
}
