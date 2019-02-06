package receitaFederal;

import fila.FilaVetor;

public class Pessoa {
	
	private String nome;
	private String cpf;
	FilaVetor<Rendimentos> filaRendimentos;
	
	public Pessoa(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
		filaRendimentos = new FilaVetor<>();
	}
	
	public void AdicionarRendimentos (Rendimentos rendimento){
		filaRendimentos.enfileirar(rendimento);
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
