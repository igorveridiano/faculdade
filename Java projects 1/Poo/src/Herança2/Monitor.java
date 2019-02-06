package Herança2;

public class Monitor extends Aluno {
	
	private String materiaMonitoria;
	
	public Monitor(String nome, int idade, String sexo, int cpf, int cep, int matricula, String curso, int periodo, String materiaMonitoria) {
		super(nome, idade, sexo, cpf, cep, matricula, curso, periodo);
		this.setMateriaMonitoria(materiaMonitoria);
	}

	public String getMateriaMonitoria() {
		return materiaMonitoria;
	}

	public void setMateriaMonitoria(String materiaMonitoria) {
		this.materiaMonitoria = materiaMonitoria;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
