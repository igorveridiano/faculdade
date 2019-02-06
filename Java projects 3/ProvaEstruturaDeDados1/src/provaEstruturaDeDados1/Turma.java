package provaEstruturaDeDados1;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;



public class Turma {
	
	private String nome;
	private int codigo;
	ListaSimplesmenteEncadeada<Aluno>  ListaAlunos; 
	ListaSimplesmenteEncadeada<Aluno>  ListaAlunosAprovados; 
	ListaSimplesmenteEncadeada<Aluno>  ListaAlunosReprovados;
	ListaSimplesmenteEncadeada<Aluno>  ListaAlunosMaiorNota;
	
	public Turma (String nome, int codigo){
		this.setNome(nome);
		this.setCodigo(codigo);
		this.ListaAlunos = new ListaSimplesmenteEncadeada<>();
		this.ListaAlunosAprovados = new ListaSimplesmenteEncadeada<>();
		this.ListaAlunosReprovados = new ListaSimplesmenteEncadeada<>();
		this.ListaAlunosMaiorNota = new ListaSimplesmenteEncadeada<>();
	}
	
	public boolean cadastrarAlunos (Aluno aluno){
		if(this.ListaAlunos.tamanho() < 50){
			this.ListaAlunos.adicionar(aluno);
			if (aluno.getMedia() >= 6){
				this.ListaAlunosAprovados.adicionar(aluno);
			} else {
				this.ListaAlunosReprovados.adicionar(aluno);
			}
			return true;
		} else {
			System.out.println("A disciplina esta lotada");
			return false;
		}
	}
	
	public void alunosMaiorNota (){
		Aluno aluno1, aluno2, aux;
		for (int i = 0; i < this.ListaAlunosAprovados.tamanho(); i++){
			aluno1 = (Aluno) this.ListaAlunosAprovados.obter(i);
			for(int j = 0; j < this.ListaAlunosAprovados.tamanho(); j++){
				aluno2 = (Aluno) this.ListaAlunosAprovados.obter(j);
				if (aluno1.getMedia() > aluno2.getMedia()){
					aux = aluno1;
					aluno1 = aluno2;
					aluno2 = aux;
				}
			}
		}
		int posicao = this.ListaAlunosAprovados.tamanho() - 1;
		Aluno aluno3 = (Aluno) this.ListaAlunosAprovados.obter(posicao);
		for (Aluno aluno4 : ListaAlunosAprovados) {
			if (aluno4.getMedia() == aluno3.getMedia()){
				this.ListaAlunosMaiorNota.adicionar(aluno4);
			}
		}
	}
	
	public void trancarTurmas(Aluno aluno){
		for (Aluno alunos : ListaAlunos) {
			if (alunos.equals(aluno)){
				this.ListaAlunos.remover(aluno);
				if (aluno.getMedia() > 6){
					this.ListaAlunosAprovados.remover(aluno);
				} else {
					this.ListaAlunosReprovados.remover(aluno);
				}
				for (Aluno alunos2 : ListaAlunosMaiorNota) {
					if(alunos2.equals(aluno)){
						this.ListaAlunosMaiorNota.remover(aluno);
					}
				}
			}  
		}
	}
	
	public void ListarAlunosAprovados(){
		Aluno aluno;
		System.out.println("Alunos Aprovados na Disciplina de " + getNome() + ": ");
		for (int i = 0; i < ListaAlunosAprovados.tamanho(); i++){
			aluno = (Aluno) ListaAlunosAprovados.obter(i);
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Nota Primeira Unidade: " + aluno.getNota1());
			System.out.println("Nota Segunda Unidade: " + aluno.getNota2());
			System.out.println("Media : " + aluno.getMedia());
		}
	}
	
	public void ListarAlunosReprovados(){
		Aluno aluno;
		System.out.println("Alunos Reprovados na Disciplina de " + getNome() + ": ");
		for (int i = 0; i < ListaAlunosReprovados.tamanho(); i++){
			aluno = (Aluno) ListaAlunosReprovados.obter(i);
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Nota Primeira Unidade: " + aluno.getNota1());
			System.out.println("Nota Segunda Unidade: " + aluno.getNota2());
			System.out.println("Media : " + aluno.getMedia());
		}
	}
	
	public void ListarAlunosDestaques(){
		Aluno aluno;
		System.out.println("Alunos destaques na Disciplina de " + getNome() + ": ");
		for (int i = 0; i < ListaAlunosMaiorNota.tamanho(); i++){
			aluno = (Aluno) ListaAlunosMaiorNota.obter(i);
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Nota Primeira Unidade: " + aluno.getNota1());
			System.out.println("Nota Segunda Unidade: " + aluno.getNota2());
			System.out.println("Media : " + aluno.getMedia());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
