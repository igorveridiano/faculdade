package Herança;

public class Gerente extends Empregado {
	
	private String depto;

	public Gerente(String nome, float salario, String dept) {
		super(nome, salario);
		this.setDepto(dept);
	}
	
	@Override
	
	public void imprimir() {
		System.out.println(String.format("Gerente: %s recebe: %f e é responsavel pelo departamento: %s", this.nome, this.salario, this.depto));
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
