package br.aju.aprendeEmCasa.entidades;

import java.time.LocalDate;

public class Curso {
	
	private int codigo;
	private String tema;
	private double custo;
	private LocalDate lancamento;
	
	public Curso (int codigo, String tema, double custo, LocalDate lancamento){
		this.setCodigo(codigo);
		this.setTema(tema);
		this.setCusto(custo);
		this.setLancamento(lancamento);
	}
	
	public double precoDeVenda(){
		return codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public LocalDate getLancamento() {
		return lancamento;
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

}
