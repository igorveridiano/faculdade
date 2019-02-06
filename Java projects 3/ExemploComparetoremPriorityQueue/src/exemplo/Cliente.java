package exemplo;

public class Cliente {
	
	private String nome;
	private int prioridade;
	
	public Cliente(String nome, int prioridade) {
		super();
		this.nome = nome;
		this.prioridade = prioridade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
}
