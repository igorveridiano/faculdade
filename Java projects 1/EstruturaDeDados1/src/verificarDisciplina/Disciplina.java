package verificarDisciplina;

import listaVetor.Vetor;

public class Disciplina {
	
	private String nome;
	Vetor<Aluno> ListaAlunos; 
	Vetor<Aluno> ListaAlunosAprovados; 
	Vetor<Aluno> ListaAlunosReprovados;
	Vetor<Aluno> ListaAlunosMaiorNota;
	
	public Disciplina (String nome){
		this.setNome(nome);
		this.ListaAlunos = new Vetor<>();
		this.ListaAlunosAprovados = new Vetor<>();
		this.ListaAlunosReprovados = new Vetor<>();
		this.ListaAlunosMaiorNota = new Vetor<>();
	}
	
	public boolean cadastrarAlunos (Aluno aluno){
		if(this.ListaAlunos.getSize() < 50){
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
		for (int i = 0; i < this.ListaAlunosAprovados.getSize(); i++){
			aluno1 = (Aluno) this.ListaAlunosAprovados.obter(i);
			for(int j = 0; j < this.ListaAlunosAprovados.getSize(); j++){
				aluno2 = (Aluno) this.ListaAlunosAprovados.obter(j);
				if (aluno1.getMedia() > aluno2.getMedia()){
					aux = aluno1;
					aluno1 = aluno2;
					aluno2 = aux;
				}
			}
		}
		int posicao = this.ListaAlunosAprovados.getSize() - 1;
		Aluno aluno3 = (Aluno) this.ListaAlunosAprovados.obter(posicao);
		for (Aluno aluno4 : ListaAlunosAprovados) {
			if (aluno4.getMedia() == aluno3.getMedia()){
				this.ListaAlunosMaiorNota.adicionar(aluno4);
			}
		}
	}
	
	public boolean trancarDisciplina(Aluno aluno){
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
				return true;
			}  
		}
		return false;
	}
	
	public void ListarAlunosAprovados(){
		Aluno aluno;
		System.out.println("Alunos Aprovados na Disciplina de " + getNome() + ": ");
		System.out.printf("%20s %30s %25s %25s %20s", "Matricula", "Nome", "Primeira Nota", "Segunda Nota", "Media\n");
		for (int i = 0; i < ListaAlunosAprovados.getSize(); i++){
			aluno = (Aluno) ListaAlunosAprovados.obter(i);
			System.out.printf("%20s %30s %25s %25s %20s",aluno.getMatricula(), aluno.getNome(), aluno.getNota1(), 
			aluno.getNota2(), aluno.getMedia() + "\n");
		}
	}
	
	public void ListarAlunosReprovados(){
		Aluno aluno;
		System.out.println("Alunos Reprovados na Disciplina de " + getNome() + ": ");
		System.out.printf("%20s %30s %25s %25s %20s", "Matricula", "Nome", "Primeira Nota", "Segunda Nota", "Media\n");
		for (int i = 0; i < ListaAlunosReprovados.getSize(); i++){
			aluno = (Aluno) ListaAlunosReprovados.obter(i);
			System.out.printf("%20s %30s %25s %25s %20s",aluno.getMatricula(), aluno.getNome(), aluno.getNota1(), 
			aluno.getNota2(), aluno.getMedia() + "\n");
		}
	}
	
	public void ListarAlunosMaiorNota(){
		Aluno aluno;
		System.out.println("Alunos Destaques na Disciplina de " + getNome() + ": ");
		System.out.printf("%20s %30s %25s %25s %20s", "Matricula", "Nome", "Primeira Nota", "Segunda Nota", "Media\n");
		for (int i = 0; i < ListaAlunosMaiorNota.getSize(); i++){
			aluno = (Aluno) ListaAlunosMaiorNota.obter(i);
			System.out.printf("%20s %30s %25s %25s %20s",aluno.getMatricula(), aluno.getNome(), aluno.getNota1(), 
			aluno.getNota2(), aluno.getMedia() + "\n");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
