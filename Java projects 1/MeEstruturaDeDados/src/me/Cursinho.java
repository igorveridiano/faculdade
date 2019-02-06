package me;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;

public class Cursinho {
	ListaSimplesmenteEncadeada<Turma> listaDeTurmas;
	ListaSimplesmenteEncadeada<Cliente> listaDeClientes;
	
	public Cursinho() {
		this.listaDeTurmas = new ListaSimplesmenteEncadeada<>();
		this.listaDeClientes = new ListaSimplesmenteEncadeada<>();
	}
	
	public boolean CadastrarCliente(Cliente cliente) {
		this.listaDeClientes.adicionar(cliente);
		return true;
	}
	
	public boolean CadastrarTurma (Turma turma){
		this.listaDeTurmas.adicionar(turma);
		return true;
	}
	
	public boolean CancelarTurma (Turma turma){
		this.listaDeTurmas.remover(turma);
		return true;
	}
	
	public void listar_turmas() {
		System.out.printf("$-25s $-25s $-25s $-25s \n","Codigo da turma","Número de vagas","Número de alunos","Tamanho da fila de espera");
		for (Turma turma : listaDeTurmas) {
			System.out.printf("%-25d %-25d %-25d %-25d ",turma.getCodigo(),turma.getNumeroMaximoAlunos(),turma.getListaDeReservas().tamanho(),turma.getListaDeEspera().tamanho());
		}
		
	}

	public ListaSimplesmenteEncadeada<Turma> getListaDeTurmas() {
		return listaDeTurmas;
	}

	public void setListaDeTurmas(ListaSimplesmenteEncadeada<Turma> listaDeTurmas) {
		this.listaDeTurmas = listaDeTurmas;
	}

	public ListaSimplesmenteEncadeada<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(ListaSimplesmenteEncadeada<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	
}
