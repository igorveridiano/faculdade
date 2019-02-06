package ALUNOS_PROFESSORES.copy;


public class Pessoa implements Comparable<Pessoa> {
	
	private int matricula;
	private String nome;
	private int Quantidade_Creditos;
	
	public Pessoa(int matricula, String nome, int quantidade_Creditos) {
		this.matricula = matricula;
		this.nome = nome;
		Quantidade_Creditos = quantidade_Creditos;
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
	public int getQuantidade_Creditos() {
		return Quantidade_Creditos;
	}
	public void setQuantidade_Creditos(int quantidade_Creditos) {
		Quantidade_Creditos = quantidade_Creditos;
	}
	@Override
	public int compareTo(Pessoa OutraPessoa) {
		if(this.matricula<OutraPessoa.matricula){
			return -1;
		}
		if(this.matricula>OutraPessoa.matricula){
			return 1;
		}
		return 0;
	}
	
	
}
