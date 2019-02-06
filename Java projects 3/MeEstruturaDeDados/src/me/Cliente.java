package me;

public class Cliente {
	private int rg;
	private String nome;
	
	public Cliente (String nome, int rg){
		this.setNome(nome);
		this.setRg(rg);
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
