package ALUNOS_PROFESSORES;

import java.util.ArrayList;

public class Disciplina {
	 private String nome;
     private int codigo;
     private int qtd_creditos;
     private Professor professor;
     private ArrayList<nota_aluno> lista_aluno;
     
     
     
	public Disciplina(String nome, int codigo, int qtd_creditos, Professor professor) {
		this.nome = nome;
		this.codigo = codigo;
		this.qtd_creditos = qtd_creditos;
		this.professor = professor;
		setLista_aluno(new ArrayList<>());
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
	public int getQtd_creditos() {
		return qtd_creditos;
	}
	public void setQtd_creditos(int qtd_creditos) {
		this.qtd_creditos = qtd_creditos;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public ArrayList<nota_aluno> getLista_aluno() {
		return lista_aluno;
	}
	public void setLista_aluno(ArrayList<nota_aluno> lista_aluno) {
		this.lista_aluno = lista_aluno;
	}

}
