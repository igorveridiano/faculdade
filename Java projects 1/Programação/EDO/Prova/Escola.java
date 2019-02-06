package Prova;



import ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto.ListaDuplamenteEncadeada;

public class Escola {
	private ListaDuplamenteEncadeada<Turma> lista_turma;
	private ListaDuplamenteEncadeada<Aluno> lista_aluno;

	public Escola() {
		this.lista_turma = new ListaDuplamenteEncadeada<Turma>();
		this.lista_aluno = new ListaDuplamenteEncadeada<Aluno>();
	}

	public void Cadastrar_aluno(Aluno aluno) {
		this.lista_aluno.adicionar(aluno);
	}

	public void Cadastrar_turma(Turma turma) {
		this.lista_turma.adicionar(turma);
	}

	public void Cancelar_Turma(Turma turma) {
		this.lista_turma.remover(turma);
	}

//	public void listar_turmas() {
//		System.out.printf("%-25s %-25s %-25s %-25s \n","Codigo da turma","Número de vagas","Número de alunos","Tamanho da fila de espera");
//		for (Turma turma : lista_turma) {
//			System.out.printf("%-25d %-25d %-25d %-25d\n ",turma.getCod(),turma.getNumero_maximo(),turma.getLista_pessoa().tamanho());
//		}
//		
//	}

	public ListaDuplamenteEncadeada<Turma> getLista_turma() {
		return lista_turma;
	}

	public void setLista_turma(ListaDuplamenteEncadeada<Turma> lista_turma) {
		this.lista_turma = lista_turma;
	}

	public ListaDuplamenteEncadeada<Aluno> getLista_aluno() {
		return lista_aluno;
	}

	public void setLista_aluno(ListaDuplamenteEncadeada<Aluno> lista_aluno) {
		this.lista_aluno = lista_aluno;
	}
}


