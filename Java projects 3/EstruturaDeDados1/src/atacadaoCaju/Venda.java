package atacadaoCaju;

import java.util.Date;

public class Venda {
	
	private Date data;
	private int quantidadeVendida;
	private double valorDaVenda;
	private double custoUnitario;
	
	public Venda (Date data, int quantidadeVendida, double valorDaVenda, Produto produto){
		setData(data);
		setQuantidadeVendida(quantidadeVendida + getQuantidadeVendida());
		setValorDaVenda(valorDaVenda);
		setCustoUnitario(produto.getCustoUnitario());
		produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidadeVendida);
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public double getValorDaVenda() {
		return valorDaVenda;
	}
	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}
	public double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}
	
}
