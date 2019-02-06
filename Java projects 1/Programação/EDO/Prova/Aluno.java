package Prova;

import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;

public class Aluno {
	private String nome;
	private int matricula;
	private ListaDuplamenteEncadeada<Nota> lista_nota;
	
	public Aluno(String nome, int matricula) {
		
		this.nome = nome;
		this.matricula = matricula;
		this.lista_nota= new ListaDuplamenteEncadeada();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public ListaDuplamenteEncadeada<Nota> getLista_nota() {
		return lista_nota;
	}

	public void setLista_nota(ListaDuplamenteEncadeada<Nota> lista_nota) {
		this.lista_nota = lista_nota;
	}
	
}
