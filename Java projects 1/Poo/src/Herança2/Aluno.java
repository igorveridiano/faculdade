package Herança2;

public class Aluno extends Pessoa {
	
	private String curso;
	private int periodo;

	public Aluno(String nome, int idade, String sexo, int cpf, int cep, int matricula, String curso, int periodo) {
		super(nome, idade, sexo, cpf, cep, matricula);
		this.setCurso(curso);
		this.setPeriodo(periodo);
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
