package verificarDisciplina;

public class Aluno {
	
	private int matricula;
	private String nome;
	private float nota1;
	private float nota2;
	private float media;
	
	public Aluno(int matricula, String nome, float nota1, float nota2){
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setNota1(nota1);
		this.setNota2(nota2);
		this.setMedia((this.nota1*4 + this.nota2*6)/10);
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

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

}
