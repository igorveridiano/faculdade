package atacadaoCaju;

import java.util.Date;

public class Compra {
	
	private Date data;
	private int quantidadeComprada;
	private double valorDaCompra;
	
	public Compra (Date data, int quantidadeComprada, double valorDaCompra, Produto produto){
		setData(data);
		setQuantidadeComprada(quantidadeComprada);
		setValorDaCompra(valorDaCompra);
		produto.setQuantidadeEstoque(quantidadeComprada + produto.getQuantidadeEstoque());
		double custoUnitario;
		custoUnitario = (valorDaCompra + getValorDaCompra()) / (quantidadeComprada + getQuantidadeComprada());
		produto.setCustoUnitario(custoUnitario);
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQuantidadeComprada() {
		return quantidadeComprada;
	}
	public void setQuantidadeComprada(int quantidadeComprada) {
		this.quantidadeComprada = quantidadeComprada;
	}
	public double getValorDaCompra() {
		return valorDaCompra;
	}
	public void setValorDaCompra(double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

}
