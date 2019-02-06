package siteFilaDePedidos;

public class Cliente {
	
	private String nome;
	private final String cpf;
	
	public Cliente (String nome, String cpf){
		setNome(nome);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

}
