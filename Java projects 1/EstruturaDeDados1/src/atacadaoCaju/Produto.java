package atacadaoCaju;

import java.text.SimpleDateFormat;

import listaSimplismenteEncadeada.ListaSimplesmenteEncadeada;

public class Produto {
	
	private int codigo;
	private String nome;
	private int quantidadeEstoque;
	private double custoUnitario;
	private ListaSimplesmenteEncadeada<Compra> listaDeCompras;
	private ListaSimplesmenteEncadeada<Venda> listaDeVendas;
	
	public Produto(int codigo, String nome){
		setCodigo(codigo);
		setNome(nome);
	    listaDeCompras = new ListaSimplesmenteEncadeada<>();
		listaDeVendas = new ListaSimplesmenteEncadeada<>();
	}
	
	public void RegistrarCompra(Compra compra){
		listaDeCompras.adicionar(compra);
	}
	
	public void RegistrarVenda(Venda venda){
		listaDeVendas.adicionar(venda);
	}
	
	public void ImprimirVendas(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("%15s %20s %18s %18s", "Data", "Quantidade Vendida", "Valor da Venda", "Custo Unitario\n");
		for (Venda venda : listaDeVendas) {
			System.out.printf("%15s %20s %15s %15s", formato.format(venda.getData()), venda.getQuantidadeVendida(),"R$ " + venda.getValorDaVenda(),"R$ " + venda.getCustoUnitario() + "\n");
		}
	}
	
	public void ImprimirCompras(){
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.printf("%15s %20s %18s", "Data", "Quantidade Comprada", "Valor da Compra\n");
		for (Compra compra : listaDeCompras) {
			System.out.printf("%15s %20s %15s", formato.format(compra.getData()), compra.getQuantidadeComprada(),"R$ " + compra.getValorDaCompra() + "\n");
		}
	}
	
	public void InformaçõesDeProduto(){
		System.out.printf("%15s %20s %25s %18s", "Codigo", "Nome", "Quantidade em Estoque", "Custo Unitario\n");
		System.out.printf("%15s %20s %25s %15s", getCodigo(), getNome(), getQuantidadeEstoque(),"R$ " + getCustoUnitario() + "\n");
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public double getCustoUnitario() {
		return custoUnitario;
	}
	public void setCustoUnitario(double custoUnitario) {
		this.custoUnitario = custoUnitario;
	}

}
