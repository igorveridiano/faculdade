package siteFilaDePedidos;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class Pedido {
	
	private Cliente cliente;
	private int id;
	private float valorTotalDaCompra;
	ListaDuplamenteEncadeada<Produto> listaProdutos;
	
	
	public Pedido (Cliente cliente){
		setCliente(cliente);
		setId(getId() + 1);
		listaProdutos = new ListaDuplamenteEncadeada<>();
	}
	
	public void AdicionarProduto (Produto produto, int quantidadeVendida){
		listaProdutos.adicionar(produto);
		produto.setQuantidadeVendida(quantidadeVendida);
		setValorTotalDaCompra(getValorTotalDaCompra() + (produto.getPrecoUnitario() * quantidadeVendida));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getValorTotalDaCompra() {
		return valorTotalDaCompra;
	}

	public void setValorTotalDaCompra(float valorTotalDaCompra) {
		this.valorTotalDaCompra = valorTotalDaCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
