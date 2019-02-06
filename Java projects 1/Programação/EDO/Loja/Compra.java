package Loja;

import java.time.LocalDate;

public class Compra {
	private LocalDate data;
	private int qtd;
	private double valor;

	public Compra( int qtd, double custo) {
		this.data =LocalDate.now();
		this.qtd = qtd;
		this.valor = custo;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
