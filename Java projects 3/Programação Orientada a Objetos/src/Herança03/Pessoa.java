package Herança03;

public class Pessoa {
	
	private String nome;
	private int idade;
	private String sexo;
	private int cpf;
	private int cep;
	private int matricula;
	
	public Pessoa (String nome, int idade, String sexo, int cpf, int cep, int matricula){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
		this.cep = cep;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}



	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public int getCpf() {
		return cpf;
	}



	public void setCpf(int cpf) {
		this.cpf = cpf;
	}



	public int getCep() {
		return cep;
	}



	public void setCep(int cep) {
		this.cep = cep;
	}


	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
