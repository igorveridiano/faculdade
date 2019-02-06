package Prova;

import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;

public class Turma {
	private int cod;
	private String nome;
	private ListaDuplamenteEncadeada<Aluno> lista_pessoa;

	public Turma(int cod,String nome) {

		this.cod = cod;
		this.nome = nome;
		this.lista_pessoa = new ListaDuplamenteEncadeada<Aluno>();

	}

	public void Efetuar_matricula(Aluno aluno, int nota1, int nota2) {

		lista_pessoa.adicionar(aluno);
		System.out.println("Entrou na turma");
		Nota nota =new Nota(nota1, nota2, this);
		aluno.getLista_nota().adicionar(nota);
	}
		

	public void Listar_alunos() {
		System.out.println("Lista de alunos");
		for (Aluno aluno : lista_pessoa) {
			System.out.println(aluno.getNome());
		}
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public ListaDuplamenteEncadeada<Aluno> getLista_pessoa() {
		return lista_pessoa;
	}

	public void setLista_pessoa(ListaDuplamenteEncadeada<Aluno> lista_pessoa) {
		this.lista_pessoa = lista_pessoa;
	}

}
