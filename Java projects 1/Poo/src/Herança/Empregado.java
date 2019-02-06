package Herança;

public class Empregado {
	
	protected String nome;
	protected float salario;
	
	public Empregado (String nome, float salario){
		this.nome = nome;
		this.salario = salario;
	}
	
	public void imprimir() {
		System.out.println(String.format("O empregado: %s possui: %f de salario", this.nome, this.salario));
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
