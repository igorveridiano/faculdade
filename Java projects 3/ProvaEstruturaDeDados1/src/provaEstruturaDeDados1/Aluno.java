package provaEstruturaDeDados1;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;

public class Aluno {
	
	private int matricula;
	private String nome;
	private float nota1;
	private float nota2;
	ListaSimplesmenteEncadeada<Turma>  ListaTurmas; 
	
	public Aluno(int matricula, String nome){
		this.setMatricula(matricula);
		this.setNome(nome);
		this.ListaTurmas = new ListaSimplesmenteEncadeada<>();
	}
	
	public boolean trancarTurmas (Aluno aluno){
		boolean verificador = false;
		for (Turma turma : ListaTurmas) {
			if (turma.ListaAlunos.contem(aluno)){
				turma.trancarTurmas(aluno);
				verificador = true;
			}
		}
		if (verificador){
			ListaTurmas.limpar();
		}
		return verificador;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMedia() {
		return (this.nota1*4 + this.nota2*6)/10;
	}

	public float getNota1() {
		return nota1;
	}

	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}

	public float getNota2() {
		return nota2;
	}

	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}

}
