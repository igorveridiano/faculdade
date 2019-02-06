package me;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;

public class Turma {
	private int codigo;
	private int numeroMaximoAlunos;
	ListaSimplesmenteEncadeada<Cliente> listaDeReservas;
	ListaSimplesmenteEncadeada<Cliente> listaDeEspera;
	
	public Turma (int codigo, int numeroMaximoAlunos) {
		this.setCodigo(codigo);
		this.setNumeroMaximoAlunos(numeroMaximoAlunos);
		this.listaDeReservas = new ListaSimplesmenteEncadeada<>();
		this.listaDeEspera = new ListaSimplesmenteEncadeada<>();
	}
	
	public boolean EfetuarReserva(Cliente cliente) {
		if (this.listaDeReservas.tamanho() == this.numeroMaximoAlunos){
			this.listaDeEspera.adicionar(cliente);
			System.out.println("Não há vagas, o cliente foi cadastrado na lista de espera");
			return true;
		} else {
			this.listaDeReservas.adicionar(cliente);
			System.out.println("O cliente foi cadastrado na lista de reservas");
			return true;
		}
	}
	
	public void Listar_alunos(){
		System.out.println("Lista de alunos");
		for (int i = 0; i <this.listaDeReservas.tamanho(); i++) {
			System.out.println(this.listaDeReservas.obter(i).getNome());
		}
	}
	
	public boolean CancelarReserva (Cliente cliente){
		if(listaDeEspera.tamanho() != 0){
			listaDeReservas.remover(cliente);
			listaDeReservas.adicionar(listaDeEspera.obter(0));
			listaDeEspera.remover(0);;
			return true;
		}
		else{
			listaDeReservas.remover(cliente);
			return true;
		}	
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumeroMaximoAlunos() {
		return numeroMaximoAlunos;
	}

	public void setNumeroMaximoAlunos(int numeroMaximoAlunos) {
		this.numeroMaximoAlunos = numeroMaximoAlunos;
	}

	public ListaSimplesmenteEncadeada<Cliente> getListaDeReservas() {
		return listaDeReservas;
	}

	public void setListaDeReservas(ListaSimplesmenteEncadeada<Cliente> listaDeReservas) {
		this.listaDeReservas = listaDeReservas;
	}

	public ListaSimplesmenteEncadeada<Cliente> getListaDeEspera() {
		return listaDeEspera;
	}

	public void setListaDeEspera(ListaSimplesmenteEncadeada<Cliente> listaDeEspera) {
		this.listaDeEspera = listaDeEspera;
	}
}
