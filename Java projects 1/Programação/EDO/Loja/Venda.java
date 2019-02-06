package Loja;

import java.time.LocalDate;

public class Venda {
	private LocalDate data;
	private int qtd;
	private double valor;
	private double custo_unitario;
	public Venda( int qtd, double valor) {
		
		this.qtd = qtd;
		this.valor = valor;
		this.custo_unitario = valor/qtd;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getCusto_unitario() {
		return custo_unitario;
	}
	public void setCusto_unitario(double custo_unitario) {
		this.custo_unitario = custo_unitario;
	}
	
}
