package VOO;

public class Passageiro {
	private String nome;
	private int CPF;
	public Passageiro(String nome, int cPF) {
		this.nome = nome;
		CPF = cPF;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCPF() {
		return CPF;
	}
	public void setCPF(int cPF) {

		CPF = cPF;
	}
	
}
