package br.aju.aprendeEmCasa.entidades;

import java.time.LocalDate;

public class VHS  {
	
	private int codigo;
	private String tema;
	private double custo;
	private LocalDate lancamento;
	private double custoDaFita;
	private String marca;

	public VHS(int codigo, String tema, double custo, LocalDate lancamento, double custoDaFita, String marca) {
		this.setCodigo(codigo);
		this.setTema(tema);
		this.setCusto(custo);
		this.setLancamento(lancamento);
		this.setCustoDaFita(custoDaFita);
		this.setMarca(marca);
	}
	
	public double precoDeVenda(double custoDaFita, double custoDoCurso){
		double precoVenda;
		precoVenda = custoDaFita + (custoDoCurso * 0.1) + custoDoCurso;
		return precoVenda;
	}

	public double getCustoDaFita() {
		return custoDaFita;
	}

	public void setCustoDaFita(double custoDaFita) {
		this.custoDaFita = custoDaFita;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
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
