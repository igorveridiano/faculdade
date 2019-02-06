package ALUNOS_PROFESSORES;

public class nota_aluno {
	private String nome;
	private String matricula;
	private double nota1,nota2;
	private String situacao;
	
	public nota_aluno(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
		this.nota1 = -1;
		this.nota2 = -1;
		this.situacao = "";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
